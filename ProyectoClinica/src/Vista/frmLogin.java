package Vista;

import Procesos.UIController;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLaf;

public class frmLogin extends javax.swing.JFrame {

    public frmLogin() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage(getClass().getResource("/_Icons/LogoLogin.png")));
        UIController.mostrarPanel(CONTENEDOR, new VentanaLogin());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CONTENEDOR = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CONTENEDOR.setBackground(new java.awt.Color(255, 255, 255));
        CONTENEDOR.setLayout(new java.awt.CardLayout());
        getContentPane().add(CONTENEDOR, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        //</editor-fold>
        FlatLaf.registerCustomDefaultsSource("Vista");
        FlatDarculaLaf.setup();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new frmLogin().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel CONTENEDOR;
    // End of variables declaration//GEN-END:variables
}
