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
    private Mozo mozo;
    private Servicio servicio;   
    private Transferencia transferencia;  
    
    // <editor-fold defaultstate="collapsed" desc="Gets y Sets y Agregar-Remover Items">    
    public int getNro(){
        return nro;
    }
    public void setNro(int nro) {
        this.nro = nro;
    }
    public boolean estaAbierta() {
        return abierta;
    }
    public void abrir(){
        abierta = true;
        servicio = new Servicio();
        servicio.setMesa(this);
    }
    public Mozo getMozo() {
        return mozo;
    }
    public void setMozo(Mozo mozo) {
        this.mozo = mozo;
    }
    public Transferencia getTransferencia(){
        return transferencia;
    }
    public void setTransferencia(Transferencia transferencia) {
        this.transferencia = transferencia;
    }        
    public Servicio getServicio() {
        return servicio;
    }
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }       
    public void removerItemAlServicio(Item item){
        servicio.removerItem(item);
    }
    // </editor-fold>
    
    public void agregarItemAlServicio(Item item) {
        Producto producto = item.getProducto();
        int cantidad = item.getCantidad();
        
        if(estaAbierta() && producto != null && cantidad > 0){
            if(producto.hayStock(cantidad)){
                Pedido pedido = new Pedido();
                pedido.agregarItem(item);
                this.getMozo().avisar(Mozo.eventos.pedido);                
            }
        }
    }
    
    
    public void cerrar() throws ModeloException {
        if(estaAbierta()){
            if(!servicio.hayPendientes()){
                this.abierta = false;
                this.servicio = new Servicio();
            } else {
                throw new ModeloException("Hay items sin finalizar, por lo que no se puede cerrar la mesa");
            }
        }        
    }

    @Override
    public boolean equals(Object obj) {
        Mesa mesa = (Mesa)obj;
        return nro == mesa.getNro();
    }

    public void transferenciaRechazada(Mozo mozoDestino) {
        setTransferencia(null);
        mozo.setTransferencia(null);
        mozoDestino.setTransferencia(null);
        
        mozo.avisar(Mozo.eventos.transferenciaRechazada);
    }
    public void transferenciaAceptada(Mozo mozoDestino){
        Mozo mozoOrigen = this.mozo;
        mozoOrigen.setTransferencia(null);
        mozoDestino.setTransferencia(null);
        setTransferencia(null);
        
        mozoOrigen.removerMesa(this);
        mozoDestino.agregarMesa(this);
        
        mozoOrigen.avisar(Mozo.eventos.transferenciaAceptada);
    }
}
