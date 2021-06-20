/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerPengembalian;
import db.KoneksiDatabase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DIKI HENDRIYANTO
 */
public class ViewPengembalianMobil extends javax.swing.JInternalFrame {
    private DefaultTableModel tbmodel;
    private ControllerPengembalian CP;
    private int hasil;
    /**
     * Creates new form ViewPengembalianMobil
     */
    public ViewPengembalianMobil() {
        initComponents();
        
        CP = new ControllerPengembalian(this);
        tbmodel = new DefaultTableModel();
        TBDataPeminjaman.setModel(tbmodel);
        tbmodel.addColumn("ID Peminjaman");
        tbmodel.addColumn("Nama Pelanggan");
        tbmodel.addColumn("No Polisi");
        tbmodel.addColumn("Tanggal Pinjam");
        tbmodel.addColumn("Tanggal Kembali");
        tbmodel.addColumn("Total Bayar");
        
        tampilDataPeminjaman();
        CP.kontrolbutton2();
    }

    public JTextField getTFIdPeminjaman() {
        return TFIdPeminjaman;
    }
    
    public JComboBox<String> getCBStatus() {
        return CBStatus;
    }

    public JButton getBTBatal() {
        return BTBatal;
    }

    public JButton getBTPengembalian() {
        return BTPengembalian;
    }

    public JTextField getTFNamaPelanggan() {
        return TFNamaPelanggan;
    }

    public JTextField getTFNoPolisi() {
        return TFNoPolisi;
    }

    public JTextField getTFTglKembali() {
        return TFTglKembali;
    }

    public JTextField getTFTglPinjam() {
        return TFTglPinjam;
    }

    public JTextField getTFTotalBayar() {
        return TFTotalBayar;
    }

    public JButton getBTHitungDenda() {
        return BTHitungDenda;
    }

    public JTextField getTFDenda() {
        return TFDenda;
    }

    public JTextField getTFTelat() {
        return TFTelat;
    }
    
    public void tampilDataPeminjaman(){
        
        tbmodel.getDataVector().removeAllElements();
        tbmodel.fireTableDataChanged();
        
        String sql = "SELECT pelanggan.nama_pelanggan, mobil.no_polisi, peminjaman.* "
                + " FROM pelanggan, mobil, peminjaman"
                + " WHERE pelanggan.id_pelanggan=peminjaman.id_pelanggan AND mobil.id_mobil=peminjaman.id_mobil "
                + " AND status = '"+"Pinjam"+"' ";
        
        try {
            Statement stat = (Statement) KoneksiDatabase.getKoneksi().createStatement();
            ResultSet res = stat.executeQuery(sql);
            
            while(res.next()){
                Object[] hasil;
                hasil = new Object[6]; 
                hasil[0] = res.getString("id_pinjam");
                hasil[1] = res.getString("nama_pelanggan");
                hasil[2] = res.getString("no_polisi");
                hasil[3] = res.getString("tgl_pinjam");
                hasil[4] = res.getString("tgl_kembali");
                hasil[5] = res.getString("total_harga");
                
                tbmodel.addRow(hasil);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ViewPelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void ambilDataTabel(){ 
        int index = TBDataPeminjaman.getSelectedRow();
        
        String id = String.valueOf(TBDataPeminjaman.getValueAt(index, 0));
        String nm = String.valueOf(TBDataPeminjaman.getValueAt(index, 1));
        String nopol = String.valueOf(TBDataPeminjaman.getValueAt(index, 2));
        String tglp = String.valueOf(TBDataPeminjaman.getValueAt(index, 3));
        String tglk = String.valueOf(TBDataPeminjaman.getValueAt(index, 4));
        String thrg = String.valueOf(TBDataPeminjaman.getValueAt(index, 5));
        
        TFIdPeminjaman.setText(id);
        TFNamaPelanggan.setText(nm);
        TFNoPolisi.setText(nopol);
        TFTglPinjam.setText(tglp);
        TFTglKembali.setText(tglk);
        TFTotalBayar.setText(thrg);
        
        CP.kontrolbutton1();
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
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TFNamaPelanggan = new javax.swing.JTextField();
        TFNoPolisi = new javax.swing.JTextField();
        TFTglPinjam = new javax.swing.JTextField();
        TFTglKembali = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        CBStatus = new javax.swing.JComboBox<>();
        TFTotalBayar = new javax.swing.JTextField();
        BTPengembalian = new javax.swing.JButton();
        BTBatal = new javax.swing.JButton();
        TFIdPeminjaman = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        TFTelat = new javax.swing.JTextField();
        TFDenda = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        BTHitungDenda = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBDataPeminjaman = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();

        setClosable(true);
        setMaximizable(true);
        setTitle("Modul Pengembalian Mobil");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("FORM PENGEMBALIAN MOBIL");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(238, 238, 238)
                .addComponent(jLabel1)
                .addContainerGap(244, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Peminjaman - Pengembalian", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("ID Peminjaman");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("No Polisi");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Tgl Pinjam");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Tgl Kembali");

        TFNamaPelanggan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TFNamaPelanggan.setEnabled(false);

        TFNoPolisi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TFNoPolisi.setEnabled(false);

        TFTglPinjam.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TFTglPinjam.setEnabled(false);

        TFTglKembali.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TFTglKembali.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Total Bayar");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Denda");

        CBStatus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CBStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pinjam ", "Kembali" }));

        TFTotalBayar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TFTotalBayar.setEnabled(false);

        BTPengembalian.setBackground(new java.awt.Color(204, 204, 204));
        BTPengembalian.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BTPengembalian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/IconReturn.png"))); // NOI18N
        BTPengembalian.setText("PENGEMBALIAN");
        BTPengembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTPengembalianActionPerformed(evt);
            }
        });

