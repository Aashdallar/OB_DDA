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
public class Pedido {

    private Item item;
    private boolean finalizado;
    private Gestor gestor;

    // <editor-fold defaultstate="collapsed" desc="Gets y Sets">    
    public Pedido() {
    }

    public Pedido(Item item) {
        agregarItem(item);
        item.getProducto().getUnidad().agregarPedidoPendiente(this);
    }

    public Item getItem() {
        return item;
    }

    public boolean estaFinalizado() {
        return finalizado;
    }

    public Gestor getGestor() {
        return gestor;
    }

    // </editor-fold>    
    
    public void agregarItem(Item item) {
        item.setPedido(this);
        item.setEstado(Item.Estado.pendiente);
        this.item = item;
    }

    public void asignarGestor(Gestor gestor) {
        this.gestor = gestor;
    }

    @Override
    public String toString() {
        return item.toString();
    }

    public void procesar() {
        item.setEstado(Item.Estado.enProceso);
        item.getServicio().getMesa().getMozo().avisar(Mozo.eventos.pedido);
    }

    public void finalizar() {
        finalizado = true;
        item.setEstado(Item.Estado.finalizado);
        item.getServicio().getMesa().getMozo().avisar(Mozo.eventos.pedido);
    }

}
