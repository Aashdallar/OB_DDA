/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mozoApp.vista;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class DialogAgregarClienteAMesa extends javax.swing.JDialog {
    
    private PanelPrincipalMozo panelPrincipal;

    public DialogAgregarClienteAMesa(java.awt.Frame parent, boolean modal, PanelPrincipalMozo pPrincipal) {
        super(parent, modal);
        initComponents();
        panelPrincipal = pPrincipal;
        setTitle("Agregar un cliente registrado");
    }
    
    private void agregarCliente() {
        try{
            if(txtClienteID.getText().isEmpty()){
                errorMessage("Porfavor ingrese un id numérico de cliente");
            } else {
                int id = Integer.parseInt(txtClienteID.getText());
                dispose();
                panelPrincipal.agregarCliente(id);
            }
        } catch(NumberFormatException ex){
            errorMessage("Porfavor ingrese un id numérico de cliente");
        }
    }
    private void errorMessage(String msg){
        JOptionPane.showMessageDialog(this, msg);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtClienteID = new javax.swing.JTextField();
        btnAgregarCliente = new javax.swing.JButton();
        jLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        txtClienteID.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtClienteID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClienteIDActionPerformed(evt);
            }
        });
        getContentPane().add(txtClienteID);
        txtClienteID.setBounds(30, 110, 340, 40);

        btnAgregarCliente.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnAgregarCliente.setText("Agregar");
        btnAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarClienteActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregarCliente);
        btnAgregarCliente.setBounds(110, 170, 180, 40);

        jLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel.setText("Ingrese el id del cliente y presione Agregar");
        getContentPane().add(jLabel);
        jLabel.setBounds(30, 70, 350, 30);

        setBounds(0, 0, 416, 338);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarClienteActionPerformed
        agregarCliente();
    }//GEN-LAST:event_btnAgregarClienteActionPerformed

    private void txtClienteIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClienteIDActionPerformed
        agregarCliente();
    }//GEN-LAST:event_txtClienteIDActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCliente;
    private javax.swing.JLabel jLabel;
    private javax.swing.JTextField txtClienteID;
    // End of variables declaration//GEN-END:variables

}
