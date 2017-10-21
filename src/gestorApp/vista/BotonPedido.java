package gestorApp.vista;

import javax.swing.JButton;
import modelo.Pedido;

public class BotonPedido extends JButton {
    
    private Pedido pedido;

    public BotonPedido(Pedido pedido) {
        super();
        this.pedido = pedido;
        setText(textDePedido());
        setFont(new java.awt.Font("Tahoma", 0, 16));
    }
    private String textDePedido(){
        /* Debe aparecer: nombre del artículo + cantidad + descripción + mesa + mozo */
        
        String desc = pedido.getItem().getDescripcion();
        String texto = "<html>" + pedido.getItem().getProducto().getNombre() + "(x" + pedido.getItem().getCantidad() + ")<br/>"
                + "Mesa: " + pedido.getItem().getServicio().getMesa().getNro() + " | Mozo: " + pedido.getItem().getServicio().getMesa().getMozo().getNombreCompleto() + "<br/>"
                + "Descripción: ";
        if(desc != null && desc != "")
            texto += desc;
        else
            texto += "Sin descripción";
        texto += "<html>";
        
        return texto;
    }

    public Pedido getPedido() {
        return pedido;
    }
    
}
