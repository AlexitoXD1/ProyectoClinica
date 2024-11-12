package Vista;

public class VentanaRegistroPaciente extends javax.swing.JInternalFrame {

    public VentanaRegistroPaciente() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPrincipal = new javax.swing.JPanel();
        PanelDatos = new javax.swing.JPanel();
        txtIdPaciente = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtGenero = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        btnOrdenar = new javax.swing.JButton();
        cbxEspecialidad = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        txaResumenPaciente = new javax.swing.JTextArea();
        btnBuscar = new javax.swing.JButton();
        cbxOrdenar = new javax.swing.JComboBox<>();
        txtBusqCod = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        txtNumPacientes = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setMaximumSize(new java.awt.Dimension(1077, 645));
        setPreferredSize(new java.awt.Dimension(1077, 645));

        PanelPrincipal.setBackground(new java.awt.Color(0, 153, 255));
        PanelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "REGISTRO DE DATOS PACIENTE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        PanelDatos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        txtIdPaciente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DNI", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        txtNombre.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NOMBRE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtGenero.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "GENERO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        txtEdad.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "EDAD", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        txtFecha.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "FECHA DE REGISTRO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });

        btnOrdenar.setBackground(new java.awt.Color(204, 204, 255));
        btnOrdenar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnOrdenar.setText("ORDENAR");
        btnOrdenar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarActionPerformed(evt);
            }
        });

        cbxEspecialidad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxEspecialidad.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ESPECIALIDAD DE ATENCION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        cbxEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEspecialidadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelDatosLayout = new javax.swing.GroupLayout(PanelDatos);
        PanelDatos.setLayout(PanelDatosLayout);
        PanelDatosLayout.setHorizontalGroup(
            PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDatosLayout.createSequentialGroup()
                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelDatosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelDatosLayout.createSequentialGroup()
                        .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelDatosLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cbxEspecialidad, javax.swing.GroupLayout.Alignment.LEADING, 0, 280, Short.MAX_VALUE)
                                    .addComponent(txtEdad, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtGenero, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIdPaciente)))
                            .addGroup(PanelDatosLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelDatosLayout.setVerticalGroup(
            PanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDatosLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(txtIdPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(txtGenero, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(txtEdad, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(cbxEspecialidad, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        PanelPrincipal.add(PanelDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 15, -1, -1));

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        jScrollPane2.setViewportView(tblDatos);

        PanelPrincipal.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 85, 695, 291));

        txaResumenPaciente.setEditable(false);
        txaResumenPaciente.setColumns(20);
        txaResumenPaciente.setRows(5);
        txaResumenPaciente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "RESUMEN DATOS DE PACIENTE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 18), new java.awt.Color(51, 0, 153))); // NOI18N
        jScrollPane3.setViewportView(txaResumenPaciente);

        PanelPrincipal.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(555, 394, 490, 202));

        btnBuscar.setBackground(new java.awt.Color(204, 204, 255));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        PanelPrincipal.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(901, 15, 144, 60));

        cbxOrdenar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxOrdenar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BINARIO", "SECUENCIAL" }));
        cbxOrdenar.setBorder(null);
        cbxOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxOrdenarActionPerformed(evt);
            }
        });
        PanelPrincipal.add(cbxOrdenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(733, 15, 148, 60));

        txtBusqCod.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CODIGO BUSCAR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        PanelPrincipal.add(txtBusqCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 15, 177, 60));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtNumPacientes.setBackground(new java.awt.Color(255, 255, 255));
        txtNumPacientes.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        txtNumPacientes.setText("Pacientes:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(txtNumPacientes, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtNumPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        PanelPrincipal.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 15, -1, -1));

        btnGuardar.setBackground(new java.awt.Color(51, 51, 255));
        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("GUARDAR");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        PanelPrincipal.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 410, 190, 52));

        btnEliminar.setBackground(new java.awt.Color(255, 51, 51));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelPrincipal.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 470, 190, 52));

        btnEditar.setBackground(new java.awt.Color(255, 255, 51));
        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("EDITAR");
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        PanelPrincipal.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 530, 190, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOrdenarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void cbxEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEspecialidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxEspecialidadActionPerformed

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed

    private void cbxOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxOrdenarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxOrdenarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel PanelDatos;
    public javax.swing.JPanel PanelPrincipal;
    public javax.swing.JButton btnBuscar;
    public javax.swing.JButton btnEditar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnOrdenar;
    public javax.swing.JComboBox<String> cbxEspecialidad;
    public javax.swing.JComboBox<String> cbxOrdenar;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JTable tblDatos;
    public javax.swing.JTextArea txaResumenPaciente;
    public javax.swing.JTextField txtBusqCod;
    public javax.swing.JTextField txtEdad;
    public javax.swing.JTextField txtFecha;
    public javax.swing.JTextField txtGenero;
    public javax.swing.JTextField txtIdPaciente;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JLabel txtNumPacientes;
    // End of variables declaration//GEN-END:variables
}
