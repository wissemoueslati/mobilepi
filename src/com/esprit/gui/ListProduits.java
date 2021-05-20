/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.esprit.entities.Produit;
import com.esprit.services.ServiceProduit;

/**
 *
 * @author WSI
 */
public class ListProduits extends Form{
    private Resources theme;
     ServiceProduit ll = new ServiceProduit();
    public ListProduits(Form previous ) {
        theme = UIManager.initFirstTheme("/theme");        
        setTitle("liste des produits.");
        
         TextField rech = new TextField("","Nom");
            Button recherche = new Button("Recherche");
            recherche.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ServiceProduit.getInstance().RechercheNom(rech.getText());
                new RechercheNom(rech.getText()).show();
               
            }
        });
        add(rech);
        add(recherche); 
          for (Produit p : ServiceProduit.getInstance().getAllProduits()){
            addItem(p);
                      
        }
          
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->previous.showBack());
    }
      private void addItem(Produit p) {
            Container C1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
             Container C2 = new Container(new BoxLayout(BoxLayout.X_AXIS));
             Label reference = new Label("Reference : "+p.getRefProd());
             Label nom = new Label("Nom : "+p.getNomProd());
             Label quantite = new Label("Quantité : "+p.getQteProd());
             Label prix = new Label("prix : "+p.getPrixProd());
                    
             
              Label sep = new Label("------------------------------------------------------------------");
              
                  Container btn = new Container(BoxLayout.x());
            int idProduit = p.getId();
         

                Button remove = new Button(FontImage.MATERIAL_DELETE_FOREVER, "Remove");
                remove.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                     ll.supprimerProduit(idProduit);
                      //new ListProduits(Form).show();
                }
                });
                  btn.add(remove);
        C1.add(reference);
        C1.add(nom);
        C1.add(quantite);
        C1.add(prix);   
        C1.add(sep);
        C1.add(btn);
        C2.add(C1);        
        add(C2);
             
       
    }
    
}
