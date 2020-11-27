/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.gui;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author user
 */
public class CafeTableModel extends AbstractTableModel {

    //Atributos
    private String[] nombreColumnas = {"ID CAFE", "NOMBRE", "STOCK"};
    private List<Cafe> datos;

    public CafeTableModel(List<Cafe> datos) {
        this.datos = datos;
    }
           
    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return nombreColumnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cafe cafe = datos.get(rowIndex);
        Object valor = null;
        switch(columnIndex){
            case 0:
                valor = cafe.getId();
            break;
            case 1:
                valor = cafe.getNombre();
            break;
            case 2: 
                valor = cafe.getCantidad();
            break;
        }
        return valor;
    }
    
    @Override
    public String getColumnName(int column){
        return nombreColumnas[column];
    }
    
}
