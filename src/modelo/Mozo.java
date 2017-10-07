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
    private void avisar(eventos eventos) {
        setChanged();
        notifyObservers(eventos);
    }

    public enum eventos {
        mesa, transferencia, pedidos;
    }
    // </editor-fold>

    public boolean tieneMesasAbiertas() {
        for (Mesa m : mesas) {
            if (m.estaAbierta()) {
                return true;
            }
        }
        return false;
    }

    public boolean aceptarTransferencia() {
        if (transferencia != null) {
            if(transferencia.confirmar()){
                avisar(eventos.transferencia);
                return true;
            }            
        }
        return false;
    }

    public void agregarItemAlServicioDeUnaMesa(Mesa mesa, Producto producto, int cantidad, String descripcion, Pedido pedido) {
        if(mesa.estaAbierta() && producto != null && cantidad > 0 && pedido != null){
            if(producto.hayStock(cantidad)){
                Item item = new Item();
                item.setProducto(producto);
                item.setCantidad(cantidad);
                if(descripcion != null && descripcion.equals("")){
                    item.setDescripcion(descripcion);
                }
                pedido.agregarItem(item);
                avisar(eventos.pedidos);                
            }
        }
    }

}
