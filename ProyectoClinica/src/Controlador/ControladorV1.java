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
        vista.txtID.addActionListener(this);
        vista.txtNombre.addActionListener(this);
        vista.txtGenero.addActionListener(this);
        vista.txtEdad.addActionListener(this);
        vista.cbxEspecialidad.addActionListener(this);
        vista.txtFecha.addActionListener(this);
        vista.btnGuardar.addActionListener(this);
        vista.btnBuscar.addActionListener(this);
        vista.btnOrdenar.addActionListener(this);
        mostrarNumPacientes();
        //Faltaria la Opcion Subir Foto
        Lista = new ArregloPaciente();
        Lista.RecuperarDeArchivo(); //-- Recuperar Archivo Binario (Class: Arreglo Mascotas)
        Lista.ActualizarCantidadPacientes(); //-- Actualizar cant de Mascotas (Class: Arreglo Mascotas)
        ProcesosVentana01.MostrarEnTabla(vista, Lista.getLista()); //-- Mostar Datos en tabla
//        ProcesosVentana01.MostrarResumen(vista, Lista.getLista()); //-- Mostar Resumen de Datos
        ProcesosVentana01.PresentarVentanaRegistroPaciente(vista); //--- Caracteristicas de la Ventana(titulo)
        ListaEnlazada listaEnlazada = DatosEspecialidad.RecuperarDeArchivo();
        filaSeleccionada = -1;
        /*El combo propietarios se rellena gracias a la lista clientes que
        me retorna el método getListaClientes sacandolo del archivo.bin     
        */       
        listaPacientes = ProcesosVentanaEspecialidad.getListaEspecialidad(listaEnlazada);
        rellenarComboPropietarios();
        eventoClickTabla();
        initBotones();
    }

    ArrayList<Especialidad> listaPacientes;
    
    private void rellenarComboPropietarios() {
        vista.cbxEspecialidad.removeAllItems();
        for (Especialidad paciente : listaPacientes) {
            String idPropietario = paciente.getCodigo();
            vista.cbxEspecialidad.addItem(idPropietario);
        }
    }
    int filaSeleccionada = -1;

    private void eventoClickTabla() {
        vista.tblDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                filaSeleccionada = vista.tblDatos.getSelectedRow();
                String idPropietario = vista.tblDatos.getValueAt(filaSeleccionada, 5).toString();
                mostrarInfoPropietario(idPropietario);
            }
        });
    }

    private void mostrarNumPacientes() {
        vista.txtNumMascotas.setText("Pacientes: " + listaPacientes().length);
    }

    private void mostrarInfoPropietario(String idPropietario) {
        vista.txaResumenMascota.setText("");
        String nombre = getPaciente(idPropietario).getNombre();
        String Nivel = getPaciente(idPropietario).getNivel();
        String Descripcion = getPaciente(idPropietario).getDescripcion();
        vista.txaResumenMascota.append("\n\n\tDATOS DE LA ATENCION");
        vista.txaResumenMascota.append("\n\n");
        vista.txaResumenMascota.append("\n - Codigo         : " + idPropietario);
        vista.txaResumenMascota.append("\n - Nombre         : " + nombre);
        vista.txaResumenMascota.append("\n - Nivel          : " + Nivel);
        vista.txaResumenMascota.append("\n - Descripcion : " + Descripcion);
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
//                ProcesosVentana01.MostrarResumen(vista, Lista.getLista()); //--- Muestra el Resumen en txtArea
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
            //---> continua aqui
            paciente = ProcesosVentana01.LeerPaciente(vista);
            Lista.AgregarPaciente(paciente);
            Lista.GuardarEnArchivo();
            Lista.RecuperarDeArchivo();
            mostrarNumPacientes();
            ProcesosVentana01.MostrarEnTabla(vista, Lista.getLista()); //--- Muestra los datos en tabla
//            ProcesosVentana01.MostrarResumen(vista, Lista.getLista()); //--- Muestra el Resumen en txtArea
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
    }

    public static Paciente[] listaPacientes() {
        ArregloPaciente arregloMas = new ArregloPaciente();
        arregloMas.RecuperarDeArchivo();
        Paciente listaPaci[] = arregloMas.getLista();
        Paciente[] mascotasFiltradas = Arrays.stream(listaPaci)
                .filter(Pat -> Pat != null)
                .toArray(Paciente[]::new);
        return mascotasFiltradas;
    }

}
