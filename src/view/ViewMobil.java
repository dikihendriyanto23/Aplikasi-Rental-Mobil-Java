/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.placeholder.PlaceHolder;
import controller.ControllerMobil;
import db.KoneksiDatabase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DIKI HENDRIYANTO
 */
public class ViewMobil extends javax.swing.JInternalFrame {
    private ControllerMobil CM;
    private DefaultTableModel tbmodel;
    
    /**
     * Creates new form ViewMobil
     */
    public ViewMobil() {
        initComponents();
        
        CM = new ControllerMobil(this);
        PlaceHolder holder = new PlaceHolder(TFIdMobil, " *ID Terisi Otomatis");
        tbmodel = new DefaultTableModel();
        TBMobil.setModel(tbmodel);
        tbmodel.addColumn("ID Mobil");
        tbmodel.addColumn("Merek");
        tbmodel.addColumn("Tipe");
        tbmodel.addColumn("Tahun");
        tbmodel.addColumn("No Polisi");
        tbmodel.addColumn("Harga");
        
        tampilDataMobil();
        CM.kontrolButton1();
    }

    public JButton getBTBatal() {
        return BTBatal;
    }

    public JButton getBTHapus() {
        return BTHapus;
    }

    public JButton getBTSimpan() {
        return BTSimpan;
    }

    public JButton getBTUbah() {
        return BTUbah;
    }

    public JTable getTBMobil() {
        return TBMobil;
    }

    public JTextField getTFIdMobil() {
        return TFIdMobil;
    }

    public JTextField getTFMerek() {
        return TFMerek;
    }

    public JTextField getTFNoPolisi() {
        return TFNoPolisi;
    }

    public JTextField getTFTahun() {
        return TFTahun;
    }

    public JTextField getTFTipe() {
        return TFTipe;
    }

    public JTextField getTFHarga() {
        return TFHarga;
    }
    
    public void tampilDataMobil(){
        
        tbmodel.getDataVector().removeAllElements();
        tbmodel.fireTableDataChanged();
        
        String sql = "SELECT * FROM mobil";
        
        try {
            Statement stat = (Statement) KoneksiDatabase.getKoneksi().createStatement();
            ResultSet res = stat.executeQuery(sql);
            
            while(res.next()){
                Object[] hasil;
                hasil = new Object[6]; 
                hasil[0] = res.getString("id_mobil");
                hasil[1] = res.getString("merek");
                hasil[2] = res.getString("tipe");
                hasil[3] = res.getString("tahun");
                hasil[4] = res.getString("no_polisi");
                hasil[5] = res.getString("harga");
                
                tbmodel.addRow(hasil);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ViewPelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void ambilDataTabel(){ 
        int index = TBMobil.getSelectedRow();
        
        String id = String.valueOf(TBMobil.getValueAt(index, 0));
        String mrk = String.valueOf(TBMobil.getValueAt(index, 1));
        String tip = String.valueOf(TBMobil.getValueAt(index, 2));
        String th = String.valueOf(TBMobil.getValueAt(index, 3));
        String nopol = String.valueOf(TBMobil.getValueAt(index, 4));
        String hrg = String.valueOf(TBMobil.getValueAt(index, 5));
        
        TFIdMobil.setText(id);
        TFMerek.setText(mrk);
        TFTipe.setText(tip);
        TFTahun.setText(th);
        TFNoPolisi.setText(nopol);
        TFHarga.setText(hrg);
        
        CM.kontrolButton2();
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TFIdMobil = new javax.swing.JTextField();
        TFTipe = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TFTahun = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        BTSimpan = new javax.swing.JButton();
        BTUbah = new javax.swing.JButton();
        BTHapus = new javax.swing.JButton();
        BTBatal = new javax.swing.JButton();
        TFMerek = new javax.swing.JTextField();
        TFNoPolisi = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        TFHarga = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TBMobil = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setTitle("Modul Mobil");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("TAMBAH MOBIL");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("ID Mobil");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Tipe");

        TFIdMobil.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TFIdMobil.setEnabled(false);

        TFTipe.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Tahun");

        TFTahun.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("No Polisi");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Merek");

        BTSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/IconSave.png"))); // NOI18N
        BTSimpan.setText("SIMPAN");
        BTSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTSimpanActionPerformed(evt);
            }
        });

        BTUbah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/IconUpdate.png"))); // NOI18N
        BTUbah.setText("UBAH");
        BTUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTUbahActionPerformed(evt);
            }
        });

        BTHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/IconDelete.png"))); // NOI18N
        BTHapus.setText("HAPUS");
        BTHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTHapusActionPerformed(evt);
            }
        });

        BTBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/IconCancel.png"))); // NOI18N
        BTBatal.setText("BATAL");
        BTBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTBatalActionPerformed(evt);
            }
        });

        TFMerek.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        TFNoPolisi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Harga");

        TFHarga.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TFMerek, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TFIdMobil, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BTHapus, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(BTBatal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BTSimpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BTUbah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(TFTipe, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TFTahun, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TFNoPolisi)
                    .addComponent(TFHarga)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TFIdMobil, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(10, 10, 10)
                .addComponent(TFMerek, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(6, 6, 6)
                .addComponent(TFTipe, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TFTahun, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TFNoPolisi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TFHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BTSimpan)
                    .addComponent(BTHapus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTBatal)
                    .addComponent(BTUbah))
                .addGap(0, 21, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setText("DAFTAR MOBIL");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(175, 175, 175))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel8)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        TBMobil.setModel(new javax.swing.table.DefaultTableModel(
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
        TBMobil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBMobilMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TBMobil);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTSimpanActionPerformed
        // TODO add your handling code here:
        CM.simpan();
        tampilDataMobil();
        PlaceHolder holder5 = new PlaceHolder(TFIdMobil, " *ID Terisi Otomatis");
    }//GEN-LAST:event_BTSimpanActionPerformed

    private void BTUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTUbahActionPerformed
        // TODO add your handling code here:
        CM.update();
        tampilDataMobil();
        PlaceHolder holder5 = new PlaceHolder(TFIdMobil, " *ID Terisi Otomatis");
    }//GEN-LAST:event_BTUbahActionPerformed

    private void BTHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTHapusActionPerformed
        // TODO add your handling code here:
        CM.delete();
        tampilDataMobil();
        PlaceHolder holder5 = new PlaceHolder(TFIdMobil, " *ID Terisi Otomatis");
    }//GEN-LAST:event_BTHapusActionPerformed

    private void BTBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTBatalActionPerformed
        // TODO add your handling code here:
        CM.kontrolButton1();
        CM.bersihkan();
        PlaceHolder holder5 = new PlaceHolder(TFIdMobil, " *ID Terisi Otomatis");
    }//GEN-LAST:event_BTBatalActionPerformed

    private void TBMobilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBMobilMouseClicked
        // TODO add your handling code here:
        ambilDataTabel();
    }//GEN-LAST:event_TBMobilMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTBatal;
    private javax.swing.JButton BTHapus;
    private javax.swing.JButton BTSimpan;
    private javax.swing.JButton BTUbah;
    private javax.swing.JTable TBMobil;
    private javax.swing.JTextField TFHarga;
    private javax.swing.JTextField TFIdMobil;
    private javax.swing.JTextField TFMerek;
    private javax.swing.JTextField TFNoPolisi;
    private javax.swing.JTextField TFTahun;
    private javax.swing.JTextField TFTipe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
