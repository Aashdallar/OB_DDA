/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestorApp.controlador;

import java.util.ArrayList;
import modelo.Gestor;
import modelo.UnidadProcesadora;

/**
 *
 * @author SG0208533
 */
public interface LoginVistaGestor {
    
    public void error(String mensaje);
    public void ingresar(Gestor gestor);
    public void seleccionarUnidadProcesadora(ArrayList<UnidadProcesadora> unidades);
    
}
