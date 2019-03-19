
import java.awt.Color;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalButtonUI;
import javax.swing.plaf.metal.MetalToggleButtonUI;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Elias-ZZZ
 */
public class Bambu_Soft extends javax.swing.JFrame {

    
    public Bambu_Soft() {
        UIManager.put("ToggleButton.select", Color.WHITE);
        initComponents();
        setVisible(true);
        setExtendedState(MAXIMIZED_BOTH);
        btnInicio.setSelected(true);
        btnInicio.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnVentas = new javax.swing.JToggleButton();
        btnStats = new javax.swing.JToggleButton();
        btnInventario = new javax.swing.JToggleButton();
        btnEmpleados = new javax.swing.JToggleButton();
        btnAbout = new javax.swing.JToggleButton();
        btnInicio = new javax.swing.JToggleButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(3);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(128, 16, 148));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnVentas.setBackground(new java.awt.Color(0, 0, 0));
        btnVentas.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnVentas.setForeground(new java.awt.Color(255, 255, 255));
        btnVentas.setText("Ventas");
        btnVentas.setHorizontalAlignment(SwingConstants.LEFT);
        btnVentas.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new java.awt.Color(255,255,255), 1),
            BorderFactory.createEmptyBorder(15,15,15,15)));
    btnVentas.setBorderPainted(false);
    btnVentas.setFocusPainted(false);
    btnVentas.setFocusable(false);
    btnVentas.setOpaque(false);
    btnVentas.setRequestFocusEnabled(false);
    btnVentas.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            btnVentasMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            btnVentasMouseExited(evt);
        }
    });
    btnVentas.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnVentasActionPerformed(evt);
        }
    });
    jPanel2.add(btnVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 190, 90));

    btnStats.setBackground(new java.awt.Color(0, 0, 0));
    btnStats.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
    btnStats.setForeground(new java.awt.Color(255, 255, 255));
    btnStats.setText("Estadisticas");
    btnStats.setHorizontalAlignment(SwingConstants.LEFT);
    btnStats.setActionCommand("");
    btnStats.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(new java.awt.Color(255,255,255), 1),
        BorderFactory.createEmptyBorder(15,15,15,15)));
btnStats.setBorderPainted(false);
btnStats.setFocusPainted(false);
btnStats.setFocusable(false);
btnStats.setOpaque(false);
btnStats.setRequestFocusEnabled(false);
btnStats.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        btnStatsMouseEntered(evt);
    }
    public void mouseExited(java.awt.event.MouseEvent evt) {
        btnStatsMouseExited(evt);
    }
    });
    btnStats.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnStatsActionPerformed(evt);
        }
    });
    jPanel2.add(btnStats, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 190, 90));

    btnInventario.setBackground(new java.awt.Color(0, 0, 0));
    btnInventario.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
    btnInventario.setForeground(new java.awt.Color(255, 255, 255));
    btnInventario.setText("Inventario");
    btnInventario.setHorizontalAlignment(SwingConstants.LEFT);
    btnInventario.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(new java.awt.Color(255,255,255), 1),
        BorderFactory.createEmptyBorder(15,15,15,15)));
btnInventario.setBorderPainted(false);
btnInventario.setFocusPainted(false);
btnInventario.setFocusable(false);
btnInventario.setOpaque(false);
btnInventario.setRequestFocusEnabled(false);
btnInventario.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        btnInventarioMouseEntered(evt);
    }
    public void mouseExited(java.awt.event.MouseEvent evt) {
        btnInventarioMouseExited(evt);
    }
    });
    btnInventario.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnInventarioActionPerformed(evt);
        }
    });
    jPanel2.add(btnInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 190, 90));

    btnEmpleados.setBackground(new java.awt.Color(0, 0, 0));
    btnEmpleados.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
    btnEmpleados.setForeground(new java.awt.Color(255, 255, 255));
    btnEmpleados.setText("Empleados");
    btnEmpleados.setHorizontalAlignment(SwingConstants.LEFT);
    btnEmpleados.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(new java.awt.Color(255,255,255), 1),
        BorderFactory.createEmptyBorder(15,15,15,15)));
