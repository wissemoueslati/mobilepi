/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import PidevAziz.MyApplication;
import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.io.ConnectionRequest;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import Entites.ProduitM;
import Services.CommandeService;
import Services.ProduitService;
import utils.image_static;
import java.io.IOException;
import java.util.ArrayList;




/**
 *
 * @author gorgi
 */
public class afficher_detprod extends Form {
     public ArrayList<ProduitM> produit;
    ProduitM v=new ProduitM();
    private ConnectionRequest req;
    public static ProduitService instance=null;
    public String retour=""; 
    public boolean resultOK;
        Form current;
    
    public afficher_detprod(int id,Form afficherpord)   {
        current= this;
        current.getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, 4, e-> afficherpord.showBack());
        setLayout(BoxLayout.y());
        setTitle("detail produits");
        ProduitM prod = ProduitService.getInstance().getListProduit_by_id(id);
       // System.out.println("one velo = "+ velo.toString());
        EncodedImage enc;
        Container holder = new Container(BoxLayout.x());
        Container details = new Container(BoxLayout.y());
        Container imagev = new Container(BoxLayout.x());
        Container boutton = new Container(BoxLayout.x());
       // Button afficherdet =new Button("afficher detail ");
        enc= EncodedImage.createFromImage(MyApplication.theme.getImage("loading.jpg").scaled(1000, 700),true);
        Image imgs = URLImage.createToStorage(enc, image_static.IMAGE_BASE_URL+"/"+prod.getImg_prod(),  image_static.IMAGE_BASE_URL+"/"+prod.getImg_prod()).scaled(1200, 1200);
        ImageViewer image = new ImageViewer(imgs);
        imagev.add(image);
          Label marque = new Label(prod.getNom_prod());
          Label prix = new Label(prod.getPrix_prod()+" DT");
          Label string = new Label("prix :");
         
          SpanLabel  description = new SpanLabel (prod.getDescription_prod());
           Button acheter =new Button("acheter ");
            Button ajouterpanier  =new Button("ajouter au panier ");
          //Container dispLayout = FlowLayout.encloseIn(disponibilite);
          //Container prixlayout = FlowLayout.encloseIn(prix);
          //Container desclayout = FlowLayout.encloseIn(description);
            acheter.addActionListener(e-> {
            acheter_prod f1= new acheter_prod(prod.getId(),this);
       f1.show();  
               
                 });
              ajouterpanier.addActionListener(e-> {
           CommandeService.getInstance().ajouterpanier(prod.getId());
             consulter_panier f1= new consulter_panier(this);
       f1.show();    
                 });
          boutton.addAll(acheter,ajouterpanier);
          details.addAll(string,prix);
          addAll(marque,imagev,details,description,boutton);
          //Label marque = new Label(velo.getMarque())    
    }
    
}
