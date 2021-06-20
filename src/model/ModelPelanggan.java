/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import db.KoneksiDatabase;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author DIKI HENDRIYANTO
 */
public class ModelPelanggan {
    private String namaPelanggan;
    private String noHp;
    private String jenisKelamin;
    private String noKTP;
    private String alamat;
    private String IdPelanggan;
    
    KoneksiDatabase koneksi = new KoneksiDatabase();
    
    public ModelPelanggan(){
        
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getIdPelanggan() {
        return IdPelanggan;
    }

    public void setIdPelanggan(String IdPelanggan) {
        this.IdPelanggan = IdPelanggan;
    }

    public String getNoKTP() {
        return noKTP;
    }

    public void setNoKTP(String noKTP) {
        this.noKTP = noKTP;
    }
    
    public  void simpanDataPelanggan(){
        String sql = ("INSERT INTO pelanggan(no_ktp, nama_pelanggan, no_hp, jk, alamat)"
                + " VALUES('"+getNoKTP()+"', '"+getNamaPelanggan()+"', '"+getNoHp()+"'"
                + ", '"+getJenisKelamin()+"', '"+getAlamat()+"')");   
        
        try{
            PreparedStatement eksekusi = koneksi.getKoneksi().prepareStatement(sql);
            eksekusi.execute();

            JOptionPane.showMessageDialog(null, "Data Pelanggan Berhasil Disimpan");
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Data Pelanggan Gagal Disimpan \n" +ex);
        }
     
    }
    
    public  void updateDataPelanggan(){
        String sql = "UPDATE pelanggan set no_ktp = '"+getNoKTP()+"'"
                + " ,nama_pelanggan = '"+getNamaPelanggan()+"'"
                + " ,no_hp = '"+getNoHp()+"'"
                + " ,jk = '"+getJenisKelamin()+"'"
                + " ,alamat = '"+getAlamat()+"' WHERE id_pelanggan = '"+getIdPelanggan()+"'";
        
        try{
            PreparedStatement eksekusi = koneksi.getKoneksi().prepareStatement(sql);
            eksekusi.execute();

            JOptionPane.showMessageDialog(null, "Data Pelanggan Berhasil Disimpan");
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Data Pelanggan Gagal Disimpan \n" +ex);
        }
    }
    
    public void deleteDataPelanggan(){
        String sql = "DELETE from pelanggan WHERE id_pelanggan = "
                + " '"+getIdPelanggan()+"'";
        
        try{
            PreparedStatement eksekusi = koneksi.getKoneksi().prepareStatement(sql);
            eksekusi.execute();

            JOptionPane.showMessageDialog(null, "Data Pelanggan Berhasil Dihapus");
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Data Pelanggan Gagal Dihapus \n" +ex);
        }
    }
}
