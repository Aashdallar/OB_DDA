/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mozoApp.vista;

import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Item;
import modelo.Mesa;
import modelo.Servicio;

/**
 *
 * @author sg0208533
 */
public class PanelMesaAbierta extends javax.swing.JPanel {

    private Mesa mesa;
    private PanelPrincipalMozo panelPrincipal;
    
    public PanelMesaAbierta(PanelPrincipalMozo pPrincipal, Mesa mesa) {
        initComponents();
        this.mesa = mesa;
        this.panelPrincipal = pPrincipal;
        mostrar();
    }
    
    public void mostrar(){
        lbl_mesaSeleccionadaValor.setText(mesa.getNro() + "");
        if(mesa.getTransferencia() == null){
            btnTransferirMesa.setEnabled(true);
        } else {
            btnTransferirMesa.setEnabled(false);
        }
        cargarServicio(mesa.getServicio());
    }
    
    private void cargarServicio(Servicio servicio){
        DefaultTableModel tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable table = new JTable();
        
        tableModel.setColumnIdentifiers(new Object[] {
                "Cnt", "Item", "Precio" });
        
        if(servicio != null){
            for (int i = 0; i < servicio.getItems().size(); i++) {
                //Item = servicio.getItems().get(i);
                tableModel.insertRow(i, createTableRow(servicio.getItems().get(i)));
                table.setRowHeight(40);
            }
        lbl_servicioTotalValue.setText("$ " + mesa.getServicio().montoTotal());
        
        table.setModel(tableModel);
        table.getColumnModel().getColumn(0).setPreferredWidth(5);
        table.getColumnModel().getColumn(1).setPreferredWidth(220);
        table.getColumnModel().getColumn(2).setPreferredWidth(10);
        JScrollPane pane = new JScrollPane(table);
        pane.setPreferredSize(new Dimension(380, 230));
        tblPanelSpace.removeAll();
        tblPanelSpace.add(pane);
        tblPanelSpace.validate();
        }
    }
    private String[] createTableRow(Item item){
        // Nombre ($ 00)
        // Estado (Gestor)
        // Estados: Pendiente, En Proceso, Finalizado
        String estado = "";
        switch (item.getEstado()){
            case pendiente:
                estado = "Pendiente";
                break;
            case enProceso:
                estado = "En Proceso (" + item.getPedido().getGestor().getNombreCompleto() + ")";
                break;
            case finalizado:
                estado = "Finalizado (" + item.getPedido().getGestor().getNombreCompleto() + ")";
                break;
        }
                
        String itemVal = "<html>" + item.getProducto().getNombre() + " ($ "
                + item.getPrecioUnitario() + ")<br />" + estado + "</html>";
        
        return new String[] { "" + item.getCantidad(), itemVal, "$ " + item.getMonto() };
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_mesaSeleccionadaValor = new javax.swing.JLabel();
        lbl_servicioTotalLabel = new javax.swing.JLabel();
        lbl_mesaSeleccionadaLabel = new javax.swing.JLabel();
        lbl_servicioTotalValue = new javax.swing.JLabel();
        tblPanelSpace = new javax.swing.JPanel();
        btnCerrarMesa = new javax.swing.JButton();
        btnTransferirMesa = new javax.swing.JButton();
        btnAgregarItem = new javax.swing.JButton();

        setLayout(null);

        lbl_mesaSeleccionadaValor.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbl_mesaSeleccionadaValor.setText("1");
        add(lbl_mesaSeleccionadaValor);
        lbl_mesaSeleccionadaValor.setBounds(230, 20, 60, 30);

        lbl_servicioTotalLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_servicioTotalLabel.setText("Total:");
        add(lbl_servicioTotalLabel);
        lbl_servicioTotalLabel.setBounds(180, 300, 70, 30);

        lbl_mesaSeleccionadaLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_mesaSeleccionadaLabel.setText("Mesa Seleccionada:");
        add(lbl_mesaSeleccionadaLabel);
        lbl_mesaSeleccionadaLabel.setBounds(20, 20, 210, 30);

        lbl_servicioTotalValue.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_servicioTotalValue.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbl_servicioTotalValue.setText("$1000.00");
        add(lbl_servicioTotalValue);
        lbl_servicioTotalValue.setBounds(260, 300, 120, 30);
        add(tblPanelSpace);
        tblPanelSpace.setBounds(10, 60, 380, 230);

        btnCerrarMesa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCerrarMesa.setText("Cerrar Mesa");
        btnCerrarMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarMesaActionPerformed(evt);
            }
        });
        add(btnCerrarMesa);
        btnCerrarMesa.setBounds(30, 480, 160, 50);

        btnTransferirMesa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnTransferirMesa.setText("Transferir");
        btnTransferirMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransferirMesaActionPerformed(evt);
            }
        });
        add(btnTransferirMesa);
        btnTransferirMesa.setBounds(210, 480, 160, 50);

        btnAgregarItem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAgregarItem.setText("(+) Agregar Item");
        btnAgregarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarItemActionPerformed(evt);
            }
        });
        add(btnAgregarItem);
        btnAgregarItem.setBounds(120, 350, 160, 50);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarItemActionPerformed
        panelPrincipal.AgregarItem();
    }//GEN-LAST:event_btnAgregarItemActionPerformed

    private void btnCerrarMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarMesaActionPerformed
        if (JOptionPane.showConfirmDialog(panelPrincipal, "Esta seguro que desea cerrar la mesa?", "Cerrando mesa",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
            panelPrincipal.CerrarMesa();
        }
    }//GEN-LAST:event_btnCerrarMesaActionPerformed

    private void btnTransferirMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransferirMesaActionPerformed
        panelPrincipal.iniciarTransferirMesa();
    }//GEN-LAST:event_btnTransferirMesaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarItem;
    private javax.swing.JButton btnCerrarMesa;
    private javax.swing.JButton btnTransferirMesa;
    private javax.swing.JLabel lbl_mesaSeleccionadaLabel;
    private javax.swing.JLabel lbl_mesaSeleccionadaValor;
    private javax.swing.JLabel lbl_servicioTotalLabel;
    private javax.swing.JLabel lbl_servicioTotalValue;
    private javax.swing.JPanel tblPanelSpace;
    // End of variables declaration//GEN-END:variables

}
