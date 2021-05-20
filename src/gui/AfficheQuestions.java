/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.table.TableLayout;
import Entites.Categorie;
import Entites.Question;
import Services.CategorieService;
import Services.QuestionService;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author 21624
 */
public class AfficheQuestions extends Form{
        private Categorie q;
         Form current;
          Form previous;
     public AfficheQuestions(int id,Form previous) {
  current=this;
    
        current.getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, 4, e-> previous.showBack());
         setTitle("Liste des questions");
         
        setLayout(BoxLayout.y());
//                Container entete = new Container(BoxLayout.x());
//        entete.addAll("categories","Tags","nombreQuestion","nombreVues");

        ArrayList<Question> c = QuestionService.getInstance().getListQuestion(id);
         
        
//        TableLayout tl = new TableLayout(cat.size()+1, 4);
//        add(tl.createConstraint().
//                widthPercentage(5),
//                new Label("Categories")).

        for (int i = 0; i < c.size(); i++) {
            System.out.println(c.get(i));
            try {
                add(addQuestionHolder(c.get(i)));
            } catch (IOException ex) {
               // Logger.getLogger(afficher_velo.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
                Form h = new Form("Ajout Question", new BoxLayout(BoxLayout.Y_AXIS));
       // Label l =new Label("Ajouter une Categorie");
                TextField tfNomQ = new TextField("","question");
        TextField tfTagQ= new TextField("", "tags");
        h.addAll(tfNomQ,tfTagQ);
        Button AjouterCat =new Button("Ajouter ");
        addAll(h,AjouterCat);
              AjouterCat.addActionListener(e-> {
          //  Dialog.show(c.getId()+" ", c.getId()+" ", "OK", null);
          Question ca = new Question(1,tfNomQ.getText(),q,tfTagQ.getText());
        QuestionService.getInstance().addques(ca,id);
        AfficheQuestions affQ = new AfficheQuestions(id,previous);
          affQ.show();
       
         
           
           });    
   
         h.setScrollable(false);
    }
    
    public Container addQuestionHolder(Question c) throws IOException  {
    TableLayout t1 = new TableLayout(1,4);
    t1.cc().widthPercentage(10);
        Container holder = new Container(BoxLayout.x());

        
        Container f;
//       GridLayout.encloseIn(4,categorie,tag,nbrQ,nbrVue);
        

Form hi = new Form(c.getQuestion(), new BoxLayout(BoxLayout.Y_AXIS));
        Component Button;
        Button afficherRep =new Button("afficher reponses ");
        

          //  afficher_det_veloav f1= new afficher_det_veloav(velo.getId());
       //f1.show();  
               
          System.out.println("---------------"); 
          System.out.println("id est "+c.getId());
        
hi.add(new Label("Tags : "+c.getTag())).
    add(new Label("NombreVues : "+c.getNbr_vue()+" ")).
    add(new Label("NombreReponses : "+c.getNbr_reponse()+" ")).
    add(afficherRep); 
  //  add(new Label(c.getNbr_vue_categorie()+" "));
            afficherRep.addActionListener(e-> {
          //  Dialog.show(c.getId()+" ", c.getId()+" ", "OK", null); 
                System.out.println("id="+c.getId());
          AfficheReponse affQ = new AfficheReponse(c.getId(),this);
          affQ.show();
           
           });
           hi.setScrollable(false);
        return hi;
}
       
}
