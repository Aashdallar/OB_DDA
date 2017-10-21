package gestorApp.controlador;

import modelo.Gestor;
import modelo.Sistema;

/**
 *
 * @author SG0208533
 */
public class MainControladorGestor {
    
    private MainVistaGestor vista;
    private Sistema sistema = Sistema.getInstancia();
    private Gestor gestor;

    public MainControladorGestor(MainVistaGestor vista, Gestor gestor) {
        this.vista = vista;
        this.gestor = gestor;
        
    }

    public void desloguearGestor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
