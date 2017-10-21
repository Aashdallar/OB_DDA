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

    // <editor-fold defaultstate="collapsed" desc="Agregar y Remover Gestores-Unidades + Constructor">
    protected SistemaGestores() {
        this.gestores = new ArrayList();
        this.gestoresActivos = new ArrayList();
        this.unidades = new ArrayList();
    }
    
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
    
    public ArrayList<UnidadProcesadora> retornarUnidadesProcesadoras(){
        return this.unidades;
    }
    // </editor-fold>

    public Gestor ingresar(String nombreUsuario, String clave) throws ModeloException {
        boolean encontrado = false;
        if(nombreUsuario != null && clave != null){
            for (Gestor g : gestores) {
                if (g.getNombreUsuario().equals(nombreUsuario) && g.getClave().equals(clave)) {
                    if (!gestorLogueado(g)) {
                        gestoresActivos.add(g);
                        return g;
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

    public boolean salir(Gestor gestor) {
        boolean exito = false;
        if (gestoresActivos.contains(gestor)) {            
            gestoresActivos.remove(gestor);
            exito = true;                
        }
        return exito;
    }
    
        public boolean gestorLogueado(Gestor gestor){
        return gestor != null && gestoresActivos.contains(gestor);
    }
    
    public void desloguearGestor(Gestor gestor) throws ModeloException {
        if(false)
            throw new ModeloException("No es posible salir del sistema");
        if(gestoresActivos.contains(gestor))
            gestoresActivos.remove(gestor);
    }
    
    public ArrayList<Producto> getProductosConStock(){
        ArrayList<Producto> lista = new ArrayList();
        for(UnidadProcesadora u : unidades){
            lista.addAll(u.getProductosConStock());
        }
        return lista;
    }

}
