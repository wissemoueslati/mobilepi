/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.table.TableLayout;
import com.esprit.entity.Categorie;
import com.esprit.service.CategorieService;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author 21624
 */
public class AfficheCategorie extends Form{
 Form current;
    public AfficheCategorie() {
current= this;
  
        
         setTitle("Liste des categories");
         
        setLayout(BoxLayout.y());
//                Container entete = new Container(BoxLayout.x());
//        entete.addAll("categories","Tags","nombreQuestion","nombreVues");

        ArrayList<Categorie> cat = CategorieService.getInstance().getListVelo();
        
//        TableLayout tl = new TableLayout(cat.size()+1, 4);
//        add(tl.createConstraint().
//                widthPercentage(5),
//                new Label("Categories")).


        for (int i = 0; i < cat.size(); i++) {
            System.out.println(cat.get(i));
            try {
                add(addCategorieHolder(cat.get(i)));
                
            } catch (IOException ex) {
               // Logger.getLogger(afficher_velo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
    }
        Form h = new Form("Ajout Categorie", new BoxLayout(BoxLayout.Y_AXIS));
       // Label l =new Label("Ajouter une Categorie");
                TextField tfNom = new TextField("","nom Categorie");
        TextField tfTag= new TextField("", "tags");
        h.addAll(tfNom,tfTag);
        Button AjouterCat =new Button("Ajouter ");
        addAll(h,AjouterCat);
              AjouterCat.addActionListener(e-> {
          //  Dialog.show(c.getId()+" ", c.getId()+" ", "OK", null);
          Categorie ca = new Categorie(1,tfNom.getText(),tfTag.getText());
        CategorieService.getInstance().addcat(ca);
         AfficheCategorie affQ = new AfficheCategorie();
          affQ.show();
       
         
           
           });    
   
         h.setScrollable(false);
    }
    
    public Container addCategorieHolder(Categorie c) throws IOException  {
    TableLayout t1 = new TableLayout(1,4);
    t1.cc().widthPercentage(10);
        Container holder = new Container(BoxLayout.x());

        Label categorie = new Label(c.getNameCategorie());
        Label tag = new Label(c.getTag());
         Label nbrQ = new Label(c.getNbr_question()+" ");
        Label nbrVue = new Label(c.getNbr_vue_categorie()+" ");

        holder.addAll(categorie,tag,nbrQ,nbrVue);
        //t1.encloseIn(4,holder);
        
        Container f;
//       GridLayout.encloseIn(4,categorie,tag,nbrQ,nbrVue);
        

Form hi = new Form(c.getNameCategorie(), new BoxLayout(BoxLayout.Y_AXIS));
        Component Button;
        Button afficherQues =new Button("afficher questions ");
        

        

               
            
        
hi.add(new Label("Tags : "+c.getTag())).
    add(new Label("NombreVues : "+c.getNbr_vue_categorie()+" ")).
    add(new Label("NombreQuestions : "+c.getNbr_question()+" ")).
    add(afficherQues);
        

  //  add(new Label(c.getNbr_vue_categorie()+" "));
           afficherQues.addActionListener(e-> {
          //  Dialog.show(c.getId()+" ", c.getId()+" ", "OK", null);   
          AfficheQuestions affQ = new AfficheQuestions(c.getId(),current);
          affQ.show();
        // c.setNbr_vue_categorie(c.getNbr_vue_categorie()+1);
           
           });
           hi.setScrollable(false);
        return hi;
}


    
}
