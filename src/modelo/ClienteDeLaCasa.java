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
