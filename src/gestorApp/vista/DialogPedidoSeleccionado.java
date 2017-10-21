/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestorApp.vista;

import javax.swing.JOptionPane;
import modelo.Item;
import modelo.Item.Estado;
import modelo.Pedido;

/**
 *
 * @author SG0208533
 */
public class DialogPedidoSeleccionado extends javax.swing.JDialog {

    private PanelPrincipalGestor panelPrincipal;

    public DialogPedidoSeleccionado(java.awt.Frame parent, boolean modal, Pedido pedido, PanelPrincipalGestor pPrincipal) {
        super(parent, modal);
        initComponents();
        panelPrincipal = pPrincipal;
        cargarValores(pedido);
        setTitle("Pedido");
        setLocationRelativeTo(panelPrincipal);
        setVisible(true);
    }
    
    private void cargarValores(Pedido pedido){
        labelItemVal.setText(pedido.getItem().toString());
        labelMesaVal.setText(pedido.getItem().getServicio().getMesa().getNro()+"");
        if(pedido.getItem().getEstado().equals(Estado.enProceso)){
            labelTipoSeleccion.setText("Pedido para finalizar");
            labelEstadoVal.setText("En proceso");
            btnConfirmar.setText("Finalizar");
        } else if (pedido.getItem().getEstado().equals(Estado.pendiente)){
            labelTipoSeleccion.setText("Pedido para procesar");
            btnConfirmar.setText("Procesar");
            labelEstadoVal.setText("Pendiente");
        }
    }
    
    private void confirmar() {
        dispose();
        panelPrincipal.confirmarSeleccion();
    }
    
    private void cancelar() {
        dispose();
        panelPrincipal.cancelarSeleccion();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelMesaVal = new javax.swing.JLabel();
        labelTipoSeleccion = new javax.swing.JLabel();
        labelItemVal = new javax.swing.JLabel();
        labelEstadoVal = new javax.swing.JLabel();
        labelItem = new javax.swing.JLabel();
        labelMesa = new javax.swing.JLabel();
        labelEstado = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        labelMesaVal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelMesaVal.setText("XX");
        getContentPane().add(labelMesaVal);
        labelMesaVal.setBounds(100, 120, 60, 30);

        labelTipoSeleccion.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labelTipoSeleccion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTipoSeleccion.setText("Pedido");
        getContentPane().add(labelTipoSeleccion);
        labelTipoSeleccion.setBounds(0, 30, 400, 40);

        labelItemVal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelItemVal.setText("XXXXXX XXXXXX");
        getContentPane().add(labelItemVal);
        labelItemVal.setBounds(100, 80, 290, 30);

        labelEstadoVal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelEstadoVal.setText("XXXX");
        getContentPane().add(labelEstadoVal);
        labelEstadoVal.setBounds(240, 120, 110, 30);

        labelItem.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelItem.setText("Item:");
        getContentPane().add(labelItem);
        labelItem.setBounds(40, 80, 60, 30);

        labelMesa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelMesa.setText("Mesa:");
        getContentPane().add(labelMesa);
        labelMesa.setBounds(40, 120, 60, 30);

        labelEstado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelEstado.setText("Estado:");
        getContentPane().add(labelEstado);
        labelEstado.setBounds(170, 120, 70, 30);

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar);
        btnCancelar.setBounds(230, 190, 130, 40);

        btnConfirmar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });
        getContentPane().add(btnConfirmar);
        btnConfirmar.setBounds(40, 190, 130, 40);

        setBounds(0, 0, 416, 303);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        cancelar();
    }//GEN-LAST:event_formWindowClosing

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        confirmar();
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        cancelar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JLabel labelEstado;
    private javax.swing.JLabel labelEstadoVal;
    private javax.swing.JLabel labelItem;
    private javax.swing.JLabel labelItemVal;
    private javax.swing.JLabel labelMesa;
    private javax.swing.JLabel labelMesaVal;
    private javax.swing.JLabel labelTipoSeleccion;
    // End of variables declaration//GEN-END:variables
}
