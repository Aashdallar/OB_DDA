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
public class Mesa {
    
    private int nro;
    private boolean abierta;
    private Servicio servicio;   
    private Transferencia transferencia;    
    
    public Transferencia getTransferencia(){
        return transferencia;
    }
    public void setTransferencia(Transferencia transferencia) {
        this.transferencia = transferencia;
    }
    public int getNro(){
        return nro;
    }
    public void setNro(int nro) {
        this.nro = nro;
    }
    public boolean isAbierta() {
        return abierta;
    }
    public void setAbierta(boolean abierta) {
        this.abierta = abierta;
    }
    public Servicio getServicio() {
        return servicio;
    }
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }        
    
}
