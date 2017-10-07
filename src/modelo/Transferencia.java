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
public class Transferencia {
        
    private Mesa mesa;    
    private Mozo mozo;
    private boolean pendiente;
       
    public Mesa getMesa(){
        return mesa;
    }   
    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }    
    public Mozo getMozo(){
        return mozo;
    }
    public void setMozo(Mozo mozo) {
        this.mozo = mozo;
    }
    public boolean isPendiente() {
        return pendiente;
    }
    public void setPendiente(boolean pendiente) {
        this.pendiente = pendiente;
    }
    
}
