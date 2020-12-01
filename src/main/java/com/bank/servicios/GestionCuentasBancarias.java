/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.servicios;

import com.bank.dominio.CuentaBancaria;
import com.bank.excepciones.BankException;
import com.db.PoolConexiones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Manuel
 */
public class GestionCuentasBancarias implements GestionCuentasBancariasInterface{

    private static final String SELECT_IBAN = "SELECT IBAN FROM CUENTAS_BANCARIAS"
            + " WHERE ID_CLIENTE = ?";
    
 ///////////////////////////////////////////////////////////////////////   
    
    private static final String SELECT_GET_CUENTAS_BANCARIAS_CLIENTE
            = "SELECT ID_CUENTA, IBAN, SALDO, ID_CLIENTE "
            + "FROM CUENTAS_BANCARIAS "
            + "WHERE ID_CLIENTE = ?";    
    
//////////////////////////////////////////////////////////////////////
    
    private static final String INSERT_CUENTA_BANCARIA = "INSERT INTO CUENTAS_BANCARIAS"
            + "(ID_CUENTA, IBAN, SALDO, ID_CLIENTE) " + "VALUES (?,?,?,?)";
    private static final String MAX_ID_CUENTA_BANCARIA = "SELECT MAX(ID_CUENTA) "
            + "FROM CUENTAS_BANCARIAS";
    
//////////////////////////////////////////////////////////////////////    
    
    private static final String UPDATE_SALDO_CUENTA_BANCARIA_POR_IBAN = "UPDATE CUENTAS_BANCARIAS "
            + "SET SALDO = SALDO + ? " + "WHERE IBAN = ?";
    
 ////////////////////////////////////////////////////////////////////////
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            GestionCuentasBancarias gcb = new GestionCuentasBancarias();
            gcb.altaNuevaCuenta(2, new CuentaBancaria("IN7585555",1,2,3000.0));
        }
        catch(BankException ex){
            System.out.println("ERROR: " + ex.getMessage());
        }
        catch(SQLException ex){
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    @Override
    public List<CuentaBancaria> getCuentasBancariasPorCliente(int idCliente) throws BankException, SQLException {
        List<CuentaBancaria> cuentas = new ArrayList<CuentaBancaria>();
        Connection con = PoolConexiones.getConexionLibre();

        PreparedStatement ps = con.prepareStatement(SELECT_GET_CUENTAS_BANCARIAS_CLIENTE);
        ps.setInt(1, idCliente);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            //"ID_CUENTA","IBAN","SALDO","ID_CLIENTE"
            CuentaBancaria c = new CuentaBancaria();
            c.setIdCuenta(rs.getInt("ID_CUENTA"));
            c.setIban(rs.getString("IBAN"));
            c.setSaldo(rs.getDouble("SALDO"));
            c.setIdCliente(rs.getInt("ID_CLIENTE"));
            cuentas.add(c);
        }
        PoolConexiones.liberaConexion(con);
        return cuentas;
    }

    @Override
    public void altaNuevaCuenta(int idCliente, CuentaBancaria cuenta) throws BankException, SQLException {
        Connection con = PoolConexiones.getConexionLibre();
        
        //gcb.altaNuevaCuenta(2, new CuentaBancaria("IN7585555",1,2,3000.0));
        //String Iban, int idCuenta, int idCliente, double saldo
        //obtener el último id de cuenta bancaria 
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(MAX_ID_CUENTA_BANCARIA);
        int nuevoId = 1;
        if(rs.next()){
            nuevoId  = rs.getInt(1) +1;
        }
        System.out.printf("Nuevo Id %d" , nuevoId);
         
        PreparedStatement ps = con.prepareStatement(INSERT_CUENTA_BANCARIA);
        ps.setInt(1, nuevoId);
        ps.setString(2, cuenta.getIban());
        ps.setDouble(3, cuenta.getSaldo());
        ps.setInt(4, idCliente);
        ps.executeUpdate();
        
        PoolConexiones.liberaConexion(con);
    }

    @Override
    public void ingresar(String iban, double importe) throws BankException, SQLException {
           
        //1. validar importe > 0
        if(importe <= 0 ){
            throw new BankException("No se hizo el ingreso. Debe indicar un importe mayor a 0. ");
        }
        else{
            Connection con = PoolConexiones.getConexionLibre();

            //obtener el último id de cuenta bancaria 
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(MAX_ID_CUENTA_BANCARIA);
            int nuevoIdCuentaBancaria = 1;
            if(rs.next()){
                nuevoIdCuentaBancaria  = rs.getInt(1) + 1;
            }
            System.out.printf("Nuevo Id %d" , nuevoIdCuentaBancaria);

            PreparedStatement ps = con.prepareStatement(INSERT_CUENTA_BANCARIA);
            CuentaBancaria cuenta = new CuentaBancaria();
            ps.setInt(1, nuevoIdCuentaBancaria);
            ps.setString(2, cuenta.getIban());
            ps.setDouble(3, cuenta.getSaldo());
            ps.setInt(4, cuenta.getIdCliente());
            ps.executeUpdate();

            PoolConexiones.liberaConexion(con);
        }
    
    }

    @Override
    public void sacar(String iban, double importe) throws BankException, SQLException {
        //Obtener conexion y libera
        Connection con = PoolConexiones.getConexionLibre();
        try{
            con.setAutoCommit(false); //desactivo la autoconfirmacion
            PreparedStatement pst = con.prepareStatement(UPDATE_SALDO_CUENTA_BANCARIA_POR_IBAN);
            //MODIFICACION DE SALDO (+ cantidadACorregir)
            pst.setDouble(1, importe);
            pst.setString(2, iban);
            pst.executeUpdate();
        }
        catch(SQLException e){
            System.out.println("... no se pudo hacer la correcion");
            try{
                con.rollback();
            }
            catch(SQLException ex) {
                System.out.println("ERROR: " + ex.getMessage());
            }
        }
        finally{
            PoolConexiones.liberaConexion(con);
        }
    }

    @Override
    public void hacerTransferencia(String ibanOrigen, String ibanDestino, double importe) throws BankException {
        //Obtener conexion y libera
        Connection con = PoolConexiones.getConexionLibre();
        try{
            con.setAutoCommit(false); //desactivo la autoconfirmacion
            PreparedStatement pst = con.prepareStatement(UPDATE_SALDO_CUENTA_BANCARIA_POR_IBAN);
            //MODIFICACION DE SALDO (+ cantidadACorregir)
            pst.setDouble(1, importe);
            pst.setString(2, ibanOrigen);
            pst.executeUpdate();
            //MODIFICACION DE SALDO DE OTRA CUENTA (- cantidadACorregir)
            pst.setDouble(1, -importe);
            pst.setString(2, ibanDestino);
            pst.executeUpdate();
            con.commit();
        }
        catch(SQLException e){
            System.out.println("... no se pudo hacer la correcion");
            try{
                con.rollback();
            }
            catch(SQLException ex) {
                System.out.println("ERROR: " + ex.getMessage());
            }
        }
        finally{
            PoolConexiones.liberaConexion(con);
        }
    }
    
}
