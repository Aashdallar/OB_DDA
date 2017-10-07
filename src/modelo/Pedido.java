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
    
    public Item getItem(){
        return item;
    }    
    public void setItem(Item item){
        this.item = item;
    }
    public boolean isFinalizado(){
        return finalizado;
    }
    public void setFinalizado(boolean value){
        finalizado = value;
    }
}
