package mozoApp.vista;

import java.awt.Color;
import javax.swing.JButton;
import modelo.Mesa;

public class BotonMesa extends JButton {
    
    private Mesa mesa;

    public BotonMesa(Mesa mesa) {
        super(mesa.getNro() + "");
        this.mesa = mesa;
        if(mesa.estaAbierta()) {
            setBackground(new java.awt.Color(0, 204, 51));
            setFont(new java.awt.Font("Tahoma", 1, 24));
            setForeground(new java.awt.Color(0, 0, 0));
        } else {
            setBackground(Color.LIGHT_GRAY);
            setFont(new java.awt.Font("Tahoma", 1, 24));
            setForeground(new java.awt.Color(153, 153, 153));
        }
    }

    public Mesa getMesa() {
        return mesa;
    }
    
}
