/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.gui;

import com.bank.dominio.Cliente;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Manuel
 */
public class ClientesDataModel extends AbstractTableModel{
    
    private List<Cliente> clientes;
    private String[] columnas = {"ID", "NOMBRE", "APELLIDOS", "FECHA NAC", "ID BANCO"};
    
    public ClientesDataModel(List<Cliente> lista) {
        this.clientes = lista;
    }

    @Override
    public int getRowCount() {
        return clientes.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente c = clientes.get(rowIndex);
        Object dato = null;
        switch(columnIndex){
            case 0:
                dato = c.getIdCliente();
                break;
            case 1:
                dato = c.getNombre();
                break;
            case 2:
                dato = c.getApellido();
                break;
            case 3:
                dato = c.getFechaNacimiento();
                break;
            case 4:
                dato = c.getIdBanco();
            break;
        }
        return dato;
    }
    
    @Override
    public String getColumnName(int column){
        return columnas[column];
    } 
    
}
