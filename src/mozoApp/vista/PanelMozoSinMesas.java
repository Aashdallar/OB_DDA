/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mozoApp.vista;

/**
 *
 * @author sg0208533
 */
public class PanelMozoSinMesas extends javax.swing.JPanel {

    /**
     * Creates new form PanelMesaCerrada
     */
    public PanelMozoSinMesas(String mozo) {
        initComponents();
        lblMozo.setText(mozo + ",");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblMozo = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(400, 600));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("no tiene mesas asignadas.");
        add(jLabel1);
        jLabel1.setBounds(20, 260, 360, 50);

        lblMozo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblMozo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMozo.setText("{Mozo},");
        add(lblMozo);
        lblMozo.setBounds(20, 200, 360, 50);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblMozo;
    // End of variables declaration//GEN-END:variables
}
