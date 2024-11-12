package Modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ArregloPaciente implements Serializable {

    private static final long serialVersionUID = 1L;
    //Atributos
    private Paciente[] Lista;
    private static int cantPacientes = 0;

    //Constructor
    public ArregloPaciente() {
        Lista = new Paciente[50]; // 50 espacios de almacenamiento
    }

    //Metodos
    public void AgregarPaciente(Paciente paciente) {
        // Crear un nuevo array con una longitud mayor en 1
        Paciente[] tempList = new Paciente[Lista.length + 1];

        // Copiar los elementos del array actual al nuevo array
        for (int i = 0; i < Lista.length; i++) {
            tempList[i] = Lista[i];
        }

        // Agregar el nuevo paciente al final del nuevo array
        tempList[Lista.length] = paciente;

        // Asignar el nuevo array a la referencia de Lista
        Lista = tempList;
    }

    public void EliminarPaciente(String idPaciente) {
        // Crear una lista temporal para almacenar los pacientes que no ser�n eliminadas
        ArrayList<Paciente> list = new ArrayList<>();

        // Recorrer el array de pacientes y agregar a la lista temporal llos apcientes que no tengan el ID especificado
        for (Paciente m : Lista) {
            if (m != null && !m.getCodigo().equals(idPaciente)) {
                list.add(m);
            }
        }

        // Convertir la lista temporal de vuelta a un array
        Paciente[] tempL = new Paciente[list.size()];
        tempL = list.toArray(tempL);

        // Asignar el nuevo array a la referencia de Lista
        Lista = tempL;
    }
    public Paciente buscarPaciente(String idPaciente) {
    for (Paciente paciente : getLista()) { // Supongo que getLista() devuelve el arreglo de pacientes
        if (paciente != null && paciente.getCodigo().equals(idPaciente)) {
            return paciente;
        }
    }
    return null; // Retorna null si no encuentra el paciente
}


    //Crear Archivo Binario con los datos
    public void GuardarEnArchivo() {
        try {
            FileOutputStream fos = new FileOutputStream("ListaPacientes.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(Lista);
            oos.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "ERROR no se puede guardar.." + ex);
        }
    }

    //Metodo para recuperar los datos del Archivo Binario
    public void RecuperarDeArchivo() {
        try {
            FileInputStream fis = new FileInputStream("ListaPacientes.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Lista = (Paciente[]) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "ERROR no se puede recuperar.." + ex);
        }
    }
    //metodo que actualizará el contador luego de recuperar los datos del archivo binario

    public void ActualizarCantidadPacientes() {
        cantPacientes = 0;
        for (Paciente paciente : Lista) {
            if (paciente != null) {
                cantPacientes++;
            }
        }
    }
    //método que mostrar en pantalla la informacion cantidad de Doctores o empleados por area y suma sueldo

    //Getter and Setters
    public Paciente[] getLista() {
        return Lista;
    }

    public void setLista(Paciente[] Lista) {
        this.Lista = Lista;
    }

    public static int getCantPacientes() {
        return cantPacientes;
    }

    public static void setCantPacientes(int aCantPacientes) {
        cantPacientes = aCantPacientes;
    }

}
