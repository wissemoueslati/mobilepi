/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.esprit.Home;
import com.esprit.entities.Produit;
import com.esprit.services.ServiceProduit;
import java.io.IOException;

/**
 *
 * @author WSI
 */
public class RechercheNom extends Form {
    private Resources theme;

        Form current;
    public RechercheNom(String nomProd) {
        theme = UIManager.initFirstTheme("/theme");

        setTitle("Produit Recherché .");

        for (Produit p : ServiceProduit.getInstance().RechercheNom(nomProd)){
            addItem(p);
        }
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->new Home().show());
    }
   
        public void addItem(Produit P){
        Container C1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Container C2 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container C3 = new Container(new BoxLayout(BoxLayout.X_AXIS));

        Label reference = new Label("Reference : "+P.getRefProd());
        Label nom = new Label("Nom : "+P.getNomProd());
        
        Label quantite = new Label("Quantite : "+P.getQteProd());
        Label prix = new Label("Prix : "+P.getPrixProd());
       
       
        TextField rech = new TextField();
        Button recherche = new Button("Recherche");
        
        Label sep = new Label("-------------------------------------------------------------------");
        
        ImageViewer m = new ImageViewer();
   
        //C3.add(nom);
        /*  C1.add(C3);
        try {
        Image img = Image.createImage("/icon.png");
        C3.add("                 ");
        C3.add(img);
        } catch (IOException ex) {
        }*/
        C1.add(nom);
        C1.add(reference);   
        C1.add(quantite);
        C1.add(prix);
        C1.add(sep);
        C2.add(C1);
        add(C2);     
    }
    
}
