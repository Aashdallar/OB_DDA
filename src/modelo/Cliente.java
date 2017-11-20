/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author SG0208533
 */
public class Cliente {
    private int oid;
    private int id;
    private String nombre;
    private String email;
    private TipoDeCliente tipo;

    public enum TipoDeCliente {
        Comun,          // $0 por café
        Preferencial,   // $0 por agua mineral + 5% de descuento si Total > $2000
        DeLaCasa,       // $500 descuento sobre el total
        SinBeneficio
    }

    public Cliente() {
    }

    public Cliente(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public TipoDeCliente getTipo() {
        return tipo;
    }
    public void setTipo(TipoDeCliente tipo) {
        this.tipo = tipo;
    }
    public void setTipo(String str){
        switch(str){
            case "COM":
                this.tipo = tipo.Comun;
                break;
            case "PRF":
                this.tipo = tipo.Preferencial;
                break;
            case "DLC":
                this.tipo = tipo.DeLaCasa;
                break;
            default:
                this.tipo = tipo.SinBeneficio;
                break;
        }
    }
    
    
    
    
}
