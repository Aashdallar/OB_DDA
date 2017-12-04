/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.Mapeador.MapeadorProducto;
import persistencia.Persistencia;

/**
 *
 * @author SG0219779
 */
public class Producto {

    private int oid;
    private String codigo;
    private String nombre;
    private double precioUnitario;
    private int stock;
    private UnidadProcesadora unidad;

    // <editor-fold defaultstate="collapsed" desc="Gets y Sets">
    public Producto() {
    }

    public Producto(String codigo, String nombre, double precioUnitario, int stock, UnidadProcesadora unidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.stock = stock;
        setUnidad(unidad);
    }

    public int getOid() {
        return oid;
    }
    public void setOid(int oid) {
        this.oid = oid;
    }

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
        this.unidad.agregarProducto(this);
    }
    // </editor-fold>
    
    public boolean hayStock(int cantidad){
        if(stock >= cantidad){
            return true;
        }else{
            return false;
        }
    }
    
    public void elaborarProducto(int cantidad){
        this.stock -= cantidad;
        MapeadorProducto mp = new MapeadorProducto(this);
        Persistencia.getInstancia().guardar(mp);
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    static void loadProductosFromBD() {
        Persistencia p = Persistencia.getInstancia();
        MapeadorProducto mp = new MapeadorProducto();
        //No hago nada con la lista,
        //porque ya al cargarlos se encarga de agregarlos a las unidades procesadoras
        p.obtenerTodos(mp);
    }
    
}
