/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import db.KoneksiDatabase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DIKI HENDRIYANTO
 */
public class ViewListDataPelanggan extends javax.swing.JFrame {
    private ViewPeminjamanMobil VP;
    private DefaultTableModel tbmodel;
    
    /**
     * Creates new form ViewListDataPelanggan
     */
    public ViewListDataPelanggan(ViewPeminjamanMobil VP) {
        initComponents();
        
        this.VP = VP;
        
        tbmodel = new DefaultTableModel();
        TBListDataPelanggan.setModel(tbmodel);
        tbmodel.addColumn("ID Pelanggan");
        tbmodel.addColumn("No KTP");
        tbmodel.addColumn("Nama Pelanggan");
        tbmodel.addColumn("No Handphone");
        tbmodel.addColumn("Jenis Kelamin");
        tbmodel.addColumn("Alamat");
        tampilDataPelanggan();
    }
    
    public void tampilDataPelanggan(){
        
        tbmodel.getDataVector().removeAllElements();
        tbmodel.fireTableDataChanged();
        
        String sql = "SELECT * FROM pelanggan";
        
        try {
            Statement stat = (Statement) KoneksiDatabase.getKoneksi().createStatement();
            ResultSet res = stat.executeQuery(sql);
            
            while(res.next()){
                Object[] hasil;
                hasil = new Object[6]; 
                hasil[0] = res.getString("id_pelanggan");
                hasil[1] = res.getString("no_ktp");
                hasil[2] = res.getString("nama_pelanggan");
                hasil[3] = res.getString("no_hp");
                hasil[4] = res.getString("jk");
                hasil[5] = res.getString("alamat");
                
                tbmodel.addRow(hasil);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ViewPelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBListDataPelanggan = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Data Pelanggan");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("DATA PELANGGAN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(254, 254, 254)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TBListDataPelanggan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TBListDataPelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBListDataPelangganMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TBListDataPelanggan);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(725, 519));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TBListDataPelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBListDataPelangganMouseClicked
        // TODO add your handling code here:
        int listX = TBListDataPelanggan.getSelectedRow();
        VP.getTFIdPelanggan().setText(TBListDataPelanggan.getValueAt(listX,0).toString());
        VP.getTFNamaPelanggan().setText(TBListDataPelanggan.getValueAt(listX,2).toString());
        VP.getTFNoHP().setText(TBListDataPelanggan.getValueAt(listX,3).toString());
        VP.getTAAlamat().setText(TBListDataPelanggan.getValueAt(listX,5).toString());
        
        dispose();
    }//GEN-LAST:event_TBListDataPelangganMouseClicked

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TBListDataPelanggan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}