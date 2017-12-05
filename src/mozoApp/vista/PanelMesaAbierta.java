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

/**
 *
 * @author sg0208533
 */
public class PanelMesaAbierta extends javax.swing.JPanel {

    private PanelPrincipalMozo panelPrincipal;
    
    public PanelMesaAbierta(PanelPrincipalMozo pPrincipal, Mesa mesa) {
        initComponents();
        this.panelPrincipal = pPrincipal;
        mostrar(mesa);
    }
    
    private void mostrar(Mesa mesa){
        lbl_mesaSeleccionadaValor.setText(mesa.getNro() + "");
        if(mesa.getTransferencia() == null){
            btnTransferirMesa.setEnabled(true);
        } else {
            btnTransferirMesa.setEnabled(false);
        }
        cargarServicio(mesa);
    }
    
    private void cargarServicio(Mesa mesa){
        DefaultTableModel tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable table = new JTable();
        
        tableModel.setColumnIdentifiers(new Object[] {
                "Cnt", "Item", "Precio" });
        
        if(mesa.getServicio() != null){
            for (int i = 0; i < mesa.getServicio().getItems().size(); i++) {
                //Item = servicio.getItems().get(i);
                tableModel.insertRow(i, createTableRow(mesa.getServicio().getItems().get(i)));
                table.setRowHeight(40);
            }
            table.setModel(tableModel);
            table.getColumnModel().getColumn(0).setPreferredWidth(5);
            table.getColumnModel().getColumn(1).setPreferredWidth(220);
            table.getColumnModel().getColumn(2).setPreferredWidth(10);
            JScrollPane pane = new JScrollPane(table);
            pane.setPreferredSize(new Dimension(380, 230));
            tblPanelSpace.removeAll();
            tblPanelSpace.add(pane);
            tblPanelSpace.validate();
            
            cargarEtiquetas(mesa);
        }
    }
    
