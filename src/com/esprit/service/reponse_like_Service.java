/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.service;

import com.codename1.components.InfiniteProgress;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionListener;
import com.esprit.utils.Statics;
import entités.Reponse_like;
import java.util.ArrayList;

/**
 *
 * @author 21624
 */
public class reponse_like_Service {
      private ConnectionRequest req;
 public ArrayList<Reponse_like> reponse;
 public static reponse_like_Service instance=null;
   public boolean resultOK;
   public String UserName;
   
   
   public reponse_like_Service() {
        req = new ConnectionRequest();
    }
    
   public static reponse_like_Service getInstance() {
        if (instance == null) {
            instance = new reponse_like_Service();
        }
        return instance;
    }
 
    public boolean addreactionlike(int id) {
        String url = Statics.BASE_URL + "/reponse/likeaddmobile/"+id+"?reaction=1"; //création de l'URL
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
             
                resultOK = req.getResponseCode() == 200; 
                req.removeResponseListener(this); 
                
            }
        });
        InfiniteProgress prog = new InfiniteProgress();
    Dialog dlg = prog.showInifiniteBlocking();
    req.setDisposeOnCompletion(dlg);
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
    
    
     public boolean addreactiondislike(int id) {
        String url = Statics.BASE_URL + "/reponse/likeaddmobile/"+id+"?reaction=0"; //création de l'URL
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
             
                resultOK = req.getResponseCode() == 200; 
                req.removeResponseListener(this); 
                
            }
        });
        InfiniteProgress prog = new InfiniteProgress();
    Dialog dlg = prog.showInifiniteBlocking();
    req.setDisposeOnCompletion(dlg);
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }  
    
    
    
    
   
   
}
