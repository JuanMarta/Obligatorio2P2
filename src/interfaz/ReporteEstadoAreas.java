// Trabajo desarrollado por: Santiago Alonso 349491 Juan Marta 332281
package interfaz;

import dominio.Area;
import dominio.Empleado;
import dominio.Sistema;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ReporteEstadoAreas extends javax.swing.JFrame implements Observer {

    private Sistema sistema;

    public ReporteEstadoAreas(Sistema sis) {
        initComponents();
        sistema = sis;
        sistema.addObserver(this);

        this.setBounds(0, 0, 633, 450);
        refrescarVentana();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelGridButtons = new javax.swing.JPanel();
        jLabelAreaYPresupuesto = new javax.swing.JLabel();
        jScrollPanelListaAreas = new javax.swing.JScrollPane();
        jPanelListaAreas = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reporte de estado de areas");
        getContentPane().setLayout(null);

        jPanelGridButtons.setLayout(new java.awt.GridLayout(0, 3, 5, 5));
        getContentPane().add(jPanelGridButtons);
        jPanelGridButtons.setBounds(190, 60, 430, 330);

        jLabelAreaYPresupuesto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelAreaYPresupuesto.setText("Area:");
        getContentPane().add(jLabelAreaYPresupuesto);
        jLabelAreaYPresupuesto.setBounds(190, 10, 430, 30);

        jScrollPanelListaAreas.setBorder(null);

        jPanelListaAreas.setLayout(new javax.swing.BoxLayout(jPanelListaAreas, javax.swing.BoxLayout.Y_AXIS));
        jScrollPanelListaAreas.setViewportView(jPanelListaAreas);

        getContentPane().add(jScrollPanelListaAreas);
        jScrollPanelListaAreas.setBounds(10, 20, 160, 370);

        pack();
    }// </editor-fold>//GEN-END:initComponents

     public void refrescarVentana() {
        cargarAreas();

        jPanelListaAreas.revalidate();
        jPanelListaAreas.repaint();
    }


    public void cargarAreas() {
        // Quito todos las areas antes de volver a colocar
        jPanelListaAreas.removeAll();

        // Lleno el panel con btn areas
        for (Area a : sistema.areasOrdenadasPorPresupuestoAsignado()) {
            JButton btnArea = new JButton(a.getNombre());

            //Guardo el objeto area como en un hashmap
            btnArea.putClientProperty("area", a);
            btnArea.setMargin(new Insets(-5, -5, -5, -5));
            btnArea.setForeground(Color.BLACK);
            btnArea.addActionListener(new AreaListener());
            btnArea.setPreferredSize(new Dimension(120, 30));
            
            // Hace que ocupe todo el ancho del panel y que tenga 30 px como maximo
            btnArea.setMaximumSize(new Dimension(Short.MAX_VALUE, 30));
            btnArea.setAlignmentX(CENTER_ALIGNMENT);

            double porcentaje = a.porcentajePresupuestoAsignado();
            if (porcentaje > 90) {
                btnArea.setBackground(Color.RED);
            } else if (porcentaje >= 70) {
                btnArea.setBackground(Color.YELLOW);
            } else {
                btnArea.setBackground(Color.LIGHT_GRAY);
            }

            jPanelListaAreas.add(btnArea);
            
            // Agrega una separacion de 4px
            jPanelListaAreas.add(javax.swing.Box.createVerticalStrut(4));
        }
    }

    public void cargarEmpleados(Area area) {
        jPanelGridButtons.removeAll();

        for (Empleado e : area.empleadosOrdenadosPorNombre()) {
            JButton btnEmpleado = new JButton(e.getNombre());
            btnEmpleado.putClientProperty("empleado", e);
            
            // Devuelve un valor entre 0 y 255 para el color del boton
            int factor = (int) Math.ceil(e.getSalarioAnual()*255/area.getPresupuestoAnual());
            btnEmpleado.setBackground(new Color(0,0, factor));
            
            btnEmpleado.setForeground(Color.WHITE);
            btnEmpleado.setMargin(new Insets(-5, -5, -5, -5));
            btnEmpleado.addActionListener(new EmpleadoListener());
            btnEmpleado.setPreferredSize(new Dimension(100, 30));
            
            JPanel panelBtn = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
            panelBtn.setOpaque(true);
            panelBtn.add(btnEmpleado);

            jPanelGridButtons.add(panelBtn);
        }

        jPanelGridButtons.revalidate();
        jPanelGridButtons.repaint();

    }

    private class AreaListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JButton btn = ((JButton) e.getSource());
            Area area = (Area) btn.getClientProperty("area");

            jLabelAreaYPresupuesto.setText("Área: " + area.getNombre() + " Porcentaje asignado: " + String.format("%.1f%%", area.porcentajePresupuestoAsignado()));
            cargarEmpleados(area);
        }
    }

    private class EmpleadoListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JButton btn = ((JButton) e.getSource());
            Empleado empleado = (Empleado) btn.getClientProperty("empleado");

            JOptionPane.showMessageDialog(ReporteEstadoAreas.this, "Cedula: " + empleado.getCedula()
                    + "\nNombre: " + empleado.getNombre()
                    + "\nCelular: " + empleado.getTelefono()
                    + "\nSalario mensual: " + empleado.getSalarioMensual());
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        refrescarVentana();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelAreaYPresupuesto;
    private javax.swing.JPanel jPanelGridButtons;
    private javax.swing.JPanel jPanelListaAreas;
    private javax.swing.JScrollPane jScrollPanelListaAreas;
    // End of variables declaration//GEN-END:variables
}
