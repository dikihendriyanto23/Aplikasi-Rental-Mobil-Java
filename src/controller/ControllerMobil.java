/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.KoneksiDatabase;
import model.ModelMobil;
import view.ViewMobil;

/**
 *
 * @author DIKI HENDRIYANTO
 */
public class ControllerMobil {
    private ModelMobil MM;
    private ViewMobil VM;
    
    public ControllerMobil(ViewMobil VM){
        this.VM = VM;
    } 
    
    public void simpan(){
        MM = new ModelMobil();
        MM.setMerek(VM.getTFMerek().getText());
        MM.setTipe(VM.getTFTipe().getText());
        MM.setTahun(VM.getTFTahun().getText());
        MM.setNo_polisi(VM.getTFNoPolisi().getText());
        MM.setHarga(Integer.parseInt(VM.getTFHarga().getText()));
        
        MM.simpanDataMobil();
        bersihkan();
    }
    
    public void update(){
        MM = new ModelMobil();
        MM.setIdMobil(VM.getTFIdMobil().getText());
        MM.setMerek(VM.getTFMerek().getText());
        MM.setTipe(VM.getTFTipe().getText());
        MM.setTahun(VM.getTFTahun().getText());
        MM.setNo_polisi(VM.getTFNoPolisi().getText());
        MM.setHarga(Integer.parseInt(VM.getTFHarga().getText()));
        
        MM.updateDataMobil();
        bersihkan();
        kontrolButton1();
    }
    
    public void delete(){
        MM = new ModelMobil();
        MM.setIdMobil(VM.getTFIdMobil().getText());
        
        MM.deleteDataMobil();
        bersihkan();
        kontrolButton1();
    }
    
    public void bersihkan(){
        VM.getTFIdMobil().setText("");
        VM.getTFMerek().setText("");
        VM.getTFTipe().setText("");
        VM.getTFTahun().setText("");
        VM.getTFNoPolisi().setText("");
        VM.getTFHarga().setText("");
    }
    
    public void kontrolButton1(){
        VM.getBTSimpan().setEnabled(true);
        VM.getBTHapus().setEnabled(false);
        VM.getBTUbah().setEnabled(false);
        VM.getBTBatal().setEnabled(true);
    }
    
    public void kontrolButton2(){
        VM.getBTSimpan().setEnabled(false);
        VM.getBTHapus().setEnabled(true);
        VM.getBTUbah().setEnabled(true);
        VM.getBTBatal().setEnabled(true);
    }
}
