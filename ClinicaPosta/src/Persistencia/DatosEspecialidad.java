package Persistencia;

import EstructurasListas.*;
import Procesos.*;
import java.io.*;
import Modelo.Especialidad;
import java.util.ArrayList;

public class DatosEspecialidad {

    public static void GuardarEnArchivo(ListaEnlazada Lista) {
        try {
            FileOutputStream fos = new FileOutputStream("InfoEspecialidad.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(Lista);
            oos.close();
        } catch (IOException ex) {
            Mensajes.MostrarTexto("ERROR no se puede guardar Lista Enlazada" + ex);
        }
    }//fin guardar

    public static ListaEnlazada RecuperarDeArchivo() {
        ListaEnlazada Lista = new ListaEnlazada();
        try {
            FileInputStream fis = new FileInputStream("InfoEspecialidad.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Lista = (ListaEnlazada) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException ex) {
            Mensajes.MostrarTexto("ERROR no se puede guardar Lista Enlazada" + ex);
        }
        return Lista;
    }//fin recuperar
    
    
    
    private static final String URL_GUARDADO = "InfoClientes.bin";

    private ArrayList<Especialidad> listaClientes;

    public DatosEspecialidad() {
        listaClientes = new ArrayList<>();
        cargarCitasDesdeArchivo();
    }

    public ArrayList<Especialidad> obtenerTodasLasCitas() {
        return new ArrayList<>(listaClientes);
    }

    private void cargarCitasDesdeArchivo() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(URL_GUARDADO))) {
            listaClientes = (ArrayList<Especialidad>) in.readObject();
        } catch (FileNotFoundException e) {
            listaClientes = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());
            listaClientes = new ArrayList<>();
        }
    }

}//fin de la clase

