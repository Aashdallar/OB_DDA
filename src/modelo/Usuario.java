/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author SG0219779
 */
public abstract class Usuario {
    
    private String nombreUsuario;
    private String nombreCompleto;
    private String clave;
    
    public String getNombreUsuario(){
        return nombreUsuario;
    }
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public String getNombreCompleto(){
        return nombreCompleto;
    }    
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    public String getClave(){
        return clave;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }
    
}
