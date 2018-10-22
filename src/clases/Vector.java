package clases;

public class Vector {
    private int tamano;
    private PQR PQRs[];

    public Vector() {
        this.tamano = 0;
        this.PQRs = null;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        if (tamano > 0) {
            this.tamano = tamano;
            this.PQRs = new PQR[tamano];
        }        
    }

    public PQR getPQRs(int posicion) {
        return PQRs[posicion];
    }

    public void setPQRs(int posicion, PQR pqr) {
        this.PQRs[posicion] = pqr;
    }
}
