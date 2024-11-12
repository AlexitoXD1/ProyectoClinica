package Controlador;

import Modelo.Cita;
import Modelo.Paciente;
import Modelo.Servicio;
import Persistencia.DataServicio;
import Procesos.ProcesosServicio;
import Vista.VentanaServicios;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControladorV5 {

    VentanaServicios c;
    DataServicio data;
    int filaSeleccionada = -1;

    public ControladorV5(VentanaServicios c) {
        this.c = c;
    }

    public void init() {
        data = new DataServicio();
        limpiar();
    }

    public void limpiar() {
        c.txtNomServicio.setText("");
        c.txtDesc.setText("");
        c.txtIdservicio.setText(ProcesosServicio.getIdActual());
        c.txtPrecio.setText("");
        c.cbxarea.setSelectedIndex(0);
        consultar();
        rellenarComboIDMascota();
        //DESABILITAR
        cambiarEstado(false);
        c.btnEditar.setEnabled(false);
        c.btnEliminar.setEnabled(false);
        c.btnCancelar.setEnabled(false);
        c.btnNuevo.setEnabled(true);
    }

    private void cambiarEstado(boolean estado) {
        ProcesosServicio.cambiarEstadoInputs(estado,
                c.txtDesc, c.txtIdservicio, c.txtNomServicio, c.txtPrecio, c.comboMascota, c.cbxarea, c.btnAgregar);
    }

    private void rellenarComboIDMascota() {
        c.comboMascota.removeAllItems();
        for (Paciente mas : ControladorV1.listaPacientes()) {
            c.comboMascota.addItem(mas.getCodigo());
        }
    }

    private void consultar() {
        ProcesosServicio.rellenarTabla(c.tblServicio);
    }

    public void btnNuevo() {
        c.btnCancelar.setEnabled(true);
        c.btnNuevo.setEnabled(false);
        cambiarEstado(true);
    }

    public void btnAgregar() {
        try {
            String idMascota = c.comboMascota.getSelectedItem().toString();
            String idServicio = ProcesosServicio.getIdActual();
            String nombreServicio = c.txtNomServicio.getText();
            String descripcion = c.txtDesc.getText();
            double precio = Double.parseDouble(c.txtPrecio.getText());
            String area = c.cbxarea.getSelectedItem().toString();
            boolean inputValido = ProcesosServicio.inputValido(idMascota, idServicio, nombreServicio, precio, descripcion, area);
            if (inputValido) {
                Servicio ser = new Servicio(idMascota, idServicio, nombreServicio, precio, area, descripcion);
                data.agregar(ser);
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Rellenar todos los datos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "No hay mascotas registradas", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (java.lang.NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingresar un numero valido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void btnCancelar() {
        limpiar();
    }

    public void btnEditar() {
        if (filaSeleccionada > -1) {
            try {
                String idMascota = c.comboMascota.getSelectedItem().toString();
                String idServicio = c.tblServicio.getValueAt(filaSeleccionada, 1).toString();
                String nombreServicio = c.txtNomServicio.getText();
                String descripcion = c.txtDesc.getText();
                double precio = Double.parseDouble(c.txtPrecio.getText());
                String area = c.cbxarea.getSelectedItem().toString();
                boolean inputValido = ProcesosServicio.inputValido(idMascota, idServicio, nombreServicio, precio, descripcion, area);
                if (inputValido) {
                    Servicio ser = new Servicio(idMascota, idServicio, nombreServicio, precio, area, descripcion);
                    data.editar(ser);
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Rellenar todos los datos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "No hay mascotas registradas", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (java.lang.NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingresar un numero valido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingresar un numero valido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void btnEliminar() {
        if (filaSeleccionada > -1) {
            String idServicio = c.tblServicio.getValueAt(filaSeleccionada, 1).toString();
            data.eliminar(idServicio);
            limpiar();
        } else {
            JOptionPane.showMessageDialog(null, "Ingresar un numero valido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void btnBuscar() {
        String codMascota = c.bscCodigo.getText();
        ProcesosServicio.buscarEnColumna(c.tblServicio, 0, codMascota);
    }

    public void btnordenar() {
        int ordenarIndex = c.cbxOrdenar.getSelectedIndex();
        ProcesosServicio.ordenarPorColumna(c.tblServicio, ordenarIndex, true);
    }

    public void clickTabla() {
        filaSeleccionada = c.tblServicio.getSelectedRow();
        String idMascota = c.tblServicio.getValueAt(filaSeleccionada, 0).toString();
        String idServicio = c.tblServicio.getValueAt(filaSeleccionada, 1).toString();
        String nombreServicio = c.tblServicio.getValueAt(filaSeleccionada, 2).toString();
        String precio = c.tblServicio.getValueAt(filaSeleccionada, 3).toString();
        String areaEncargada = c.tblServicio.getValueAt(filaSeleccionada, 4).toString();
        String descripcion = c.tblServicio.getValueAt(filaSeleccionada, 5).toString();
        c.comboMascota.setSelectedItem(idMascota);
        c.txtIdservicio.setText(idServicio);
        c.txtNomServicio.setText(nombreServicio);
        c.txtDesc.setText(descripcion);
        c.txtPrecio.setText(precio);
        c.cbxarea.setSelectedItem(areaEncargada);
        c.btnEditar.setEnabled(true);
        c.btnEliminar.setEnabled(true);
        c.btnCancelar.setEnabled(true);
        cambiarEstado(true);
        c.btnAgregar.setEnabled(false);
        c.btnNuevo.setEnabled(false);
    }
    
    public void btnLimpiar(){
        consultar();
    }
}
