package Bambu_soft;

import java.awt.Color;
import java.text.DecimalFormat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Elias-ZZZ
 */
public class Venta extends javax.swing.JFrame {

    /**
     * Creates new form Venta
     */
    public Venta() {
        initComponents();
        setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    public Venta(double total,double pago) {
        initComponents();
        setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);
        calcular(total,pago);
        setVisible(true);
        btnAceptar.requestFocus();
    }
    
    private void calcular(double total,double pago){
        DecimalFormat f=new DecimalFormat("#0.00");
        labelTotal.setText(f.format(total));
        labelPago.setText(f.format(pago));
        double cambio=pago-total;
        labelCambio.setText(f.format(cambio));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelCambio = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labelTotal = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        labelPago = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Venta realizada");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(530, 320));
        setPreferredSize(new java.awt.Dimension(530, 320));
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);
        getContentPane().setLayout(null);

        labelCambio.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        labelCambio.setForeground(new java.awt.Color(0, 0, 0));
        labelCambio.setText("0.00");
        getContentPane().add(labelCambio);
        labelCambio.setBounds(210, 130, 170, 50);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Cambio: $");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 130, 290, 50);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Total: $");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 10, 140, 50);

        labelTotal.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        labelTotal.setForeground(new java.awt.Color(0, 0, 0));
        labelTotal.setText("0.00");
        getContentPane().add(labelTotal);
        labelTotal.setBounds(160, 10, 190, 50);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Pago recibido: $");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 70, 290, 50);

        labelPago.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        labelPago.setForeground(new java.awt.Color(0, 0, 0));
        labelPago.setText("0.00");
        getContentPane().add(labelPago);
        labelPago.setBounds(310, 70, 210, 50);

        btnAceptar.setBackground(new java.awt.Color(255, 255, 255));
        btnAceptar.setForeground(new java.awt.Color(0, 0, 0));
        btnAceptar.setText("Aceptar");
        btnAceptar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 61, 168)));
        btnAceptar.setBorderPainted(false);
        btnAceptar.setFocusPainted(false);
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAceptarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAceptarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAceptarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnAceptarMouseReleased(evt);
            }
        });
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAceptar);
        btnAceptar.setBounds(200, 240, 130, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseEntered
        btnAceptar.setBorderPainted(true);
    }//GEN-LAST:event_btnAceptarMouseEntered

    private void btnAceptarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseExited
        btnAceptar.setBorderPainted(false);
    }//GEN-LAST:event_btnAceptarMouseExited

    private void btnAceptarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMousePressed
        btnAceptar.setForeground(Color.BLACK);
        btnAceptar.setFont(new java.awt.Font("Dialog", 1, 11));
        btnAceptar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 61, 168),2));
    }//GEN-LAST:event_btnAceptarMousePressed

    private void btnAceptarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseReleased
        btnAceptar.setForeground(Color.BLACK);
        btnAceptar.setFont(new java.awt.Font("Dialog", 1, 12));
        btnAceptar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 61, 168),1));
    }//GEN-LAST:event_btnAceptarMouseReleased

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Venta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel labelCambio;
    private javax.swing.JLabel labelPago;
    private javax.swing.JLabel labelTotal;
    // End of variables declaration//GEN-END:variables
}
