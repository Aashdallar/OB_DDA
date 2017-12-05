/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.Mapeador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Producto;
import modelo.Sistema;
import modelo.SistemaGestores;
import modelo.UnidadProcesadora;
import persistencia.Mapeador;

/**
 *
 * @author SG0208533
 */
public class MapeadorProducto implements Mapeador {
    
    private Producto producto;

    public MapeadorProducto() {
    }
    public MapeadorProducto(Producto producto) {
        this.producto = producto;
    }
    public Producto getProducto() {
        return producto;
    }
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public int getOid() {
        return producto.getOid();
    }

    @Override
    public void setOid(int oid) {
        producto.setOid(oid);
    }

    @Override
    public ArrayList<String> getSqlInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getSqlUpdate() {
        ArrayList<String> sqls = new ArrayList();
        sqls.add ("UPDATE productos SET stock=" + producto.getStock() + " WHERE oid=" + producto.getOid());
        return sqls;
    }

    @Override
    public String getSqlDelete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSqlSelect() {
        return "SELECT * FROM productos";
    }

    @Override
    public void cargarRegistro(ResultSet rs) throws SQLException {
        producto.setCodigo(rs.getString("codigo"));
        producto.setNombre(rs.getString("nombre"));
        producto.setPrecioUnitario(rs.getDouble("precioUnitario"));
        producto.setStock(rs.getInt("stock"));
        ArrayList<UnidadProcesadora> unidades = Sistema.getInstancia().getUnidadesProcesadoras();
        String nombreUPP = rs.getString("nombreUPP");
        for(UnidadProcesadora u : unidades){
            if(u.getNombre().equals(nombreUPP)){
                producto.setUnidad(u);
                return;
            }
        }
        producto.setUnidad(null);
    }

    @Override
    public void crearNuevo() {
        producto = new Producto();
    }

    @Override
    public Object getObjeto() {
        return producto;
    }
    
}
