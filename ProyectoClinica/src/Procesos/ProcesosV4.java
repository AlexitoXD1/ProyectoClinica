package Procesos;

import Vista.*;
import Pila.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author FAMILIA
 */
public class ProcesosV4 {

    public static Doctor LeerDoctor(VentanaDoctor vem) {
        String cod = vem.txtCodigoEmp.getText();
        String nombre = vem.txtNomEmp.getText();
        String condicion = vem.cbxCondicion.getSelectedItem().toString();
        String area = vem.comboArea.getSelectedItem().toString();
        return new Doctor(cod, nombre, condicion, area);
    }

    public static void LimpiarEntradas(VentanaDoctor vem) {
        vem.txtCodigoEmp.setText("");
        vem.txtNomEmp.setText("");
        vem.cbxCondicion.setSelectedIndex(0);
        vem.txtCodigoEmp.requestFocus();
    }

    public static void Presentacion(VentanaDoctor vem) {
        vem.setTitle("Registro de Empleados - Uso de Pilas");
        vem.cbxCondicion.removeAllItems();
        vem.cbxCondicion.addItem("DOCTOR");
        vem.cbxCondicion.addItem("ASISTENTE");
        vem.cbxCondicion.addItem("SECRETARIO/A");
        vem.cbxCondicion.addItem("LIMPIEZA");
    }

    public static void MostrarDatosEnTabla(VentanaDoctor vem, PilaDoctor lista) {
        String[] titulos = {"Nro", "Codigo", "Nombre", "Condicion", "Area"};
        DefaultTableModel mt = new DefaultTableModel(null, titulos);
        vem.tblDatosEmp.setModel(mt);
        for (int i = 0; i < lista.getPila().size(); i++) {
            Doctor emp = lista.getPila().get(i);
            String[] rowData = {
                String.valueOf(i + 1),
                emp.getCod(),
                emp.getNombre(),
                emp.getCargo(),
                emp.getArea()
            };
            mt.addRow(rowData);
        }
    }
}
