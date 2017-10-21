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
public class Sistema {
    
    private SistemaMozos sisM = new SistemaMozos();
    private SistemaGestores sisG = new SistemaGestores();    
    private static Sistema instancia = new Sistema();

    public static Sistema getInstancia() {
        return instancia;
    }
    private Sistema() { cargarDatos(); }
    
    public Mozo loginMozo(String usuario, String password) throws ModeloException {
        return sisM.ingresar(usuario, password);
    }
    
    public void desloguearMozo(Mozo mozo) throws ModeloException {
        sisM.desloguearMozo(mozo);
    }
    
    public ArrayList<Producto> getProductosConStock() {
        return sisG.getProductosConStock();
    }
    
    public ArrayList<Mozo> getMozosLogueados(){
        return sisM.getMozosActivos();
    }
    
    public Gestor loginGestor(String usuario, String password) throws ModeloException {
        return sisG.ingresar(usuario, usuario);
    }
    
    public ArrayList<UnidadProcesadora> getUnidadesProcesadoras() {
        return sisG.retornarUnidadesProcesadoras();
    }
    
    
    
    private void cargarDatos(){
        Mozo m1 = new Mozo();
        Mozo m2 = new Mozo();
        Mozo m3 = new Mozo();
        Mozo m4 = new Mozo();
        Mozo m5 = new Mozo();
        Mozo m6 = new Mozo();
        
        m1.setNombreCompleto("Jaime Talero");
        m2.setNombreCompleto("Esteban Quito");
        m3.setNombreCompleto("Aldo Lorido");
        m4.setNombreCompleto("Marta Tuada");
        m5.setNombreCompleto("Guillermo Nigote");
        m6.setNombreCompleto("Mary Quita");
        
        m1.setNombreUsuario("a");
        m2.setNombreUsuario("b");
        m3.setNombreUsuario("c");
        m4.setNombreUsuario("d");
        m5.setNombreUsuario("e");
        m6.setNombreUsuario("f");
        
        m1.setClave("a");
        m2.setClave("b");
        m3.setClave("c");
        m4.setClave("d");
        m5.setClave("e");
        m6.setClave("f");
        
        Mesa me01 = new Mesa();
        Mesa me02 = new Mesa();
        Mesa me03 = new Mesa();
        Mesa me04 = new Mesa();
        Mesa me05 = new Mesa();
        Mesa me06 = new Mesa();
        Mesa me07 = new Mesa();
        Mesa me08 = new Mesa();
        Mesa me09 = new Mesa();
        Mesa me10 = new Mesa();
        Mesa me11 = new Mesa();
        Mesa me12 = new Mesa();
        me01.setNro(3);
        me02.setNro(5);
        me03.setNro(7);
        me04.setNro(8);
        me05.setNro(10);
        me06.setNro(12);
        me07.setNro(13);
        me08.setNro(14);
        me09.setNro(16);
        me10.setNro(18);
        me11.setNro(19);
        me12.setNro(20);
        me07.abrir();
        me08.abrir();
        me10.abrir();
        me11.abrir();
        
        m3.agregarMesa(me01);
        m3.agregarMesa(me02);
        m3.agregarMesa(me03);
        m3.agregarMesa(me04);
        m3.agregarMesa(me05);
        m1.agregarMesa(me06);
        m1.agregarMesa(me07);
        m1.agregarMesa(me08);
        m2.agregarMesa(me09);
        m2.agregarMesa(me10);
        m2.agregarMesa(me11);
        m2.agregarMesa(me12);
        
        
        sisM.agregarMozo(m1);
        sisM.agregarMozo(m2);
        sisM.agregarMozo(m3);
        sisM.agregarMozo(m4);
        sisM.agregarMozo(m5);
        sisM.agregarMozo(m6);
        
        UnidadProcesadora u1 = new UnidadProcesadora();
        UnidadProcesadora u2 = new UnidadProcesadora();
        
        u1.setNombre("Cocina");
        u1.setNombre("Bar");
        
        Producto p01 = new Producto("c001","Pescado a la plancha",260.00,15,u1);
        Producto p02 = new Producto("c002","Milanesa napolitana",360.00,25,u1);
        Producto p03 = new Producto("c003","Ensalada de la casa",220.00,8,u1);
        Producto p04 = new Producto("c004","Empanadas variadas (1un)",50.00,45,u1);
        Producto p05 = new Producto("c005","Tallarines Lomein",300.00,40,u1);
        Producto p06 = new Producto("c006","Arrollado de pollo",350.00,0,u1);
        Producto p07 = new Producto("b001","Refresco 1Lt",120.00,19,u1);
        Producto p08 = new Producto("b002","Agua 500ml",60.00,15,u1);
        Producto p09 = new Producto("b003","Cerveza 1Lt",180.00,1,u1);
        
        sisG.agregarUnidadProcesadora(u1);
        sisG.agregarUnidadProcesadora(u2);
    }

}
