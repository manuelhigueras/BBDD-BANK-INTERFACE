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
public class ventanaCuentaBancariaAdd extends javax.swing.JFrame {

    private int idCliente;
    
    public ventanaCuentaBancariaAdd(int idCliente) {
        this.idCliente = idCliente;
        initComponents();
    }

    /**
     * Creates new form ventanaCuentaBancariaDet
     */
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblBan = new javax.swing.JLabel();
        lblngreso = new javax.swing.JLabel();
        jTFB = new javax.swing.JTextField();
        jTFI = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();

        setTitle("Crea cuenta bancaria");

        lblTitle.setText("ALTA DE CUENTA BANCARIA");

        lblBan.setText("IBAN NUEVO:");

        lblngreso.setText("SALDO DE INGRESO:");

        jTFI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFIActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregar)
                .addGap(33, 33, 33))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(lblTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(lblBan)
                        .addGap(45, 45, 45)
                        .addComponent(jTFB, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(lblngreso)
                        .addGap(50, 50, 50)
                        .addComponent(jTFI, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(188, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblTitle)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBan)
                    .addComponent(jTFB, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(btnAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFI, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblngreso))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTFIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFIActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        
        try{
            String iban = jTFB.getText();
            double saldo = Double.parseDouble(jTFI.getText());
            GestionCuentasBancarias gcb = new GestionCuentasBancarias();
            //gcb.altaNuevaCuenta(2, new CuentaBancaria("IN7585555",1,2,3000.0));
            //String Iban, int idCuenta, int idCliente, double saldo
            gcb.altaNuevaCuenta(idCliente, new CuentaBancaria(iban,saldo)); 
            this.dispose();
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new ventanaCuentaBanco(idCliente).setVisible(true);
                }
            });
        }
        catch(Exception ex){
            JOptionPane.showConfirmDialog(this, ex.getMessage());
        }
        
    }//GEN-LAST:event_btnAgregarActionPerformed
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JTextField jTFB;
    private javax.swing.JTextField jTFI;
    private javax.swing.JLabel lblBan;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblngreso;
    // End of variables declaration//GEN-END:variables

}
