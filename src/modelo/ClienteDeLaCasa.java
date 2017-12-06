package modelo;

import java.util.ArrayList;

public class ClienteDeLaCasa implements TipoCliente {

    @Override
    public String getBeneficioTexto() {
        return "$500 de consumo gratis";
    }

    @Override
    public String getCodigoProductoDescontado() {
        return null;
    }

    @Override
    public double getOtrosDescuentos(double total) {
        return 500;
    }

}