    private void cargarEtiquetas(Mesa mesa) {
        lbl_servicioTotalValue.setText("$ " + mesa.getServicio().getMontoTotalAAbonar());
        lbl_clienteDescuentoPorBeneficio_Value.setText("$ " + mesa.getServicio().getMontoDescontado());
        lbl_clienteTotalSinBeneficio_Value.setText("$ " + mesa.getServicio().getMontoTotalSinDescuento());
        
        lbl_clienteNombre_Value.setText(mesa.getClienteNombre());
        lbl_clienteBeneficioDescripcion_Value.setText(mesa.getClienteBeneficioTexto());
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
    
    private void agregarCliente() {
        new DialogAgregarClienteAMesa(null, true, panelPrincipal);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_mesaSeleccionadaValor = new javax.swing.JLabel();
        lbl_clienteBeneficioDescripcion_Label = new javax.swing.JLabel();
        lbl_mesaSeleccionadaLabel = new javax.swing.JLabel();
        lbl_servicioTotalValue = new javax.swing.JLabel();
        tblPanelSpace = new javax.swing.JPanel();
        btnCerrarMesa = new javax.swing.JButton();
        btnTransferirMesa = new javax.swing.JButton();
        btnAgregarItem = new javax.swing.JButton();
        btnAgregarCliente = new javax.swing.JButton();
        lbl_servicioTotalLabel = new javax.swing.JLabel();
        lbl_clienteNombre_Value = new javax.swing.JLabel();
        lbl_clienteTotalSinBeneficio_Label = new javax.swing.JLabel();
        lbl_clienteBeneficioDescripcion_Value = new javax.swing.JLabel();
        lbl_clienteNombre_Label = new javax.swing.JLabel();
        lbl_clienteTotalSinBeneficio_Value = new javax.swing.JLabel();
        lbl_clienteDescuentoPorBeneficio_Label = new javax.swing.JLabel();
        lbl_clienteDescuentoPorBeneficio_Value = new javax.swing.JLabel();

        setLayout(null);

        lbl_mesaSeleccionadaValor.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbl_mesaSeleccionadaValor.setText("1");
        add(lbl_mesaSeleccionadaValor);
        lbl_mesaSeleccionadaValor.setBounds(230, 20, 60, 30);

        lbl_clienteBeneficioDescripcion_Label.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl_clienteBeneficioDescripcion_Label.setText("Beneficio:");
        add(lbl_clienteBeneficioDescripcion_Label);
        lbl_clienteBeneficioDescripcion_Label.setBounds(20, 460, 80, 20);

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
        btnCerrarMesa.setBounds(30, 540, 160, 50);

        btnTransferirMesa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnTransferirMesa.setText("Transferir");
        btnTransferirMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransferirMesaActionPerformed(evt);
            }
        });
        add(btnTransferirMesa);
        btnTransferirMesa.setBounds(210, 540, 160, 50);

        btnAgregarItem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAgregarItem.setText("(+) Agregar Item");
        btnAgregarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarItemActionPerformed(evt);
            }
        });
        add(btnAgregarItem);
        btnAgregarItem.setBounds(120, 340, 160, 50);

        btnAgregarCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAgregarCliente.setText("Agregar Cliente");
        btnAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarClienteActionPerformed(evt);
            }
        });
        add(btnAgregarCliente);
        btnAgregarCliente.setBounds(120, 490, 160, 40);

        lbl_servicioTotalLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_servicioTotalLabel.setText("Total a abonar:");
        add(lbl_servicioTotalLabel);
        lbl_servicioTotalLabel.setBounds(90, 300, 170, 30);

        lbl_clienteNombre_Value.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl_clienteNombre_Value.setText("No hay cliente agregado");
        add(lbl_clienteNombre_Value);
        lbl_clienteNombre_Value.setBounds(100, 440, 280, 20);

        lbl_clienteTotalSinBeneficio_Label.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl_clienteTotalSinBeneficio_Label.setText("Total sin beneficio:");
        add(lbl_clienteTotalSinBeneficio_Label);
        lbl_clienteTotalSinBeneficio_Label.setBounds(20, 420, 190, 20);

        lbl_clienteBeneficioDescripcion_Value.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl_clienteBeneficioDescripcion_Value.setText("Sin beneficio");
        add(lbl_clienteBeneficioDescripcion_Value);
        lbl_clienteBeneficioDescripcion_Value.setBounds(100, 460, 280, 20);

        lbl_clienteNombre_Label.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl_clienteNombre_Label.setText("Cliente:");
        add(lbl_clienteNombre_Label);
        lbl_clienteNombre_Label.setBounds(20, 440, 80, 20);

        lbl_clienteTotalSinBeneficio_Value.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl_clienteTotalSinBeneficio_Value.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbl_clienteTotalSinBeneficio_Value.setText("$1000.00");
        add(lbl_clienteTotalSinBeneficio_Value);
        lbl_clienteTotalSinBeneficio_Value.setBounds(210, 420, 80, 20);

        lbl_clienteDescuentoPorBeneficio_Label.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl_clienteDescuentoPorBeneficio_Label.setText("Descuento por beneficio:");
        add(lbl_clienteDescuentoPorBeneficio_Label);
        lbl_clienteDescuentoPorBeneficio_Label.setBounds(20, 400, 190, 20);

        lbl_clienteDescuentoPorBeneficio_Value.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl_clienteDescuentoPorBeneficio_Value.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbl_clienteDescuentoPorBeneficio_Value.setText("$1000.00");
        add(lbl_clienteDescuentoPorBeneficio_Value);
        lbl_clienteDescuentoPorBeneficio_Value.setBounds(210, 400, 80, 20);
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

    private void btnAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarClienteActionPerformed
        agregarCliente();
    }//GEN-LAST:event_btnAgregarClienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCliente;
    private javax.swing.JButton btnAgregarItem;
    private javax.swing.JButton btnCerrarMesa;
    private javax.swing.JButton btnTransferirMesa;
    private javax.swing.JLabel lbl_clienteBeneficioDescripcion_Label;
    private javax.swing.JLabel lbl_clienteBeneficioDescripcion_Value;
    private javax.swing.JLabel lbl_clienteDescuentoPorBeneficio_Label;
    private javax.swing.JLabel lbl_clienteDescuentoPorBeneficio_Value;
    private javax.swing.JLabel lbl_clienteNombre_Label;
    private javax.swing.JLabel lbl_clienteNombre_Value;
    private javax.swing.JLabel lbl_clienteTotalSinBeneficio_Label;
    private javax.swing.JLabel lbl_clienteTotalSinBeneficio_Value;
    private javax.swing.JLabel lbl_mesaSeleccionadaLabel;
    private javax.swing.JLabel lbl_mesaSeleccionadaValor;
    private javax.swing.JLabel lbl_servicioTotalLabel;
    private javax.swing.JLabel lbl_servicioTotalValue;
    private javax.swing.JPanel tblPanelSpace;
    // End of variables declaration//GEN-END:variables

}
