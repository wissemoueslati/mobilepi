/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionListener;
import com.esprit.entities.Produit;
import com.esprit.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author WSI
 */
public class ServiceProduit {
    public ArrayList<Produit> produits;
    
    public boolean resultOK;
    
    public static ServiceProduit instance=null;
    
    private final ConnectionRequest req;
    
    
    public ServiceProduit() {
         req = new ConnectionRequest();
    }
    
    public static ServiceProduit getInstance() {
        if (instance == null) {
            instance = new ServiceProduit();
        }
        return instance;
    }
    
    
    public ArrayList<Produit> parseProduits(String jsonText){
        try {
            produits=new ArrayList<>();
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            Map<String,Object> produitsListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String,Object>> list = (List<Map<String,Object>>)produitsListJson.get("root");
            
            //Parcourir la liste des tâches Json
            for(Map<String,Object> obj : list){
                //Création des tâches et récupération de leurs données
                Produit p = new Produit();
                int id = (int) Float.parseFloat(obj.get("id").toString());
                p.setId((int)id);
                p.setRefProd(((int)Float.parseFloat(obj.get("refProd").toString())));
                p.setQteProd(((int)Float.parseFloat(obj.get("qteProd").toString())));
                p.setNomProd(obj.get("nomProd").toString());
                
                p.setPrixProd(Float.parseFloat(obj.get("prixProd").toString()));
            
               produits.add(p);
            }
            
            
        } catch (IOException ex) {
            
        }
        return produits;
    }
     public ArrayList<Produit> getAllProduits(){
        String url = Statics.BASE_URL+"/AfficheProduitMobile";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                produits = parseProduits(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return produits;
    }
    
     
     
     public void supprimerProduit(int id) {
       ConnectionRequest con = new ConnectionRequest();
       con.setPost(false);
       con.setHttpMethod("DELETE");
       
        String Url =Statics.BASE_URL +"/deleteProduitMobile/"+id;
        
        con.setUrl(Url);
        con.addResponseListener((ee) -> {
            String str = new String(con.getResponseData());
            //System.out.println(str);
            Dialog.show("Succés", "Produit supprimée", "ok", null);
            

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        
    }
     public ArrayList<Produit> RechercheNom(String nomProd){
        String url = Statics.BASE_URL+"/rechercheNomProduitMobile/"+nomProd;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                produits = parseProduits(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return produits;
    }
     /*  public Produit DetailProduit(int id , Produit produit){
     String url = Statics.BASE_URL+"/detailProduitMobile?"+id;
     req.setUrl(url);
     String str = new String(req.getResponseData());
     req.addResponseListener(((evt)->{
     JSONParser jsonp = new JSONParser();
     try{
     Map<String,Object> obj = jsonp.parseJSON(new CharArrayReader(str.toCharArray()));
     produit.setRefProd(((int)Float.parseFloat(obj.get("refProd").toString())));
     produit.setQteProd(((int)Float.parseFloat(obj.get("qteProd").toString())));
     produit.setNomProd(obj.get("nomProd").toString());
     
     produit.setPrixProd(Float.parseFloat(obj.get("prixProd").toString()));
     
     } catch(IOException ex){
     
     }
     System.out.println("data==="+str);
     
     
     }));
     NetworkManager.getInstance().addToQueueAndWait(req);
     return produit;
     }*/
}
