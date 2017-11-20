/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.Mapeador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Cliente;
import persistencia.Mapeador;

/**
 *
 * @author SG0208533
 */
public class MapeadorCliente implements Mapeador {
    
    private Cliente cliente;

    public MapeadorCliente() {
    }
    public MapeadorCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    @Override
    public int getOid() {
        return cliente.getOid();
    }

    @Override
    public void setOid(int oid) {
        cliente.setOid(oid);
    }

    @Override
    public ArrayList<String> getSqlInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getSqlUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSqlDelete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSqlSelect() {
        return "SELECT * FROM clientes";
    }

    @Override
    public void cargarRegistro(ResultSet rs) throws SQLException {
        cliente.setOid(rs.getInt("oid"));
        cliente.setId(rs.getInt("idCliente"));
        cliente.setNombre(rs.getString("nombre"));
        cliente.setEmail(rs.getString("email"));
        cliente.setTipo(rs.getString("tipoClienteCod"));
    }

    @Override
    public void crearNuevo() {
        cliente = new Cliente();
    }

    @Override
    public Object getObjeto() {
        return cliente;
    }
    
}
