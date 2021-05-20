/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Services.UserService;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import java.io.IOException;

/**
 *
 * @author Admin
 */
public class MenuForm extends Form{
    
      private Form current;
    
         public MenuForm(Form previous) {
        /*
        Le paramètre previous définit l'interface(Form) précédente.
        Quelque soit l'interface faisant appel à AddTask, on peut y revenir
        en utilisant le bouton back
        */
        setTitle("A&M");
        setLayout(BoxLayout.y());
        
       
        
        Button btnValider = new Button("Exposee");
         Button btnBlog = new Button("Blog");
           Button btnprod = new Button("Produit");
            Button btnFor = new Button("Forum");
             Button btnGmi = new Button("Gmusee&siteH");
        
        
        
        addAll(btnValider,btnBlog,btnprod,btnFor,btnGmi);
           btnBlog.addActionListener(e->{
           
        new AffBlog(current).show();
     
       });
           
                 btnprod.addActionListener(e->{
           
       Afficher_ProduitGUI f1= new Afficher_ProduitGUI();
       f1.show(); 
     
       });
       btnValider.addActionListener(e->{
           
                 try {
        new ExposeeForm(current).show();
        
        } catch (IOException ex) {
        
        }
       });
        btnGmi.addActionListener(e->{
           
                  new HomeForm().show();  
       });
           btnFor.addActionListener(e->{
      AfficheCategorie aff = new AfficheCategorie();
        aff.show();
       });
       
    }
    
}
