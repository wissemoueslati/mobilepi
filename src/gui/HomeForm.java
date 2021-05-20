/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import java.io.IOException;


/**
 *
 * @author bhk
 */
public class HomeForm extends Form {

    Form current;
    /*Garder traçe de la Form en cours pour la passer en paramètres 
    aux interfaces suivantes pour pouvoir y revenir plus tard en utilisant
    la méthode showBack*/
    
    public HomeForm() {
        current = this; //Récupération de l'interface(Form) en cours
        setTitle("Home");
        setLayout(BoxLayout.y());

        add(new Label("Choose an option"));
        Button btnListSite = new Button("Liste Site");
        Button btnListGmusee = new Button("Liste Musée");
        
         Button btnBlog = new Button("Retour");
        
        
        
        addAll(btnBlog);
           btnBlog.addActionListener(e->{
           
        new MenuForm(current).show();
     
       });

        btnListGmusee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new ListGmuseeForm(current).show();
                } catch (IOException ex) {
                }
            }
        });

        btnListSite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new ListSiteForm(current).show();
                } catch (IOException ex) {
                  
                }
            }
        });
     addAll(btnListSite, btnListGmusee);

    }
    

}