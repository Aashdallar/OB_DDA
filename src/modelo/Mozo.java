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

    // <editor-fold defaultstate="collapsed" desc="Gets, Sets y Agregar-Remover Mesas">
    
    public Mozo() {
        this.mesas = new ArrayList();
    }

    public ArrayList<Mesa> getMesas() {
        return mesas;
    }

    public void agregarMesa(Mesa mesa) {
        if (!this.mesas.contains(mesa)) {
            this.mesas.add(mesa);
            mesa.setMozo(this);
        }
    }

    public void removerMesa(Mesa mesa) {
        this.mesas.remove(mesa);
    }

    public Transferencia getTransferencia() {
        return transferencia;
    }

    public void setTransferencia(Transferencia transferencia) {
        this.transferencia = transferencia;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Observable Section">  
    public void avisar(eventos eventos) {
        setChanged();
        notifyObservers(eventos);
    }

    public void solicitarTransferencia(Transferencia transferencia) {
        setTransferencia(transferencia);
        avisar(eventos.transferenciaSolicitadaFrom);
        transferencia.notificar();
    }

    public boolean tiene(Mesa mesa) {
        return mesa != null && mesas.contains(mesa);
    }

    public enum eventos {
        mesa,
        transferenciaSolicitadaTo,
        transferenciaSolicitadaFrom,
        transferenciaRechazada,
        transferenciaAceptada,
        pedido
    }
    // </editor-fold>

    public boolean tieneMesas(){
        return mesas != null && !mesas.isEmpty();
    }
    
    public boolean tieneMesasAbiertas() {
        if(tieneMesas()){
            for (Mesa m : mesas) {
                if (m.estaAbierta()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void aceptarTransferencia() {
        if (transferencia != null) {
            transferencia.confirmar();
        }
    }
    
    public void rechazarTransferencia(){
        transferencia.transferenciaRechazada();
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
}
