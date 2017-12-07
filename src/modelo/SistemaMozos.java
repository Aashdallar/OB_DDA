/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author SG0219779
 */
public class SistemaMozos {

    private ArrayList<Mozo> mozos;
    private ArrayList<Mozo> mozosActivos;

    // <editor-fold defaultstate="collapsed" desc="Agregar y Remover Mozos + Constructor">   
    protected SistemaMozos() {
        this.mozos = new ArrayList();
        this.mozosActivos = new ArrayList();
    }
    
    public ArrayList<Mozo> getMozos() {
        return mozos;
    }

    public void agregarMozo(Mozo mozo) {
        this.mozos.add(mozo);
    }

    public void removerMozo(Mozo mozo) {
        this.mozos.remove(mozo);
    }

    public ArrayList<Mozo> getMozosActivos() {
        return mozosActivos;
    }

    public void agregarMozoActivo(Mozo mozo) {
        this.mozosActivos.add(mozo);
    }

    public void removerMozoActivo(Mozo mozo) {
        this.mozosActivos.remove(mozo);
    }
    // </editor-fold>

    public Mozo ingresar(String nombreUsuario, String clave) throws ModeloException {
        boolean encontrado = false;
        if(nombreUsuario != null && clave != null){
            for (Mozo m : mozos) {
                if (m.getNombreUsuario().equals(nombreUsuario) && m.getClave().equals(clave)) {
                    if (!mozoLogueado(m)) {
                        mozosActivos.add(m);
                        return m;
                    } else {
                        throw new ModeloException("El usuario ya está logueado");
                    }
                }
            }
            if(!encontrado){
                throw new ModeloException("Credenciales incorrectas");
            }
        }
        return null;
    }

    public boolean salir(Mozo mozo) {
        boolean exito = false;
        if (mozosActivos.contains(mozo)) {            
            if(!mozo.tieneMesasAbiertas()){
                mozosActivos.remove(mozo);
                exito = true;
            }                        
        }
        return exito;
    }

    public boolean mozoLogueado(Mozo mozo){
        return mozo != null && mozosActivos.contains(mozo);
    }

    public void desloguearMozo(Mozo mozo) throws ModeloException {
        if(mozo.tieneMesasAbiertas())
            throw new ModeloException("No es posible salir del sistema teniendo mesas abiertas. Cierre o transfieralas antes de salir.");
        if(mozosActivos.contains(mozo))
            mozosActivos.remove(mozo);
    }

}
