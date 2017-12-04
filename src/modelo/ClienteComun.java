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

    @Override
    public double getBeneficio(ArrayList<Item> items) {
        double total = 0;
        //Codigo de café es b004
        for(Item i:items){
            if(!i.getProducto().getCodigo().equals("b004")){
                total += i.getMonto();
            }
        }
        return total;
    }    
}
