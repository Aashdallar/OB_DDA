/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author SG0219779
 */
public class UnidadProcesadora extends Observable{
    
    private String nombre;
    private ArrayList<Producto> productos;
    private ArrayList<Pedido> pedidosEnProceso;
    private ArrayList<Pedido> pedidosPendientes;
    
    // <editor-fold defaultstate="collapsed" desc="Sets, Gets, Agregar y Remover Productos-Pedidos">
    
    public UnidadProcesadora() {
        this.productos = new ArrayList();
        this.pedidosEnProceso = new ArrayList();
        this.pedidosPendientes = new ArrayList();
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public ArrayList<Producto> getProductos() {
        return productos;
    }
    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
    }
    public void removerProducto(Producto producto) {
        this.productos.remove(producto);
    }
    public ArrayList<Pedido> getPedidosEnProceso() {
        return pedidosEnProceso;
    }
    public void agregarPedidoEnProceso(Pedido pedido) {
        this.pedidosEnProceso.add(pedido);
    }
    public void removerPedidoEnProceso(Pedido pedido) {
        if(pedido.estaFinalizado()){
            this.pedidosEnProceso.remove(pedido);
        }
    }
    public ArrayList<Pedido> getPedidosPendientes() {
        return pedidosPendientes;
    }
    public void agregarPedidoPendiente(Pedido pedido) {
        if(!pedido.estaFinalizado()){
            this.pedidosPendientes.add(pedido);
            avisar(eventos.pedidos);
        }        
    }
    public void removerPedidoPendiente(Pedido pedido) {
        this.pedidosPendientes.remove(pedido);
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

    public boolean procesarPedido(Pedido pedido){
        if(pedidosPendientes.contains(pedido)){
            removerPedidoPendiente(pedido);
            pedido.procesar();
            agregarPedidoEnProceso(pedido);
            avisar(eventos.pedidos);
            return true;
        }
        return false;
    }
    
    public boolean finalizarPedido(Pedido pedido){
        if(pedidosEnProceso.contains(pedido)){
            removerPedidoEnProceso(pedido);
            pedido.finalizar();
            avisar(eventos.pedidos);
            return true;
        }
        return false;
    }
    
    public ArrayList<Producto> getProductosConStock(){
        ArrayList<Producto> lista = new ArrayList();
        if(productos != null){
            for(Producto p : productos){
                if(p.getStock() > 0) lista.add(p);
            }
        }
        return lista;
    }

    @Override
    public String toString() {
        return nombre;
    }    
    
}
