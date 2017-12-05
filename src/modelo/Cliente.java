/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import modelo.Mapeador.MapeadorCliente;
import persistencia.Persistencia;

/**
 *
 * @author SG0208533
 */
public class Cliente {
    private int oid;
    private int id;
    private String nombre;
    private String email;
    private TipoCliente tipo;

    public Cliente() {
    }

    public int getOid() {
        return oid;
    }
    public void setOid(int oid) {
        this.oid = oid;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public TipoCliente getTipo() {
        return tipo;
    }
    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo;
    }
    public void setTipo(String str){
        if(str == null){
            this.tipo = null;
            return;
        }
        switch(str){
            case "COM":
                this.tipo = new ClienteComun();
                break;
            case "PRF":
                this.tipo = new ClientePreferencial();
                break;
            case "DLC":
                this.tipo = new ClienteDeLaCasa();
                break;
            default:
                this.tipo = null;
                break;
        }
    }
    
    public static Cliente getClienteFromDB(int clienteId){
        Persistencia p = Persistencia.getInstancia();
        MapeadorCliente mc = new MapeadorCliente();
        ArrayList arr = p.buscar(mc, "idCliente = " + clienteId);
        if(arr.size() > 0){
            return (Cliente) arr.get(0);
        } else {
            return null;
        }
    }

    public String getBeneficioTexto() {
        if(tipo == null){
            return "Sin Beneficio";
        }
        return tipo.getBeneficioTexto();
    }

    String getCodigoProductoDescontado() {
        if(tipo!= null){
            return tipo.getCodigoProductoDescontado();
        }
        return null;
    }

    double getOtrosDescuentos(double total) {
        if(tipo != null){
            return tipo.getOtrosDescuentos(total);
        }
        return 0;
    }
    
    
}
