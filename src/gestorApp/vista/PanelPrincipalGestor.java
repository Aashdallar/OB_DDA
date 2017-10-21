package gestorApp.vista;

import gestorApp.controlador.MainControladorGestor;
import gestorApp.controlador.MainVistaGestor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import modelo.Gestor;
import modelo.ModeloException;
import modelo.Pedido;

public class PanelPrincipalGestor extends JPanel implements ActionListener, MainVistaGestor {

    private MainControladorGestor controlador;

    public PanelPrincipalGestor(Gestor gestor) {
        setLayout(new GridLayout(1, 2));
        controlador = new MainControladorGestor(this, gestor);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Pedido pedidoSeleccionado = ((BotonPedido) e.getSource()).getPedido();
        controlador.seleccionarPedido(pedidoSeleccionado);
    }

    @Override
    public void mostrarDialogPedidoSeleccionado(Pedido pedidoSeleccionado) {
        new DialogPedidoSeleccionado(null, true, pedidoSeleccionado, this);
    }
    
    public void confirmarSeleccion(){
        controlador.procesarPedidoSeleccionado();
    }
    
      public void cancelarSeleccion(){
          controlador.deseleccionarPedido();
    }

    public void desloguearGestor(Gestor gestor) throws ModeloException {
        controlador.desloguearGestor(gestor);
    }

    @Override
    public void mostrarPedidosPendientes(ArrayList<Pedido> pedidosPendientes, ArrayList<Pedido> pedidosTomados) {
        cargarPanel(new PanelPedidosPendientes(this, pedidosPendientes), new PanelPedidosTomados(this, pedidosTomados));
    }

    private void cargarPanel(PanelPedidosPendientes pPedidosPendientes, PanelPedidosTomados pPedidosTomados) {
        removeAll();
        add(pPedidosPendientes);
        add(pPedidosTomados);
        revalidate();
    }

}
