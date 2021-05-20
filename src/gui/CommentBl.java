/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entites.blogcomment;
import Services.BlogService;
import Services.commentaireService;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import java.util.ArrayList;

/**
 *
 * @author Iheb
 */
public class CommentBl extends Form {
    private Form current;
    public CommentBl(Form previous) {
        /*
        Le paramètre previous définit l'interface(Form) précédente.
        Quelque soit l'interface faisant appel à AddTask, on peut y revenir
        en utilisant le bouton back
        */
        setTitle("Reservation");
        setLayout(BoxLayout.y());
         commentaireService rs=new commentaireService();
         int i;
            ArrayList <blogcomment> listRes= rs.afficheblogcoemm();
      for (i = 0; i < listRes.size(); i++) {
            Label email = new Label("Email :" + String.valueOf(listRes.get(i).getEmail()));
          
                         Label id = new Label("name :" + String.valueOf(listRes.get(i).getName()));
                         
            Label tfnom = new Label("Contenu:"+ listRes.get(i).getContenu()); 
         
            addAll(email,id,tfnom);
            
     
          

        }
        TextField tfemail = new TextField("","email");
         TextField tfCoenu = new TextField("","Contenu");
          TextField tfname = new TextField("","name");
        Button btnReserver= new Button("commenter");
    
        btnReserver.addActionListener(e->{
            
            rs.Ajouter(tfCoenu, tfemail, tfname);
        });
        
      
        
        
        
        addAll(tfemail,tfCoenu, tfname, btnReserver);
        
            Button btnBlog = new Button("Retour");
        
        
        
        addAll(btnBlog);
           btnBlog.addActionListener(e->{
           
        new MenuForm(current).show();
     
       });
     }
    
}
