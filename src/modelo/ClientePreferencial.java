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
public class ClientePreferencial implements TipoCliente {
    
    @Override
    public String getBeneficioTexto() {
        return "Agua gratis y -5% (si total >$2000)";
    }

    @Override
    public double getBeneficio(ArrayList<Item> items) {
        double total = 0;
        //Codigo del agua mineral es b002
        for(Item i:items){
            if(!i.getProducto().getCodigo().equals("b002")){
                total += i.getMonto();
            }
        }
        if(total >= 2000){
            total -= total * 0.05;
        }
        return total;
    }
}
