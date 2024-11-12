package Procesos;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class PresentarMenu {

    public static void Centrar(JInternalFrame frame, JDesktopPane escritorio) {
        escritorio.removeAll();
        escritorio.add(frame);
        frame.setVisible(true);
        // Obtener el tamaño del escritorio
        Dimension tamanioescritorio = escritorio.getSize();
        // Establecer el tamaño del frame para que coincida con el tamaño del escritorio
        frame.setSize(tamanioescritorio);
        // Establecer la localización en (0,0) ya que el tamaño es el mismo que el del escritorio
        frame.setLocation(0, 0);
        // Asignar un ícono al frame
        ImageIcon icon = new ImageIcon("/_Icons/logotipo.png"); // Asegúrate de que la ruta sea correcta
        JFrame parentWindow = (JFrame) javax.swing.SwingUtilities.windowForComponent(escritorio);
        parentWindow.setTitle("POSTA MEDICA - " + frame.getTitle());
        frame.setFrameIcon(icon);
        frame.show();
        escritorio.repaint();
    }

}
