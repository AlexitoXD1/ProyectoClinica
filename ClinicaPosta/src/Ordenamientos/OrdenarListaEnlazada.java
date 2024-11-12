package Ordenamientos;

import EstructurasListas.ListaEnlazada;
import EstructurasListas.Nodo;
import Modelo.Especialidad;

public class OrdenarListaEnlazada {

    // MÃ©todo de clonaciÃ³n
    public static ListaEnlazada clonarLista(ListaEnlazada listaOriginal) {
        if (listaOriginal == null || listaOriginal.getIni() == null) {
            return new ListaEnlazada();
        }

        ListaEnlazada listaClonada = new ListaEnlazada();
        Nodo actualOriginal = listaOriginal.getIni();
        Nodo nodoClonado = new Nodo(actualOriginal.cli);
        listaClonada.setIni(nodoClonado);
        Nodo actualClonado = nodoClonado;

        while (actualOriginal.sig != null) {
            actualOriginal = actualOriginal.sig;
            actualClonado.sig = new Nodo(actualOriginal.cli);
            actualClonado = actualClonado.sig;
        }

        return listaClonada;
    }

    /**
     * Ordena una lista enlazada por los nombres de los elementos.
     *
     * @param lista la lista enlazada a ordenar
     * @return una nueva lista enlazada ordenada por nombres
     */
    public static ListaEnlazada OrdenarListaPorNombres(ListaEnlazada lista) {
        if (lista == null || lista.getIni() == null || lista.getIni().sig == null) {
            // Si la lista es nula o tiene menos de dos elementos, no es necesario ordenar
            return lista;
        }
        ListaEnlazada listaClonada = clonarLista(lista);
        Nodo cabezaOrdenada = mergeSort(listaClonada.getIni());
        listaClonada.setIni(cabezaOrdenada);
        return listaClonada;
    }

    /**
     * Ordena una lista enlazada usando el algoritmo merge sort.
     *
     * @param cabeza el nodo cabeza de la lista a ordenar
     * @return el nodo cabeza de la lista ordenada
     */
    private static Nodo mergeSort(Nodo cabeza) {
        if (cabeza == null || cabeza.sig == null) {
            // Si la lista es vacía o tiene un solo nodo, ya está ordenada
            return cabeza;
        }

        Nodo medio = obtenerMedio(cabeza);
        Nodo siguienteDelMedio = medio.sig;
        medio.sig = null;

        Nodo izquierda = mergeSort(cabeza);
        Nodo derecha = mergeSort(siguienteDelMedio);

        return merge(izquierda, derecha);
    }

    /**
     * Obtiene el nodo medio de una lista enlazada.
     *
     * @param cabeza el nodo cabeza de la lista
     * @return el nodo medio de la lista
     */
    private static Nodo obtenerMedio(Nodo cabeza) {
        if (cabeza == null) {
            return cabeza;
        }

        Nodo lento = cabeza, rapido = cabeza.sig;

        while (rapido != null) {
            rapido = rapido.sig;
            if (rapido != null) {
                // El nodo lento avanza un paso y el nodo rápido avanza dos pasos
                lento = lento.sig;
                rapido = rapido.sig;
            }
        }
        // El nodo lento estará en la posición media cuando el nodo rápido alcance el final
        return lento;
    }

    /**
     * Fusiona dos listas enlazadas ordenadas en una sola lista ordenada.
     *
     * @param izquierda la cabeza de la primera lista enlazada ordenada
     * @param derecha la cabeza de la segunda lista enlazada ordenada
     * @return la cabeza de la lista enlazada fusionada y ordenada
     */
    private static Nodo merge(Nodo izquierda, Nodo derecha) {
        Nodo nodoDummy = new Nodo(null);
        Nodo cola = nodoDummy;

        while (izquierda != null && derecha != null) {
            if (izquierda.cli.getNombre().compareTo(derecha.cli.getNombre()) <= 0) {
                // Si el nombre del nodo izquierdo es menor o igual al del derecho, se añade el nodo izquierdo
                cola.sig = izquierda;
                izquierda = izquierda.sig;
            } else {
                // Si el nombre del nodo derecho es menor, se añade el nodo derecho
                cola.sig = derecha;
                derecha = derecha.sig;
            }
            // Se avanza el puntero cola
            cola = cola.sig;
        }

        // Si hay nodos restantes en la lista izquierda, se añaden al final
        if (izquierda != null) {
            cola.sig = izquierda;
        } else {
            // Si hay nodos restantes en la lista derecha, se añaden al final
            cola.sig = derecha;
        }

        return nodoDummy.sig;
    }

    /**
     * Ordena una lista enlazada por los códigos de los elementos.
     *
     * @param lista la lista enlazada a ordenar
     * @return una nueva lista enlazada ordenada por códigos
     */
    public static ListaEnlazada OrdenarListaPorCodigo(ListaEnlazada lista) {
        if (lista == null || lista.getIni() == null || lista.getIni().sig == null) {
            // Si la lista es nula o tiene menos de dos elementos, no es necesario ordenar
            return lista;
        }
        ListaEnlazada listaClonada = clonarLista(lista);
        listaClonada.setIni(ordenarRecursivoCodigo(listaClonada.getIni()));
        return listaClonada;
    }

    /**
     * Ordena recursivamente una lista enlazada por código usando selección
     * recursiva.
     *
     * @param head el nodo cabeza de la lista a ordenar
     * @return el nodo cabeza de la lista ordenada
     */
    private static Nodo ordenarRecursivoCodigo(Nodo head) {
        if (head == null || head.sig == null) {
            // Si la lista es vacía o tiene un solo nodo, ya está ordenada
            return head;
        }

        Nodo minNode = head;
        Nodo current = head.sig;

        while (current != null) {
            if (current.cli.getCodigo().compareTo(minNode.cli.getCodigo()) < 0) {
                // Encuentra el nodo con el menor código en la lista
                minNode = current;
            }
            current = current.sig;
        }

        if (minNode != head) {
            // Si se encontró un nodo con un menor código, se intercambia con el nodo cabeza
            Especialidad temp = head.cli;
            head.cli = minNode.cli;
            minNode.cli = temp;
        }

        // Ordena recursivamente el resto de la lista
        head.sig = ordenarRecursivoCodigo(head.sig);
        return head;
    }
}
