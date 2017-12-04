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
public interface TipoCliente {

    public String getBeneficioTexto();

    public double getBeneficio(ArrayList<Item> items);
    
}
