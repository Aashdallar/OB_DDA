/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mozoApp.vista;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelo.Mesa;
import modelo.Mozo;

/**
 *
 * @author sg0208533
 */
public class DiagTransferirMesa extends javax.swing.JDialog {
    
    private PanelPrincipal panelPrincipal;
    private Mesa mesa;

    public DiagTransferirMesa(java.awt.Frame parent, boolean modal, Mesa mesa, ArrayList<Mozo> mozosLogueados, PanelPrincipal pPrincipal) {
        super(parent, modal);
        initComponents();
        this.panelPrincipal = pPrincipal;
        this.mesa = mesa;
        setTitle("Transferir mesa");
        cargarMozosLista(mesa, mozosLogueados);
        setLocationRelativeTo(panelPrincipal);
        setVisible(true);
    }
    
    private void cargarMozosLista(Mesa mesa, ArrayList<Mozo> mozosLogueados){
        ArrayList<Mozo> lista = new ArrayList();
        for(Mozo m : mozosLogueados){
            if(!mesa.getMozo().equals(m)){
                lista.add(m);
            }
        }
        lstMozos.setListData(lista.toArray());
    }
    
    
    private void transferir(){
        try {
            //Mozo mozo = (Mozo)cmbMozos.getSelectedItem();
            Mozo mozo = (Mozo)lstMozos.getSelectedValue();
            if(mozo != null){
                dispose();
                panelPrincipal.transferirMesa(mozo, mesa);
            } else {
                mozoSeleccionadoError();
            }
        } catch (ClassCastException ex) {
            mozoSeleccionadoError();
        }
    }
    
    private void mozoSeleccionadoError(){
        JOptionPane.showMessageDialog(this, "Seleccione un mozo valido");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTransferir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstMozos = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        btnTransferir.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnTransferir.setText("Transferir");
        btnTransferir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransferirActionPerformed(evt);
            }
        });
        getContentPane().add(btnTransferir);
        btnTransferir.setBounds(110, 210, 160, 50);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setText("Seleccione al mozo y presione Transferir");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 30, 360, 40);

        lstMozos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jScrollPane1.setViewportView(lstMozos);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(40, 70, 320, 120);

        setBounds(0, 0, 416, 325);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTransferirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransferirActionPerformed
        transferir();
    }//GEN-LAST:event_btnTransferirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTransferir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList lstMozos;
    // End of variables declaration//GEN-END:variables
}
