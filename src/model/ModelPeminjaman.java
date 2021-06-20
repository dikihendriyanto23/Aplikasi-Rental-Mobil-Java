/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import db.KoneksiDatabase;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author DIKI HENDRIYANTO
 */
public class ModelPeminjaman {
    private String idPeminjaman;
    private String idPelanggan;
    private String idMobil;
    private Date tglPinjam;
    private Date tglKembali;
    private String totalHarga;
    private String uangBayar;

    KoneksiDatabase koneksi = new KoneksiDatabase();
    
    public String getIdPeminjaman() {
        return idPeminjaman;
    }

    public void setIdPeminjaman(String idPeminjaman) {
        this.idPeminjaman = idPeminjaman;
    }

    public String getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(String idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public void setIdMobil(String idMobil) {
        this.idMobil = idMobil;
    }

    public String getIdMobil() {
        return idMobil;
    }
    
    public Date getTglPinjam() {
        return tglPinjam;
    }

    public void setTglPinjam(Date tglPinjam) {
        this.tglPinjam = tglPinjam;
    }

    public Date getTglKembali() {
        return tglKembali;
    }

    public void setTglKembali(Date tglKembali) {
        this.tglKembali = tglKembali;
    }
    
    public String getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(String totalHarga) {
        this.totalHarga = totalHarga;
    }

    public String getUangBayar() {
        return uangBayar;
    }

    public void setUangBayar(String uangBayar) {
        this.uangBayar = uangBayar;
    }
    
    public void simpanPeminjaman(){
        String sql = "INSERT into peminjaman (id_pelanggan, id_mobil, tgl_pinjam, tgl_kembali, total_harga, uang_bayar, status)"
                + "VALUES ('"+getIdPelanggan()+"','"+getIdMobil()+"','"+getTglPinjam()+"'"
                + ",'"+getTglKembali()+"','"+getTotalHarga()+"','"+getUangBayar()+"','"+"Pinjam"+"')";
        
        try {
            PreparedStatement eksekusi = KoneksiDatabase.getKoneksi().prepareStatement(sql);
            eksekusi.execute();
            
            JOptionPane.showMessageDialog(null, "Data Peminjaman Berhasil Disimpan");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data Peminjaman Gagal Disimpan \n"+ex);
        }
    }
}
