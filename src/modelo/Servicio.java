/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import modelo.Mapeador.MapeadorServicio;
import persistencia.Persistencia;

/**
 *
 * @author SG0219779
 */
public class Servicio {
   
    private int oid;
    private ArrayList<Item> items;
    private Mesa mesa;
    
    // <editor-fold defaultstate="collapsed" desc="Agregar-Remover Items">
    public void setOid(int oid) {
        this.oid = oid;
    }
    public int getOid(){
        return oid;
    }

    public Servicio() {
        this.items = new ArrayList();
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }
    
    public ArrayList<Item> getItems() {
        return items;
    }
    public void agregarItem(Item item) throws ModeloException {
        item.validar();
        this.items.add(item);
        item.hacerPedido(this);
    }
    public void removerItem(Item item) {
        this.items.remove(item);
    }
    // </editor-fold>
    
    public double getMontoTotalAAbonar(){
        double total = 0;
        
        for(Item i:items){
            total += i.getMonto();
        }
        double otrosDescuentos = mesa.getOtrosDescuentos(total);
        
        if(total < otrosDescuentos){
            return 0;
        } else {
            return total - otrosDescuentos;
        }
        
    }
    
    public double getMontoTotalSinDescuento() {
        double total = 0;
        for(Item i: items){
            total += i.getMontoSinAplicarDescuento();
        }
        return total;
    }
    //Hay que calcular los montos por separado cada vez, porque no se sabe como pueden llegar a ser pedidos
    public double getMontoDescontado() {
        return getMontoTotalSinDescuento() - getMontoTotalAAbonar();
    }
    
    public boolean hayPendientes() {
        for(Item i:items){
            if(i.getEstado().equals(Item.Estado.pendiente)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Servicio: " + mesa.toString();
    }  

    public void actualizarMesa() {
        mesa.avisarMozo();
    }

    public void guardarServicio() {
        if(items != null && items.size() >0){
            MapeadorServicio ms = new MapeadorServicio(this);
            Persistencia.getInstancia().guardar(ms);
        }
    }

    public String getCodigoProductoDescontado() {
        return mesa.getCodigoProductoDescontado();
    }
    
}
