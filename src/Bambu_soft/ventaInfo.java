/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bambu_soft;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import utilidades.EncabezadoTabla;
import utilidades.SQL;

/**
 *
 * @author Elias-ZZZ
 */
public class ventaInfo extends javax.swing.JFrame {

    /**
     * Creates new form ventaInfo
     */
    public ventaInfo(String id,ArrayList datosVenta) {
        initComponents();
        setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        JTableHeader header=TableProductos.getTableHeader();
        header.setDefaultRenderer(new EncabezadoTabla());
        TableProductos.setTableHeader(header);
        setDatosVenta(datosVenta);
        setTablaDatos(id);
        
    }
    
    private void setDatosVenta(ArrayList datos){
        labelNumero.setText(datos.get(0).toString());
        labelVendedor.setText(datos.get(1).toString());
        labelMonto.setText(datos.get(2).toString());
        labelTipo.setText(datos.get(3).toString());
        labelFecha.setText(datos.get(4).toString());
    }
    
    private void setTablaDatos(String id){
        SQL sql=new SQL();
        try{
            ArrayList datos=sql.getVentaProductos(id);
            DefaultTableModel modelo=(DefaultTableModel)TableProductos.getModel();
            for(int i=0;i<datos.size();i++){
                modelo.addRow((Object[])datos.get(i));
            }
        }
        catch(Exception e){e.printStackTrace();}
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAceptar = new javax.swing.JButton();
        labelVendedor = new javax.swing.JLabel();
        labelNumero = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        labelMonto = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        labelFecha = new javax.swing.JLabel();
        labelTipo = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableProductos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setPreferredSize(new java.awt.Dimension(415, 465));
        getContentPane().setLayout(null);

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
        btnAceptar.setBounds(130, 380, 130, 30);

        labelVendedor.setForeground(new java.awt.Color(0, 0, 0));
        labelVendedor.setText("Vendedor");
        getContentPane().add(labelVendedor);
        labelVendedor.setBounds(20, 100, 100, 16);

        labelNumero.setForeground(new java.awt.Color(0, 0, 0));
        labelNumero.setText("##");
        getContentPane().add(labelNumero);
        labelNumero.setBounds(20, 50, 100, 16);

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Numero de venta:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(20, 30, 100, 16);

        labelMonto.setForeground(new java.awt.Color(0, 0, 0));
        labelMonto.setText("Monto de la venta");
        getContentPane().add(labelMonto);
        labelMonto.setBounds(140, 100, 100, 16);

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Vendedor:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(20, 80, 100, 16);

        labelFecha.setForeground(new java.awt.Color(0, 0, 0));
        labelFecha.setText("Fecha de la venta");
        getContentPane().add(labelFecha);
        labelFecha.setBounds(270, 50, 100, 16);

        labelTipo.setForeground(new java.awt.Color(0, 0, 0));
        labelTipo.setText("Tipo de pago");
        getContentPane().add(labelTipo);
        labelTipo.setBounds(140, 50, 100, 16);

        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Monto de la venta:");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(140, 80, 110, 16);

        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Tipo de pago:");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(140, 30, 100, 16);

        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Fecha de la venta:");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(270, 30, 110, 16);

        TableProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código de barras", "Artículo", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableProductos.setGridColor(new java.awt.Color(140, 61, 168));
        TableProductos.setSelectionBackground(new java.awt.Color(204, 204, 255));
        TableProductos.getTableHeader().setReorderingAllowed(false);
        TableProductos.getTableHeader().setBackground(new java.awt.Color(140,61,168));
        TableProductos.getTableHeader().setBorder(BorderFactory.createLineBorder(new java.awt.Color(255,255,255), 1));
        jScrollPane2.setViewportView(TableProductos);
        if (TableProductos.getColumnModel().getColumnCount() > 0) {
            TableProductos.getColumnModel().getColumn(0).setResizable(false);
            TableProductos.getColumnModel().getColumn(1).setResizable(false);
            TableProductos.getColumnModel().getColumn(2).setResizable(false);
        }

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(20, 130, 360, 230);

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
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableProductos;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelMonto;
    private javax.swing.JLabel labelNumero;
    private javax.swing.JLabel labelTipo;
    private javax.swing.JLabel labelVendedor;
    // End of variables declaration//GEN-END:variables
}