/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entites.blog;
import Services.BlogService;
import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class AffBlog extends Form {
 private Form current;

    public AffBlog(Form previous) {
        /*
        Le paramètre previous définit l'interface(Form) précédente.
        Quelque soit l'interface faisant appel à AddTask, on peut y revenir
        en utilisant le bouton back
         */
        BlogService es = new BlogService();
        int i;
        
        ArrayList<blog> listRes = new ArrayList<>();
        listRes = es.afficheblogs();
        setTitle("Blogs");
        setLayout(BoxLayout.y());

        for (i = 0; i < listRes.size(); i++) {
                         Label id = new Label("id :" + String.valueOf(listRes.get(i).getId()));
            Label tfnom = new Label("Contenu:"+ listRes.get(i).getContenu());
               Button btnUpdate= new Button("Commenter");
                btnUpdate.addActionListener(e->{
                    
            new CommentBl(current).show();
     
         });
            Label tags = new Label("Tags:" + listRes.get(i).getTags());
            listRes.get(i).setId(i);
                        Label titre = new Label("Titre:" + listRes.get(i).getTitre());
           
            addAll(id,titre,tfnom,tags,btnUpdate);
            
     
          

        }
 
  }

}
