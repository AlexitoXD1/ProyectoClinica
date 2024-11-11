/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Colecciones.ArregloUsuarios;
import Persistencia.AlmacenarUsuarios;
import Vista.Buscar;
import Vista.VistaDoctor;
import Vista.Especialidad;
import Vista.Menu;
import Vista.Paciente;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author PC
 */
public class ControlMenu implements ActionListener {

    Menu men;
    private Component originalContent2;  // Variable para guardar el contenido original

    public ControlMenu(Menu me) {
        men = me;
        men.setTitle("Menu del sistema");
        men.setVisible(true);
        men.btnDoctor.addActionListener(this);
        men.btnPaciente.addActionListener(this);
        men.btnBuscar.addActionListener(this);
        men.btnEspecialidad.addActionListener(this);
        men.btnHome.addActionListener(this);
        men.setLocationRelativeTo(null);
        // Guardar el componente original de dpsPrueba
        originalContent2 = men.dpsPrueba.getComponent(0);
    }

    private void MostrarFrame(JPanel frame) {
        men.dpsPrueba.removeAll();
        men.dpsPrueba.setLayout(new java.awt.BorderLayout());
        men.dpsPrueba.add(frame);
        men.dpsPrueba.revalidate();
        men.dpsPrueba.repaint();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == men.btnDoctor) {
            VistaDoctor doc = new VistaDoctor();
            MostrarFrame(doc);
        }
        if (e.getSource() == men.btnHome) {
//            men.dpsPrueba.removeAll();
//            men.dpsPrueba.setLayout(new java.awt.BorderLayout());
//            men.dpsPrueba.add(originalContent2);  // Volver a agregar el contenido original
//            men.dpsPrueba.revalidate();
//            men.dpsPrueba.repaint();
            
            MostrarFrame((JPanel) originalContent2);
        }
        if (e.getSource() == men.btnPaciente) {
            Paciente pac = new Paciente();
            MostrarFrame(pac);
        }
        if (e.getSource() == men.btnEspecialidad) {
            Especialidad esp = new Especialidad();
            MostrarFrame(esp);
        }
        if (e.getSource() == men.btnBuscar) {
            Buscar bus = new Buscar();
            MostrarFrame(bus);
        }      

    }

}
