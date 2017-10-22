package gestorApp.vista;

import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Gestor;
import modelo.ModeloException;

public class FrameContenedorGestor extends JFrame {

    public FrameContenedorGestor(Gestor gestor) {
        setSize(800, 700);
        setTitle("Hola " + gestor.getNombreCompleto() + "!");
        PanelPrincipalGestor panelPrincipal = new PanelPrincipalGestor(gestor);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (JOptionPane.showConfirmDialog(panelPrincipal, 
                    "Esta seguro que desea salir?", "Esta saliendo del sistema", 
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    try {
                        panelPrincipal.desloguearGestor();
                        dispose();
                    } catch (ModeloException ex) {
                        Logger.getLogger(FrameContenedorGestor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        setContentPane(panelPrincipal);
        setVisible(true);
    }
}
