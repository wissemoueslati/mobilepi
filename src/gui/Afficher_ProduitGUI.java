/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import PidevAziz.MyApplication;
import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import Entites.ProduitM;
import Services.ProduitService;
import utils.image_static;
import java.io.IOException;

import java.util.ArrayList;

/**
 *
 * @author gorgi
 */
public class Afficher_ProduitGUI extends Form {
    
    Form current;
    public Afficher_ProduitGUI()   {
        current= this;
        setTitle("Liste des produit");
        setLayout(BoxLayout.y());
        
        ArrayList<ProduitM> produit = ProduitService.getInstance().getListProduit();
 
         
       
        for (int i = 0; i < produit.size(); i++) {
           // System.out.println(produit.get(i));
            try {
                add(addSerieHolder(produit.get(i)));
                
            } catch (IOException ex) {
               // Logger.getLogger(afficher_velo.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            
        }
 Button consulterpanier =new Button(" consulter panier ");
           
                      Button btnBlog = new Button("Retour");
        
        
        
        addAll(btnBlog);
           btnBlog.addActionListener(e->{
           
        new MenuForm(current).show();
     
       });
      add(consulterpanier);
       consulterpanier.addActionListener(e-> {
        consulter_panier f1= new consulter_panier(current);
       f1.show();  
               
                 });
    }
    
        
        
        
        public Container addSerieHolder(ProduitM prod) throws IOException  {
     EncodedImage enc;


     Container holder = new Container(BoxLayout.x());
        Container details = new Container(BoxLayout.y());
        Container notee = new Container(BoxLayout.x());
        Container titleDuree = new Container(BoxLayout.x());
        Button afficherdet =new Button("afficher detail ");

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
        details.addAll(titleDuree,prix,afficherdet);
        holder.addAll( notee,details);
        afficherdet.addActionListener(e-> {
        afficher_detprod f1= new afficher_detprod(prod.getId(),current);
       f1.show();  
               
                 });
        //holder.setLeadComponent(marque);
        return holder;
}
 
    
}
