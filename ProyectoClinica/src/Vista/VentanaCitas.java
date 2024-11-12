package Vista;

import Controlador.ControladorV2;

public class VentanaCitas extends javax.swing.JInternalFrame {

    ControladorV2 controlador;

    public VentanaCitas() {
        initComponents();
        controlador = new ControladorV2(this);
        controlador.init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPrincipal = new javax.swing.JPanel();
        PanelRegistroCitas = new javax.swing.JPanel();
        comboEstado = new javax.swing.JComboBox<>();
        txtIDPropietario = new javax.swing.JLabel();
        txtCodCita = new javax.swing.JTextField();
        comboIdDoctor = new javax.swing.JComboBox<>();
        comboIdMascota = new javax.swing.JComboBox<>();
        cbxServicio = new javax.swing.JComboBox<>();
        btnLimpiar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminarCita = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDatosCita = new javax.swing.JTable();
        btnBuscarCod = new javax.swing.JButton();
        txtBuscarCod = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        txaDetalleCita = new javax.swing.JTextArea();
        cbxOrdenarCita = new javax.swing.JComboBox<>();
        btnOrdenarCita = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setMaximumSize(new java.awt.Dimension(1174, 650));
        setPreferredSize(new java.awt.Dimension(1174, 650));

        PanelPrincipal.setBackground(new java.awt.Color(0, 153, 255));

        PanelRegistroCitas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "REGISTRO DE CITAS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        comboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pendiente", "cancelado", "atendido" }));
        comboEstado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ESTADO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        comboEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboEstadoActionPerformed(evt);
            }
        });

        txtIDPropietario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtIDPropietario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ID PROPIETARIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        txtCodCita.setEditable(false);
        txtCodCita.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CODIGO DE CITA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        comboIdDoctor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NOMBRE DOCTOR A CARGO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        comboIdMascota.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ID MASCOTA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        comboIdMascota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboIdMascotaActionPerformed(evt);
            }
        });

        cbxServicio.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SERVICIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        cbxServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxServicioActionPerformed(evt);
            }
        });

        btnLimpiar.setBackground(new java.awt.Color(102, 102, 255));
        btnLimpiar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(102, 102, 255));
        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("GUARDAR");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminarCita.setBackground(new java.awt.Color(102, 102, 255));
        btnEliminarCita.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEliminarCita.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarCita.setText("ELIMINAR");
        btnEliminarCita.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCitaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelRegistroCitasLayout = new javax.swing.GroupLayout(PanelRegistroCitas);
        PanelRegistroCitas.setLayout(PanelRegistroCitasLayout);
        PanelRegistroCitasLayout.setHorizontalGroup(
            PanelRegistroCitasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRegistroCitasLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelRegistroCitasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(PanelRegistroCitasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtCodCita, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboIdMascota, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtIDPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbxServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboIdDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelRegistroCitasLayout.createSequentialGroup()
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarCita, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        PanelRegistroCitasLayout.setVerticalGroup(
            PanelRegistroCitasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRegistroCitasLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(txtCodCita)
                .addGap(15, 15, 15)
                .addComponent(comboIdMascota)
                .addGap(10, 10, 10)
                .addComponent(txtIDPropietario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(cbxServicio)
                .addGap(10, 10, 10)
                .addComponent(comboIdDoctor)
                .addGap(18, 18, 18)
                .addGroup(PanelRegistroCitasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminarCita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(comboEstado)
                .addContainerGap())
        );

        tblDatosCita.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tblDatosCita.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Cita", "ID Mascota", "ID Propietario", "Nombre Doctor", "Servicio", "Fecha", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDatosCita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDatosCitaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblDatosCita);

        btnBuscarCod.setBackground(new java.awt.Color(102, 102, 255));
        btnBuscarCod.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnBuscarCod.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarCod.setText("BUSCAR");
        btnBuscarCod.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCodActionPerformed(evt);
            }
        });

        txtBuscarCod.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        txtBuscarCod.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CÓDIGO A BUSCAR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        txaDetalleCita.setEditable(false);
        txaDetalleCita.setColumns(20);
        txaDetalleCita.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txaDetalleCita.setRows(5);
        txaDetalleCita.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DETALLE DE CITA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(51, 0, 153))); // NOI18N
        jScrollPane5.setViewportView(txaDetalleCita);

        cbxOrdenarCita.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CODIGO CITA", "ID MASCOTA", "ID PROPIETARIO", "NOMBRE DOCTOR", "SERVICIO", "FECHA" }));
        cbxOrdenarCita.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ORDENAR POR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        btnOrdenarCita.setBackground(new java.awt.Color(153, 102, 255));
        btnOrdenarCita.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnOrdenarCita.setForeground(new java.awt.Color(255, 255, 255));
        btnOrdenarCita.setText("ORDENAR");
        btnOrdenarCita.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOrdenarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarCitaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelPrincipalLayout = new javax.swing.GroupLayout(PanelPrincipal);
        PanelPrincipal.setLayout(PanelPrincipalLayout);
        PanelPrincipalLayout.setHorizontalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(PanelRegistroCitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                        .addComponent(txtBuscarCod, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarCod, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(cbxOrdenarCita, 0, 232, Short.MAX_VALUE)
                        .addGap(15, 15, 15)
                        .addComponent(btnOrdenarCita, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelPrincipalLayout.setVerticalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtBuscarCod)
                            .addComponent(btnOrdenarCita, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBuscarCod, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxOrdenarCita, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(PanelRegistroCitas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        controlador.limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        controlador.guardar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCitaActionPerformed
        controlador.eliminar();
    }//GEN-LAST:event_btnEliminarCitaActionPerformed

    private void tblDatosCitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDatosCitaMouseClicked
        controlador.clickTabla();
    }//GEN-LAST:event_tblDatosCitaMouseClicked

    private void btnBuscarCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCodActionPerformed
        controlador.buscarCodigo();
    }//GEN-LAST:event_btnBuscarCodActionPerformed

    private void btnOrdenarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarCitaActionPerformed
        controlador.ordenar();
    }//GEN-LAST:event_btnOrdenarCitaActionPerformed

    private void comboEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboEstadoActionPerformed
        controlador.cambiarEstado();
    }//GEN-LAST:event_comboEstadoActionPerformed

    private void comboIdMascotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboIdMascotaActionPerformed
        controlador.rellenarComboServicio();
    }//GEN-LAST:event_comboIdMascotaActionPerformed

    private void cbxServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxServicioActionPerformed
        
    }//GEN-LAST:event_cbxServicioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel PanelPrincipal;
    public javax.swing.JPanel PanelRegistroCitas;
    public javax.swing.JButton btnBuscarCod;
    public javax.swing.JButton btnEliminarCita;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnLimpiar;
    public javax.swing.JButton btnOrdenarCita;
    public javax.swing.JComboBox<String> cbxOrdenarCita;
    public javax.swing.JComboBox<String> cbxServicio;
    public javax.swing.JComboBox<String> comboEstado;
    public javax.swing.JComboBox<String> comboIdDoctor;
    public javax.swing.JComboBox<String> comboIdMascota;
    public javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JScrollPane jScrollPane5;
    public javax.swing.JTable tblDatosCita;
    public javax.swing.JTextArea txaDetalleCita;
    public javax.swing.JTextField txtBuscarCod;
    public javax.swing.JTextField txtCodCita;
    public javax.swing.JLabel txtIDPropietario;
    // End of variables declaration//GEN-END:variables
}
