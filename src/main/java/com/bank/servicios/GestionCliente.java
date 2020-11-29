/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.servicios;

import com.bank.dominio.Cliente;
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
 * @author Manuel
 */
public class GestionCliente implements GestionClienteInterface{
    
    private static final String SELECT_ALL_CLIENTES_BANCO = "SELECT * FROM CLIENTES WHERE ID_BANCO = ? ";
    
    public static void main(String[] args) {
        try{
           GestionCliente gb = new GestionCliente();
           List<Cliente> lista = gb.getClientesPorIdBanco(1);
           System.out.println(lista.toString());
       }
       catch(BankException ex){
           System.out.println("ERROR EN: " + ex.getMessage());
       }
       catch(SQLException e){
           System.out.println("ERROR EN: " + e.getMessage());
       }
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
                c.setApellido(rs.getString("APELLIDOS"));
                c.setFechaNacimiento(rs.getDate("FECHA_NACIMIENTO"));
                c.setIdBanco(rs.getInt("ID_BANCO"));
                clientes.add(c);
            }
            System.out.println("GUARDADO");
        }
        finally{
            PoolConexiones.liberaConexion(con);
        }
        return clientes;
    }
}
