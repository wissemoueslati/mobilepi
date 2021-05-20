/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.PIDEVM.myapp.MyApplication;
import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.esprit.entities.ProduitM;
import com.esprit.service.CommandeService;
import com.esprit.service.ProduitService;
import com.esprit.utils.image_static;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author gorgi
 */
public class consulter_panier extends Form {
Form current;
    public consulter_panier(Form previous) {
        
        current=this;
        setTitle("Liste des panier ");
        setLayout(BoxLayout.y());
        current.getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, 4, e-> previous.showBack());
        ArrayList<ProduitM> produit = CommandeService.getInstance().getlistpanier();
        
        if (produit.size()==0){
             
             Button marque  =new Button("Votre panier est vide ");
             
              add(marque);
        }
        else{
              for (int i = 0; i < produit.size(); i++) {
            System.out.println(produit.get(i));
            try {
                add(addSerieHolder(produit.get(i),previous));
            } catch (IOException ex) {
               // Logger.getLogger(afficher_velo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        }
      
    }
        
    
    
   

  public Container addSerieHolder(ProduitM prod,Form previous) throws IOException  {
     EncodedImage enc;


     Container holder = new Container(BoxLayout.x());
        Container details = new Container(BoxLayout.y());
        Container notee = new Container(BoxLayout.x());
        Container titleDuree = new Container(BoxLayout.x());
        Button afficherdet =new Button(" acheter ");
        Button supprimer =new Button(" retirer ");
        enc= EncodedImage.createFromImage(MyApplication.theme.getImage("loading.jpg"),false);
        URLImage imgs = URLImage.createToStorage(enc, image_static.IMAGE_BASE_URL+"/"+prod.getImg_prod(),  image_static.IMAGE_BASE_URL+"/"+prod.getImg_prod());
        imgs.fetch();
        ImageViewer image = new ImageViewer();
        image.setImage(imgs);
        notee.addAll(image);
        Label marque = new Label(prod.getNom_prod());
        Label prix = new Label("prix : "+prod.getPrix_prod()+" DT");
        // String duree = serie.getDuree()+ "";
        // String duree = String.valueOf(serie.getDuree());
        //Label type = new Label(velo.getType());
       // Label lbdisponibilite = new Label(prod.getDisponibilite());
 
        //Button lbDescription = new Button("CLICK ME");
        //lbDescription.addActionListener((evt) -> {
        //    Dialog.show(serie.getTitle() , serie.getDescription(), "OK", null);
        //});
        //lbTitle.addPointerReleasedListener((evt) -> {
          //  Dialog.show(serie.getTitle(), serie.getDescription(), "OK", null);
        //});
     
        titleDuree.addAll(marque);
        details.addAll(titleDuree,prix,afficherdet,supprimer);
        holder.addAll( notee,details);
        afficherdet.addActionListener(e-> {
           acheter_prod f1= new acheter_prod(prod.getId(),previous);
       f1.show();  
               
                 });
        supprimer.addActionListener(e-> {
            CommandeService.getInstance().supprimerpanier(prod.getId());
            Dialog.show("suppression", "suppression effectue ! ", "OK", null);
           consulter_panier f1= new consulter_panier(previous);
       f1.show();  
               
                 });
        //holder.setLeadComponent(marque);
        return holder;
}
}
 
    


