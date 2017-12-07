/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestorApp.vista;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelo.UnidadProcesadora;

/**
 *
 * @author SG0208533
 */
public class SeleccionarUnidadDialog extends javax.swing.JDialog {

    private LoginDialog loginDialog;
    
    public SeleccionarUnidadDialog(java.awt.Frame parent, boolean modal, ArrayList<UnidadProcesadora> unidades, LoginDialog loginDialog) {
        super(parent, modal);
        initComponents();
        this.loginDialog = loginDialog;
        cargarUnidades(unidades);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void cargarUnidades(ArrayList<UnidadProcesadora> unidades){
        DefaultComboBoxModel comboModel = (DefaultComboBoxModel)cmbUnidadProcesadora.getModel();
        cmbUnidadProcesadora.removeAllItems();
        
        if(unidades.size() > 0){
            comboModel.addElement("Seleccionar Unidad");
            for(UnidadProcesadora u : unidades){
                comboModel.addElement(u);
            }
        } else {
            comboModel.addElement("No hay Unidades");
        }
        cmbUnidadProcesadora.validate();
        cmbUnidadProcesadora.setVisible(true);
    }

    private void finalizarLogin(){
        try{
            UnidadProcesadora unidad = (UnidadProcesadora)cmbUnidadProcesadora.getSelectedItem();
            loginDialog.unidadSeleccionada(unidad);
            dispose();
        } catch (ClassCastException ex) {
            JOptionPane.showMessageDialog(this, "Seleccione una unidad de proceso válida");
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbUnidadProcesadora = new javax.swing.JComboBox();
        btnSeleccionar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        cmbUnidadProcesadora.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        cmbUnidadProcesadora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbUnidadProcesadoraActionPerformed(evt);
            }
        });
        getContentPane().add(cmbUnidadProcesadora);
        cmbUnidadProcesadora.setBounds(20, 70, 300, 50);

        btnSeleccionar.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSeleccionar);
        btnSeleccionar.setBounds(80, 150, 180, 50);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Seleccionar Unidad Procesadora");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 40, 340, 30);

        setBounds(0, 0, 359, 279);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbUnidadProcesadoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbUnidadProcesadoraActionPerformed

    }//GEN-LAST:event_cmbUnidadProcesadoraActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        finalizarLogin();
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        loginDialog.desloguear();
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JComboBox cmbUnidadProcesadora;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
