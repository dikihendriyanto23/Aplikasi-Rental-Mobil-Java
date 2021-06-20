/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.ModelPelanggan;
import view.ViewPelanggan;

/**
 *
 * @author DIKI HENDRIYANTO
 */
public class ControllerPelanggan {
    private ModelPelanggan MP;
    private ViewPelanggan VP;
    
    public ControllerPelanggan(ViewPelanggan VP){
        this.VP = VP;
    }
    
    public void simpan(){
        MP = new ModelPelanggan();
        MP.setNoKTP(VP.getTFNoKTP().getText());
        MP.setNamaPelanggan(VP.getTFNamaPelanggan().getText());
        MP.setNoHp(VP.getTFNoHP().getText());
        if(VP.getRBPria().isSelected()){
            MP.setJenisKelamin("Pria");
        }else{
            MP.setJenisKelamin("Wanita");
        }
        MP.setAlamat(VP.getTAAlamat().getText());
        
        MP.simpanDataPelanggan();
        bersihkan();
    }
    
    public void update(){
        MP = new ModelPelanggan();
        MP.setIdPelanggan(VP.getTFIdPelanggan().getText());
        MP.setNoKTP(VP.getTFNoKTP().getText());
        MP.setNamaPelanggan(VP.getTFNamaPelanggan().getText());
        MP.setNoHp(VP.getTFNoHP().getText());
        if(VP.getRBPria().isSelected()){
            MP.setJenisKelamin("Pria");
        }else{
            MP.setJenisKelamin("Wanita");
        }
        MP.setAlamat(VP.getTAAlamat().getText());
        
        MP.updateDataPelanggan();
        bersihkan();
        kontrolButton1();
    }
    
    public void delete(){
        MP = new ModelPelanggan();
        MP.setIdPelanggan(VP.getTFIdPelanggan().getText());
        
        MP.deleteDataPelanggan();
        bersihkan();
        kontrolButton1();
    }
    
    public void bersihkan(){
        VP.getTFIdPelanggan().setText("");
        VP.getTFNoKTP().setText("");
        VP.getTFNamaPelanggan().setText("");
        VP.getTFNoHP().setText("");
        VP.getButtonGroup1().clearSelection();
        VP.getTAAlamat().setText("");
    }
    
    public void kontrolButton1(){
        VP.getBTSimpan().setEnabled(true);
        VP.getBTHapus().setEnabled(false);
        VP.getBTUbah().setEnabled(false);
        VP.getBTBatal().setEnabled(true);
    }
    
    public void kontrolButton2(){
        VP.getBTSimpan().setEnabled(false);
        VP.getBTHapus().setEnabled(true);
        VP.getBTUbah().setEnabled(true);
        VP.getBTBatal().setEnabled(true);
    }
}
