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
public class ModelMobil {
    private String idMobil;
    private String merek;
    private String tipe;
    private String tahun;
    private String no_polisi;
    private int harga;
    
    KoneksiDatabase koneksi = new KoneksiDatabase();

    public String getIdMobil() {
        return idMobil;
    }

    public void setIdMobil(String idMobil) {
        this.idMobil = idMobil;
    }

    public String getMerek() {
        return merek;
    }

    public void setMerek(String merek) {
        this.merek = merek;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public String getNo_polisi() {
        return no_polisi;
    }

    public void setNo_polisi(String no_polisi) {
        this.no_polisi = no_polisi;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
    
    public  void simpanDataMobil(){
        String sql = ("INSERT INTO mobil(merek, tipe, tahun, no_polisi, harga)"
                + " VALUES('"+getMerek()+"', '"+getTipe()+"', '"+getTahun()+"'"
                + ", '"+getNo_polisi()+"', '"+getHarga()+"')");   
        
        try{
            PreparedStatement eksekusi = koneksi.getKoneksi().prepareStatement(sql);
            eksekusi.execute();

            JOptionPane.showMessageDialog(null, "Data Mobil Berhasil Disimpan");
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Data Mobil Gagal Disimpan \n" +ex);
        }
     
    }
    
    public  void updateDataMobil(){
        String sql = "UPDATE mobil set merek = '"+getMerek()+"'"
                + " ,tipe = '"+getTipe()+"'"
                + " ,tahun = '"+getTahun()+"'"
                + " ,no_polisi = '"+getNo_polisi()+"'"
                + " ,harga = '"+getHarga()+"' WHERE id_mobil = '"+getIdMobil()+"'";
        
        try{
            PreparedStatement eksekusi = koneksi.getKoneksi().prepareStatement(sql);
            eksekusi.execute();

            JOptionPane.showMessageDialog(null, "Data Mobil Berhasil Disimpan");
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Data Mobil Gagal Disimpan \n" +ex);
        }
     
    }
    
    public void deleteDataMobil(){
        String sql = "DELETE from mobil WHERE id_mobil = "
                + " '"+getIdMobil()+"'";
        
        try{
            PreparedStatement eksekusi = koneksi.getKoneksi().prepareStatement(sql);
            eksekusi.execute();

            JOptionPane.showMessageDialog(null, "Data Mobil Berhasil Dihapus");
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Data Mobil Gagal Dihapus \n" +ex);
        }
    }
}
