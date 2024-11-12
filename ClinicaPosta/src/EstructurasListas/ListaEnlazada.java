package EstructurasListas;

import java.io.Serializable;

public class ListaEnlazada implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private Nodo ini;
    private Nodo fin;

    public ListaEnlazada() {
        ini = null;
        fin = null;
    }

    public void AgregarNodoInicio(Nodo nuevo) {
        if (ini == null && fin == null) {
            ini = nuevo;
            fin = nuevo;
        } else {
            nuevo.setSig(ini);
            ini = nuevo;
        }
    }

    public void AgregarNodoFinal(Nodo nuevo) {
        if (ini == null && fin == null) {
            ini = nuevo;
            fin = nuevo;
        } else {
            fin.setSig(nuevo);
            fin = nuevo;
        }
        // Asegurarse de que el siguiente del nodo final es null
        fin.setSig(null);
    }

    public Nodo BuscarEspecialidad(String codbuscado) {
        Nodo aux = ini;
        while (aux != null && !codbuscado.equalsIgnoreCase(aux.cli.getCodigo())) {
            aux = aux.getSig();
        }
        return aux;
    }

    public void EliminarEspecialidad(Nodo actual) {
        if (actual != null) {
            if (ini == actual) {
                ini = actual.getSig();
                if (ini == null) {
                    fin = null; // La lista queda vacía
                }
            } else {
                Nodo anterior = ini;
                while (anterior.getSig() != actual && anterior.getSig() != null) {
                    anterior = anterior.getSig();
                }
                if (anterior.getSig() == actual) {
                    anterior.setSig(actual.getSig());
                    if (actual == fin) {
                        fin = anterior; // Actualizamos fin si eliminamos el último nodo
                    }
                }
            }
        }
    }

    // Getter y Setter
    public Nodo getIni() {
        return ini;
    }

    public void setIni(Nodo ini) {
        this.ini = ini;
    }

    public Nodo getFin() {
        return fin;
    }

    public void setFin(Nodo fin) {
        this.fin = fin;
    }

    // Método para imprimir la lista (para depuración)
    public void imprimirLista() {
        Nodo aux = ini;
        while (aux != null) {
            System.out.print(aux.getEsp().getCodigo() + " -> ");
            aux = aux.getSig();
        }
        System.out.println("null");
    }
}
