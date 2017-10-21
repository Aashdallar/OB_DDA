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

    public MainControladorMozo(MainVistaMozo vista, Mozo mozo) {
        this.vista = vista;
        this.mozo = mozo;
        this.mozo.addObserver(this);
        mostrarMesas(null);
    }
    
    public void mostrarMesas(Mesa mesa){
        vista.mostrarMesas(mesa);
    }
    
    public boolean desloguearMozo() {
        try{
            sistema.desloguearMozo(mozo);
            return true;
        } catch (ModeloException  ex) {
            vista.mostrarAlerta(ex.getMessage());
            return false;
        }
    }

    public void abrirMesa(Mesa mesa) {
        mesa.abrir();
        vista.mostrarMesas(mesa);
    }

    public void cerrarMesa(Mesa mesa) {
        try {
            mesa.cerrar();
            vista.mostrarMesas(mesa);
        } catch (ModeloException ex) {
            vista.mostrarAlerta(ex.getMessage());
        }
    }

    public ArrayList<Producto> getProductosConStock() {
        return sistema.getProductosConStock();
    }

    public void agregarItemALaMesa(Servicio servicio, Item item) {
        try {
            servicio.agregarItem(item);
            vista.mostrarMesas(servicio.getMesa());
        } catch (ModeloException ex) {
            vista.mostrarAlerta(ex.getMessage());
        }
    }
    
    public void iniciarTransferirMesa(){
        vista.mostrarTransferirMesa(sistema.getMozosLogueados());
    }

    public void transferirMesa(Mozo mozoDestino, Mesa mesa) {
        Transferencia transferencia = new Transferencia();
        transferencia.setMesa(mesa);
        transferencia.setMozoDestino(mozoDestino);
        mozo.solicitarTransferencia(transferencia);
    }

    @Override
    public void update(Observable origen, Object evento) {
        if(evento.equals(Mozo.eventos.transferenciaSolicitadaFrom)){
            vista.mostrarMesas(mozo.getTransferencia().getMesa());
        } else if(evento.equals(Mozo.eventos.transferenciaSolicitadaTo)){
            vista.mostrarTransferenciaSolicitud(mozo.getTransferencia());
        } else if(evento.equals(Mozo.eventos.transferenciaRechazada)){
            vista.mostrarMesas(null);
            vista.mostrarAlerta("La solicitud de transferecia fue rechazada");
        } else if(evento.equals(Mozo.eventos.transferenciaAceptada)){
            vista.mostrarMesas(null);
            vista.mostrarAlerta("La solicitud de transferecia fue aceptada");
        }
        
        else if(evento.equals(Mozo.eventos.pedido)){
            
        } else if(evento.equals(Mozo.eventos.mesa)){
            
        }
    }

    public void transferenciaAceptar() {
        mozo.aceptarTransferencia();
        vista.mostrarMesas(null);
    }

    public void transferenciaRechazar() {
        mozo.rechazarTransferencia();
        vista.mostrarMesas(null);
    }
    
}
