/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author SG0208533
 */
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
