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
public class Servicio {
   
    private ArrayList<Item> items;
    
    public ArrayList<Item> getItems(){
        return items;
    }
    public void agregarItem(Item item) {
        this.items.add(item);
    }
    public void removerItem(Item item) {
        this.items.remove(item);
    }
    
    public double montoTotal(){
        double total = 0;        
        for(Item i:items){
            total += i.getMonto();
        }
        return total;
    }
    
    public boolean hayPendientes() {
        for(Item i:items){
            if(i.getEstado().equals(Item.Estado.pendiente)){
                return true;
            }
        }
        return false;
    }
    
}
