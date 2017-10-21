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
    private String descripcion;
    private double precioUnitario; //PARA CONGELAR EL PRECIO
    private Pedido pedido;
    private Estado estado;
    private Servicio servicio;

    public void validar() throws ModeloException {
        if(cantidad <= 0)
            throw new ModeloException("Cantidad invalida");
        if(producto == null)
            throw new ModeloException("Debe elegir al menos un producto");
        if(!producto.hayStock(cantidad))
            throw new ModeloException("Sin Stock");
    }
    public enum Estado {pendiente,enProceso,finalizado;}

    // <editor-fold defaultstate="collapsed" desc="Gets y Sets">
    
    public Producto getProducto(){
        return producto;
    }    
    public void setProducto(Producto producto) {
        this.producto = producto;
        this.precioUnitario = this.producto.getPrecioUnitario();
    }
    public int getCantidad(){
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public double getPrecioUnitario(){
        return precioUnitario;
    }
    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }  
    public Estado getEstado(){
        return estado;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    } 
    public Pedido getPedido() {
        return pedido;
    }
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    public Servicio getServicio() {
        return servicio;
    }
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
    // </editor-fold>
    
    public double getMonto(){
        return precioUnitario*cantidad;
    }
    
    public void hacerPedido(Servicio servicio){
        setPedido(new Pedido(this));
        producto.elaborarProducto(cantidad);
        setServicio(servicio);
    }
    
    @Override
    public String toString() {
        return producto + " x" + cantidad;
    }
    
}
