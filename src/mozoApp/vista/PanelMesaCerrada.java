/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mozoApp.vista;

import modelo.Mesa;

/**
 *
 * @author sg0208533
 */
public class PanelMesaCerrada extends javax.swing.JPanel {

    private PanelPrincipalMozo panelPrincipal;
    private Mesa mesa;
    
    public PanelMesaCerrada(PanelPrincipalMozo pPrincipal, Mesa mesa) {
        initComponents();
        this.panelPrincipal = pPrincipal;
        this.mesa = mesa;
        lblMesa.setText("La mesa " + mesa.getNro() + " está cerrada,");
        if(this.mesa.getTransferencia() == null) {
            btn_TransferirMesa.setEnabled(true);
        } else {
            btn_TransferirMesa.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        lblMesa = new javax.swing.JLabel();
        btn_TransferirMesa = new javax.swing.JButton();
        btn_AbrirMesa = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(400, 600));
        setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("para abrirla haga click en Abrir");
        add(jLabel2);
        jLabel2.setBounds(0, 119, 400, 30);

        lblMesa.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblMesa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMesa.setText("La mesa está cerrada,");
        add(lblMesa);
        lblMesa.setBounds(0, 90, 400, 29);

        btn_TransferirMesa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_TransferirMesa.setText("Transferir");
        btn_TransferirMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TransferirMesaActionPerformed(evt);
            }
        });
        add(btn_TransferirMesa);
        btn_TransferirMesa.setBounds(100, 450, 190, 50);

        btn_AbrirMesa.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_AbrirMesa.setText("Abrir");
        btn_AbrirMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AbrirMesaActionPerformed(evt);
            }
        });
        add(btn_AbrirMesa);
        btn_AbrirMesa.setBounds(100, 180, 190, 100);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_TransferirMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TransferirMesaActionPerformed
        panelPrincipal.iniciarTransferirMesa();
    }//GEN-LAST:event_btn_TransferirMesaActionPerformed

    private void btn_AbrirMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AbrirMesaActionPerformed
        panelPrincipal.abrirMesa();
    }//GEN-LAST:event_btn_AbrirMesaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_AbrirMesa;
    private javax.swing.JButton btn_TransferirMesa;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblMesa;
    // End of variables declaration//GEN-END:variables
}
