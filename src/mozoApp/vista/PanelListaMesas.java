package mozoApp.vista;

import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import modelo.Mesa;

public class PanelListaMesas extends JPanel {
    
    private ActionListener al;

    public PanelListaMesas(ActionListener al, ArrayList<Mesa> lista) {
        this.al = al;
        mostrar(lista);
    }
    
     public void mostrar(ArrayList<Mesa> lista){
        removeAll();
        setLayout(new GridLayout(0,2));
        if(lista != null){
            for(Mesa m : lista){
                BotonMesa b = new BotonMesa(m);
                b.addActionListener(al);
                add(b);
            }
        }
        validate();
    }
}
