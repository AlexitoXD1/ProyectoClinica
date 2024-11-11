package Procesos;
import Vista.VistaDoctor;
import javax.swing.table.DefaultTableModel;
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
    public static void Estado_Botones(boolean Estado,VistaDoctor Vdoc){
        Vdoc.txtDcod.setEnabled(Estado);
        Vdoc.txtDnom.setEnabled(Estado);
        Vdoc.txtDapel.setEnabled(Estado);
        Vdoc.cbxDesp.setEnabled(Estado);
        Vdoc.txtDtel.setEnabled(Estado);
        Vdoc.btnDnuevo.setEnabled(Estado);
        Vdoc.btnDingresar.setEnabled(Estado);
        Vdoc.btnDborrar.setEnabled(Estado);
        Vdoc.btnDbuscar.setEnabled(Estado);
        Vdoc.tblDregistro.setEnabled(Estado);
    }
    public static void LimpiarTabla(DefaultTableModel modtabla){
       modtabla.setRowCount(0);
   }   
}
