/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulario.cliente;

import formularios.JPanelArrastrable;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.RoundRectangle2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import jiconfont.swing.IconFontSwing;
import recursos.iconos.GoogleMaterialDesignIcons;
import utiles.Constantes;

/**
 *
 * @author Alex
 */
public class FormPrincipalCliente extends javax.swing.JFrame {

    /**
     * Creates new form FormPrincipal
     */
    public FormPrincipalCliente() {
        configVentana();
        initComponents();
        pintarIconos();
        
    }
    
    /*Método para color iconos en la ventana principal*/
    private void pintarIconos() {
        IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont());

        //Top bar
        lblSistemaIco.setIcon(IconFontSwing.buildIcon(GoogleMaterialDesignIcons.LOCAL_HOSPITAL, 30, Constantes.COLOR_BLANCO));
        lblUsuarioIcon.setIcon(IconFontSwing.buildIcon(GoogleMaterialDesignIcons.ACCOUNT_CIRCLE, 25, Constantes.COLOR_BLANCO));
        lblNotificacionIcon.setIcon(IconFontSwing.buildIcon(GoogleMaterialDesignIcons.NOTIFICATIONS, 25, Constantes.COLOR_BLANCO));
        lblCorazonIcon.setIcon(IconFontSwing.buildIcon(GoogleMaterialDesignIcons.FAVORITE, 25, Constantes.COLOR_BLANCO));
        
        lblIconSalir.setIcon(IconFontSwing.buildIcon(GoogleMaterialDesignIcons.CLOSE, 30, Constantes.COLOR_BLANCO));
        lblIconMinMax.setIcon(IconFontSwing.buildIcon(GoogleMaterialDesignIcons.REMOVE, 30, Constantes.COLOR_BLANCO));
        //Menu items
        //jLabel2.setIcon(IconFontSwing.buildIcon(GoogleMaterialDesignIcons.ASSIGNMENT_IND, 30, Constantes.COLOR_PRIMARIO));
        //jLabel3.setIcon(IconFontSwing.buildIcon(GoogleMaterialDesignIcons.EQUALIZER, 30, Constantes.COLOR_PRIMARIO));
    }
    
    /*Ajustes a la ventana principal*/
    private void configVentana() {
        //Ajustar al 90% de la pantalla
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().getWidth());
        int ySize = ((int) tk.getScreenSize().getHeight());
        int gameHeight = (int) (Math.round(ySize * 0.90));
        int gameWidth = (int) (Math.round(xSize * 0.90));
        setPreferredSize(new Dimension(gameWidth, gameHeight));

        getContentPane().setBackground(new Color(230, 230, 230));
        setResizable(true);
        setUndecorated(true);

        //Redondear bordes
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 40, 40));
            }
        });
    }
    
    
    /*GETTER y SETTERS para el ControladorMenuCliente*/
    public JPanel getPanelCuerpo() {
        return panelCuerpo;
    }

    public JPanel getPanelMenuContenedor() {
        return panelMenuContenedor;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelToolBar = new JPanelArrastrable();
        lblIconSalir = new javax.swing.JLabel();
        lblSistemaNombre = new javax.swing.JLabel();
        lblSistemaIco = new javax.swing.JLabel();
        lblCorazonIcon = new javax.swing.JLabel();
        lblUsuarioIcon = new javax.swing.JLabel();
        lblNotificacionIcon = new javax.swing.JLabel();
        lblIconMinMax = new javax.swing.JLabel();
        panelMenuContenedor = new javax.swing.JPanel();
        panelCuerpo = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelToolBar.setBackground(Constantes.COLOR_PRIMARIO);
        panelToolBar.setPreferredSize(new java.awt.Dimension(900, 50));

        lblIconSalir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconSalir.setAlignmentX(0.5F);
        lblIconSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblIconSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblIconSalirMouseClicked(evt);
            }
        });

        lblSistemaNombre.setText(Constantes.EMPRESA + " - Cliente");
        lblSistemaNombre.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblSistemaNombre.setForeground(Constantes.COLOR_BLANCO       );

        lblIconMinMax.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconMinMax.setAlignmentX(0.5F);
        lblIconMinMax.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblIconMinMax.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblIconMinMaxMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelToolBarLayout = new javax.swing.GroupLayout(panelToolBar);
        panelToolBar.setLayout(panelToolBarLayout);
        panelToolBarLayout.setHorizontalGroup(
            panelToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelToolBarLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lblSistemaIco, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSistemaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 316, Short.MAX_VALUE)
                .addComponent(lblCorazonIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblNotificacionIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(lblUsuarioIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(lblIconMinMax, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblIconSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelToolBarLayout.setVerticalGroup(
            panelToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelToolBarLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(panelToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblIconSalir, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(lblSistemaNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSistemaIco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCorazonIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblUsuarioIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNotificacionIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblIconMinMax, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(panelToolBar, java.awt.BorderLayout.PAGE_START);

        panelMenuContenedor.setBackground(Constantes.COLOR_PRIMARIO);
        panelMenuContenedor.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelMenuContenedor.setName(""); // NOI18N
        panelMenuContenedor.setPreferredSize(new java.awt.Dimension(250, 450));
        panelMenuContenedor.setLayout(new javax.swing.BoxLayout(panelMenuContenedor, javax.swing.BoxLayout.Y_AXIS));
        getContentPane().add(panelMenuContenedor, java.awt.BorderLayout.LINE_START);

        panelCuerpo.setBackground(Constantes.COLOR_LIGERO);
        panelCuerpo.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelCuerpo.setLayout(new java.awt.CardLayout());
        getContentPane().add(panelCuerpo, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblIconSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIconSalirMouseClicked
        if(ClienteSocket.socket != null)
            ClienteSocket.desconectar();
        System.exit(0);
    }//GEN-LAST:event_lblIconSalirMouseClicked
    
    boolean minmax = true;
    private void lblIconMinMaxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIconMinMaxMouseClicked
        if(minmax){
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }else{
            this.setExtendedState(JFrame.NORMAL);
        }
        minmax = !minmax;
    }//GEN-LAST:event_lblIconMinMaxMouseClicked
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPrincipalCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormPrincipalCliente vistaPrincipal = new FormPrincipalCliente();
                vistaPrincipal.setLocationRelativeTo(null);
                vistaPrincipal.setVisible(true);
                
                ControladorMenuCliente ctrlMenu = new ControladorMenuCliente(vistaPrincipal);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblCorazonIcon;
    private javax.swing.JLabel lblIconMinMax;
    private javax.swing.JLabel lblIconSalir;
    private javax.swing.JLabel lblNotificacionIcon;
    private javax.swing.JLabel lblSistemaIco;
    private javax.swing.JLabel lblSistemaNombre;
    private javax.swing.JLabel lblUsuarioIcon;
    private javax.swing.JPanel panelCuerpo;
    private javax.swing.JPanel panelMenuContenedor;
    private javax.swing.JPanel panelToolBar;
    // End of variables declaration//GEN-END:variables
}