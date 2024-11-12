package Procesos;

import Modelo.*;
import Vista.VentanaRegistroPaciente;
import javax.swing.table.DefaultTableModel;


public class ProcesosVentana01 {

    // Metodo para Enviar los datos de los txtField a la tabla
    public static void MostrarEnTabla(VentanaRegistroPaciente f1, Paciente[] a) {
        String titulos[] = {"N� Orden", "DNI", "Nombre", "Genero", "Edad", "Cod_Especialidad", "Fecha de Registro"};
        DefaultTableModel mt = new DefaultTableModel(null, titulos);
        mt.setRowCount(0);
        int cont = 0;
        for (Paciente mas : a) {
//            System.out.println("cd: " + mas);
            if (mas != null) {
                cont++;
                mt.addRow(mas.Registro(cont));
            }
        }
        f1.tblDatos.setModel(mt);
    }

    public static void MostrarResumen(VentanaRegistroPaciente f1, Paciente[] a) {
    }//fin método  

    //Configura Carcteristicas de la VentanaRegistro Pacientes
    public static void PresentarVentanaRegistroPaciente(VentanaRegistroPaciente f1) {
        f1.setTitle("Registro de Pacientes");
    }//fin método 

    //Este metodo recupera los datos de los componentes Paciente
    public static Paciente LeerPaciente(VentanaRegistroPaciente f1) {
        Paciente paciente = new Paciente();
        paciente.setCodigo(f1.txtIdPaciente.getText());
        paciente.setNombre(f1.txtNombre.getText());
        paciente.setGenero(f1.txtGenero.getText());
        paciente.setEdad(Integer.parseInt(f1.txtEdad.getText()));
        paciente.setEspecialidad(f1.cbxEspecialidad.getSelectedItem().toString());
        paciente.setFecha(f1.txtFecha.getText());
        return paciente;
    }//fin de método

    //Este metodo limpia todos los campos de datos de Registro
    public static void LimpiarEntradas(VentanaRegistroPaciente f1) {
        f1.txtIdPaciente.setText("");
        f1.txtNombre.setText("");
        f1.txtGenero.setText("");
        f1.txtEdad.setText("");
        f1.cbxEspecialidad.setSelectedIndex(0);
        f1.txtFecha.setText("");
    }//fin del metodo

    public static void EliminarRegistro(VentanaRegistroPaciente f1) {
        DefaultTableModel mt = (DefaultTableModel) f1.tblDatos.getModel();
        mt.setRowCount(0);
        f1.tblDatos.setModel(mt);
    }//fin del metodo

}
