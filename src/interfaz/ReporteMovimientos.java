package interfaz;

import auxiliar.ArchivoGrabacion;
import dominio.*;
import dominio.Sistema;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ReporteMovimientos extends javax.swing.JFrame implements Observer {

    private Sistema sistema;

    public ReporteMovimientos(Sistema sis) {
        initComponents();
        sistema = sis;
        sistema.addObserver(this);
        refrescarVentana();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMovimientos = new javax.swing.JTable();
        jLabelMes = new javax.swing.JLabel();
        jComboMes = new javax.swing.JComboBox<>();
        jLabelAreaOrigen = new javax.swing.JLabel();
        jComboAreaOrigen = new javax.swing.JComboBox<>();
        jLabelAreaDestino = new javax.swing.JLabel();
        jComboAreaDestino = new javax.swing.JComboBox<>();
        jLabelEmpleados = new javax.swing.JLabel();
        jComboEmpleados = new javax.swing.JComboBox<>();
        jButtonExportarCSV = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reporte de movimientos");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Reporte de Movimientos");

        jTableMovimientos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mes del movimiento", "Nombre del área de origen", "Nombre del área de destino", "Nombre del empleado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableMovimientos);

        jLabelMes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelMes.setText("Mes");

        jComboMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboMesActionPerformed(evt);
            }
        });

        jLabelAreaOrigen.setText("Área origen");

        jComboAreaOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboAreaOrigenActionPerformed(evt);
            }
        });

        jLabelAreaDestino.setText("Área destino");

        jComboAreaDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboAreaDestinoActionPerformed(evt);
            }
        });

        jLabelEmpleados.setText("Empleados");

        jComboEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboEmpleadosActionPerformed(evt);
            }
        });

        jButtonExportarCSV.setText("Exportar CSV");
        jButtonExportarCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExportarCSVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelMes)
                    .addComponent(jComboMes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelAreaOrigen)
                    .addComponent(jComboAreaOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelAreaDestino)
                    .addComponent(jComboAreaDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelEmpleados)
                    .addComponent(jComboEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48))
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonExportarCSV, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelAreaDestino)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboAreaDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelMes)
                            .addComponent(jLabelAreaOrigen)
                            .addComponent(jLabelEmpleados))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboAreaOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jButtonExportarCSV)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboMesActionPerformed
        cargarTabla();
    }//GEN-LAST:event_jComboMesActionPerformed

    private void jComboAreaOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboAreaOrigenActionPerformed
        cargarTabla();
    }//GEN-LAST:event_jComboAreaOrigenActionPerformed

    private void jComboAreaDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboAreaDestinoActionPerformed
        cargarTabla();
    }//GEN-LAST:event_jComboAreaDestinoActionPerformed

    private void jComboEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboEmpleadosActionPerformed
        cargarTabla();
    }//GEN-LAST:event_jComboEmpleadosActionPerformed

    private void jButtonExportarCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExportarCSVActionPerformed
        JFileChooser selectorArchivo = new JFileChooser();
        selectorArchivo.setDialogTitle("Especifique un archivo a guardar");

        if (selectorArchivo.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            ArchivoGrabacion ag = new ArchivoGrabacion(selectorArchivo.getSelectedFile().getAbsolutePath() + ".csv", false);
            
            for (int i = 0; i < jTableMovimientos.getRowCount(); i++) {
                String linea = "";
                for (int j = 0; j < jTableMovimientos.getColumnCount(); j++) {
                    linea += jTableMovimientos.getValueAt(i, j) + ";";
                }
                ag.grabarLinea(linea);
            }
            ag.cerrar();
            JOptionPane.showMessageDialog(this, "Movimientos exportados correctamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Exportación cancelada por el usuario.");
        }
    }//GEN-LAST:event_jButtonExportarCSVActionPerformed

    public void cargarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) jTableMovimientos.getModel();
        modelo.setRowCount(0); // limpia las filas actuales

        int mes = jComboMes.getSelectedIndex();

        String nomAreaOrigen = null;
        if (!(jComboAreaOrigen.getSelectedIndex() <= 0)) {
            Area a = (Area) jComboAreaOrigen.getSelectedItem();
            nomAreaOrigen = a.getNombre();
        }

        String nomAreaDestino = null;
        if (!(jComboAreaDestino.getSelectedIndex() <= 0)) {
            Area a = (Area) jComboAreaDestino.getSelectedItem();
            nomAreaDestino = a.getNombre();
        }

        String nombre = null;
        if (!(jComboEmpleados.getSelectedIndex() <= 0)) {
            Empleado e = (Empleado) jComboEmpleados.getSelectedItem();
            nombre = e.getNombre();
        }

        for (Movimiento m : sistema.filtroMovimiento(mes, nomAreaOrigen, nomAreaDestino, nombre)) {
            modelo.addRow(new Object[]{
                m.getMesRealizacion(),
                m.getNombreAreaOrigen(),
                m.getNombreAreaDestino(),
                m.getNombreEmpleado()
            });
        }
    }

    public void refrescarVentana() {
        // Quito todos los elementos
        jComboMes.removeAllItems();
        jComboAreaOrigen.removeAllItems();
        jComboAreaDestino.removeAllItems();
        jComboEmpleados.removeAllItems();

        //Lleno los combo de con todos los datos
        jComboMes.addItem("Todos los meses");
        jComboAreaOrigen.addItem("Todos las areas");
        jComboAreaDestino.addItem("Todas las areas");
        jComboEmpleados.addItem("Todos los empleados");

        for (int i = 1; i < 13; i++) {
            jComboMes.addItem(String.valueOf(i));
        }

        for (Area a : sistema.getListaAreasHistoricas()) {
            jComboAreaOrigen.addItem(a);
        }

        for (Area a : sistema.getListaAreasHistoricas()) {
            jComboAreaDestino.addItem(a);
        }

        for (Empleado e : sistema.getListaEmpleados()) {
            jComboEmpleados.addItem(e);
        }

        cargarTabla();
    }

    @Override
    public void update(Observable o, Object arg) {
        refrescarVentana();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonExportarCSV;
    private javax.swing.JComboBox<Object> jComboAreaDestino;
    private javax.swing.JComboBox<Object> jComboAreaOrigen;
    private javax.swing.JComboBox<Object> jComboEmpleados;
    private javax.swing.JComboBox<Object> jComboMes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelAreaDestino;
    private javax.swing.JLabel jLabelAreaOrigen;
    private javax.swing.JLabel jLabelEmpleados;
    private javax.swing.JLabel jLabelMes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMovimientos;
    // End of variables declaration//GEN-END:variables
}
