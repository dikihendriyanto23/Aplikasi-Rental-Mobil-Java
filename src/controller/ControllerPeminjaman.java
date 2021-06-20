/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Date;
import model.ModelPeminjaman;
import view.ViewPeminjamanMobil;

/**
 *
 * @author DIKI HENDRIYANTO
 */
public class ControllerPeminjaman {
    private ModelPeminjaman MP;
    private ViewPeminjamanMobil VP;
    
    public ControllerPeminjaman(ViewPeminjamanMobil VP){
        this.VP = VP;
    }
    
    public void simpanPeminjaman(){
        MP = new ModelPeminjaman();
        
        MP.setIdPelanggan(VP.getTFIdPelanggan().getText());
        MP.setIdMobil(VP.getTFIdMobil().getText());
        Date d = VP.getDCTglPinjam().getCalendar().getTime();
                    java.sql.Date tglPinjam = new java.sql.Date(d.getTime());
                    MP.setTglPinjam(tglPinjam);
        Date c = VP.getDCTglKembali().getCalendar().getTime();
                    java.sql.Date tglKembali = new java.sql.Date(d.getTime());
                    MP.setTglKembali(tglKembali);
        MP.setTotalHarga(VP.getTFTotalBayar().getText());
        MP.setUangBayar(VP.getTFUangBayar().getText());
        
        MP.simpanPeminjaman();
    }
    
    public void bersihkan(){
        VP.getTFIdPelanggan().setText("");
        VP.getTFNamaPelanggan().setText("");
        VP.getTFNoHP().setText("");
        VP.getTAAlamat().setText("");
        VP.getTFIdMobil().setText("");
        VP.getTFMerek().setText("");
        VP.getTFTipe().setText("");
        VP.getTFTahun().setText("");
        VP.getTFNoPolisi().setText("");
        VP.getTFHargaSewa().setText("");
        VP.getTFLamaHari().setText("");
        VP.getDCTglPinjam().setDate(null);
        VP.getDCTglKembali().setDate(null);
        VP.getTFTotalBayar().setText("0");
        VP.getTFUangBayar().setText("");
    }
}
