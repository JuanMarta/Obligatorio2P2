package interfaz;

import auxiliar.ServicioIA;
import dominio.Area;
import dominio.Empleado;
import dominio.Sistema;
import java.util.Collection;
import java.util.Collections;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.SwingWorker;

public class ReporteInteligente extends javax.swing.JFrame implements Observer {

    private Sistema sistema;

    public ReporteInteligente(Sistema sis) {
        initComponents();
        sistema = sis;
        sistema.addObserver(this);

        refrescarVentana();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxAreaOrigen = new javax.swing.JComboBox<>();
        jComboBoxEmpleado = new javax.swing.JComboBox<>();
        jComboBoxAreaDestino = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaRespuestaAI = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabelResultado = new javax.swing.JLabel();
        jButtonConsultarAI = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reporte inteligente");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Área origen");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Empleado");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Área destino");

        jComboBoxAreaOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxAreaOrigenActionPerformed(evt);
            }
        });

        jTextAreaRespuestaAI.setEditable(false);
        jTextAreaRespuestaAI.setColumns(20);
        jTextAreaRespuestaAI.setLineWrap(true);
        jTextAreaRespuestaAI.setRows(5);
        jTextAreaRespuestaAI.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextAreaRespuestaAI);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Resultado");

        jButtonConsultarAI.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonConsultarAI.setText("Generar reporte");
        jButtonConsultarAI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarAIActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 746, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(28, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                .addComponent(jComboBoxAreaOrigen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(162, 162, 162)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxAreaDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59))))
            .addGroup(layout.createSequentialGroup()
                .addGap(294, 294, 294)
                .addComponent(jButtonConsultarAI, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxAreaOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(23, 23, 23)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxEmpleado)
                            .addComponent(jComboBoxAreaDestino, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))))
                .addGap(34, 34, 34)
                .addComponent(jButtonConsultarAI, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConsultarAIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarAIActionPerformed
        Area a1 = (Area) jComboBoxAreaOrigen.getSelectedItem();
        Area a2 = (Area) jComboBoxAreaDestino.getSelectedItem();
        Empleado e = (Empleado) jComboBoxEmpleado.getSelectedItem();
        
        if (a1 != null && a2 != null && e != null && !a1.equals(a2)) {

            jLabelResultado.setIcon(new ImageIcon(getClass().getResource("/img/reloj_icon.png")));
            
            SwingWorker<String, Void> hilo = new SwingWorker<String, Void>() {

                @Override
                protected String doInBackground() throws Exception {
                    // Este código NO congela la interfaz
                    String informacion = "Información area origen: Nombre:" + a1.getNombre() + " Descripción: " + a1.getDescripcion()
                                       + "Información empleado: CV: " + e.getCv()
                                       + "Informacion area destino: Nombre: " + a2.getNombre() + " Descripción " + a2.getDescripcion();
                    return ServicioIA.LlamarIA(informacion);
                }

                @Override
                protected void done() {
                    try {
                        String resultado = get(); // obtenés la respuesta
                        jTextAreaRespuestaAI.setText(resultado);

                    } catch (Exception e) {
                        jTextAreaRespuestaAI.setText("Error al llamar a la IA: " + e.getMessage());
                    }

                    // cambiar icono al de "OK"
                    jLabelResultado.setIcon(new ImageIcon(getClass().getResource("/img/tik_icon.png")));
                }
            };

            hilo.execute();  // arranca el hilo
        }
    }//GEN-LAST:event_jButtonConsultarAIActionPerformed

    private void jComboBoxAreaOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxAreaOrigenActionPerformed
        // Cargo los empleados que tiene el area para poder transferir
        jComboBoxEmpleado.removeAllItems();

        Area a = (Area) jComboBoxAreaOrigen.getSelectedItem();
        for (Empleado e : a.getListaEmpleados()) {
            jComboBoxEmpleado.addItem(e);
        }
    }//GEN-LAST:event_jComboBoxAreaOrigenActionPerformed

    private void refrescarVentana() {
        jComboBoxAreaOrigen.removeAllItems();
        jComboBoxAreaDestino.removeAllItems();
        
        for (Area a : sistema.getListaAreas()) {
            jComboBoxAreaOrigen.addItem(a);
            jComboBoxAreaDestino.addItem(a);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConsultarAI;
    private javax.swing.JComboBox<Area> jComboBoxAreaDestino;
    private javax.swing.JComboBox<Area> jComboBoxAreaOrigen;
    private javax.swing.JComboBox<Empleado
    > jComboBoxEmpleado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelResultado;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaRespuestaAI;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        refrescarVentana();
    }
}