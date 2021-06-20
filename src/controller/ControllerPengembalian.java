/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.ModelPengembalian;
import view.ViewPengembalianMobil;

/**
 *
 * @author DIKI HENDRIYANTO
 */
public class ControllerPengembalian {
    ModelPengembalian MP;
    ViewPengembalianMobil VPM;
    
    public ControllerPengembalian(ViewPengembalianMobil VPM){
        this.VPM = VPM;
    }
    
    public void updatePeminjaman(){
        MP = new ModelPengembalian();
        MP.setIdPeminjaman(VPM.getTFIdPeminjaman().getText());
        if (VPM.getCBStatus().getSelectedIndex() == 0) {
            MP.setStatus("Pinjam");
        } else {
            MP.setStatus("Kembali");
        }
        
        MP.updateDataPeminjaman();
    }
    
    public void simpanPengembalian(){
        MP = new ModelPengembalian();
        MP.setIdPeminjaman(VPM.getTFIdPeminjaman().getText());
        MP.setDenda(VPM.getTFDenda().getText());
        
        MP.simpanDataPengembalian();
    }
    public void kontrolbutton1(){
        VPM.getBTPengembalian().setEnabled(true);
        VPM.getBTBatal().setEnabled(true);
        VPM.getBTHitungDenda().setEnabled(true);
        VPM.getTFTelat().setEnabled(true);
        VPM.getTFDenda().setEnabled(true);
    }
    
    public void kontrolbutton2(){
        VPM.getBTPengembalian().setEnabled(false);
        VPM.getBTBatal().setEnabled(false);
        VPM.getBTHitungDenda().setEnabled(false);
        VPM.getTFTelat().setEnabled(false);
        VPM.getTFDenda().setEnabled(false);
    }
    
    public void bersihkan(){
        VPM.getTFIdPeminjaman().setText("");
        VPM.getTFNamaPelanggan().setText("");
        VPM.getTFNoPolisi().setText("");
        VPM.getTFTglPinjam().setText("");
        VPM.getTFTglKembali().setText("");
        VPM.getTFTotalBayar().setText("");
        VPM.getTFTelat().setText("");
        VPM.getTFDenda().setText("0");
    }
}
