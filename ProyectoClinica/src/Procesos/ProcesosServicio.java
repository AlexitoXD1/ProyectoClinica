package Procesos;

import Modelo.Servicio;
import Persistencia.DataServicio;
import java.util.Arrays;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ProcesosServicio {

    private static int ID_ACTUAL() {
        try {
            int idActual = 0;
            for (Servicio servicio : new Persistencia.DataServicio().consultar()) {
                idActual = Integer.parseInt(servicio.getIdServicio());
            }
            return idActual;
        } catch (NumberFormatException e) {
            System.out.println("ERROR: " + e.getMessage());
            return 0;
        }
    }

    public static String getIdActual() {
        int valorActualId = ID_ACTUAL() + 1;
        String nuevaID = String.format("%08d", valorActualId);
        return nuevaID;
    }

    /**
     * 
     * @param texto Recibe como parámetros una lista de textos o valores y me verifica
     * que no haya ingresado ningún valor vacío, de ser asi, me retorna false, de lo
     * contrario me retorna true
     * @return 
     */
    public static boolean inputValido(Object... texto) {
        for (Object tx : texto) {
            String text = tx.toString();
            if (text.equals("")) {
                return false;
            }
        }
        return true;
    }

    public static void rellenarTabla(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);
        DataServicio data = new DataServicio();
        Object datos[] = new Object[6];
        for (Servicio se : data.consultar()) {
            datos[0] = se.getIdMascota();
            datos[1] = se.getIdServicio();
            datos[2] = se.getNomServicio();
            datos[3] = se.getPrecio();
            datos[4] = se.getArea();
            datos[5] = se.getDescripcion();
            modelo.addRow(datos);
        }
        tabla.setModel(modelo);
    }

    public static void cambiarEstadoInputs(boolean estado, JComponent... componets) {
        for (JComponent com : componets) {
            com.setEnabled(estado);
        }
    }

    public static void ordenarPorColumna(JTable table, int numeroColumna, boolean ascendente) {
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

   
    public static void buscarEnColumna(JTable table, int numeroColumna, String datoBuscar) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        DefaultTableModel filteredModel = new DefaultTableModel(
                new Object[][]{},
                getColumnNames(model)
        );

        for (int i = 0; i < model.getRowCount(); i++) {
            String datoTabla = model.getValueAt(i, numeroColumna).toString();
            if (datoTabla.contains(datoBuscar)) {
                Object[] rowData = new Object[model.getColumnCount()];
                for (int j = 0; j < model.getColumnCount(); j++) {
                    rowData[j] = model.getValueAt(i, j);
                }
                filteredModel.addRow(rowData);
            }
        }

        table.setModel(filteredModel);
    }

    private static Object[] getColumnNames(DefaultTableModel model) {
        int columnCount = model.getColumnCount();
        Object[] columnNames = new Object[columnCount];
        for (int i = 0; i < columnCount; i++) {
            columnNames[i] = model.getColumnName(i);
        }
        return columnNames;
    }
}