btnEmpleados.setBorderPainted(false);
btnEmpleados.setFocusPainted(false);
btnEmpleados.setFocusable(false);
btnEmpleados.setOpaque(false);
btnEmpleados.setRequestFocusEnabled(false);
btnEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        btnEmpleadosMouseEntered(evt);
    }
    public void mouseExited(java.awt.event.MouseEvent evt) {
        btnEmpleadosMouseExited(evt);
    }
    });
    btnEmpleados.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnEmpleadosActionPerformed(evt);
        }
    });
    jPanel2.add(btnEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 190, 90));

    btnAbout.setBackground(new java.awt.Color(0, 0, 0));
    btnAbout.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
    btnAbout.setForeground(new java.awt.Color(255, 255, 255));
    btnAbout.setText("Acerca de");
    btnAbout.setHorizontalAlignment(SwingConstants.LEFT);
    btnAbout.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(new java.awt.Color(255,255,255), 1),
        BorderFactory.createEmptyBorder(15,15,15,15)));
btnAbout.setBorderPainted(false);
btnAbout.setFocusPainted(false);
btnAbout.setFocusable(false);
btnAbout.setOpaque(false);
btnAbout.setRequestFocusEnabled(false);
btnAbout.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        btnAboutMouseEntered(evt);
    }
    public void mouseExited(java.awt.event.MouseEvent evt) {
        btnAboutMouseExited(evt);
    }
    });
    btnAbout.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnAboutActionPerformed(evt);
        }
    });
    jPanel2.add(btnAbout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 190, 90));

    btnInicio.setBackground(new java.awt.Color(0, 0, 0));
    btnInicio.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
    btnInicio.setForeground(new java.awt.Color(255, 255, 255));
    btnInicio.setText("Inicio");
    btnInicio.setHorizontalAlignment(SwingConstants.LEFT);
    btnInicio.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(new java.awt.Color(255,255,255), 1),
        BorderFactory.createEmptyBorder(15,15,15,15)));
