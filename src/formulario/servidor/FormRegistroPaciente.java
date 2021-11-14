/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulario.servidor;

import formularios.LoadingHistorialItem;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import jiconfont.swing.IconFontSwing;
import recursos.iconos.GoogleMaterialDesignIcons;
import utiles.Constantes;

/**
 *
 * @author Alex
 */
public class FormRegistroPaciente extends javax.swing.JPanel {

    private DefaultTableModel modeloTabla;

    /**
     * Creates new form FormRecordObtenidos
     */
    public FormRegistroPaciente() {
        initComponents();
        pintarIconos();
        
        //Scroll velocidad
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(20);
        jScrollPane2.getVerticalScrollBar().setUnitIncrement(20);
        
        //Spinner del panel de historial de registros
        panelHistorialPacientes.add(new LoadingHistorialItem("Error de conexión con la base de datos", true));
    }
    
    private void pintarIconos() {
        //Icono informacion
        btnInfoIcono.setIcon(IconFontSwing.buildIcon(GoogleMaterialDesignIcons.INFO, 24, Constantes.COLOR_MEDIO));
        btnInfoIcono.setRolloverIcon(IconFontSwing.buildIcon(GoogleMaterialDesignIcons.INFO, 27, Constantes.COLOR_MEDIO));
    }
    

    /*GETTERS*/
    
    public JPanel getPanelProcesandoRegistros(){
        return panelProcesandoRegistros;
    }

    public JPanel getPanelHistorialPacientes() {
        return this.panelHistorialPacientes;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelProcesandoRegistros = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btnInfoIcono = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        panelHistorialPacientes = new javax.swing.JPanel();

        setBackground(Constantes.COLOR_LIGERO);
        setPreferredSize(new java.awt.Dimension(650, 450));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(Constantes.COLOR_LIGERO);
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 10, 0));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(630, 280));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(Constantes.COLOR_BLANCO);
        jPanel4.setPreferredSize(new java.awt.Dimension(500, 200));

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setOpaque(false);

        panelProcesandoRegistros.setBackground(Constantes.COLOR_BLANCO);
        panelProcesandoRegistros.setLayout(new javax.swing.BoxLayout(panelProcesandoRegistros, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(panelProcesandoRegistros);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, java.awt.BorderLayout.LINE_START);

        jPanel5.setOpaque(false);
        jPanel5.setPreferredSize(new java.awt.Dimension(650, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setText("Procesando registros");

        btnInfoIcono.setToolTipText("Detener jornada");
        btnInfoIcono.setBorder(null);
        btnInfoIcono.setContentAreaFilled(false);
        btnInfoIcono.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInfoIcono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInfoIconoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInfoIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(439, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnInfoIcono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanel5, java.awt.BorderLayout.PAGE_START);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(255, 0, 51));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(60, 300));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setMaximumSize(new java.awt.Dimension(2034, 40));
        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(650, 40));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        jLabel5.setToolTipText("");
        jLabel5.setMaximumSize(new java.awt.Dimension(20, 14));
        jLabel5.setPreferredSize(new java.awt.Dimension(20, 14));
        jPanel3.add(jLabel5);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Paciente");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setMaximumSize(new java.awt.Dimension(500, 14));
        jLabel1.setPreferredSize(new java.awt.Dimension(100, 14));
        jPanel3.add(jLabel1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Síntomas");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.setMaximumSize(new java.awt.Dimension(500, 14));
        jLabel2.setPreferredSize(new java.awt.Dimension(100, 14));
        jPanel3.add(jLabel2);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Doctor");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel3.setMaximumSize(new java.awt.Dimension(500, 14));
        jLabel3.setPreferredSize(new java.awt.Dimension(100, 14));
        jPanel3.add(jLabel3);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Turno");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel4.setMaximumSize(new java.awt.Dimension(500, 14));
        jLabel4.setPreferredSize(new java.awt.Dimension(50, 14));
        jPanel3.add(jLabel4);

        jPanel2.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jScrollPane2.setBackground(new java.awt.Color(102, 255, 51));
        jScrollPane2.setBorder(null);
        jScrollPane2.setOpaque(false);

        panelHistorialPacientes.setBackground(Constantes.COLOR_LIGERO);
        panelHistorialPacientes.setLayout(new javax.swing.BoxLayout(panelHistorialPacientes, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane2.setViewportView(panelHistorialPacientes);

        jPanel2.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnInfoIconoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfoIconoActionPerformed
        Runnable r = () -> {
            String html = "<html><body width='%1s'><h1>Procesando registros</h1>"
            + "<p>Esta ventana muestra la información del paciente "
                    + "cuando un cliente manda un registro, una vez procesado el registro, "
                    + "se agrega al módulo de historial de registros"
                    + "<br><br>"
                    + "<p>";
            int w = 200;
            JOptionPane.showMessageDialog(null, String.format(html, w, w), "Información", JOptionPane.INFORMATION_MESSAGE);
        };
        SwingUtilities.invokeLater(r);
    }//GEN-LAST:event_btnInfoIconoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInfoIcono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelHistorialPacientes;
    private javax.swing.JPanel panelProcesandoRegistros;
    // End of variables declaration//GEN-END:variables
}