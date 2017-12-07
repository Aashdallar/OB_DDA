package gestorApp.controlador;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Gestor;
import modelo.ModeloException;
import modelo.Sistema;
import modelo.UnidadProcesadora;

public class LoginControladorGestor {
    
    private LoginVistaGestor vista;
    private Sistema sistema = Sistema.getInstancia();
    private Gestor gestor;
    
    public LoginControladorGestor(LoginVistaGestor vista){
        this.vista = vista;
    }
    
    public void empezarLogin(String usuario, String password){
        try{
            Gestor gestor = sistema.loginGestor(usuario, password);
            this.gestor = gestor;
            vista.seleccionarUnidadProcesadora(sistema.getUnidadesProcesadoras());
        } catch (ModeloException ex){
            vista.error(ex.getMessage());
        }
    }
    
    public void finalizarLogin(UnidadProcesadora unidad){
        gestor.setUnidad(unidad);
        vista.ingresar(gestor);
    }

    public void desloguearGestor() {
        try {
            sistema.desloguearGestor(gestor);
        } catch (ModeloException ex) {
            
        }
    }
}
