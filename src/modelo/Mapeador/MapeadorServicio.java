/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.Mapeador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Item;
import modelo.Servicio;
import persistencia.Mapeador;

/**
 *
 * @author SG0208533
 */
public class MapeadorServicio implements Mapeador {
    
    private Servicio servicio;

    public MapeadorServicio() {
    }
    public MapeadorServicio(Servicio servicio) {
        this.servicio = servicio;
    }
    public Servicio getServicio() {
        return servicio;
    }
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
    
    @Override
    public int getOid() {
        return servicio.getOid();
    }

    @Override
    public void setOid(int oid) {
        servicio.setOid(oid);
    }

    @Override
    public ArrayList<String> getSqlInsert() {
        ArrayList<String> sqls = new ArrayList();
        int oid = getOid();
        sqls.add(
         "INSERT INTO servicios VALUES (" + oid + "," + servicio.getMesa().getNro() + ")"
        );
        
        for(int x = 1; x <= servicio.getItems().size(); x++){
            Item i = servicio.getItems().get(x);
            sqls.add(
                "INSERT INTO items VALUES (" + x + "," + oid + "," + i.getCantidad() + ",'" + i.getDescripcion() + "'," + i.getPrecioUnitario()
                    + ",'"+ i.getPedido().getGestor().getNombreUsuario() + "','" + i.getProducto().getCodigo() + "')"
            );
        }
        return sqls;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cargarRegistro(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crearNuevo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getObjeto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
