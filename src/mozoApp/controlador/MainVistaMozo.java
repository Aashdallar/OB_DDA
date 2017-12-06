package mozoApp.controlador;

import java.util.ArrayList;
import modelo.Mesa;
import modelo.Mozo;
import modelo.Transferencia;

public interface MainVistaMozo {
    
    public void mostrarMesas(Mesa mesa, Mozo mozo);
    public void mostrarAlerta(String mensaje);
    public void mostrarTransferirMesa(ArrayList<Mozo> mozosLogueados, Mesa mesa);
    public void mostrarTransferenciaSolicitud(Transferencia transferencia);
    public void mostrarTransferenciaActualizada();
    public void terminarTransferenciaPorTiempoTerminado();
    
}
