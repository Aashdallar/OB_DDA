package gestorApp.controlador;

import java.util.ArrayList;
import modelo.Pedido;


public interface MainVistaGestor {

    public void mostrarPedidosPendientes(ArrayList<Pedido> pedidosPendientes,ArrayList<Pedido> pedidosTomados);
    
    public void mostrarDialogPedidoSeleccionado(Pedido pedidoSeleccionado);

   
}
