/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import db.KoneksiDatabase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import mvc.MenuUtama;
import mvc.MenuUtama_Karyawan;

/**
 *
 * @author DIKI HENDRIYANTO
 */
public class ModelLogin {
    private String usernameModel;
    private String passwordModel;
    
    KoneksiDatabase koneksi = new KoneksiDatabase();
    
    public String getUsernameModel() {
        return usernameModel;
    }

    public void setUsernameModel(String usernameModel) {
        this.usernameModel = usernameModel;
    }

    public String getPasswordModel() {
        return passwordModel;
    }

    public void setPasswordModel(String passwordModel) {
        this.passwordModel = passwordModel;
    }
    
    public void login(){
        String sql = "SELECT * FROM user WHERE username='"+getUsernameModel()+"'"
                + " AND password='"+getPasswordModel()+"'";
        
        try{
            Statement stat = (Statement) koneksi.getKoneksi().createStatement();
            ResultSet res = stat.executeQuery(sql);
            
            if(res.next()){
                if(getUsernameModel().equals(res.getString("username")) && getPasswordModel().equals(res.getString("password"))){
                    JOptionPane.showMessageDialog(null, "Login Berhasil");
                    if(res.getString("level").equals("Admin")){
                        MenuUtama MU = new MenuUtama();
                        MU.setVisible(true); 
                    }else{
                        MenuUtama_Karyawan MUK = new MenuUtama_Karyawan();
                        MUK.setVisible(true);
                    }  
                }
            }else{
                JOptionPane.showMessageDialog(null, "Username atau Password Salah");
            }
        } catch (SQLException ex){
            JOptionPane.showConfirmDialog(null, "Login Gagal \n" +ex);
        }
    }
}
