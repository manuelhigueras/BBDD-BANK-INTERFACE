/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.gui;

import com.bank.dominio.CuentaBancaria;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Manuel
 */
public class CuentaBancariaDataModel extends AbstractTableModel{

private List<CuentaBancaria> cuentas;
    private String[] columnas = {"ID_CLIENTE","IBAN","SALDO","ID_CUENTA"};

    public CuentaBancariaDataModel(List<CuentaBancaria> cuentas) {
        this.cuentas = cuentas;
    }

    @Override
    public int getRowCount() {
        return cuentas.size() ;
    }

    @Override
    public int getColumnCount() {
        return columnas.length ;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         CuentaBancaria c = cuentas.get(rowIndex);
         Object dato = null;
         switch(columnIndex){
            case 0:
                dato = c.getIdCliente();
                break;
            case 1:
                dato = c.getIban();
                break;
            case 2:
                dato = c.getSaldo();
                break;
            case 3:
                dato = c.getIdCuenta();
                break;
         }      
         return dato;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column]; 
    }
    
}
