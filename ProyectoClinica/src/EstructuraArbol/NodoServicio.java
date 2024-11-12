package EstructuraArbol;

import java.io.Serializable;
import Modelo.Servicio;

public class NodoServicio implements Serializable {

    private static final long serialVersionUID = 1L;

    private Servicio elemento;
    private NodoServicio Izq;
    private NodoServicio Der;

    public NodoServicio(Servicio elem) {
        this.elemento = elem;
        Izq = Der = null;
    }

    public Servicio getElemento() {
        return elemento;
    }

    public void setElemento(Servicio elemento) {
        this.elemento = elemento;
    }

    public NodoServicio getIzq() {
        return Izq;
    }

    public void setIzq(NodoServicio Izq) {
        this.Izq = Izq;
    }

    public NodoServicio getDer() {
        return Der;
    }

    public void setDer(NodoServicio Der) {
        this.Der = Der;
    }

}
