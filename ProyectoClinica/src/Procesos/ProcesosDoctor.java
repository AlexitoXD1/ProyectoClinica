package Procesos;
import Modelo.Doctor;
import Vista.VistaDoctor;
public class ProcesosDoctor {
    public static void Presentación(VistaDoctor Vdoc){
        Vdoc.setVisible(true);
        Vdoc.txtDcod.requestFocus();
    }
    public static void LimpiarEntradas(VistaDoctor Vdoc){
        Vdoc.txtDcod.setText("");
        Vdoc.txtDnom.setText("");
        Vdoc.txtDapel.setText("");
        Vdoc.cbxDesp.setSelectedIndex(0);
        Vdoc.txtDtel.setText("");
    }
}
