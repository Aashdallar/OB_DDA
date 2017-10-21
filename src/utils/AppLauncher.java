/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author SG0208533
 */
public class AppLauncher extends javax.swing.JDialog {

    /**
     * Creates new form AppLauncher
     */
    public AppLauncher(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        startGestoresApp = new javax.swing.JButton();
        startMozosApp = new javax.swing.JButton();
        etiquetaSeleccionApp = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        startGestoresApp.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        startGestoresApp.setText("Gestores");
        startGestoresApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startGestoresAppActionPerformed(evt);
            }
        });
        getContentPane().add(startGestoresApp);
        startGestoresApp.setBounds(230, 80, 180, 170);

        startMozosApp.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        startMozosApp.setText("Mozos");
        startMozosApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startMozosAppActionPerformed(evt);
            }
        });
        getContentPane().add(startMozosApp);
        startMozosApp.setBounds(30, 80, 180, 170);

        etiquetaSeleccionApp.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        etiquetaSeleccionApp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaSeleccionApp.setText("Seleccione la applicación");
        getContentPane().add(etiquetaSeleccionApp);
        etiquetaSeleccionApp.setBounds(30, 40, 380, 30);

        setBounds(0, 0, 457, 331);
    }// </editor-fold>//GEN-END:initComponents

    private void startMozosAppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startMozosAppActionPerformed
        new mozoApp.vista.LoginDialog(null, false).setVisible(true);
    }//GEN-LAST:event_startMozosAppActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    private void startGestoresAppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startGestoresAppActionPerformed
        new gestorApp.vista.LoginDialog(null, false).setVisible(true);
    }//GEN-LAST:event_startGestoresAppActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel etiquetaSeleccionApp;
    private javax.swing.JButton startGestoresApp;
    private javax.swing.JButton startMozosApp;
    // End of variables declaration//GEN-END:variables
    
}
