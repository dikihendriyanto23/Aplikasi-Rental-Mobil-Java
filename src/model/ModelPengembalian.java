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
public class ModelPengembalian {
    private String idPeminjaman;
    private String status;
    private String denda;

    KoneksiDatabase koneksi = new KoneksiDatabase();
    
    public String getIdPeminjaman() {
        return idPeminjaman;
    }

    public void setIdPeminjaman(String idPeminjaman) {
        this.idPeminjaman = idPeminjaman;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDenda() {
        return denda;
    }

    public void setDenda(String denda) {
        this.denda = denda;
    }
    
    public  void updateDataPeminjaman(){
        String sql = "UPDATE peminjaman set status = '"+getStatus()+"' WHERE id_pinjam = '"+getIdPeminjaman()+"'";
        
        try{
            PreparedStatement eksekusi = koneksi.getKoneksi().prepareStatement(sql);
            eksekusi.execute();

            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan \n" +ex);
        }
    }
    
    public void simpanDataPengembalian(){
        String sql = "INSERT into pengembalian (id_pinjam, denda)"
                + "VALUES ('"+getIdPeminjaman()+"','"+getDenda()+"')";
        
        try {
            PreparedStatement eksekusi = KoneksiDatabase.getKoneksi().prepareStatement(sql);
            eksekusi.execute();
            
            JOptionPane.showMessageDialog(null, "Data Pengembalian Berhasil Disimpan");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data Pengembalian Gagal Disimpan \n"+ex);
        }
    }
}
