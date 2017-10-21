/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mozoApp.vista;

import javax.swing.JOptionPane;
import modelo.Transferencia;

/**
 *
 * @author SG0208533
 */
public class DiagTransferenciaSolicitar extends javax.swing.JDialog {

    private PanelPrincipal panelPrincipal;
    private Transferencia transferencia;
    public DiagTransferenciaSolicitar(java.awt.Frame parent, boolean modal, Transferencia transferencia, PanelPrincipal pPrincipal) {
        super(parent, modal);
        initComponents();
        panelPrincipal = pPrincipal;
        this.transferencia = transferencia;
        cargarValores();
        setTitle("Pedido de transferencia");
        setLocationRelativeTo(panelPrincipal);
        setVisible(true);
    }
    
    private void cargarValores(){
        lblValueMozo.setText(transferencia.getMesa().getMozo().getNombreCompleto());
        lblValueMesa.setText("" + transferencia.getMesa().getNro());
        if(transferencia.getMesa().estaAbierta())
            lblValueEstado.setText("Abierta");
        else
            lblValueEstado.setText("Cerrada");
    }
    
    private void aceptar() {
        dispose();
        panelPrincipal.aceptarTransferencia();
    }
    
    private void rechazar() {
        dispose();
        panelPrincipal.rechazarTransferencia();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblValueMesa = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblValueMozo = new javax.swing.JLabel();
        lblValueEstado = new javax.swing.JLabel();
        lblTextoMozo = new javax.swing.JLabel();
        lblTextoMesa = new javax.swing.JLabel();
        lblTextoEstado = new javax.swing.JLabel();
        btnRechazar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        lblValueMesa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblValueMesa.setText("XX");
        getContentPane().add(lblValueMesa);
        lblValueMesa.setBounds(100, 120, 60, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Solicitud de Transferencia");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 30, 400, 40);

        lblValueMozo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblValueMozo.setText("XXXXXX XXXXXX");
        getContentPane().add(lblValueMozo);
        lblValueMozo.setBounds(100, 80, 290, 30);

        lblValueEstado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblValueEstado.setText("XXXX");
        getContentPane().add(lblValueEstado);
        lblValueEstado.setBounds(240, 120, 110, 30);

        lblTextoMozo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTextoMozo.setText("Mozo:");
        getContentPane().add(lblTextoMozo);
        lblTextoMozo.setBounds(40, 80, 60, 30);

        lblTextoMesa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTextoMesa.setText("Mesa:");
        getContentPane().add(lblTextoMesa);
        lblTextoMesa.setBounds(40, 120, 60, 30);

        lblTextoEstado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTextoEstado.setText("Estado:");
        getContentPane().add(lblTextoEstado);
        lblTextoEstado.setBounds(170, 120, 70, 30);

        btnRechazar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRechazar.setText("Rechazar");
        btnRechazar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRechazarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRechazar);
        btnRechazar.setBounds(230, 190, 130, 40);

        btnAceptar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAceptar);
        btnAceptar.setBounds(40, 190, 130, 40);

        setBounds(0, 0, 416, 303);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (JOptionPane.showConfirmDialog(null, "Si cierra se toma como rechazada la transferencia?", "Cancelando transferencia",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
            rechazar();
        }
    }//GEN-LAST:event_formWindowClosing

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        aceptar();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnRechazarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRechazarActionPerformed
        rechazar();
    }//GEN-LAST:event_btnRechazarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnRechazar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblTextoEstado;
    private javax.swing.JLabel lblTextoMesa;
    private javax.swing.JLabel lblTextoMozo;
    private javax.swing.JLabel lblValueEstado;
    private javax.swing.JLabel lblValueMesa;
    private javax.swing.JLabel lblValueMozo;
    // End of variables declaration//GEN-END:variables
}
