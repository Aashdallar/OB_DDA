/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestorApp.vista;

import gestorApp.controlador.LoginControladorGestor;
import gestorApp.controlador.LoginVistaGestor;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Gestor;
import modelo.UnidadProcesadora;


/**
 *
 * @author SG0208533
 */
public class LoginDialog extends javax.swing.JDialog implements LoginVistaGestor {
    
    private LoginControladorGestor controlador;

    public LoginDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        controlador = new LoginControladorGestor(this);
    }
    
    public void login() {
        controlador.empezarLogin(txtUsuario.getText(), txtPassword.getText());
    }
    
    public void unidadSeleccionada(UnidadProcesadora unidad){
        controlador.finalizarLogin(unidad);
    }
    
    @Override
    public void error(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    @Override
    public void seleccionarUnidadProcesadora(ArrayList<UnidadProcesadora> unidades) {
        new SeleccionarUnidadDialog(null, false, unidades, this);
    }
    
    @Override
    public void ingresar(Gestor gestor) {
        dispose();
        new FrameContenedorGestor(gestor);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPassword = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        btnIngresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(txtPassword);
        txtPassword.setBounds(170, 140, 190, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Contraseña:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 140, 110, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Usuario:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(50, 100, 110, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Ingrese sus credenciales");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(50, 40, 310, 40);

        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(txtUsuario);
        txtUsuario.setBounds(170, 100, 190, 30);

        btnIngresar.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnIngresar);
        btnIngresar.setBounds(50, 200, 310, 40);

        setBounds(0, 0, 416, 338);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        login();
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        login();
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        login();
    }//GEN-LAST:event_btnIngresarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    void desloguear() {
        controlador.desloguearGestor();
    }

}
