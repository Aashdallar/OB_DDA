/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mozoApp.controlador;

import modelo.Mozo;

/**
 *
 * @author SG0208533
 */
public interface LoginVistaMozo {
    
    public void error(String mensaje);
    public void ingresar(Mozo mozo);
    
}
