package Controlador;

import Modelo.Cita;
import Modelo.Paciente;
import Modelo.Servicio;
import Persistencia.DataCita;
import Persistencia.DataServicio;
import Pila.Doctor;
import Vista.VentanaCitas;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JTable;

public class ControladorCitas {

    VentanaCitas c;
    DefaultTableModel modelo;
    int filaSeleccionada = -1;
    DataCita dataCita;

    public ControladorCitas(VentanaCitas c) {
        this.c = c;
    }

    public void init() {
        modelo = (DefaultTableModel) c.tblDatosCita.getModel();
        dataCita = new DataCita();
        filaSeleccionada = 0;
        limpiar();
        c.tblDatosCita.getTableHeader().setReorderingAllowed(false);
    }

    public void consultar() {
        modelo.setRowCount(0);
        modelo = dataCita.consultar(c.tblDatosCita);
        c.tblDatosCita.setModel(modelo);
    }

    public void limpiar() {
        eventoSeleccionServicio();
        rellenarComboIDPaciente();

        c.txtCodCita.setText(getIdActual());
        c.txtIdEspecialidad.setText("");
        c.txaDetalleCita.setText("");
        consultar();
        selectInfoPropietario();
        filaSeleccionada = -1;
    }

    public void guardar() {
        String codigoCita = c.txtCodCita.getText();
        String idPaciente = c.cbxIdPaciente.getSelectedItem().toString();
        String idEspecialidad = c.txtIdEspecialidad.getText();
        String nombreDoctor = c.comboIdDoctor.getSelectedItem().toString();
        Timestamp fecha = obtenerFechaActual();
        if (sinVacio(codigoCita, idPaciente, idEspecialidad, nombreDoctor)) {
            int res = JOptionPane.YES_NO_OPTION;
            int result = JOptionPane.showConfirmDialog(null, "Confirmar registro", "Confirmacion", res);
            if (result == 0) {
                String servicio = c.cbxServicio.getSelectedItem().toString();                
                Cita cit = new Cita(codigoCita, idPaciente, idEspecialidad, nombreDoctor, servicio, fecha, 0);
                dataCita.registrar(cit);
                consultar();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Rellene todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void clickTabla() {
        filaSeleccionada = c.tblDatosCita.getSelectedRow();
        String codigoCita = (String) c.tblDatosCita.getValueAt(filaSeleccionada, 0);
        String idPaciente = (String) c.tblDatosCita.getValueAt(filaSeleccionada, 1);
        String idEspecialidad = (String) c.tblDatosCita.getValueAt(filaSeleccionada, 2);
        String nombreDoctor = (String) c.tblDatosCita.getValueAt(filaSeleccionada, 3);
        String servicio = (String) c.tblDatosCita.getValueAt(filaSeleccionada, 4);
        String fecha = c.tblDatosCita.getValueAt(filaSeleccionada, 5).toString();
        String nameEstado = c.tblDatosCita.getValueAt(filaSeleccionada, 6).toString();
        int parseEstado = Cita.parseEstado(nameEstado);
        c.comboEstado.setSelectedIndex(parseEstado);
        imprimirInfoTextArea(codigoCita, idPaciente, idEspecialidad, nombreDoctor, servicio, fecha);
    }

    private void rellenarComboIDPaciente() {
        try {
            c.cbxIdPaciente.removeAllItems();
            for (Paciente mas : ControladorDatosPaciente.listaPacientes()) {
                c.cbxIdPaciente.addItem(mas.getCodigo());
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }

    }
    int idPosicionServicio = 0;

    public void rellenarComboDoctores() {
        try {
            idPosicionServicio = c.cbxServicio.getSelectedIndex();
            if (idPosicionServicio > -1) {
                ArrayList<Servicio> listaServiciosEncontrador = new ArrayList<>();
                listaServiciosEncontrador = serviciosEncontrador();
                Servicio serTemp = listaServiciosEncontrador.get(idPosicionServicio);
                c.comboIdDoctor.removeAllItems();
                for (Doctor emp : ControladorDoctor.listaDoctores("doctor")) {
                    String areaTemp = serTemp.getArea();
                    if (areaTemp.equals(emp.getArea())) {
                        c.comboIdDoctor.addItem(emp.getNombre());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }

    }

    public void selectInfoPropietario() {

        c.cbxIdPaciente.addActionListener((java.awt.event.ActionEvent evt) -> {
            try {               
                String idPaciente = (String) c.cbxIdPaciente.getSelectedItem();                
                for (Paciente mas : ControladorDatosPaciente.listaPacientes()) {                    
                    String idEspecialidad = mas.getCodigo();
                    //Una vez teniendo el´código de la Especialidad
                    //posteriormente comparamos el id del Paciente seleccionada
                    //y procedemos a mostrar el id de la Especialidad asignado
                    if (idEspecialidad.equals(idPaciente)) {
                        //y se muestra automáticamente en el TXTPropietario
                        c.txtIdEspecialidad.setText(mas.getEspecialidad());
                    }
                }
            } catch (Exception e) {
                System.out.println("Error" + e);
            }

        });
    }

    public void cambiarEstado() {
        if (filaSeleccionada > -1) {
            String codigoCita = (String) c.tblDatosCita.getValueAt(filaSeleccionada, 0);
            Cita citEditada = dataCita.obtenerCita(codigoCita);
            int estadoSelect = c.comboEstado.getSelectedIndex();
            citEditada.setEstado(estadoSelect);
            dataCita.actualizar(citEditada);
            consultar();
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una cita", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void imprimirInfoTextArea(String codigoCita, String idPaciente, String idEspecialidad, String nombreDoctor, String servicio, String fecha) {
        c.txaDetalleCita.setText("");
        c.txaDetalleCita.append("\n\t\t\t\tINFO CITA\t\t");
        c.txaDetalleCita.append("\n");
        c.txaDetalleCita.append("\t - COD          : " + codigoCita);
        c.txaDetalleCita.append("\n");
        c.txaDetalleCita.append("\t - IdPaciente    : " + idPaciente);
        c.txaDetalleCita.append("\n");
        c.txaDetalleCita.append("\t - IdEspecialidad: " + idEspecialidad);
        c.txaDetalleCita.append("\n");
        c.txaDetalleCita.append("\t - NombreDoctor : " + nombreDoctor);
        c.txaDetalleCita.append("\n");
        c.txaDetalleCita.append("\t - Servicio     : " + servicio);
        c.txaDetalleCita.append("\n");
        c.txaDetalleCita.append("\t - Fecha        : " + fecha);
        c.txaDetalleCita.append("\n");
    }

    private int ID_ACTUAL() {
        try {
            int idActual = 0;
            for (Cita citaa : new Persistencia.DataCita().obtenerTodasLasCitas()) {
                idActual = Integer.parseInt(citaa.getCodigoCita());
            }
            return idActual;
        } catch (NumberFormatException e) {
            System.out.println("ERROR: " + e.getMessage());
            return 0;
        }
    }

    private String getIdActual() {
        int valorActualId = ID_ACTUAL() + 1;
        String nuevaID = String.format("%08d", valorActualId);
        return nuevaID;
    }

    public void eliminar() {
        if (filaSeleccionada > -1) {
            int res = JOptionPane.YES_NO_OPTION;
            int result = JOptionPane.showConfirmDialog(null, "Confirmar eliminacion", "Confirmacion", res);
            if (result == 0) {
                String codigoCita = (String) c.tblDatosCita.getValueAt(filaSeleccionada, 0);
                dataCita.borrar(codigoCita);
                limpiar();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Timestamp obtenerFechaActual() {
        Date fechaActual = new Date();
        Timestamp timestamp = new Timestamp(fechaActual.getTime());
        return timestamp;
    }

    private boolean sinVacio(String... txts) {
        for (String t : txts) {
            if (t.equals("")) {
                return false;
            }
        }
        return true;
    }

    public void buscarCodigo() {
        DefaultTableModel filtro = buscarEnColumna(modelo, 0, c.txtBuscarCod.getText());
        c.tblDatosCita.setModel(filtro);
    }

    public void ordenar() {
        int columna = c.cbxOrdenarCita.getSelectedIndex();
        ordenarPorColumna(c.tblDatosCita, columna, true);
    }

    private DefaultTableModel buscarEnColumna(DefaultTableModel model, int numeroColumna, String datoBuscar) {
        DefaultTableModel filteredModel = (new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Codigo Cita", "ID Paciente", "ID Especialidad", "Nombre Doctor", "Servicio", "Fecha", "Estado"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        int fila = buscarBinario(model, numeroColumna, datoBuscar);

        if (fila != -1) {
            Object[] rowData = new Object[model.getColumnCount()];
            for (int i = 0; i < model.getColumnCount(); i++) {
                rowData[i] = model.getValueAt(fila, i);
            }
            filteredModel.addRow(rowData);
        } else {
        }

        return filteredModel;
    }

    private int buscarBinario(DefaultTableModel model, int numeroColumna, String datoBuscar) {
        int inicio = 0;
        int fin = model.getRowCount() - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            String datoMedio = model.getValueAt(medio, numeroColumna).toString();
            int comparacion = datoMedio.compareTo(datoBuscar);

            if (comparacion == 0) {
                return medio;
            } else if (comparacion < 0) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }

        return -1;
    }

    private static void ordenarPorColumna(JTable table, int numeroColumna, boolean ascendente) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        Object[][] rowData = new Object[model.getRowCount()][model.getColumnCount()];
        for (int i = 0; i < model.getRowCount(); i++) {
            for (int j = 0; j < model.getColumnCount(); j++) {
                rowData[i][j] = model.getValueAt(i, j);
            }
        }

        Arrays.sort(rowData, (Object[] o1, Object[] o2) -> {
            Comparable<Object> c1 = (Comparable<Object>) o1[numeroColumna];
            Comparable<Object> c2 = (Comparable<Object>) o2[numeroColumna];
            return c1.compareTo(c2);
        });

        if (!ascendente) {
            for (int i = 0; i < rowData.length / 2; i++) {
                Object[] temp = rowData[i];
                rowData[i] = rowData[rowData.length - i - 1];
                rowData[rowData.length - i - 1] = temp;
            }
        }

        model.setRowCount(0);

        for (Object[] row : rowData) {
            model.addRow(row);
        }
    }

    public void rellenarComboServicio() {
        DataServicio dataSer = new DataServicio();
        String codPaciente = c.cbxIdPaciente.getSelectedItem().toString();
        c.cbxServicio.removeAllItems();
        for (Servicio se : dataSer.consultar()) {
            String tempPaciente = se.getIdPaciente();
            if (tempPaciente.equals(codPaciente)) {
                c.cbxServicio.addItem(se.getNomServicio());
            }
        }
    }

    public ArrayList<Servicio> serviciosEncontrador() {
        ArrayList<Servicio> listaServicios = new ArrayList<>();
        DataServicio dataSer = new DataServicio();
        String codPaciente = c.cbxIdPaciente.getSelectedItem().toString();
        for (Servicio se : dataSer.consultar()) {
            String tempPaciente = se.getIdPaciente();
            if (tempPaciente.equals(codPaciente)) {
                listaServicios.add(se);
            }
        }
        return listaServicios;
    }

    private void eventoSeleccionServicio() {
        c.cbxServicio.addActionListener((java.awt.event.ActionEvent evt) -> {
            rellenarComboDoctores();
        });
    }

}
