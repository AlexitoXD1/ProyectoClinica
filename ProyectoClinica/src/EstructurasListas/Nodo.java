package EstructurasListas;

import Modelo.Especialidad;
import java.io.Serializable;

public class Nodo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    public Especialidad cli;
    public Nodo sig;

    public Nodo(Especialidad cli) {
        this.cli = cli;
        this.sig = null; // Inicializar sig como null
    }

    // Getter y Setter para cli y sig
    public Especialidad getEsp() {
        return cli;
    }

    public void setCli(Especialidad cli) {
        this.cli = cli;
    }

    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }
}
