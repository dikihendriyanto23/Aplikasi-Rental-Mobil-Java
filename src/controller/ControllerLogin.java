/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.ModelLogin;
import view.ViewLogin;

/**
 *
 * @author DIKI HENDRIYANTO
 */
public class ControllerLogin {
    private ModelLogin ML;
    private ViewLogin VL;
    
    public ControllerLogin(ViewLogin VL){
        this.VL = VL;
    }
    
    public void login(){
        ML = new ModelLogin();
        ML.setUsernameModel(VL.getTFUsername().getText());
        ML.setPasswordModel(VL.getTFPassword().getText());
        
        ML.login();
    }
    
    public void bersihkan(){
        VL.getTFUsername().setText("");
        VL.getTFPassword().setText("");
    }
}
