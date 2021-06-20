/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author DIKI HENDRIYANTO
 */
public class KoneksiDatabase {
    //Inisialisasi variabel dengan connection file class JDBC
    private static Connection conn;
    //Kemudian fungsi class properties untuk memanggil file konfig database yang kita buat sebelumnya
    private static Properties properti = new Properties();
    
    //Membuat fungsi untuk koneksi ke database
    public static Connection getKoneksi() throws SQLException {
        //Cek apakah ada koneksi
        if (conn == null) {
            try {
                //load file konfigurasiDatabase.properties
                properti.load(new FileInputStream("D:\\Praktikum Web and Java\\Praktikum Permograman Desktop\\AplikasiRentalMobil\\src\\db\\konfigurasiDatabase.properties"));
                //inisialisasi koneksi database
            } catch (IOException ex ) {
                System.err.println("Error mengambil file "+ex);
                System.err.println("Error membaca file file "+ex);
            }
            
            conn = DriverManager.getConnection(properti.getProperty("jdbc.url"), properti.getProperty("jdbc.username"), properti.getProperty("jdbc.password"));
        }
        return conn;
    }
    
    public static void main(String[] args) throws SQLException {
        if (getKoneksi().equals(conn)) {
            System.out.println("Sukses Terkoneksi");
        }
    }
}
