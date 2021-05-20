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

/**
 *
 * @author Admin
 */
public class changermdpForm extends Form{
    
         private Form current;
     public changermdpForm(Form previous) {
        /*
        Le paramètre previous définit l'interface(Form) précédente.
        Quelque soit l'interface faisant appel à AddTask, on peut y revenir
        en utilisant le bouton back
        */
        setTitle("change password");
        setLayout(BoxLayout.y());
        
        TextField tfemail = new TextField("","Email");
        TextField tfmdp= new TextField("", "Password", 20, TextField.PASSWORD);
        TextField tfconfmdp = new TextField("","confirmer mot de passe", 20, TextField.PASSWORD);
         TextField tfnewmdp = new TextField("","nouveau mot de passe", 20, TextField.PASSWORD);
        Button btnValider = new Button("Valider");
        
        
        
        addAll(tfemail,tfmdp,tfnewmdp,tfconfmdp,btnValider);
       btnValider.addActionListener(e->{
          if(tfconfmdp.getText().equals(tfnewmdp.getText())){
              UserService us=new UserService();
            us.changepsword(tfnewmdp, tfmdp, tfemail);
              new loginform(current).show();
          }else{
              System.out.println("Confirmer votre mot de passe");
          }
           
       });
       
       
       
    }
    
}
