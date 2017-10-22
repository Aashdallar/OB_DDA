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
public class Gestor extends Usuario {

    private UnidadProcesadora unidad;
    private ArrayList<Pedido> pedidos;

    // <editor-fold defaultstate="collapsed" desc="Gets y Sets">
    public UnidadProcesadora getUnidad() {
        return unidad;
    }

    public void setUnidad(UnidadProcesadora unidad) {
        this.unidad = unidad;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public Gestor() {
        this.pedidos = new ArrayList();
    }
    
    // </editor-fold>
        
    public void trabajarPedido(Pedido pedido) {
        this.pedidos.add(pedido);
        pedido.asignarGestor(this);
        this.unidad.procesarPedido(pedido);
    }

    public void finalizarPedido(Pedido pedido) {
        if(pedidos.contains(pedido)){  
            this.pedidos.remove(pedido);
            this.unidad.finalizarPedido(pedido);
        }        
    }

}
