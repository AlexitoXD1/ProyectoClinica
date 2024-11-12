package Persistencia;

import EstructuraArbol.ArbolServicio;
import EstructuraArbol.NodoServicio;
import Modelo.Servicio;
import java.io.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class DataServicio {

    private final String fileName = "servicios.bin";
    private ArbolServicio arbolServicio;

    public DataServicio() {
        arbolServicio = new ArbolServicio();
        cargarDatos();
    }

    // Método para agregar un nuevo servicio
    public void agregar(Servicio servicio) {
        arbolServicio.setRaiz(arbolServicio.agregarServicio(arbolServicio.getRaiz(), servicio));
        guardarDatos();
    }

    // Método para editar un servicio existente
    public void editar(Servicio servicio) {
        NodoServicio nodo = arbolServicio.buscarServicio(servicio.getIdServicio());
        if (nodo != null) {
            nodo.setElemento(servicio);
            guardarDatos();
        }
    }

    // Método para eliminar un servicio por ID
    public void eliminar(String idServicio) {
        arbolServicio.setRaiz(arbolServicio.eliminar(arbolServicio.getRaiz(), idServicio));
        guardarDatos();
    }

    // Método para consultar todos los servicios
    public ArrayList<Servicio> consultar() {
        ArrayList<Servicio> listaServicios = new ArrayList<>();
        String[] columnNames = {"ID_MASCOTA", "IdServicio", "NomServicio", "Precio", "Area", "Descripcion"};
        DefaultTableModel modelo = new DefaultTableModel(columnNames, 0);
        arbolServicio.mostrarEnOrden(arbolServicio.getRaiz(), modelo);

        for (int i = 0; i < modelo.getRowCount(); i++) {
            Object[] registro = new Object[modelo.getColumnCount()];
            for (int j = 0; j < modelo.getColumnCount(); j++) {
                registro[j] = modelo.getValueAt(i, j);
            }
            listaServicios.add(new Servicio(registro));
        }
        return listaServicios;
    }

    // Método para guardar los datos en un archivo binario
    private void guardarDatos() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(arbolServicio);
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    // Método para cargar los datos desde un archivo binario
    private void cargarDatos() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            arbolServicio = (ArbolServicio) in.readObject();
        } catch (FileNotFoundException e) {
            // El archivo no existe, lo creamos vacío
            arbolServicio = new ArbolServicio();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

//    public static void main(String[] args) {
//        DataServicio dataServicio = new DataServicio();
//
//        // Agregar servicios
//        Servicio servicio1 = new Servicio("1", "S004", "Corte de pelo", 30.0, "Peluquería", "Corte y aseo");
//        Servicio servicio2 = new Servicio("2", "S004", "Vacunación", 50.0, "Veterinaria", "Vacunación completa");
//
//        dataServicio.agregar(servicio1);
//        dataServicio.agregar(servicio2);
//
//        // Consultar servicios
//        System.out.println("Lista de servicios:");
//        for (Servicio servicio : dataServicio.consultar()) {
//            System.out.println(servicio.getIdServicio() + " - " + servicio.getNomServicio() + " - " + servicio.getPrecio() + " - " + servicio.getIdMascota());
//        }
//
//        // Editar un servicio
//        Servicio servicioEditado = new Servicio("2", "S002", "Vacunación", 60.0, "Veterinaria", "Vacunación completa con refuerzo");
//        dataServicio.editar(servicioEditado);
//
//        // Consultar servicios después de la edición
//        System.out.println("Lista de servicios después de la edición:");
//        for (Servicio servicio : dataServicio.consultar()) {
//            System.out.println(servicio.getIdServicio() + " - " + servicio.getNomServicio() + " - " + servicio.getPrecio() + " - " + servicio.getIdMascota());
//        }
//
//        // Eliminar un servicio
//        dataServicio.eliminar("S001");
//
//        // Consultar servicios después de la eliminación
//        System.out.println("Lista de servicios después de la eliminación:");
//        for (Servicio servicio : dataServicio.consultar()) {
//            System.out.println(servicio.getIdServicio() + " - " + servicio.getNomServicio() + " - " + servicio.getPrecio() + " - " + servicio.getIdMascota());
//        }
//    }
}
