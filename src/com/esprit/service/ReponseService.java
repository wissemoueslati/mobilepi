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
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionListener;

import com.esprit.entity.Reponse;
import com.esprit.entity.User;
import com.esprit.utils.Statics;
import java.util.ArrayList;
import java.util.Date;

import org.json.JSONArray;

/**
 *
 * @author 21624
 */
public class ReponseService {
    
    
      private ConnectionRequest req;
 public ArrayList<Reponse> reponse;
 public static ReponseService instance=null;
   public boolean resultOK;
   public String UserName;
   
    public ReponseService() {
        req = new ConnectionRequest();
    }
    
   public static ReponseService getInstance() {
        if (instance == null) {
            instance = new ReponseService();
        }
        return instance;
    }
   
   public ArrayList<Reponse> parseQuestion(String jsonText) throws ParseException{
      
            reponse=new ArrayList<>();
            System.out.println(jsonText);
            JSONArray arr = new JSONArray(jsonText);
            
            for (int i = 0; i < arr.length(); i++) {
                Reponse v=new Reponse();
                v.setId(arr.getJSONObject(i).getInt("id"));
                //v.getQuestion().setId(arr.getJSONObject(i).getInt("question_id"));
                v.setReponse(arr.getJSONObject(i).getString("reponse"));
                 v.setUser_id(arr.getJSONObject(i).getInt("user_id"));
                 
                 
                 
//               SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
//                 String inputDateStr =arr.getJSONObject(i).getString("datereponse") ;
//                Date inputDate = inputFormat.parse(inputDateStr);             
//
//                 v.setDatereponse(inputDate);


             //   v.setDatereponse(arr.getJSONObject(i).getInt("nbrReponse"));


                reponse.add(v);
                
        }
                
        
        return reponse;
    }
      public String parseUser(String jsonText){
      
          
            System.out.println(jsonText);
            JSONArray arr = new JSONArray(jsonText);
            
            for (int i = 0; i < arr.length(); i++) {
                User v=new User();
              //  v.setId(arr.getJSONObject(i).getInt("id"));
                v.setNom(arr.getJSONObject(i).getString("nom"));
   
             //   v.setDatereponse(arr.getJSONObject(i).getInt("nbrReponse"));

                UserName=v.getNom();
                
                
        }
                
        
        return UserName;
    }
   
   
   
   public ArrayList<Reponse> getListReponse(int id){
        String url = Statics.BASE_URL+"/reponse/listR/"+id;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                try {
                    reponse = parseQuestion(new String(req.getResponseData()));
                    req.removeResponseListener(this);
                } catch (ParseException ex) {
                   
                }
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return reponse;
    } 
   
   
   
   
   
      public String getUserM(int id){
        String url = Statics.BASE_URL+"/reponse/User"+id;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                UserName = parseUser(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return UserName;
    } 
   
      
      
      
        public boolean addrep(Reponse v,int id, int userid ) {
        String url = Statics.BASE_URL + "/reponse/newReponseM/"+id+ "?reponse=" + v.getReponse()+"&userid="+userid; //création de l'URL
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
