/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.ModelUser;
import view.ViewUser;

/**
 *
 * @author DIKI HENDRIYANTO
 */
public class ControllerUser {
    private ModelUser MU;
    private ViewUser VU;
    
    public ControllerUser(ViewUser VU){
        this.VU = VU;
    }
    
    public void simpan(){
        MU = new ModelUser();
        MU.setNama(VU.getTFNama().getText());
        MU.setUsername(VU.getTFUsername().getText());
        MU.setPassword(VU.getTFPassword().getText());
        
        MU.simpanDataUser();
        bersihkan();
    }
    
    public void update(){
        MU = new ModelUser();
        MU.setIdUser(VU.getTFIdUser().getText());
        MU.setNama(VU.getTFNama().getText());
        MU.setUsername(VU.getTFUsername().getText());
        MU.setPassword(VU.getTFPassword().getText());
        
        MU.updateDataUser();
        bersihkan();
        kontrolButton1();
    }
    
    public void delete(){
        MU = new ModelUser();
        MU.setIdUser(VU.getTFIdUser().getText());
        
        MU.deleteDataUser();
        bersihkan();
        kontrolButton1();
    }
    
    public void bersihkan(){
        VU.getTFIdUser().setText("");
        VU.getTFNama().setText("");
        VU.getTFUsername().setText("");
        VU.getTFPassword().setText("");
    }
    
    public void kontrolButton1(){
        VU.getBTSimpan().setEnabled(true);
        VU.getBTHapus().setEnabled(false);
        VU.getBTUbah().setEnabled(false);
        VU.getBTBatal().setEnabled(true);
    }
    
    public void kontrolButton2(){
        VU.getBTSimpan().setEnabled(false);
        VU.getBTHapus().setEnabled(true);
        VU.getBTUbah().setEnabled(true);
        VU.getBTBatal().setEnabled(true);
    }
}
