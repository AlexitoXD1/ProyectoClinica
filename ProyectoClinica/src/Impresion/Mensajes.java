
package Impresion;
import javax.swing.JOptionPane;
public class Mensajes {
    public static void Mostrar(String msj){
        JOptionPane.showMessageDialog(null, msj);
    }
    public static String Leer(String msj){
        return JOptionPane.showInputDialog(msj);
    }
    public static int Confirmar(String titulo,String msj){
        return JOptionPane.showConfirmDialog(null,
                msj,
                titulo,
                JOptionPane.YES_NO_OPTION); // 0: Si 1: No
    }
    
}
