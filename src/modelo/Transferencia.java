package modelo;

public class Transferencia extends Thread {

    private Mesa mesa;
    private Mozo mozoDestino;
    private int tiempoMax = 20;
    private int tiempoRestante = tiempoMax;

    // <editor-fold defaultstate="collapsed" desc="Gets y Sets">      
    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
        mesa.setTransferencia(this);
    }

    public Mozo getMozoDestino() {
        return mozoDestino;
    }

    public void setMozoDestino(Mozo mozo) {
        this.mozoDestino = mozo;
        mozoDestino.setTransferencia(this);
    }

    public int getTiempoMax() {
        return tiempoMax;
    }

    public void setTiempoMax(int tiempo) {
        this.tiempoMax = tiempoMax;
    }

    public int getTiempoRestante() {
        return tiempoRestante;
    }

    public void setTiempoRestante(int tiempoRestante) {
        this.tiempoRestante = tiempoRestante;
    }
    // </editor-fold>   

    public void confirmar() {
        tiempoMax = -1;
        mesa.transferenciaAceptada(mozoDestino);
    }

    public boolean validar() {
        return mesa != null && mozoDestino != null;
    }

    public void notificar() {
        mozoDestino.avisar(Mozo.eventos.transferenciaSolicitadaTo);
        start();
    }

    public void transferenciaRechazada() {
        tiempoMax = -1;
        mesa.transferenciaRechazada(mozoDestino);
    }

    @Override
    public void run() {
        while (tiempoMax != -1 && tiempoRestante > 0) {
            System.out.println(tiempoRestante);
            try {
                sleep(1000);
                tiempoRestante--;
                mozoDestino.avisar(Mozo.eventos.transferenciaActualizada);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
        if (tiempoRestante == 0) {
            mozoDestino.avisar(Mozo.eventos.transferenciaTiempoTerminado);
            transferenciaRechazada();
        }
    }
}
