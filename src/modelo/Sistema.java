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
public class Sistema {
    
    private SistemaMozos sisM = new SistemaMozos();
    private SistemaGestores sisG = new SistemaGestores();    
    private static Sistema instancia = new Sistema();

    public static Sistema getInstancia() {
        return instancia;
    }
    private Sistema() {}
    
}