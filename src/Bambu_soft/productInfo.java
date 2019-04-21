package Bambu_soft;


import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import utilidades.SQL;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Elias-ZZZ
 */
public class productInfo extends javax.swing.JFrame {

    /**
     * Creates new form productInfo
     */
    public productInfo(){
        setResizable(false);
        initComponents();
        
    }
    String id;
    public productInfo(String id) {
        this.id=id;
        setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
        try{Thread.sleep(100);}catch(Exception e){e.printStackTrace();}
        initComponents();
        revalidate();
        repaint();
        setDatos();
        setLocationRelativeTo(null);
        
        setVisible(true);
    }
    private void setDatos(){
        SQL sql=new SQL();
        ArrayList producto=new ArrayList();
        try{producto=sql.getProductoById(id);}catch(Exception e){e.printStackTrace();}
        try{
            String rec=producto.get(0).toString();
            Image p=new ImageIcon(getClass().getResource(rec)).getImage();
            p=p.getScaledInstance(110,120,java.awt.Image.SCALE_SMOOTH);
            ImageIcon p2=new ImageIcon(p);
            labelImagen.setIcon(p2);
        }catch(NullPointerException e){
            String rec="/img/productos/default.png";
            Image p=new ImageIcon(getClass().getResource(rec)).getImage();
            p=p.getScaledInstance(110,120,java.awt.Image.SCALE_SMOOTH);
            ImageIcon p2=new ImageIcon(p);
            labelImagen.setIcon(p2);
        }
        
        labelArticulo.setText(producto.get(1).toString());
        labelBarCode.setText(producto.get(2).toString());
        labelPrecio.setText(producto.get(3).toString());
        labelCantidad.setText(producto.get(4).toString());
        labelVentas.setText(producto.get(5).toString());
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
        labelBarCode = new javax.swing.JLabel();
        labelPrecio = new javax.swing.JLabel();
        labelCantidad = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        labelArticulo = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        labelVentas = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        labelImagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Articulo");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 210, 460));
        setSize(new java.awt.Dimension(210, 460));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelBarCode.setForeground(new java.awt.Color(0, 0, 0));
        labelBarCode.setText("Codigo de barras");
        jPanel1.add(labelBarCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 140, -1));

        labelPrecio.setForeground(new java.awt.Color(0, 0, 0));
        labelPrecio.setText("Precio");
        jPanel1.add(labelPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 140, -1));

        labelCantidad.setForeground(new java.awt.Color(0, 0, 0));
        labelCantidad.setText("Cantidad");
        jPanel1.add(labelCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Articulo:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Codigo de barras:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        labelArticulo.setForeground(new java.awt.Color(0, 0, 0));
        labelArticulo.setText("Articulo");
        jPanel1.add(labelArticulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 140, -1));

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Precio:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        labelVentas.setForeground(new java.awt.Color(0, 0, 0));
        labelVentas.setText("ventas");
        jPanel1.add(labelVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Cantidad en existencia:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Numero de ventas:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

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
        jPanel1.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 110, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 210, 320));

        labelImagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 61, 168)));
        getContentPane().add(labelImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 110, 120));

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
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(productInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(productInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(productInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(productInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new productInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelArticulo;
    private javax.swing.JLabel labelBarCode;
    private javax.swing.JLabel labelCantidad;
    private javax.swing.JLabel labelImagen;
    private javax.swing.JLabel labelPrecio;
    private javax.swing.JLabel labelVentas;
    // End of variables declaration//GEN-END:variables
}