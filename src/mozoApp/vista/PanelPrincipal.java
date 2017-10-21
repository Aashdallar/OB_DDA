package mozoApp.vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modelo.Item;
import modelo.Mesa;
import modelo.Mozo;
import modelo.Servicio;
import modelo.Transferencia;
import mozoApp.controlador.MainControladorMozo;
import mozoApp.controlador.MainVistaMozo;

public class PanelPrincipal extends JPanel implements ActionListener, MainVistaMozo {
    
    private MainControladorMozo controlador;
    private Mozo mozo;
    private Mesa mesaSeleccionada;
    
    public PanelPrincipal(Mozo mozo) {
        this.mozo = mozo;
        setLayout(new GridLayout(1,2));
        controlador = new MainControladorMozo(this, mozo);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        mesaSeleccionada = ((BotonMesa)e.getSource()).getMesa();
        controlador.mostrarMesas(mesaSeleccionada);
    }
    
    @Override
    public void mostrarMesas(Mesa mesa) {
        if(mesaSeleccionada == null || (mesa != null && !mesaSeleccionada.equals(mesa))){
            mesaSeleccionada = mesa;
        }
        if(mesaSeleccionada != null && !mozo.tiene(mesaSeleccionada)){
            mesaSeleccionada = null;
        }
        
        if(mesaSeleccionada == null){
            if(mozo.tieneMesas()) {
                cargarPanel(new PanelListaMesas(this, mozo.getMesas()), new PanelSinMesaSeleccionada());
            } else {
                cargarPanel(new PanelListaMesas(this, new ArrayList()), new PanelMozoSinMesas(mozo.getNombreCompleto()));
            }
        } else {
            
            if(mozo.getMesas().contains(mesaSeleccionada)){
                if(mesaSeleccionada.estaAbierta()){
                    cargarPanel(new PanelListaMesas(this, mozo.getMesas()), new PanelMesaAbierta(this, mesaSeleccionada));
                } else {
                    cargarPanel(new PanelListaMesas(this, mozo.getMesas()), new PanelMesaCerrada(this, mesaSeleccionada));
                }
            }
        }
    }
    
    @Override
    public void mostrarAlerta(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
    
    @Override
    public void mostrarTransferirMesa(ArrayList<Mozo> mozosLogueados) {
        new DiagTransferirMesa(null, true, mesaSeleccionada, mozosLogueados, this);
    }

    @Override
    public void mostrarTransferenciaSolicitud(Transferencia transferencia) {
        new DiagTransferenciaSolicitar(null, true, transferencia, this);
    }
    
    private void cargarPanel(PanelListaMesas pMesas, JPanel pEstatico){
        removeAll();
        add(pMesas);
        add(pEstatico);
        pMesas.mostrar(mozo.getMesas());
        revalidate();
    }
    
    public void abrirMesa() {
        controlador.abrirMesa(mesaSeleccionada);
    }
    
    public boolean desloguearMozo(){
        return controlador.desloguearMozo();
    }
    
    public void AgregarItem() {
        JDialog agregarItem = new DiagAgregarItem(null, false, this, mesaSeleccionada.getServicio(), controlador.getProductosConStock());
        agregarItem.setLocationRelativeTo(this);
        agregarItem.setVisible(true);
    }

    public void CerrarMesa() {
        controlador.cerrarMesa(mesaSeleccionada);
    }
    
    void agregarItemALaMesa(Servicio servicio, Item item) {
        controlador.agregarItemALaMesa(servicio, item);
    }

    public void iniciarTransferirMesa() {
        controlador.iniciarTransferirMesa();
    }
    
    public void transferirMesa(Mozo mozoDestino, Mesa mesa){
        controlador.transferirMesa(mozoDestino, mesa);
    }
    
    void aceptarTransferencia() {
        controlador.transferenciaAceptar();
    }

    void rechazarTransferencia() {
        controlador.transferenciaRechazar();
    }

}
