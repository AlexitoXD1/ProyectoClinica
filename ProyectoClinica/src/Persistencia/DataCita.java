package Persistencia;

import Modelo.Cita;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JTable;

public class DataCita {

    private static final String URL_GUARDADO = "Citas.bin";

    private ArrayList<Cita> listaCitas;

    public DataCita() {
        listaCitas = new ArrayList<>();
        cargarCitasDesdeArchivo();
    }

    public void registrar(Cita cita) {
        listaCitas.add(cita);
        guardarEnArchivo();
    }

    public void actualizar(Cita cita) {
        for (int i = 0; i < listaCitas.size(); i++) {
            if (listaCitas.get(i).getCodigoCita().equals(cita.getCodigoCita())) {
                listaCitas.set(i, cita);
                break;
            }
        }
        guardarEnArchivo();
    }

    public void borrar(String codigoCita) {
        listaCitas.removeIf(cita -> cita.getCodigoCita().equals(codigoCita));
        guardarEnArchivo();
    }

    public DefaultTableModel consultar(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);

        for (Cita cita : listaCitas) {
            modelo.addRow(new Object[]{
                cita.getCodigoCita(),
                cita.getIdMascota(),
                cita.getIdPropietario(),
                cita.getNombreDoctor(),
                cita.getServicio(),
                cita.getFecha(),
                cita.toEstado()
            });
        }
        return modelo;
    }

    private void guardarEnArchivo() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(URL_GUARDADO))) {
            out.writeObject(listaCitas);
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public ArrayList<Cita> obtenerTodasLasCitas() {
        return new ArrayList<>(listaCitas);
    }
    
    public Cita obtenerCita(String idCita){
        for(Cita ci : listaCitas){
            String tempCita = ci.getCodigoCita();
            if(tempCita.equals(idCita)){
                return ci;
            }
        }
        return null;
    }
    
    private void cargarCitasDesdeArchivo() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(URL_GUARDADO))) {
            listaCitas = (ArrayList<Cita>) in.readObject();
        } catch (FileNotFoundException e) {
            listaCitas = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());
            listaCitas = new ArrayList<>();
        }
    }
}
