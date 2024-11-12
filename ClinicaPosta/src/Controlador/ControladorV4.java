package Controlador;

import Modelo.ArregloPaciente;
import Modelo.Servicio;
import Persistencia.DataServicio;
import Pila.*;
import Vista.*;
import Procesos.*;
import Persistencia.DatosDoctor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.VentanaDoctor;
import java.util.ArrayList;
import java.util.Arrays;


public class ControladorV4 implements ActionListener {

    VentanaDoctor vista;
    PilaDoctor Pila;

    public ControladorV4(VentanaDoctor vem) {
        vista = vem;

        vista.btnAgregar.addActionListener(this);
        vista.btnRetirar.addActionListener(this);
        vista.btnVerPrimero.addActionListener(this);
        vista.btnVerUltimo.addActionListener(this);
        vista.btnBuscar.addActionListener(this);
        Pila = new PilaDoctor();
        Pila = DatosDoctor.RecuperaDeArchivo();
        ProcesosV4.Presentacion(vista);
        ProcesosV4.MostrarDatosEnTabla(vista, Pila);
    }

    //Metodo para escuchar los eventos de los componentes de Ventana Registro Doctor
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnAgregar) {
            Pila.Agregar(ProcesosV4.LeerDoctor(vista));
            ProcesosV4.LimpiarEntradas(vista);
            ProcesosV4.MostrarDatosEnTabla(vista, Pila);
        }
        if (e.getSource() == vista.btnRetirar) {
            Pila.Eliminar();
            ProcesosV4.LimpiarEntradas(vista);
            ProcesosV4.MostrarDatosEnTabla(vista, Pila);
        }
        if (e.getSource() == vista.btnVerPrimero) {
            Pila.VerPrimerElemento();
        }
        if (e.getSource() == vista.btnVerUltimo) {
            Pila.VerUltimoElemento();
        }
        if (e.getSource() == vista.btnBuscar) {
            String codbuscado = Mensajes.LeerTexto("Ingrese el "
                    + "codigo del Doctor a buscar");
            Pila.BuscarPorCodigo(codbuscado);
        }
    }//fin action 

    public static Doctor[] listaDoctores() {
        PilaDoctor Pil = new PilaDoctor();
        Pil = DatosDoctor.RecuperaDeArchivo();
        int cantDatos = Pil.getPila().size();
        Doctor arrayDoctor[] = new Doctor[cantDatos];
        for (int i = 0; i < cantDatos; i++) {
            arrayDoctor[i] = Pil.getPila().get(i);
        }
        Doctor[] DoctorFiltrados = Arrays.stream(arrayDoctor)
                .filter(pat -> pat != null)
                .toArray(Doctor[]::new);
        return DoctorFiltrados;
    }

    public static ArrayList<Doctor> listaDoctores(String condicion) {
        ArrayList<Doctor> listaDoctores = new ArrayList<>();
        for (Doctor emp : listaDoctores()) {
            String tempCargo = emp.getCargo();
            if (tempCargo.equalsIgnoreCase(condicion)) {
                listaDoctores.add(emp);
//                break;
            }
        }
        return listaDoctores;
    }

}//fin controlador
