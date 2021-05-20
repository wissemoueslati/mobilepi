/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Services.UserService;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author Admin
 */
public class AcctivationForm extends Form {
      private Form current;
    
         public AcctivationForm(Form previous) {
        /*
        Le paramètre previous définit l'interface(Form) précédente.
        Quelque soit l'interface faisant appel à AddTask, on peut y revenir
        en utilisant le bouton back
        */
        setTitle("Activation");
        setLayout(BoxLayout.y());
        
       
         TextField tfcode = new TextField("","Code");
        Button btnValider = new Button("Verifier");
        
        
        
        addAll(tfcode,btnValider);
       btnValider.addActionListener(e->{
            UserService us=new UserService();
            System.out.println("code userconnected"+us.check().getCode());
            if(us.verifcode(tfcode)){
                us.verifcodeuser(tfcode);
                Dialog.show("", "Compte Verfier", new Command("OK"));
                  new loginform(current).show();
                  
            }else{
                System.out.println("code ghalet");
            }
  
       });
       
    }
    
}
