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
public class ModelUser {
    private String idUser;
    private String nama;
    private String username;
    private String password;
    
    KoneksiDatabase koneksi = new KoneksiDatabase();

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public  void simpanDataUser(){
        String sql = ("INSERT INTO user(nama, username, password, level)"
                + " VALUES('"+getNama()+"', '"+getUsername()+"', '"+getPassword()+"'"
                + ", '"+"Karyawan"+"')");   
        
        try{
            PreparedStatement eksekusi = koneksi.getKoneksi().prepareStatement(sql);
            eksekusi.execute();

            JOptionPane.showMessageDialog(null, "Data User Berhasil Disimpan");
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Data User Gagal Disimpan \n" +ex);
        }
     
    }
    
    public  void updateDataUser(){
        String sql = "UPDATE user set nama = '"+getNama()+"'"
                + " ,username = '"+getUsername()+"'"
                + " ,password = '"+getPassword()+"' WHERE id_user = '"+getIdUser()+"'";
        
        try{
            PreparedStatement eksekusi = koneksi.getKoneksi().prepareStatement(sql);
            eksekusi.execute();

            JOptionPane.showMessageDialog(null, "Data User Berhasil Disimpan");
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Data User Gagal Disimpan \n" +ex);
        }
    }
    
    public void deleteDataUser(){
        String sql = "DELETE from user WHERE id_user = "
                + " '"+getIdUser()+"'";
        
        try{
            PreparedStatement eksekusi = koneksi.getKoneksi().prepareStatement(sql);
            eksekusi.execute();

            JOptionPane.showMessageDialog(null, "Data User Berhasil Dihapus");
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Data User Gagal Dihapus \n" +ex);
        }
    }
}
