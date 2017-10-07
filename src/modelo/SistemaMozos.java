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

    public Mozo ingresar(String nombreUsuario, String clave) {
        Mozo mozo = null;
        for (Mozo m : mozos) {
            if (m.getNombreUsuario().equals(nombreUsuario) && m.getClave().equals(clave)) {
                if (!mozosActivos.contains(m)) {
                    mozo = m;
                    mozosActivos.add(mozo);
                }
            }
        }
        return mozo;
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

}
