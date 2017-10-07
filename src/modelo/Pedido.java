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
    
    // <editor-fold defaultstate="collapsed" desc="Gets y Sets">    
    
    public Item getItem(){
        return item;
    }    
    public boolean estaFinalizado(){
        return finalizado;
    }
    public void setFinalizado(boolean value){
        finalizado = value;
    }
    
    // </editor-fold>    
    
        public void agregarItem(Item item){
        item.setPedido(this);
        item.setEstado(Item.Estado.pendiente);
        this.item = item;
    }
}
