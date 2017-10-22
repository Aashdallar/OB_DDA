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
    private Mozo mozoDestino;
    
    // <editor-fold defaultstate="collapsed" desc="Gets y Sets">      
    public Mesa getMesa(){
        return mesa;
    }   
    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
        mesa.setTransferencia(this);
    }    
    public Mozo getMozoDestino(){
        return mozoDestino;
    }
    public void setMozoDestino(Mozo mozo) {
        this.mozoDestino = mozo;
        mozoDestino.setTransferencia(this);
    }
    // </editor-fold>   
    
    public void confirmar(){
        mesa.transferenciaAceptada(mozoDestino);
    }
    
    public boolean validar(){
        return mesa != null && mozoDestino != null;
    }

    public void notificar() {
        mozoDestino.avisar(Mozo.eventos.transferenciaSolicitadaTo);
    }

    public void transferenciaRechazada() {
        mesa.transferenciaRechazada(mozoDestino);
    }
    
}
