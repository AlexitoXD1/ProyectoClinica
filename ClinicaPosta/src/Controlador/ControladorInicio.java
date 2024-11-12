package Controlador;

import Modelo.Usuario;
import Procesos.UIController;
import Vista.VentanaLogin;
import Vista.VentanaRegistro;
import Vista.frmLogin;
import javax.swing.JOptionPane;
import Persistencia.DataLogin;
import Vista.VentanaPrincipal;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLaf;
import java.awt.Color;
import javax.swing.UIManager;

public class ControladorInicio {

    VentanaLogin login;
    VentanaRegistro registro;

    public ControladorInicio(VentanaLogin login) {
        this.login = login;
    }

    public ControladorInicio(VentanaRegistro registro) {
        this.registro = registro;
    }

    public void initRegistro() {
        UIController.transparentarTxtField(registro.txtUsuario, registro.txtPassword, registro.txtPasswordConfir);
        UIController.applyPlaceholder(registro.txtUsuario, "usuario");
        UIController.applyPlaceholder(registro.txtPassword, "password");
        UIController.applyPlaceholder(registro.txtPasswordConfir, "confirmar password");
    }

    public void initLogin() {
        UIController.transparentarTxtField(login.txtUsuario, login.txtPassword);
        UIController.applyPlaceholder(login.txtUsuario, "usuario");
        UIController.applyPlaceholder(login.txtPassword, "password");
    }

    public void btnIrLogin() {
        frmLogin frmInicio = (frmLogin) javax.swing.SwingUtilities.windowForComponent(registro);
        UIController.mostrarPanel(frmInicio.CONTENEDOR, new VentanaLogin());
    }

    public void btnIrRegistro() {
        frmLogin frmInicio = (frmLogin) javax.swing.SwingUtilities.windowForComponent(login);
        UIController.mostrarPanel(frmInicio.CONTENEDOR, new VentanaRegistro());
    }

    public void registrar() {
        String usuario = registro.txtUsuario.getText();
        String password = registro.txtPassword.getText();
        String passwordConfir = registro.txtPasswordConfir.getText();
        DataLogin regist = new DataLogin();
        if (!usuario.equals("") && !password.equals("") && !passwordConfir.equals("")) {
            if (password.equals(passwordConfir)) {
                if (!regist.usuarioExiste(usuario)) {
                    Usuario us = new Usuario(usuario, password);
                    regist.registrar(us);
                    JOptionPane.showMessageDialog(null, "Usuario registrado", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
                    btnIrLogin();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario existente", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Repetir password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Rellenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void ingresar() {
        String usuario = login.txtUsuario.getText();
        String password = login.txtPassword.getText();
        DataLogin regist = new DataLogin();
        if (regist.usuarioExiste(usuario)) {
            String passwordUsuario = regist.getPassword(usuario);
            if (password.equals(passwordUsuario)) {
                frmLogin frmInicio = (frmLogin) javax.swing.SwingUtilities.windowForComponent(login);
                frmInicio.setVisible(false);
                javax.swing.SwingUtilities.invokeLater(() -> {
                    FlatLaf.registerCustomDefaultsSource("Vista");
                    FlatDarculaLaf.setup();
                    VentanaPrincipal principal = new VentanaPrincipal();
                    ControladorMenu menu = new ControladorMenu(principal);
                });
            } else {
                JOptionPane.showMessageDialog(null, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    int contOjoLogin = 0;

    public void btnClickOjoLogin() {
        //<editor-fold defaultstate="collapsed" desc="Evento de muestra password">
        contOjoLogin++;
        if (contOjoLogin % 2 != 0) {
            login.btnOjoPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_Icons/ojoAbierto.png")));
            login.txtPassword.setEchoChar((char) 0);
        } else {
            login.btnOjoPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_Icons/ojoCerrado.png")));
            login.txtPassword.setEchoChar('*');
        }
        //</editor-fold>
    }

    int contOjoRegistro = 0;

    public void btnClickOjoRegistro() {
        //<editor-fold defaultstate="collapsed" desc="Evento de muestra password">
        contOjoRegistro++;
        if (contOjoRegistro % 2 != 0) {
            registro.btnOjoPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_Icons/ojoAbierto.png")));
            registro.txtPassword.setEchoChar((char) 0);
        } else {
            registro.btnOjoPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_Icons/ojoCerrado.png")));
            registro.txtPassword.setEchoChar('*');
        }
        //</editor-fold>
    }

    int contOjoRegistroConfir = 0;

    public void btnClickOjoRegistroConfir() {
        //<editor-fold defaultstate="collapsed" desc="Evento de muestra password">
        contOjoRegistroConfir++;
        if (contOjoRegistroConfir % 2 != 0) {
            registro.btnOjoPasswordConfir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_Icons/ojoAbierto.png")));
            registro.txtPasswordConfir.setEchoChar((char) 0);
        } else {
            registro.btnOjoPasswordConfir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_Icons/ojoCerrado.png")));
            registro.txtPasswordConfir.setEchoChar('*');
        }
        //</editor-fold>
    }

}
