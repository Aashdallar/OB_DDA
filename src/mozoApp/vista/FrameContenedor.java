package mozoApp.vista;

import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.ModeloException;
import modelo.Mozo;

public class FrameContenedor extends JFrame {

    public FrameContenedor(Mozo mozo) {
        setSize(800, 600);
        setTitle("Hola " + mozo.getNombreCompleto() + "!");
        PanelPrincipal panelPrincipal = new PanelPrincipal(mozo);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (JOptionPane.showConfirmDialog(panelPrincipal, 
                    "Esta seguro que desea salir?", "Esta saliendo del sistema", 
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    if(panelPrincipal.desloguearMozo()){
                        dispose();
                    }
                } else {
                    
                }
            }
        });
        setContentPane(panelPrincipal);
        setVisible(true);
    }
}
