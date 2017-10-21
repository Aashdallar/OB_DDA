package gestorApp.controlador;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import modelo.Gestor;
import modelo.Item;
import modelo.Item.Estado;
import modelo.ModeloException;
import modelo.Pedido;
import modelo.Sistema;
import modelo.UnidadProcesadora;

/**
 *
 * @author SG0208533
 */
public class MainControladorGestor implements Observer {
    
    private MainVistaGestor vista;
    private Sistema sistema = Sistema.getInstancia();
    private Gestor gestor;
    private UnidadProcesadora unidad;
    private Pedido pedidoSeleccionado;

    public MainControladorGestor(MainVistaGestor vista, Gestor gestor) {
        this.vista = vista;
        this.gestor = gestor;
        this.unidad = gestor.getUnidad();
        this.unidad.addObserver(this);
        mostrarPedidos();
    }

    public void desloguearGestor(Gestor gestor) throws ModeloException {
        sistema.desloguearGestor(gestor);
    }

    public void mostrarPedidos() {
        ArrayList<Pedido> pedidosPendientes = gestor.getUnidad().getPedidosPendientes();
        ArrayList<Pedido> pedidosTomados = gestor.getPedidos();
        vista.mostrarPedidosPendientes(pedidosPendientes, pedidosTomados);
    }
    
    public void procesarPedidoSeleccionado(){
        if(pedidoSeleccionado.getItem().getEstado().equals(Estado.enProceso)){
            gestor.finalizarPedido(pedidoSeleccionado);
        }else if (pedidoSeleccionado.getItem().getEstado().equals(Estado.pendiente)){
            gestor.trabajarPedido(pedidoSeleccionado);
        }
    }

    @Override
    public void update(Observable origen, Object evento) {
        mostrarPedidos();
    }

    public void seleccionarPedido(Pedido pedidoSeleccionado) { 
        this.pedidoSeleccionado = pedidoSeleccionado;
        vista.mostrarDialogPedidoSeleccionado(pedidoSeleccionado);
    }
    
    public void deseleccionarPedido(){
        this.pedidoSeleccionado = null;
    }
    
}
