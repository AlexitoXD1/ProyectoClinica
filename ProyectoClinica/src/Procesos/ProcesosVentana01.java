package Procesos;

import Modelo.*;
import Vista.VentanaRegistroPaciente;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NITRO 5
 */
public class ProcesosVentana01 {

    // Metodo para Enviar los datos de los txtField a la tabla
    public static void MostrarEnTabla(VentanaRegistroPaciente f1, Paciente[] a) {
        String titulos[] = {"N� Orden", "Codigo", "Nombre", "Raza", "Edad", "Propietario", "Fecha de Registro"};
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

    //Muestra el Resumen de cantidad de Mascotas en txtArea
    public static void MostrarResumen(VentanaRegistroPaciente f1, Paciente[] a) {
//        f1.txaResumenMascota.setText("Cantidad de Mascotas    : " + ArregloMascotas.getCantMascotas());
    }//fin método  

    //Configura Carcteristicas de la VentanaRegistro Mascotas
    public static void PresentarVentanaRegistroPaciente(VentanaRegistroPaciente f1) {
        f1.setTitle("Registro de Mascotas");
    }//fin método 

    //Este metodo recupera los datos de los componentes Paciente
    public static Paciente LeerPaciente(VentanaRegistroPaciente f1) {
        Paciente mascota = new Paciente();
        mascota.setCodigo(f1.txtID.getText());
        mascota.setNombre(f1.txtNombre.getText());
        mascota.setGenero(f1.txtGenero.getText());
        mascota.setEdad(Integer.parseInt(f1.txtEdad.getText()));
        mascota.setEspecialidad(f1.cbxEspecialidad.getSelectedItem().toString());
        mascota.setFecha(f1.txtFecha.getText());
        return mascota;
    }//fin de método

    //Este metodo limpia todos los campos de datos de Registro
    public static void LimpiarEntradas(VentanaRegistroPaciente f1) {
        f1.txtID.setText("");
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
//        mt.removeRow(f1.tblDatos.getSelectedRow());

    }//fin del metodo

}