        BTBatal.setBackground(new java.awt.Color(204, 204, 204));
        BTBatal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BTBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/IconCancel.png"))); // NOI18N
        BTBatal.setText("BATAL");
        BTBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTBatalActionPerformed(evt);
            }
        });

        TFIdPeminjaman.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TFIdPeminjaman.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Nama Pelanggan");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Telat");

        TFTelat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        TFDenda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TFDenda.setText("0");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Status");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Hari");

        BTHitungDenda.setBackground(new java.awt.Color(204, 204, 204));
        BTHitungDenda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BTHitungDenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/IconCalculator.png"))); // NOI18N
        BTHitungDenda.setText("HITUNG DENDA");
        BTHitungDenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTHitungDendaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TFNamaPelanggan, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                            .addComponent(TFNoPolisi)
                            .addComponent(TFTglPinjam)
                            .addComponent(TFTglKembali)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(TFIdPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(59, 59, 59)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TFTotalBayar)
                            .addComponent(CBStatus, 0, 155, Short.MAX_VALUE)
                            .addComponent(TFDenda, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(TFTelat, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(BTHitungDenda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTPengembalian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(TFTotalBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TFIdPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CBStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(TFTelat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TFDenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BTBatal)
                            .addComponent(BTPengembalian)
                            .addComponent(BTHitungDenda)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TFNamaPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(TFNoPolisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(TFTglPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(TFTglKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        TBDataPeminjaman.setModel(new javax.swing.table.DefaultTableModel(
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
        TBDataPeminjaman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBDataPeminjamanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TBDataPeminjaman);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("DATA PEMINJAMAN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(361, 361, 361)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TBDataPeminjamanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBDataPeminjamanMouseClicked
        // TODO add your handling code here:
        ambilDataTabel();
    }//GEN-LAST:event_TBDataPeminjamanMouseClicked

    private void BTBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTBatalActionPerformed
        // TODO add your handling code here:
        CP.kontrolbutton2();
        CP.bersihkan();
    }//GEN-LAST:event_BTBatalActionPerformed

    private void BTPengembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTPengembalianActionPerformed
        // TODO add your handling code here:
        CP.updatePeminjaman();
        CP.simpanPengembalian();
        tampilDataPeminjaman();
    }//GEN-LAST:event_BTPengembalianActionPerformed

    private void BTHitungDendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTHitungDendaActionPerformed
        // TODO add your handling code here:
        hasil = Integer.parseInt(TFTelat.getText()) * 50000;
        TFDenda.setText(String.valueOf(hasil));
    }//GEN-LAST:event_BTHitungDendaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTBatal;
    private javax.swing.JButton BTHitungDenda;
    private javax.swing.JButton BTPengembalian;
    private javax.swing.JComboBox<String> CBStatus;
    private javax.swing.JTable TBDataPeminjaman;
    private javax.swing.JTextField TFDenda;
    private javax.swing.JTextField TFIdPeminjaman;
    private javax.swing.JTextField TFNamaPelanggan;
    private javax.swing.JTextField TFNoPolisi;
    private javax.swing.JTextField TFTelat;
    private javax.swing.JTextField TFTglKembali;
    private javax.swing.JTextField TFTglPinjam;
    private javax.swing.JTextField TFTotalBayar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}