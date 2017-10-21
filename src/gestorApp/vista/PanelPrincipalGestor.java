package gestorApp.vista;

import gestorApp.controlador.MainControladorGestor;
import gestorApp.controlador.MainVistaGestor;
import java.awt.GridLayout;
import javax.swing.JPanel;
import modelo.Gestor;



public class PanelPrincipalGestor extends JPanel implements MainVistaGestor {
    
    private Gestor gestor;
    private MainControladorGestor controlador;
    
    public PanelPrincipalGestor(Gestor gestor) {
        this.gestor = gestor;
        setLayout(new GridLayout(1,2));
        controlador = new MainControladorGestor(this, gestor);
    }

    public void desloguearGestor() {
        controlador.desloguearGestor();
    }
}
