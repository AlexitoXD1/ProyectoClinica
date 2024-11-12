package Procesos;

import Vista.VentanaPrincipal;
import javax.swing.JFrame;

public class PresentarVentanaPrincipal {
    public static void MostrarMenu(VentanaPrincipal vp){
       vp.setVisible(true);
       vp.setTitle("POSTA CLINICA");
       vp.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}
