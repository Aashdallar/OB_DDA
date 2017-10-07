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
public class SistemaGestores {
    
    private ArrayList<Gestor> gestores;
    private ArrayList<Gestor> gestoresActivos;
    private ArrayList<UnidadProcesadora> unidades;

    // <editor-fold defaultstate="collapsed" desc="Agregar y Remover Gestores-Unidades">    
    public ArrayList<Gestor> getGestors() {
        return gestores;
    }

    public void agregarGestor(Gestor gestor) {
        this.gestores.add(gestor);
    }

    public void removerGestor(Gestor gestor) {
        this.gestores.remove(gestor);
    }

    public ArrayList<Gestor> getGestorsActivos() {
        return gestoresActivos;
    }

    public void agregarGestorActivo(Gestor gestor) {
        this.gestoresActivos.add(gestor);
    }

    public void removerGestorActivo(Gestor gestor) {
        this.gestoresActivos.remove(gestor);
    }
    
    public void agregarUnidadProcesadora(UnidadProcesadora unidad) {
        this.unidades.add(unidad);
    }

    public void removerUnidadProcesadora(UnidadProcesadora unidad) {
        this.unidades.remove(unidad);
    }
    // </editor-fold>

    public Gestor ingresar(String nombreUsuario, String clave) {
        Gestor gestor = null;
        for (Gestor m : gestores) {
            if (m.getNombreUsuario().equals(nombreUsuario) && m.getClave().equals(clave)) {
                if (!gestoresActivos.contains(m)) {
                    gestor = m;
                    gestoresActivos.add(gestor);
                }
            }
        }
        return gestor;
    }

    public boolean salir(Gestor gestor) {
        boolean exito = false;
        if (gestoresActivos.contains(gestor)) {            
            gestoresActivos.remove(gestor);
            exito = true;                
        }
        return exito;
    }
    
}
