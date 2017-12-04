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
    public double getBeneficio(ArrayList<Item> items) {
        //Dado que dice que tienen $500 de consumo gratis, se lo pongo como valor fijo a favor
        return 500;
    }
}
