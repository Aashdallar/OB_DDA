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
public class Item {
    
    private Producto producto;
    private int cantidad;
    private double precioUnitario; //PARA CONGELAR EL PRECIO
    
    public Producto getProducto(){
        return producto;
    }    
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public int getCantidad(){
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }    
    public double getPrecioUnitario(){
        return precioUnitario;
    }
    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    public double getPrecioItem(){
        return precioUnitario*cantidad;
    }    

    @Override
    public String toString() {
        return producto + " x" + cantidad;
    }
    
    
    
}
