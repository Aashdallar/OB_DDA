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
    private double montoTotal;
    private double montoDeDescuento;
    
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
    
    public void calcularMontos(){
        montoTotal = 0;        
        for(Item i:items){
            montoTotal += i.getMonto();
        }
        montoDeDescuento = mesa.getDescuentoDeCliente(items, montoTotal);
    }
    public double getMontoTotal() {
        return montoTotal;
    }
    public double getMontoDeDescuento() {
        return montoDeDescuento;
    }
    public double getMontoConDescuento() {
        double total = montoTotal - montoDeDescuento;
        if(total < 0)
            return 0;
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

    @Override
    public String toString() {
        return "Servicio: " + mesa.toString();
    }  

    public void actualizarMesa() {
        mesa.avisarMozo();
    }

    void guardarServicio() {
        MapeadorServicio ms = new MapeadorServicio(this);
        Persistencia.getInstancia().guardar(ms);
    }
    
}
