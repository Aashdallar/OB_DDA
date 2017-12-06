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

public class PanelPrincipalMozo extends JPanel implements ActionListener, MainVistaMozo {
    
    private MainControladorMozo controlador;
    private DialogTransferenciaSolicitar dialogoTransferencia;
    
    public void setDialogoTransferencia(DialogTransferenciaSolicitar dialogo){
        this.dialogoTransferencia = dialogo;
    }
    
    
    
    public PanelPrincipalMozo(Mozo mozo) {
        setLayout(new GridLayout(1,2));
        controlador = new MainControladorMozo(this, mozo);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Mesa mesa = ((BotonMesa)e.getSource()).getMesa();
        controlador.seleccionarMesa(mesa);
    }
    
    @Override
    public void mostrarMesas(Mesa mesa, Mozo mozo) {
        
        if(mesa == null){
            if(mozo.tieneMesas()) {
                cargarPanel(new PanelListaMesas(this, mozo.getMesas()), new PanelSinMesaSeleccionada(), mozo);
            } else {
                cargarPanel(new PanelListaMesas(this, new ArrayList()), new PanelMozoSinMesas(mozo.getNombreCompleto()), mozo);
            }
        } else {
            
            if(mozo.getMesas().contains(mesa)){
                if(mesa.estaAbierta()){
                    cargarPanel(new PanelListaMesas(this, mozo.getMesas()), new PanelMesaAbierta(this, mesa), mozo);
                } else {
                    cargarPanel(new PanelListaMesas(this, mozo.getMesas()), new PanelMesaCerrada(this, mesa), mozo);
                }
            }
        }
    }
    
    @Override
    public void mostrarAlerta(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
    
    @Override
    public void mostrarTransferirMesa(ArrayList<Mozo> mozosLogueados, Mesa mesa) {
        new DialogTransferirMesa(null, true, mesa, mozosLogueados, this);
    }

    @Override
    public void mostrarTransferenciaSolicitud(Transferencia transferencia) {
        new DialogTransferenciaSolicitar(null, false, transferencia, this);
    }
    
    private void cargarPanel(PanelListaMesas pMesas, JPanel pEstatico, Mozo mozo){
        removeAll();
        add(pMesas);
        add(pEstatico);
        pMesas.mostrar(mozo.getMesas());
        revalidate();
    }
    
    public void abrirMesa() {
        controlador.abrirMesa();
    }
    
    public boolean desloguearMozo(){
        return controlador.desloguearMozo();
    }
    
    public void AgregarItem() {
        JDialog agregarItem = new DialogAgregarItem(null, false, this, controlador.getProductosConStock());
        agregarItem.setLocationRelativeTo(this);
        agregarItem.setVisible(true);
    }

    public void CerrarMesa() {
        controlador.cerrarMesa();
    }
    
    void agregarItemALaMesa(Item item) {
        controlador.agregarItemALaMesa(item);
    }

    public void iniciarTransferirMesa() {
        controlador.iniciarTransferirMesa();
    }
    
    public void transferirMesa(Mozo mozoDestino){
        controlador.transferirMesa(mozoDestino);
    }
    
    void aceptarTransferencia() {
        controlador.transferenciaAceptar();
    }

    void rechazarTransferencia() {
        controlador.transferenciaRechazar();
    }

    void agregarCliente(int idCliente) {
        controlador.agregarClienteALaMesa(idCliente);
    }

    @Override
    public void mostrarTransferenciaActualizada() {
        if(dialogoTransferencia!=null){
            dialogoTransferencia.mostrarTiempo();
        }
    }
    
    @Override
    public void terminarTransferenciaPorTiempoTerminado() {
        if(dialogoTransferencia!=null){
            dialogoTransferencia.dispose();
        }
    }

}
