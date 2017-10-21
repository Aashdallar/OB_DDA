package mozoApp.controlador;

import java.util.ArrayList;
import modelo.Mesa;
import modelo.Mozo;
import modelo.Transferencia;

public interface MainVistaMozo {
    
    public void mostrarMesas(Mesa mesa);
    public void mostrarAlerta(String mensaje);
    public void mostrarTransferirMesa(ArrayList<Mozo> mozosLogueados);
    public void mostrarTransferenciaSolicitud(Transferencia transferencia);
    
}