btnInicio.setBorderPainted(false);
btnInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
btnInicio.setFocusPainted(false);
btnInicio.setFocusable(false);
btnInicio.setOpaque(false);
btnInicio.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        btnInicioMouseClicked(evt);
    }
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        btnInicioMouseEntered(evt);
    }
    public void mouseExited(java.awt.event.MouseEvent evt) {
        btnInicioMouseExited(evt);
    }
    });
    btnInicio.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnInicioActionPerformed(evt);
        }
    });
    jPanel2.add(btnInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 90));

    getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 190, 660));

    jPanel3.setBackground(new java.awt.Color(255, 255, 255));
    jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
    getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 1180, 750));

    jPanel1.setBackground(new java.awt.Color(102, 0, 102));
    jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jLabel1.setText("LOGO");
    jLabel1.setOpaque(true);
    jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1420, 0, 140, 60));

    jLabel2.setForeground(new java.awt.Color(255, 255, 255));
    jLabel2.setText("Usuario");
    jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 10, -1, -1));

    btnLogout.setBackground(new java.awt.Color(102, 0, 102));
    btnLogout.setForeground(new java.awt.Color(255, 255, 255));
    btnLogout.setText("Cerrar sesión");
    btnLogout.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
    btnLogout.setBorderPainted(false);
    btnLogout.setFocusPainted(false);
    btnLogout.setOpaque(false);
    btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            btnLogoutMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            btnLogoutMouseExited(evt);
        }
    });
    btnLogout.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnLogoutActionPerformed(evt);
        }
    });
    jPanel1.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 30, 100, 30));

    jLabel3.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
    jLabel3.setForeground(new java.awt.Color(255, 255, 255));
    jLabel3.setText("Inicio");
    jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, -1, -1));

    getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-190, 0, 1560, 60));

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpleadosActionPerformed
        changeButtons("Empleados");
    }//GEN-LAST:event_btnEmpleadosActionPerformed

    private void btnEmpleadosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmpleadosMouseEntered
        btnEmpleados.setBorderPainted(true);
        repaint();
    }//GEN-LAST:event_btnEmpleadosMouseEntered

    private void btnEmpleadosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmpleadosMouseExited
        btnEmpleados.setBorderPainted(false);
        repaint();
    }//GEN-LAST:event_btnEmpleadosMouseExited

    private void btnInicioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInicioMouseEntered
        btnInicio.setBorderPainted(true);
        repaint();
    }//GEN-LAST:event_btnInicioMouseEntered

    private void btnInicioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInicioMouseExited
        btnInicio.setBorderPainted(false);
        repaint();
    }//GEN-LAST:event_btnInicioMouseExited

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        changeButtons("Inicio");
    }//GEN-LAST:event_btnInicioActionPerformed

    private void btnInventarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInventarioMouseEntered
        btnInventario.setBorderPainted(true);
        repaint();
    }//GEN-LAST:event_btnInventarioMouseEntered

    private void btnInventarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInventarioMouseExited
        btnInventario.setBorderPainted(false);
        repaint();
    }//GEN-LAST:event_btnInventarioMouseExited

    private void btnInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventarioActionPerformed
        changeButtons("Inventario");
    }//GEN-LAST:event_btnInventarioActionPerformed

    private void btnVentasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVentasMouseEntered
        btnVentas.setBorderPainted(true);
        repaint();
    }//GEN-LAST:event_btnVentasMouseEntered

    private void btnVentasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVentasMouseExited
        btnVentas.setBorderPainted(false);
        repaint();
    }//GEN-LAST:event_btnVentasMouseExited

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed
        changeButtons("Ventas");
    }//GEN-LAST:event_btnVentasActionPerformed

    private void btnStatsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStatsMouseEntered
        btnStats.setBorderPainted(true);
        repaint();
    }//GEN-LAST:event_btnStatsMouseEntered

    private void btnStatsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStatsMouseExited
        btnStats.setBorderPainted(false);
        repaint();
    }//GEN-LAST:event_btnStatsMouseExited

    private void btnStatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatsActionPerformed
        changeButtons("Stats");
    }//GEN-LAST:event_btnStatsActionPerformed

    private void btnAboutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAboutMouseEntered
        btnAbout.setBorderPainted(true);
        repaint();
    }//GEN-LAST:event_btnAboutMouseEntered

    private void btnAboutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAboutMouseExited
        btnAbout.setBorderPainted(false);
        repaint();
    }//GEN-LAST:event_btnAboutMouseExited

    private void btnAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAboutActionPerformed
        changeButtons("About");
    }//GEN-LAST:event_btnAboutActionPerformed

    private void btnInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInicioMouseClicked
        
        
    }//GEN-LAST:event_btnInicioMouseClicked

    private void btnLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseEntered
        btnLogout.setBorderPainted(true);
        repaint();
    }//GEN-LAST:event_btnLogoutMouseEntered

    private void btnLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseExited
        btnLogout.setBorderPainted(false);
        repaint();
    }//GEN-LAST:event_btnLogoutMouseExited

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        
    }//GEN-LAST:event_btnLogoutActionPerformed
    private void changeButtons(String s){
        setButtonsNormal();
        switch(s){
            case "Inicio":
                btnInicio.setEnabled(false);
                //btnInicio.setDisabledTextColor(new java.awt.Color(0,0,0));
                btnInicio.setSelected(true);
                break;
            case "Empleados":
                btnEmpleados.setForeground(new java.awt.Color(0,0,0));
                btnEmpleados.setEnabled(false);
                btnEmpleados.setSelected(true);
                break;
            case "About":
                btnAbout.setEnabled(false);
                btnAbout.setForeground(new java.awt.Color(0,0,0));
                btnAbout.setSelected(true);
                break;
            case "Inventario":
                btnInventario.setEnabled(false);
                btnInventario.setForeground(new java.awt.Color(0,0,0));
                btnInventario.setSelected(true);
                break;
            case "Stats":
                btnStats.setEnabled(false);
                btnStats.setForeground(new java.awt.Color(0,0,0));
                btnStats.setSelected(true);
                break;
            case "Ventas":
                btnVentas.setEnabled(false);
                btnVentas.setForeground(new java.awt.Color(0,0,0));
                btnVentas.setSelected(true);
                break;
        }
        repaint();
    }
    private void setButtonsNormal(){
        btnEmpleados.setForeground(new java.awt.Color(255,255,255));
        btnEmpleados.setEnabled(true);
        btnEmpleados.setSelected(false);
        btnInicio.setEnabled(true);
        btnInicio.setForeground(new java.awt.Color(255,255,255));
        btnInicio.setSelected(false);
        btnAbout.setEnabled(true);
        btnAbout.setForeground(new java.awt.Color(255,255,255));
        btnAbout.setSelected(false);
        btnInventario.setEnabled(true);
        btnInventario.setForeground(new java.awt.Color(255,255,255));
        btnInventario.setSelected(false);
        btnStats.setEnabled(true);
        btnStats.setForeground(new java.awt.Color(255,255,255));
        btnStats.setSelected(false);
        btnVentas.setEnabled(true);
        btnVentas.setForeground(new java.awt.Color(255,255,255));
        btnVentas.setSelected(false);
        repaint();
    }
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
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Bambu_Soft.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bambu_Soft.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bambu_Soft.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bambu_Soft.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bambu_Soft().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnAbout;
    private javax.swing.JToggleButton btnEmpleados;
    private javax.swing.JToggleButton btnInicio;
    private javax.swing.JToggleButton btnInventario;
    private javax.swing.JButton btnLogout;
    private javax.swing.JToggleButton btnStats;
    private javax.swing.JToggleButton btnVentas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
