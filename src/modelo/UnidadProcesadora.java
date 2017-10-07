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
public class UnidadProcesadora {
    
    private String nombre;
    private ArrayList<Producto> productos;
    private ArrayList<Pedido> pedidosProcesados;
    private ArrayList<Pedido> pedidosPendientes;

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
    public ArrayList<Pedido> getPedidosProcesados() {
        return pedidosProcesados;
    }
    public void agregarPedidoProcesado(Pedido pedido) {
        this.pedidosProcesados.add(pedido);
    }
    public void removerPedidoProcesado(Pedido pedido) {
        this.pedidosProcesados.remove(pedido);
    }
    public ArrayList<Pedido> getPedidosPendientes() {
        return pedidosPendientes;
    }
    public void agregarPedidoPendiente(Pedido pedido) {
        this.pedidosPendientes.add(pedido);
    }
    public void removerPedidoPendiente(Pedido pedido) {
        this.pedidosPendientes.remove(pedido);
    }    
    
}
