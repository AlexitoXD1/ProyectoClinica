package Procesos;
//librerias

import Vista.Registro;
import Modelo.Usuario;
import Colecciones.*;
import Impresion.Mensajes;

public class ProcesosRegistrar {

    public static void Presentacion(Registro f1) {
        f1.setTitle("Registro de Estudiantes");
        f1.setVisible(true);
        f1.setLocationRelativeTo(null);
        f1.txtUsuarioRegis.requestFocus();
    }

    public static void LimpiarEntradas(Registro f1) {
        f1.txtUsuarioRegis.setText("");
        f1.txtContraRegis.setText("");
        f1.txtCorreoRegis.setText("");
        f1.txtTelefonoRegis.setText("");
    }

    public static Usuario LeerUsuario(Registro f1) {
        Usuario usu = new Usuario();
        if (f1.txtUsuarioRegis.getText().isEmpty()) {
            Mensajes.Mostrar("Nombre de usuario no debe estar vacio");
            return null;
        }else{
            usu.setNom(f1.txtUsuarioRegis.getText());
        }
        
        if (f1.txtContraRegis.getText().isEmpty()) {
            Mensajes.Mostrar("Contraseña no debe estar vacio");
            return null;
        }else{
            usu.setContra(f1.txtContraRegis.getText());
        }

// Verifica que el campo no esté vacío
        if (f1.txtCorreoRegis.getText().isEmpty()) {
            Mensajes.Mostrar("Correo no debe estar vacio");
            return null;
        } // Verifica que el correo tenga el formato de Gmail
        else if (!f1.txtCorreoRegis.getText().matches("^[\\w.-]+@gmail\\.com$")) {
            Mensajes.Mostrar("Correo debe terminar en @mail.com");
            return null;
        } else {
            //Mensajes.Mostrar("Correo correcto");
            usu.setCorre(f1.txtCorreoRegis.getText());
        }
        
        if (f1.txtTelefonoRegis.getText().isEmpty()) {
            Mensajes.Mostrar("Telefono no debe estar vacio");
            return null;
        } // Verifica que el correo tenga el formato de Gmail
        else if (!f1.txtTelefonoRegis.getText().matches("^9\\d{8}$")) {
            Mensajes.Mostrar("El telefono debe empezar en 9 y tener 9 digitos");
            return null;
        } else {
            //Mensajes.Mostrar("Correo correcto");
            usu.setTel(f1.txtTelefonoRegis.getText());
        }
        return usu;
    }

    public static int MostrarContador(ArregloUsuarios Lista) {
        int cont = ArregloUsuarios.contador;
        for (int i = 0; i < ArregloUsuarios.contador; i++) {
            cont++;
        }
        return cont;
    }

}//fin de la clase
