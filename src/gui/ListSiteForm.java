/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.components.ImageViewer;
import static com.codename1.push.PushContent.setTitle;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import Entites.Site;
import Services.ServiceSite;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Mohamed
 */
public class ListSiteForm extends Form {
    
Form current;
 Resources theme;
 EncodedImage encImg;
 ImageViewer imgV;
 Image videImg;
 public Site e;
 //********************************************
 public Button btnrech;
  public  TextField rtitre;
  public  Label lb;
  public  Button btnaff;
//*********************************************
 

    public ListSiteForm(Form previous) throws IOException {
        
        
        
        
        
        

         btnrech=new Button("Chercher");
         rtitre = new TextField("","Site");
         lb = new Label("");
     
         
        add(rtitre);    
        add(btnrech);
       
          // f.add(btnaff);
        btnrech.addActionListener((e)->{
        //Recherche r=new Recherche();
        //r.getR().show();
        if(rtitre.getText().equalsIgnoreCase("") ){
             Dialog.show("alert","Entrer  !!", "ok", null);
                 ;}
        else{
        ServiceSite ser=new ServiceSite();
        lb.setText(ser.Recherche(rtitre.getText()).toString());
        }});
       add(lb);
    
        
        
        
        
        
        setTitle("Liste Des Sites");
    ArrayList<Site> data = new ArrayList<Site>();
    ServiceSite v = new ServiceSite();
    data = v.getAllTasks(); 
    Container cnt = new Container(BoxLayout.y());

                    
for(int i=0; i<data.size(); i++){ 
Label l1 = new Label(data.get(i).getNom());
Label l2 = new Label(data.get(i).getPlace());
Label l4 = new Label(data.get(i).getDescription());


              
cnt.add(l1);
cnt.add(l2); 


}  
    Button btnBlog = new Button("Retour");
        
        
        
        addAll(btnBlog);
           btnBlog.addActionListener(e->{
           
        new MenuForm(current).show();
     
       });  
add(cnt);
    
 
 


}}



