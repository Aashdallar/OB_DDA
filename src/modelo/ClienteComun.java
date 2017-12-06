package modelo;

import java.util.ArrayList;

public class ClienteComun implements TipoCliente {

    @Override
    public String getBeneficioTexto() {
        return "Café gratis";
    }

    //Codigo de café es b004
    @Override
    public String getCodigoProductoDescontado() {
        return "b004";
    }

    @Override
    public double getOtrosDescuentos(double total) {
        return 0;
    }
    
}
