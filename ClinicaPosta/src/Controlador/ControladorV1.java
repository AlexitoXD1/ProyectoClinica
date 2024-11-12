package Controlador;

import EstructurasListas.ListaEnlazada;
import Modelo.*;
import Ordenamientos.OrdenarArreglosObjetos;
import Persistencia.DatosEspecialidad;
import Procesos.Busquedas;
import Procesos.ProcesosVentana01;
import Procesos.ProcesosVentanaEspecialidad;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.VentanaRegistroPaciente;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class ControladorV1 implements ActionListener {

    VentanaRegistroPaciente vista;
    ArregloPaciente Lista;
    Paciente paciente;

    public ControladorV1(VentanaRegistroPaciente vr) {
        vista = vr;
        //Cada componente se registra como un Action Listener
        vista.txtIdPaciente.addActionListener(this);
        vista.txtNombre.addActionListener(this);
        vista.txtGenero.addActionListener(this);
        vista.txtEdad.addActionListener(this);
        vista.cbxEspecialidad.addActionListener(this);
        vista.txtFecha.addActionListener(this);
        vista.btnGuardar.addActionListener(this);
        vista.btnBuscar.addActionListener(this);
        vista.btnOrdenar.addActionListener(this);
        vista.btnEditar.addActionListener(this);
        mostrarNumPacientes();
        Lista = new ArregloPaciente();
        Lista.RecuperarDeArchivo(); //-- Recuperar Archivo Binario 
        Lista.ActualizarCantidadPacientes(); //-- Actualizar cant 
        ProcesosVentana01.MostrarEnTabla(vista, Lista.getLista()); //-- Mostar Datos en tabla
        ProcesosVentana01.PresentarVentanaRegistroPaciente(vista); //--- Caracteristicas de la Ventana(titulo)
        ListaEnlazada listaEnlazada = DatosEspecialidad.RecuperarDeArchivo();
        filaSeleccionada = -1;
    
        listaPacientes = ProcesosVentanaEspecialidad.getListaEspecialidad(listaEnlazada);
        rellenarComboEspecialidad();
        eventoClickTabla();
        initBotones();
    }

    ArrayList<Especialidad> listaPacientes;
    
    private void rellenarComboEspecialidad() {
        vista.cbxEspecialidad.removeAllItems();
        for (Especialidad paciente : listaPacientes) {
            String idEspecialidad = paciente.getCodigo();
            vista.cbxEspecialidad.addItem(idEspecialidad);
        }
    }
    int filaSeleccionada = -1;

    private void eventoClickTabla() {
        vista.tblDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                filaSeleccionada = vista.tblDatos.getSelectedRow();
                String idEspecialidad = vista.tblDatos.getValueAt(filaSeleccionada, 5).toString();
                mostrarInfoPropietario(idEspecialidad);
            }
        });
    }

    private void mostrarNumPacientes() {
        vista.txtNumPacientes.setText("Pacientes: " + listaPacientes().length);
    }

    private void mostrarInfoPropietario(String idPropietario) {
        vista.txaResumenPaciente.setText("");
        String nombre = getPaciente(idPropietario).getNombre();
        String Nivel = getPaciente(idPropietario).getNivel();
        String Descripcion = getPaciente(idPropietario).getDescripcion();
        vista.txaResumenPaciente.append("\n\n\tDATOS DE LA ATENCION");
        vista.txaResumenPaciente.append("\n\n");
        vista.txaResumenPaciente.append("\n - Codigo         : " + idPropietario);
        vista.txaResumenPaciente.append("\n - Nombre         : " + nombre);
        vista.txaResumenPaciente.append("\n - Nivel          : " + Nivel);
        vista.txaResumenPaciente.append("\n - Descripcion : " + Descripcion);
    }

    private Especialidad getPaciente(String idEspecialidad) {
        for (Especialidad paciente : listaPacientes) {
            String tempId = paciente.getCodigo();
            if (idEspecialidad.equals(tempId)) {
                return paciente;
            }
        }
        return null;
    }

    private void initBotones() {
        eliminar();
    }

    private void eliminar() {
        vista.btnEliminar.addActionListener((java.awt.event.ActionEvent evt) -> {
            if (filaSeleccionada >= 0) {
                String idEspecialidad = vista.tblDatos.getValueAt(filaSeleccionada, 1).toString();
                Lista.EliminarPaciente(idEspecialidad);
                ProcesosVentana01.MostrarEnTabla(vista, Lista.getLista()); //--- Muestra los datos en tabla
                Lista.GuardarEnArchivo();
                Lista.GuardarEnArchivo();
                mostrarNumPacientes();
            } else {
                System.out.println("SELECCIONA");
                JOptionPane.showMessageDialog(null, "Selecciona una fila", "Error", JOptionPane.ERROR_MESSAGE);
            }

        });
    }

    //Metodo para escuchar los eventos de los componentes de Ventana Registro
    @Override
    public void actionPerformed(ActionEvent e) {
        //GUARDAR
        if (e.getSource() == vista.btnGuardar) {
            paciente = ProcesosVentana01.LeerPaciente(vista);
            Lista.AgregarPaciente(paciente);
            Lista.GuardarEnArchivo();
            Lista.RecuperarDeArchivo();
            mostrarNumPacientes();
            ProcesosVentana01.MostrarEnTabla(vista, Lista.getLista()); //--- Muestra los datos en tabla
            ProcesosVentana01.LimpiarEntradas(vista); //--- Limpia los campos de datos
        }

        //METODOS BUSCAR
        if (e.getSource() == vista.btnBuscar) {
            String codPaciente = vista.txtBusqCod.getText();
            int opcCombo = vista.cbxOrdenar.getSelectedIndex();
            ArregloPaciente arregloPac = new ArregloPaciente();
            arregloPac.RecuperarDeArchivo();
            Paciente listaPasci[] = arregloPac.getLista();
            switch (opcCombo) {
                case 0:
                    Paciente pacienteEncontrado = Busquedas.buscarPacientePorCodigo(listaPasci, codPaciente);
                    if (pacienteEncontrado != null) {
                        JOptionPane.showMessageDialog(null, pacienteEncontrado.imprimir());
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontro", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 1:
                    Paciente buSecuencial = Busquedas.buscarPacientePorCodigo_SecuencialRecursiva(listaPasci, codPaciente);
                    if (buSecuencial != null) {
                        JOptionPane.showMessageDialog(null, buSecuencial.imprimir());
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontro", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
            }
        }

        //ACCION BOTON ORDENAR
        if (e.getSource() == vista.btnOrdenar) {           
            ArregloPaciente arregloMas = new ArregloPaciente();
            arregloMas.RecuperarDeArchivo();
            Paciente listaPaci[] = arregloMas.getLista();
            Paciente[] listaordenada = OrdenarArreglosObjetos.OrdernarPacientesPorCodigo(listaPaci);
            System.out.println("EEEOOO");
                    ProcesosVentana01.MostrarEnTabla(vista, listaordenada);
                    ProcesosVentana01.MostrarResumen(vista, listaordenada);
        }
        //ACCION BOTON EDITAR
        // Acción del botón Editar
if (e.getSource() == vista.btnEditar) {
    if (filaSeleccionada >= 0) {
        // Obtener el ID del paciente desde la tabla
        String idPaciente = vista.tblDatos.getValueAt(filaSeleccionada, 1).toString();
        
        // Obtener el paciente actual usando el ID
        Paciente pacienteAEditar = Lista.buscarPaciente(idPaciente);
        if (pacienteAEditar == null) {
            JOptionPane.showMessageDialog(null, "Paciente no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Solicitar los nuevos datos mediante JOptionPane
        String nuevoNombre = JOptionPane.showInputDialog(null, "Editar Nombre:", pacienteAEditar.getNombre());
        String nuevoGenero = JOptionPane.showInputDialog(null, "Editar Género:", pacienteAEditar.getGenero());
        String nuevaEdadStr = JOptionPane.showInputDialog(null, "Editar Edad:", pacienteAEditar.getEdad());

        // Validar los datos ingresados (ejemplo para la edad)
        int nuevaEdad = pacienteAEditar.getEdad();
        try {
            nuevaEdad = Integer.parseInt(nuevaEdadStr);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Edad no válida. No se realizarán cambios en la edad.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }

        // Actualizar los datos del paciente
        pacienteAEditar.setNombre(nuevoNombre);
        pacienteAEditar.setGenero(nuevoGenero);
        pacienteAEditar.setEdad(nuevaEdad);

        // Guardar cambios y actualizar la tabla
        Lista.GuardarEnArchivo(); // Guarda la lista actualizada
        ProcesosVentana01.MostrarEnTabla(vista, Lista.getLista()); // Muestra los datos actualizados en la tabla
    } else {
        JOptionPane.showMessageDialog(null, "Selecciona un paciente de la tabla para editar", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    }

    public static Paciente[] listaPacientes() {
        ArregloPaciente arregloMas = new ArregloPaciente();
        arregloMas.RecuperarDeArchivo();
        Paciente listaPaci[] = arregloMas.getLista();
        Paciente[] listaPac = Arrays.stream(listaPaci)
                .filter(Pat -> Pat != null)
                .toArray(Paciente[]::new);
        return listaPac;
    }

}
