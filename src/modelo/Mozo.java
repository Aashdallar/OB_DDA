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
public class Mozo extends Usuario {
    
    private ArrayList<Mesa> mesas;
    private Transferencia transferencia;    
      
    public ArrayList<Mesa> getMesas(){
        return mesas;
    }
    public void agregarMesa(Mesa mesa) {
        this.mesas.add(mesa);
    }    
    public Transferencia getTransferencia(){
        return transferencia;
    }
    public void setTransferencia(Transferencia transferencia) {
        this.transferencia = transferencia;
    }
    
}
