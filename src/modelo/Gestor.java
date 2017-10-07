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
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Observable Section">  
    private void avisar(eventos eventos) {
        setChanged();
        notifyObservers(eventos);
    }

    public enum eventos {
        pedidos;
    }
    // </editor-fold>      
    
    public void trabajarPedido(Pedido pedido) {
        this.pedidos.add(pedido);
        this.unidad.agregarPedidoPendiente(pedido);
        avisar(eventos.pedidos);
    }

    public void finalizarPedido(Pedido pedido) {
        if(pedidos.contains(pedido)){       
            pedido.setFinalizado(true);
            if(this.unidad.finalizarPedido(pedido)){
                this.pedidos.remove(pedido);
                avisar(eventos.pedidos);
            }else{
                pedido.setFinalizado(false);
            }        
        }        
    }

}
