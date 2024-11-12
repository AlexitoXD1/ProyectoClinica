package EstructuraArbol;

import Modelo.Servicio;
import java.io.Serializable;
import javax.swing.table.DefaultTableModel;

public class ArbolServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    private NodoServicio Raiz;

    /**
     * Usamos arboles binarios por que es una forma eficiente de almacenar datos
     */
    public ArbolServicio() {
        Raiz = null;
    }
    //metodo que agrega elementos al arbol

    public NodoServicio agregarServicio(NodoServicio Nodo, Servicio elemento) {
        if (Nodo == null) { // si el primer elemento del arbol
            NodoServicio nuevo = new NodoServicio(elemento);
            return nuevo;
        } else {//en el caso que no este vacío.
            if (elemento.getIdServicio().compareTo(Nodo.getElemento().getIdServicio()) > 0) {
                Nodo.setDer(agregarServicio(Nodo.getDer(), elemento));
            } else {
                Nodo.setIzq(agregarServicio(Nodo.getIzq(), elemento));
            }
        }
        return Nodo;
    }

    //metodo que recorre el arbol en Orden -- Izq - Raiz - Der
    public void mostrarEnOrden(NodoServicio Nodo, DefaultTableModel modelo) {
        if (Nodo != null) {
            mostrarEnOrden(Nodo.getIzq(), modelo); // por la izquieda
            modelo.addRow(Nodo.getElemento().getRegistro()); //mostrar el dato actual
            mostrarEnOrden(Nodo.getDer(), modelo); //por el lado derecho            
        }
    }

    //método que busca un nodo por el id del servicio
    public NodoServicio buscarServicio(String idServicio) {
        NodoServicio auxiliar = Raiz;
        while (auxiliar != null) {
            if (auxiliar.getElemento().getIdServicio().equals(idServicio)) {
                return auxiliar;
            } else {
                if (idServicio.compareToIgnoreCase(auxiliar.getElemento().getIdServicio()) > 0) {
                    auxiliar = auxiliar.getDer();
                } else {
                    auxiliar = auxiliar.getIzq();
                }
            }
        }
        return null;
    }

    public NodoServicio getRaiz() {
        return Raiz;
    }

    public void setRaiz(NodoServicio Raiz) {
        this.Raiz = Raiz;
    }

    // metodo que busca el mayor elemento del subarbol izquierdo
    public NodoServicio buscarMayorIzquierda(NodoServicio auxiliar) {
        if (auxiliar != null) {
            while (auxiliar.getDer() != null) {
                auxiliar = auxiliar.getDer();
            }
        }
        return auxiliar;
    }

    //Método que elimina el mayor nodo del lado izquierdo
    public NodoServicio eliminarMayorIzquierda(NodoServicio auxiliar) {
        if (auxiliar == null) {
            return null;
        } else if (auxiliar.getDer() != null) {
            auxiliar.setDer(eliminarMayorIzquierda(auxiliar.getDer()));
            return auxiliar;
        }
        return auxiliar.getIzq();
    }

    //Método que elimina un nodo del arbol por idServicio
    public NodoServicio eliminar(NodoServicio auxiliar, String idServicio) {
        if (auxiliar == null) {
            return null;
        }
        if (idServicio.compareTo(auxiliar.getElemento().getIdServicio()) < 0) {
            auxiliar.setIzq(eliminar(auxiliar.getIzq(), idServicio));
        } else if (idServicio.compareTo(auxiliar.getElemento().getIdServicio()) > 0) {
            auxiliar.setDer(eliminar(auxiliar.getDer(), idServicio));
        } else {
            if (auxiliar.getIzq() != null && auxiliar.getDer() != null) {
                auxiliar.setElemento(buscarMayorIzquierda(auxiliar.getIzq()).getElemento());
                auxiliar.setIzq(eliminarMayorIzquierda(auxiliar.getIzq()));
            } else {
                auxiliar = (auxiliar.getIzq() != null) ? auxiliar.getIzq() : auxiliar.getDer();
            }
        }
        return auxiliar;
    }
}
