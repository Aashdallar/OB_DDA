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
    
    public UnidadProcesadora getUnidad(){
        return unidad;
    }
    public void setUnidad(UnidadProcesadora unidad) {
        this.unidad = unidad;
    }
    public ArrayList<Pedido> getPedidos(){
        return pedidos;
    }    
    public void agregarPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }
    public void removerPedido(Pedido pedido){
        this.pedidos.remove(pedido);
    }
    
}
