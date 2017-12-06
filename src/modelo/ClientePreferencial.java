package modelo;

import java.util.ArrayList;

public class ClientePreferencial implements TipoCliente {
    
    @Override
    public String getBeneficioTexto() {
        return "Agua gratis y -5% (si total >$2000)";
    }
    
    //Codigo del agua mineral es b002
    @Override
    public String getCodigoProductoDescontado() {
        return "b002";
    }

    @Override
    public double getOtrosDescuentos(double total) {
        if(total >= 2000){
            return total * 0.05;
        }
        return 0;
    }
    
}
