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
public class Producto {
    
    private String codigo;
    private String nombre;
    private double precioUnitario;
    private int stock;
    private UnidadProcesadora unidad;

    // <editor-fold defaultstate="collapsed" desc="Gets y Sets">    
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPrecioUnitario() {
        return precioUnitario;
    }
    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public UnidadProcesadora getUnidad() {
        return unidad;
    }
    public void setUnidad(UnidadProcesadora unidad) {
        this.unidad = unidad;
    }
    // </editor-fold>
    
    public boolean hayStock(int cantidad){
        if(stock >= cantidad){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return nombre;
    }    
    
   
}
