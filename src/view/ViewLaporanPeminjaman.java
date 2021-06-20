/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.toedter.calendar.JDateChooser;
import db.KoneksiDatabase;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DIKI HENDRIYANTO
 */
public class ViewLaporanPeminjaman extends javax.swing.JInternalFrame {
    public DefaultTableModel tbmodel;
    private Date tglAwal;
    private Date tglAkhir;
    
    /**
     * Creates new form ViewLaporanPeminjaman
     */
    public ViewLaporanPeminjaman() {
        initComponents();
        
        tbmodel = new DefaultTableModel();
        TBDataPeminjaman.setModel(tbmodel);
        tbmodel.addColumn("ID Peminjaman");
        tbmodel.addColumn("Nama Pelanggan");
        tbmodel.addColumn("No Polisi");
        tbmodel.addColumn("Tgl Transaksi");
        tbmodel.addColumn("Tgl Pinjam");
        tbmodel.addColumn("Tgl Kembali");
        tbmodel.addColumn("Total Harga");
        tbmodel.addColumn("Uang Bayar");
        tbmodel.addColumn("Status");
        
        tampilDataPeminjaman();
    }

    public Date getTglAwal() {
        return tglAwal;
    }

    public Date getTglAkhir() {
        return tglAkhir;
    }
    
    public void setTglAwal(Date tglAwal) {
        this.tglAwal = tglAwal;
    }

    public void setTglAkhir(Date tglAkhir) {
        this.tglAkhir = tglAkhir;
    }
    
    public void setDCTanggalAkhir(JDateChooser DCTanggalAkhir) {
        this.DCTanggalAkhir = DCTanggalAkhir;
    }

    public void setDCTanggalAwal(JDateChooser DCTanggalAwal) {
        this.DCTanggalAwal = DCTanggalAwal;
    }
    
    public JDateChooser getDCTanggalAkhir() {
        return DCTanggalAkhir;
    }

    public JDateChooser getDCTanggalAwal() {
        return DCTanggalAwal;
    }
    
    public void tampilDataPeminjaman(){
        
        tbmodel.getDataVector().removeAllElements();
        tbmodel.fireTableDataChanged();
        
        String sql = "SELECT pelanggan.nama_pelanggan, mobil.no_polisi, peminjaman.* "
                + " FROM pelanggan, mobil, peminjaman"
                + " WHERE pelanggan.id_pelanggan=peminjaman.id_pelanggan AND mobil.id_mobil=peminjaman.id_mobil";
        
        try {
            Statement stat = (Statement) KoneksiDatabase.getKoneksi().createStatement();
            ResultSet res = stat.executeQuery(sql);
            
            while(res.next()){
                Object[] hasil;
                hasil = new Object[9]; 
                hasil[0] = res.getString("id_pinjam");
                hasil[1] = res.getString("nama_pelanggan");
                hasil[2] = res.getString("no_polisi");
                hasil[3] = res.getString("tgl_transaksi");
                hasil[4] = res.getString("tgl_pinjam");
                hasil[5] = res.getString("tgl_kembali");
                hasil[6] = res.getString("total_harga");
                hasil[7] = res.getString("uang_bayar");
                hasil[8] = res.getString("status");
                
                tbmodel.addRow(hasil);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ViewPelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void tampilDataPeminjamanPerTanggal(){
        
        tbmodel.getDataVector().removeAllElements();
        tbmodel.fireTableDataChanged();
        
        //Query untuk mengambil data tanggal awal dan akhir
        Date a = getDCTanggalAwal().getCalendar().getTime();
                 java.sql.Date tglawal = new java.sql.Date(a.getTime());
                 setTglAwal(tglawal);
        Date b = getDCTanggalAkhir().getCalendar().getTime();
                 java.sql.Date tglakhir = new java.sql.Date(b.getTime());
                 setTglAkhir(tglakhir);
        
        //Query untuk menampilkan data berdasarkan tanggal yang telah dimasukkan
        String sql = "SELECT pelanggan.nama_pelanggan, mobil.no_polisi, peminjaman.* "
                + " FROM pelanggan, mobil, peminjaman"
                + " WHERE pelanggan.id_pelanggan=peminjaman.id_pelanggan AND mobil.id_mobil=peminjaman.id_mobil "
                + " AND tgl_transaksi BETWEEN '"+getTglAwal()+"' and '"+getTglAkhir()+"'";
        
        try {
            Statement stat = (Statement) KoneksiDatabase.getKoneksi().createStatement();
            ResultSet res = stat.executeQuery(sql);
            
            while(res.next()){
                Object[] hasil;
                hasil = new Object[9]; 
                hasil[0] = res.getString("id_pinjam");
                hasil[1] = res.getString("nama_pelanggan");
                hasil[2] = res.getString("no_polisi");
                hasil[3] = res.getString("tgl_transaksi");
                hasil[4] = res.getString("tgl_pinjam");
                hasil[5] = res.getString("tgl_kembali");
                hasil[6] = res.getString("total_harga");
                hasil[7] = res.getString("uang_bayar");
                hasil[8] = res.getString("status");
                
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        DCTanggalAwal = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        DCTanggalAkhir = new com.toedter.calendar.JDateChooser();
        BTCari = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBDataPeminjaman = new javax.swing.JTable();
        BTCetak = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setTitle("Modul Laporan Peminjaman");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("LAPORAN PEMINJAMAN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(272, 272, 272)
                .addComponent(jLabel1)
                .addContainerGap(282, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Tanggal");

        DCTanggalAwal.setDateFormatString("dd/MM/yyyy");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("s/d");

        DCTanggalAkhir.setDateFormatString("dd/MM/yyyy");

        BTCari.setBackground(new java.awt.Color(204, 204, 204));
        BTCari.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BTCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/IconSearch.png"))); // NOI18N
        BTCari.setText("Cari");
        BTCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTCariActionPerformed(evt);
            }
        });

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
        jScrollPane1.setViewportView(TBDataPeminjaman);

        BTCetak.setBackground(new java.awt.Color(204, 204, 204));
        BTCetak.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BTCetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/IconPrint.png"))); // NOI18N
        BTCetak.setText("Cetak Laporan");
        BTCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTCetakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BTCari)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(DCTanggalAwal, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(DCTanggalAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BTCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DCTanggalAwal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(DCTanggalAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTCari)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BTCetak, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
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

    private void BTCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTCariActionPerformed
        // TODO add your handling code here:
        tampilDataPeminjamanPerTanggal();
    }//GEN-LAST:event_BTCariActionPerformed

    private void BTCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTCetakActionPerformed
        // TODO add your handling code here:
        try{
            TBDataPeminjaman.print(JTable.PrintMode.FIT_WIDTH, new MessageFormat("Laporan Peminjaman GC Rent"), null);
        } catch (PrinterException ex){
            Logger.getLogger(ViewLaporanPeminjaman.class.getName()).log(Level.SEVERE,null,ex);
        }
    }//GEN-LAST:event_BTCetakActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTCari;
    private javax.swing.JButton BTCetak;
    private com.toedter.calendar.JDateChooser DCTanggalAkhir;
    private com.toedter.calendar.JDateChooser DCTanggalAwal;
    private javax.swing.JTable TBDataPeminjaman;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
