package Controlador;

import Colecciones.ArregloUsuarios;
import Impresion.Mensajes;
import Modelo.Usuario;
import Persistencia.AlmacenarUsuarios;
import Procesos.ProcesosRegistrar;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlRegistrarse implements ActionListener {

    Registro reg;
    ArregloUsuarios Lista;

    public ControlRegistrarse(Registro regis) {
        reg = regis;
        reg.btnRegistrarseRegis.addActionListener(this);
        reg.btnVolverIS.addActionListener(this);
        reg.setTitle("Registro del sistema");
        reg.setVisible(true);
        reg.setLocationRelativeTo(null);
        Lista = new ArregloUsuarios(50);
        Lista = AlmacenarUsuarios.RecuperarDatos();
        if (Lista != null) {
            Lista.ActualizarContador();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (reg.btnRegistrarseRegis == e.getSource()) {
            Usuario emp = ProcesosRegistrar.LeerUsuario(reg);
            if (emp == null) {

            } else {
                Lista.AgregarUsuario(emp);
                AlmacenarUsuarios.GuardarUsuarios(Lista);
                ProcesosRegistrar.LimpiarEntradas(reg);
                Mensajes.Mostrar("Administrador Registrado.....");
                Menu men = new Menu();
                ControlMenu cm = new ControlMenu(men);
                men.setVisible(true);
                String usu = reg.txtUsuarioRegis.getText();
                men.setTitle(usu.toUpperCase() + " : Menu del hospital");
                reg.setVisible(false);
            }

        }
        if (reg.btnVolverIS == e.getSource()) {
            Login lo = new Login();
            ControlLogin clog = new ControlLogin(lo);
            lo.setVisible(true);
            reg.setVisible(false);
        }

    }

}
