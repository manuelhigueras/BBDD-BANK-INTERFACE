/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.gui;

import com.bank.dominio.CuentaBancaria;
import com.bank.servicios.GestionCuentasBancarias;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Manuel
 */
public class ventanaCuentaBanco extends javax.swing.JFrame {

    /**
     * Creates new form ventanaBanco2
     */
    private List<CuentaBancaria> lista;
    private int idCliente;
    private boolean condIngreso, condRetiro;
    
    public ventanaCuentaBanco(int idCliente) {
        this.idCliente = idCliente;
        initComponents();
        inicializaCuenta();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCB = new javax.swing.JTable();
        btnIngresar = new javax.swing.JButton();
        btnRetirar = new javax.swing.JButton();
        btnAddCB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CST Cuenta Bancaria");

        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Cuenta Bancaria");

        jTableCB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableCB);

        btnIngresar.setText("Ingresar a la cuenta");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        btnRetirar.setText("Retirar de la cuenta");
        btnRetirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetirarActionPerformed(evt);
            }
        });

        btnAddCB.setText("Agregar una cuenta bancaria");
        btnAddCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnIngresar)
                .addGap(18, 18, 18)
                .addComponent(btnRetirar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddCB)
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(186, 186, 186))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngresar)
                    .addComponent(btnRetirar)
                    .addComponent(btnAddCB))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        try{
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    condIngreso = true;
                    condRetiro = false;
                    new ventanaIngresoRetiro(idCliente, condIngreso, condRetiro).setVisible(true);
                    dispose();
                }
            });
        }
        catch(Exception ex){
            
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnAddCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCBActionPerformed
        try{
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new ventanaCuentaBancariaAdd(idCliente, lista).setVisible(true);
                    dispose();
                }
            });
        }
        catch(Exception ex){
            
        }
    }//GEN-LAST:event_btnAddCBActionPerformed

    private void btnRetirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetirarActionPerformed
        try{
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    condIngreso = false;
                    condRetiro = true;
                    new ventanaIngresoRetiro(idCliente, condIngreso, condRetiro).setVisible(true);
                    dispose();
                }
            });
        }
        catch(Exception ex){
            
        }        
    }//GEN-LAST:event_btnRetirarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCB;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnRetirar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCB;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables

    private void inicializaCuenta() {
        try{
            GestionCuentasBancarias gcb = new GestionCuentasBancarias();
            lista = gcb.getCuentasBancariasPorCliente(idCliente);
            jTableCB.setModel(new CuentaBancariaDataModel(lista));          
        }
        catch(Exception ex){
            JOptionPane.showConfirmDialog(this, ex.getMessage());
        }
    }
}
