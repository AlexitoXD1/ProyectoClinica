package Procesos;

import Modelo.*;
import EstructurasListas.*;
import Persistencia.DatosEspecialidad;
import Vista.*;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

public class ProcesosVentanaEspecialidad {

    public static void LimpiarEntradas(VentanaEspecialidad vcl) {
        vcl.txtCodigo.setText("");
        vcl.txtNombre.setText("");
        vcl.cbxNivel.setSelectedIndex(0);
        vcl.txtDescripcion.setText("");
        vcl.txtCodigo.requestFocus();
    }//fin del metodo

    public static Especialidad LeerEspecialidad(VentanaEspecialidad vcl) {
        Especialidad cli = new Especialidad();
        cli.setCodigo(vcl.txtCodigo.getText());
        cli.setNombre(vcl.txtNombre.getText());
        cli.setNivel(vcl.cbxNivel.getSelectedItem().toString());
        cli.setDescripcion(vcl.txtDescripcion.getText());
        return cli;
    }//fin de m√©todo

    public static ArrayList<Especialidad> MostrarDatos(VentanaEspecialidad vcl, ListaEnlazada Lista) {
        ArrayList<Especialidad> listaEspecialidad = new ArrayList<>();
        String titulos[] = {"Num", "CÛdigo", "Nombre", "Nivel", "Descripcion"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        vcl.tblDatos.setModel(modelo);
        //variables
        Nodo aux = Lista.getIni();
        int c1 = 0, c2 = 0, c3 = 0, c4 = 0, numeracion = 0;
        while (aux != null) {
            numeracion++;
            listaEspecialidad.add(aux.getEsp());
            modelo.addRow(aux.getEsp().Registro(numeracion));
//            System.out.println(aux.cli.getCodigo());
            switch (aux.getEsp().getNivel()) {
                case "1":
                    c1++;
                    break;
                case "2":
                    c2++;
                    break;
                case "3":
                    c3++;
                    break;
                case "4":
                    c4++;
                    break;
            }//fin switch
            aux = aux.getSig();
        }//fin while
        vcl.txaResumen.setText("\nEspecialidad de Nivel 1   : " + c1
                + "\nEspecialidad de Nivel 2 : " + c2
                + "\nEspecialidad de Nivel 3 : " + c3
                + "\nEspecialidad de Nivel 4 : " + c4);
                
        return listaEspecialidad;
    }//fin mostrar

    public static ArrayList<Especialidad> getListaEspecialidad(ListaEnlazada Lista) {
        ArrayList<Especialidad> lista = new ArrayList<>();
        //variables
        Nodo aux = Lista.getIni();
        while (aux != null) {
            lista.add(aux.getEsp());
            aux = aux.getSig();
        }//fin while
        return lista;
    }//fin mostrar

    public static void MostrarDatosNodo(Nodo actual, VentanaEspecialidad vcl) {
        if (actual != null) {
            vcl.txtCodigo.setText(actual.getEsp().getCodigo());
            vcl.txtNombre.setText(actual.getEsp().getNombre());
            vcl.txtDescripcion.setText(actual.getEsp().getDescripcion());
            switch (actual.getEsp().getCodigo()) {
                case "1":
                    vcl.cbxNivel.setSelectedIndex(0);
                    break;
                case "2":
                    vcl.cbxNivel.setSelectedIndex(1);
                    break;
                case "3":
                    vcl.cbxNivel.setSelectedIndex(2);
                    break;
                case "4":
                    vcl.cbxNivel.setSelectedIndex(3);
                    break;
            }//fin switch
        }//if
    }//fin mostrar datos nodo

}//fin de la clase

