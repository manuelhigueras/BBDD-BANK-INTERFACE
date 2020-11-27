/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.servicios;

import com.bank.dominio.Banco;
import com.bank.dominio.Cliente;
import com.bank.dominio.CuentaBancaria;
import com.bank.excepciones.BankException;
import com.db.PoolConexiones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class GestionBanco implements GestionBancoInterface, GestionClienteInterface, GestionCuentasBancariasInterface{

    private static final String SELECT_ALL_CLIENTES_BANCO = "SELECT * "
            + "FROM CLIENTES " + "WHERE ID_BANCO = ? ";
    
    private static final String SELECT_ALL_CUENTAS_BANCARIAS_FOR_CLIENTE = "SELECT C.NOMBRE, C.APELLIDOS, CB.IBAN, CB.SALDO FROM " +
            "CLIENTES C INNER JOIN CUENTAS_BANCARIAS CB ON C.ID_CLIENTE = CB.ID_CLIENTE";
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
       
    }

    public Banco getBancoPorId(int idBanco) throws BankException, SQLException {
        Banco banco = null;
        //INICIALIZAS
        String query = "SELECT ID_BANCO, NOMBRE FROM BANCOS WHERE ID_BANCO = 1";
        Connection con = PoolConexiones.getConexionLibre();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, idBanco);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                banco = new Banco(rs.getInt("ID_BANCO"), rs.getString("NOMBRE"));
            }
            else{
                throw new BankException("No hay un banco con id = " + idBanco);
            }
        }
        finally{
            PoolConexiones.liberaConexion(con);
        }
        return banco;
    }

    @Override
    public List<Cliente> getClientesPorIdBanco(int idBanco) throws BankException, SQLException {
        List<Cliente> clientes = new ArrayList<Cliente>();
        Connection con = PoolConexiones.getConexionLibre();
        try{
            PreparedStatement ps = con.prepareStatement(SELECT_ALL_CLIENTES_BANCO);
            ps.setInt(1, idBanco);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Cliente c = new Cliente();
                c.setIdCliente(rs.getInt("ID_CLIENTE"));
                c.setNombre(rs.getString("NOMBRE"));
                c.setApellido(rs.getString("APELLIDO"));
                c.setFechaNacimiento(rs.getDate("FECHA_NACIMIENTO"));
                c.setIdBanco(rs.getInt("ID_BANCO"));
                clientes.add(c);
            }
        }
        finally{
            PoolConexiones.liberaConexion(con);
        }
        return clientes;
    }

    @Override
    public List<CuentaBancaria> getCuentasBancariasPorCliente(int idCliente) throws BankException, SQLException {
        List<CuentaBancaria> cuentaBancaria = new ArrayList<CuentaBancaria>();
        Connection con = PoolConexiones.getConexionLibre();
        try{
            PreparedStatement ps = con.prepareStatement(SELECT_ALL_CUENTAS_BANCARIAS_FOR_CLIENTE);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                CuentaBancaria cb = new CuentaBancaria();
                cb.setIdCuenta(rs.getInt("ID_CUENTA"));
                cb.setIban(rs.getString("IBAN"));
                cb.setSaldo(rs.getInt("SALDO"));
                cb.setIdCliente(rs.getInt("ID_CLIENTE"));
                cuentaBancaria.add(cb);
            }
        }
        finally{
            PoolConexiones.liberaConexion(con);
        }
        return cuentaBancaria;
    }

    @Override
    public void altaNuevaCuenta(int idCliente, CuentaBancaria cuenta) throws BankException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ingresar(int iban, double importe) throws BankException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sacar(int iban, double importe) throws BankException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
