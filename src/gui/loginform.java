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
public class loginform extends Form{
       private Form current;
     public loginform(Form previous) {
        /*
        Le paramètre previous définit l'interface(Form) précédente.
        Quelque soit l'interface faisant appel à AddTask, on peut y revenir
        en utilisant le bouton back
        */
        setTitle("Login");
        setLayout(BoxLayout.y());
        
        TextField tfemail = new TextField("","Email");
        TextField tfmdp= new TextField("", "Password", 20, TextField.PASSWORD);
        Button btnLogin= new Button("Login");
         Button btnRegister= new Button("Don t have an account?");
          Button btnchnagermdp= new Button("Forgot password?");
        
        
        
        addAll(tfemail,tfmdp,btnLogin,btnRegister,btnchnagermdp);
        
        btnLogin.addActionListener(e -> {
            UserService us=new UserService();
            us.login(tfemail, tfmdp);
        });
        
        btnRegister.addActionListener(e->{
            new RegisterForm(current).show();
       });
        
         btnchnagermdp.addActionListener(e->{
            
            new changermdpForm(current).show();
       });
    }

  
    
}
