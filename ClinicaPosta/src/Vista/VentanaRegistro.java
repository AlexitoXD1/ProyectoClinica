package Vista;

import Controlador.ControladorInicio;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class VentanaRegistro extends javax.swing.JPanel {

    ControladorInicio controlador;

    public VentanaRegistro() {
        initComponents();
        controlador = new ControladorInicio(this);
        controlador.initRegistro();
    }
    
    class JPanelGradient extends JPanel{  //Para poner un degradado al panel
        protected void paintComponent(Graphics g){
            Graphics2D g2d = (Graphics2D)g ;
            int width = getWidth();
            int height = getHeight();

            Color color1= new Color(175,123,215);
            Color color2= new Color(124,210,243);
            GradientPaint gp = new GradientPaint(0,0,color1,180,height,color2);
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, width, height);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlbTextRegistr = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtUsuario = new javax.swing.JTextField();
        imgUsuario = new Componet.Imagen();
        btnRegistrar = new javax.swing.JButton();
        jlbTittle1 = new javax.swing.JLabel();
        btnIrLogin = new javax.swing.JLabel();
        imgUsuario1 = new Componet.Imagen();
        jSeparator2 = new javax.swing.JSeparator();
        txtPassword = new javax.swing.JPasswordField();
        jlbTittle4 = new javax.swing.JLabel();
        btnOjoPasswordConfir = new javax.swing.JLabel();
        txtPasswordConfir = new javax.swing.JPasswordField();
        jSeparator3 = new javax.swing.JSeparator();
        imgUsuario2 = new Componet.Imagen();
        btnOjoPassword = new javax.swing.JLabel();
        jPanel1 = new JPanelGradient();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jlbRegistro = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlbTextRegistr.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jlbTextRegistr.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlbTextRegistr.setText("¿Ya te encuentras registro?");
        add(jlbTextRegistr, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 160, 20));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 160, 10));

        txtUsuario.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        txtUsuario.setSelectionColor(new java.awt.Color(51, 0, 102));
        add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 160, 30));

        imgUsuario.setImage(new javax.swing.ImageIcon(getClass().getResource("/_Icons/Usuario_32px.png"))); // NOI18N
        add(imgUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 40, 40));

        btnRegistrar.setBackground(new java.awt.Color(204, 255, 255));
        btnRegistrar.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btnRegistrar.setText("Registrarse");
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar.setFocusPainted(false);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, 130, 40));

        jlbTittle1.setFont(new java.awt.Font("Century Gothic", 0, 20)); // NOI18N
        jlbTittle1.setForeground(new java.awt.Color(51, 0, 102));
        jlbTittle1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlbTittle1.setText("Contraseña");
        add(jlbTittle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 150, 30));

        btnIrLogin.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnIrLogin.setForeground(new java.awt.Color(51, 0, 102));
        btnIrLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnIrLogin.setText("Inicia Sesion");
        btnIrLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIrLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIrLoginMouseClicked(evt);
            }
        });
        add(btnIrLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 80, 20));

        imgUsuario1.setImage(new javax.swing.ImageIcon(getClass().getResource("/_Icons/password_32px.png"))); // NOI18N
        add(imgUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 40, 40));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 160, 10));

        txtPassword.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        txtPassword.setSelectionColor(new java.awt.Color(51, 0, 102));
        add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 160, 30));

        jlbTittle4.setFont(new java.awt.Font("Century Gothic", 0, 20)); // NOI18N
        jlbTittle4.setForeground(new java.awt.Color(51, 0, 102));
        jlbTittle4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlbTittle4.setText("Usuario");
        add(jlbTittle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 110, 30));

        btnOjoPasswordConfir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_Icons/ojoCerrado.png"))); // NOI18N
        btnOjoPasswordConfir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOjoPasswordConfir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOjoPasswordConfirMouseClicked(evt);
            }
        });
        add(btnOjoPasswordConfir, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, 30, 30));

        txtPasswordConfir.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        txtPasswordConfir.setSelectionColor(new java.awt.Color(51, 0, 102));
        add(txtPasswordConfir, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 160, 30));
        add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, 160, 10));

        imgUsuario2.setImage(new javax.swing.ImageIcon(getClass().getResource("/_Icons/password_32px.png"))); // NOI18N
        add(imgUsuario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 40, 40));

        btnOjoPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_Icons/ojoCerrado.png"))); // NOI18N
        btnOjoPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOjoPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOjoPasswordMouseClicked(evt);
            }
        });
        add(btnOjoPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, 30, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/_Icons/LogoLogin.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jPanel1.add(jLabel1);

        jlbRegistro.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jlbRegistro.setForeground(new java.awt.Color(51, 0, 102));
        jlbRegistro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbRegistro.setText("Registro");
        jPanel1.add(jlbRegistro);

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 440));
    }// </editor-fold>//GEN-END:initComponents

    private void btnOjoPasswordConfirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOjoPasswordConfirMouseClicked
        controlador.btnClickOjoRegistroConfir();
    }//GEN-LAST:event_btnOjoPasswordConfirMouseClicked

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        controlador.registrar();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnIrLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIrLoginMouseClicked
        controlador.btnIrLogin();
    }//GEN-LAST:event_btnIrLoginMouseClicked

    private void btnOjoPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOjoPasswordMouseClicked
        controlador.btnClickOjoRegistro();
    }//GEN-LAST:event_btnOjoPasswordMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel btnIrLogin;
    public javax.swing.JLabel btnOjoPassword;
    public javax.swing.JLabel btnOjoPasswordConfir;
    public javax.swing.JButton btnRegistrar;
    public Componet.Imagen imgUsuario;
    public Componet.Imagen imgUsuario1;
    public Componet.Imagen imgUsuario2;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JSeparator jSeparator1;
    public javax.swing.JSeparator jSeparator2;
    public javax.swing.JSeparator jSeparator3;
    public javax.swing.JLabel jlbRegistro;
    public javax.swing.JLabel jlbTextRegistr;
    public javax.swing.JLabel jlbTittle1;
    public javax.swing.JLabel jlbTittle4;
    public javax.swing.JPasswordField txtPassword;
    public javax.swing.JPasswordField txtPasswordConfir;
    public javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
