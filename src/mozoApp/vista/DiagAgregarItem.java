/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mozoApp.vista;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelo.Item;
import modelo.ModeloException;
import modelo.Producto;
import modelo.Servicio;
import modelo.UnidadProcesadora;

public class DiagAgregarItem extends javax.swing.JDialog {
    
    private PanelPrincipal panelPrincipal;
    private Servicio servicio;

    public DiagAgregarItem(java.awt.Frame parent, boolean modal, PanelPrincipal pPrincipal, Servicio servicio, ArrayList<Producto> productos) {
        super(parent, modal);
        initComponents();
        cargarComboBox(productos);
        this.panelPrincipal = pPrincipal;
        this.servicio = servicio;
        setTitle("Agregar un item al servicio");
        
    }
    
    private void cargarComboBox(ArrayList<Producto> productos){
        DefaultComboBoxModel comboModel = (DefaultComboBoxModel)cmbProductos.getModel();
        cmbProductos.removeAllItems();
        
        if(productos.size() > 0){
            comboModel.addElement("Seleccionar producto");
            for(Producto p : productos){
                comboModel.addElement(p);
            }
        } else {
            comboModel.addElement("Sin disponibilidad");
        }
        cmbProductos.validate();
        cmbProductos.setVisible(true);
    }
    
    private void agregarItem(){
        try {
            Item item = new Item();
            item.setCantidad(Integer.parseInt(txtCantidad.getText()));
            if(txtDescripcion.getText() != null) item.setDescripcion(txtDescripcion.getText());
            item.setProducto((Producto)cmbProductos.getSelectedItem());
            panelPrincipal.agregarItemALaMesa(servicio, item);
            dispose();
        }
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "La cantidad debe de ser un número mayor a 0 (cero)");
        }
        catch (ClassCastException ex){
            JOptionPane.showMessageDialog(this, "Seleccione un producto válido");
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbProductos = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        cmbProductos.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        getContentPane().add(cmbProductos);
        cmbProductos.setBounds(130, 50, 240, 40);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Alguna descripción o aclaración?");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 110, 240, 30);

        txtCantidad.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        getContentPane().add(txtCantidad);
        txtCantidad.setBounds(30, 50, 90, 40);

        txtDescripcion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(txtDescripcion);
        txtDescripcion.setBounds(30, 140, 340, 90);

        btnAgregar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar);
        btnAgregar.setBounds(110, 240, 180, 40);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Selecciona el Item a agregar e indica la cantidad:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 20, 350, 30);

        setBounds(0, 0, 416, 338);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        agregarItem();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        agregarItem();
    }//GEN-LAST:event_txtCantidadActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JComboBox cmbProductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtDescripcion;
    // End of variables declaration//GEN-END:variables
}
