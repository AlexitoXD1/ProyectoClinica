package Modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author NITRO 5
 */
public class ArregloPaciente implements Serializable {

    private static final long serialVersionUID = 1L;
    //Atributos
    private Paciente[] Lista;
    private static int cantMascotas = 0;

    //Constructor
    public ArregloPaciente() {
        Lista = new Paciente[50]; // 50 espacios de almacenamiento
    }

    //Metodos
    public void AgregarPaciente(Paciente mascota) {
        // Crear un nuevo array con una longitud mayor en 1
        Paciente[] tempList = new Paciente[Lista.length + 1];

        // Copiar los elementos del array actual al nuevo array
        for (int i = 0; i < Lista.length; i++) {
            tempList[i] = Lista[i];
        }

        // Agregar la nueva mascota al final del nuevo array
        tempList[Lista.length] = mascota;

        // Asignar el nuevo array a la referencia de Lista
        Lista = tempList;
    }

    public void EliminarPaciente(String idMascota) {
        // Crear una lista temporal para almacenar las mascotas que no ser�n eliminadas
        ArrayList<Paciente> list = new ArrayList<>();

        // Recorrer el array de mascotas y agregar a la lista temporal las mascotas que no tengan el ID especificado
        for (Paciente m : Lista) {
            if (m != null && !m.getCodigo().equals(idMascota)) {
                list.add(m);
            }
        }

        // Convertir la lista temporal de vuelta a un array
        Paciente[] tempL = new Paciente[list.size()];
        tempL = list.toArray(tempL);

        // Asignar el nuevo array a la referencia de Lista
        Lista = tempL;
    }

    //Crear Archivo Binario con los datos
    public void GuardarEnArchivo() {
        try {
            FileOutputStream fos = new FileOutputStream("ListaMascotas.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(Lista);
//            System.out.println("ARCHIVO ACTUALIZADO");
            oos.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "ERROR no se puede guardar.." + ex);
        }
    }

    //Metodo para recuperar los datos del Archivo Binario
    public void RecuperarDeArchivo() {
        try {
            FileInputStream fis = new FileInputStream("ListaMascotas.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Lista = (Paciente[]) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "ERROR no se puede recuperar.." + ex);
        }
    }
    //metodo que actualizará el contador luego de recuperar los datos del archivo binario

    public void ActualizarCantidadPacientes() {
        cantMascotas = 0;
        for (Paciente mascota : Lista) {
            if (mascota != null) {
                cantMascotas++;
            }
        }
    }
    //método que mostrar en pantalla la informacion cantidad empleados por area y suma sueldo

    //Getter and Setters
    public Paciente[] getLista() {
        return Lista;
    }

    public void setLista(Paciente[] Lista) {
        this.Lista = Lista;
    }

    public static int getCantMascotas() {
        return cantMascotas;
    }

    public static void setCantMascotas(int aCantMascotas) {
        cantMascotas = aCantMascotas;
    }

}
