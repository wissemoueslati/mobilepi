/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entites.Exposee;
import Services.ExposeeService;
import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.image.ImageView;

/**
 *
 * @author Admin
 */
public class ExposeeForm extends Form {
    private Form current;
     public ExposeeForm(Form previous) throws IOException {
       ExposeeService es= new ExposeeService();
       int i;
     ArrayList <Exposee> listexpose =new ArrayList <>();
     listexpose=es.afficheExposee();
        setTitle("Exposee");
        setLayout(BoxLayout.y());
         
        for(i=0;i<listexpose.size();i++){
               Label tfnom = new Label("exposee nom:"+listexpose.get(i).getNom());
           Label tfdesc = new Label("exposee Date:"+listexpose.get(i).getDatec());
           Image red = Image.createImage("file:///C:\\Users\\Admin\\Desktop\\integrationfinalpi\\mydir\\public\\images\\products\\3bc7fce0fe243dda73171e688c470e25.jpeg");
           ImageViewer  image;
           image = new ImageViewer (red);
           
        
        
        addAll(tfnom,tfdesc,image);
        }
         Button btnBlog = new Button("Retour");
        
        
        
        addAll(btnBlog);
           btnBlog.addActionListener(e->{
           
        new MenuForm(current).show();
     
       });
     
    }
    
}
