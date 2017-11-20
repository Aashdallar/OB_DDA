package mozoApp.controlador;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import modelo.Item;
import modelo.Mesa;
import modelo.ModeloException;
import modelo.Mozo;
import modelo.Producto;
import modelo.Servicio;
import modelo.Sistema;
import modelo.Transferencia;

/**
 *
 * @author SG0208533
 */
public class MainControladorMozo implements Observer {
    
    private MainVistaMozo vista;
    private Sistema sistema = Sistema.getInstancia();
    private Mozo mozo;
    private Mesa mesaSeleccionada;

    public MainControladorMozo(MainVistaMozo vista, Mozo mozo) {
        this.vista = vista;
        this.mozo = mozo;
        this.mozo.addObserver(this);
        vista.mostrarMesas(null, this.mozo);
    }
    
    public void seleccionarMesa(Mesa mesa){
        mesaSeleccionada = mesa;
        vista.mostrarMesas(mesa, mozo);
    }
    
    public boolean desloguearMozo() {
        try{
            sistema.desloguearMozo(mozo);
            mozo.deleteObserver(this);
            return true;
        } catch (ModeloException  ex) {
            vista.mostrarAlerta(ex.getMessage());
            return false;
        }
    }

    public void abrirMesa() {
        mesaSeleccionada.abrir();
        vista.mostrarMesas(mesaSeleccionada, mozo);
    }

    public void cerrarMesa() {
        try {
            mesaSeleccionada.cerrar();
            vista.mostrarMesas(mesaSeleccionada, mozo);
        } catch (ModeloException ex) {
            vista.mostrarAlerta(ex.getMessage());
        }
    }

    public ArrayList<Producto> getProductosConStock() {
        return sistema.getProductosConStock();
    }

    public void agregarItemALaMesa(Item item) {
        try {
            mesaSeleccionada.getServicio().agregarItem(item);
            vista.mostrarMesas(mesaSeleccionada, mozo);
        } catch (ModeloException ex) {
            vista.mostrarAlerta(ex.getMessage());
        }
    }
    
    public void iniciarTransferirMesa(){
        vista.mostrarTransferirMesa(sistema.getMozosLogueados(), mesaSeleccionada);
    }

    public void transferirMesa(Mozo mozoDestino) {
        Transferencia transferencia = new Transferencia();
        transferencia.setMesa(mesaSeleccionada);
        transferencia.setMozoDestino(mozoDestino);
        mozo.solicitarTransferencia(transferencia);
    }

    @Override
    public void update(Observable origen, Object evento) {
        if(evento.equals(Mozo.eventos.transferenciaSolicitadaFrom)){
            vista.mostrarMesas(mozo.getTransferencia().getMesa(), mozo);
        } else if(evento.equals(Mozo.eventos.transferenciaSolicitadaTo)){
            vista.mostrarTransferenciaSolicitud(mozo.getTransferencia());
        } else if(evento.equals(Mozo.eventos.transferenciaRechazada)){
            vista.mostrarMesas(mesaSeleccionada, mozo);
            vista.mostrarAlerta("La solicitud de transferecia fue rechazada.");
        } else if(evento.equals(Mozo.eventos.transferenciaAceptada)){
            mesaSeleccionada = null;
            vista.mostrarMesas(mesaSeleccionada, mozo);
            vista.mostrarAlerta("La solicitud de transferecia fue aceptada.");
        } else if(evento.equals(Mozo.eventos.pedido)){
            vista.mostrarMesas(mesaSeleccionada, mozo);
        }
    }

    public void transferenciaAceptar() {
        mozo.aceptarTransferencia();
        vista.mostrarMesas(mesaSeleccionada, mozo);
    }

    public void transferenciaRechazar() {
        mozo.rechazarTransferencia();
        vista.mostrarMesas(mesaSeleccionada, mozo);
    }
    
    public boolean agregarClienteALaMesa(int idCliente){
        return mesaSeleccionada.agregarCliente(idCliente);
    }
    
}
