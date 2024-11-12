package Procesos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

public class UIController {

    public static void mostrarPanel(JPanel contenedor, JPanel panel) {
        contenedor.removeAll();
//        contenedor.setSize(0, 0);
        contenedor.add(panel, BorderLayout.CENTER);
        contenedor.revalidate();
        contenedor.repaint();
    }

    public static void transparentarTxtField(JTextField... txtField) {
        for (JTextField txt : txtField) {
            txt.setBackground(new java.awt.Color(0, 0, 0, 1));
            txt.setBorder(null);
        }
    }

    public static void applyPlaceholder(JTextComponent textField, String placeholder) {
        textField.setForeground(Color.GRAY);
        textField.setText(placeholder);

        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(new Color(0, 0, 0));
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setForeground(Color.GRAY);
//                    textField.setForeground(new Color(255, 255, 255, 161));
                    textField.setText(placeholder);
                }
            }
        });
    }

}
