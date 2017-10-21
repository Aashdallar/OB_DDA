package mozoApp.controlador;

import modelo.ModeloException;
import modelo.Mozo;
import modelo.Sistema;

/**
 *
 * @author SG0208533
 */
public class LoginControladorMozo {
    
    private LoginVistaMozo vista;
    private Sistema sistema = Sistema.getInstancia();
    
    public LoginControladorMozo(LoginVistaMozo vista){
        this.vista = vista;
    }
    
    public void login(String usuario, String password){
        try{
            Mozo mozo = sistema.loginMozo(usuario, password);
            vista.ingresar(mozo);
        } catch (ModeloException ex){
            vista.error(ex.getMessage());
        }
    }

}
