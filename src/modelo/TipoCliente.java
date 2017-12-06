package modelo;

import java.util.ArrayList;

public interface TipoCliente {

    public String getBeneficioTexto();
    public String getCodigoProductoDescontado();
    public double getOtrosDescuentos(double total);

}
