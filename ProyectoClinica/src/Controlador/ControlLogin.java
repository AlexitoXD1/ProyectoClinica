package Controlador;

import Colecciones.ArregloUsuarios;
import Impresion.Mensajes;
import Persistencia.AlmacenarUsuarios;
import Vista.Login;
import Vista.Menu;
import Vista.Registro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlLogin implements ActionListener {

    Login log;
    ArregloUsuarios Lista;

    public ControlLogin(Login flog) {
        log = flog;
        log.btnAcceder.addActionListener(this);
        log.btnRegistrarse.addActionListener(this);
        log.btnMostrar.addActionListener(this);
        log.setTitle("Login del sistema");
        log.setVisible(true);
        log.setLocationRelativeTo(null);
        Lista = new ArregloUsuarios(50);
        Lista = AlmacenarUsuarios.RecuperarDatos();

        if (Lista != null) {
            Lista.ActualizarContador();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (log.btnAcceder == e.getSource()) {
            boolean mostrar=true;
            if(log.txtUsuario.getText().isEmpty()  ){
                    Mensajes.Mostrar("Nombre de usario o contraseña vacio");
                    mostrar=false;
            }
            for (int i = 0; i < Lista.MostrarContador(); i++) {  
                if (log.txtUsuario.getText().equals(Lista.RecuperarUsuario(i).getNom())
                    && log.txtContraseña.getText().equals(Lista.RecuperarUsuario(i).getContra())) {
                    Menu men = new Menu();
                    ControlMenu cm = new ControlMenu(men);
                    men.setVisible(true);
                    String usu = log.txtUsuario.getText();
                    men.setTitle(usu.toUpperCase()+" : Menu del hospital");
                    log.setVisible(false);
                    mostrar=false;
                    break;
                }
            }
            if(mostrar){
               Mensajes.Mostrar("No existe el nombre o contraseña, Registrate sino tienes cuenta");
            }

        }
        if (log.btnRegistrarse == e.getSource()) {
            Registro re = new Registro();
            ControlRegistrarse cm = new ControlRegistrarse(re);
            re.setVisible(true);
            log.setVisible(false);
        }
        if (e.getSource() == log.btnMostrar) {
            /* System.out.print(contador);

            for (int i = 0; i < ArregloEstudiantes.contador; i++) {
                System.out.print(i);
                System.out.print(Lista.RecuperarEmpleado(i).getPe());
            }*/

            //Lista.MostrarContador();
            for (int i = 0; i < Lista.MostrarContador(); i++) {
                System.out.print(Lista.RecuperarUsuario(i).getNom() + "-");
                System.out.println(Lista.RecuperarUsuario(i).getContra());
                System.out.print(log.txtUsuario.getText());
            }

        }
    }

}
