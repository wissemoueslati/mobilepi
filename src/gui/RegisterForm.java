/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import Services.UserService;
import com.codename1.capture.Capture;
import com.codename1.io.File;
import com.codename1.io.MalformedURLException;

import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import java.io.IOException;


/**
 *
 * @author Admin
 */
public class RegisterForm extends Form {
         private File selectedFile2;
         private File getImageFile() {
            return this.selectedFile2 = selectedFile2;
        }

        private void setImageFile(File file2) {
            this.selectedFile2 = file2;
        } 
    private Form current;
     public RegisterForm(Form previous) {
        /*
        Le paramètre previous définit l'interface(Form) précédente.
        Quelque soit l'interface faisant appel à AddTask, on peut y revenir
        en utilisant le bouton back
        */
        setTitle("Register");
        setLayout(BoxLayout.y());
        
        TextField tfemail = new TextField("","Email");
        TextField tfmdp= new TextField("", "Password", 20, TextField.PASSWORD);
        TextField tfName = new TextField("","name");
         TextField tftel = new TextField("","tel");
            TextField image = new TextField("","Image");
        
        Button btnValider = new Button("Register");
         Label ImageF = new Label();
         Button btnimg= new Button("img");
            btnimg.addActionListener(e->{
                String path=Capture.capturePhoto(Display.getInstance().getDisplayWidth(),-1);
                             try {
                Image img= Image.createImage(path);
                ImageF.setIcon(img);
                 java.io.File f=new java.io.File(path);
                 image.setText(f.getName());
                 revalidate();
            } catch (IOException ex) {
                
            }

       });
        
   
        
        
        
        addAll(tfemail,tftel,tfName,tfmdp,btnValider,btnimg,ImageF,image);
       btnValider.addActionListener(e->{
            UserService us=new UserService();
        us.register(tfemail, tfName, tfmdp, tftel,image);
           new AcctivationForm(current).show();
       });
       
       
       
    }

    
}
