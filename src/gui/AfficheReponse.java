/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.components.ImageViewer;
import com.codename1.io.Log;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.table.TableLayout;
import PidevAziz.MyApplication;
import Entites.Categorie;
import Entites.Question;
import Entites.Reponse;
import Services.QuestionService;
import Services.ReponseService;
import Services.reponse_like_Service;
import entités.Reponse_like;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author 21624
 */
public class AfficheReponse extends Form{
         private Question q;
         int nbr;
         int nbrr;
         static int idd;
          Form current;
     public AfficheReponse(int id,Form previous) {
  current=this;
    idd=id;
           current.getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, 4, e-> previous.showBack());
         setTitle("Liste des Reponses");
         
        setLayout(BoxLayout.y());


        ArrayList<Reponse> r= ReponseService.getInstance().getListReponse(id);
        
         System.out.println(r.toString());

        for (int i = 0; i < r.size(); i++) {
            System.out.println(r.get(i));
            try {
                add(addReponseHolder(r.get(i)));
            } catch (IOException ex) {
               // Logger.getLogger(afficher_velo.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
                Form h = new Form("Ajouter une reponse", new BoxLayout(BoxLayout.Y_AXIS));
       // Label l =new Label("Ajouter une Categorie");
                TextField tfNomR = new TextField("","reponse");
        
        h.addAll(tfNomR);
        Button AjouterRep =new Button("Ajouter ");
        addAll(h,AjouterRep);
              AjouterRep.addActionListener(e-> {
          //  Dialog.show(c.getId()+" ", c.getId()+" ", "OK", null);
          Reponse ca = new Reponse(1,tfNomR.getText(),q);
        ReponseService.getInstance().addrep(ca,id,1);
                   AfficheReponse aff = new AfficheReponse(idd,previous);
    
        aff.show();
       
         
           
           });    
   
         h.setScrollable(false);
    }
    
    public Container addReponseHolder(Reponse c) throws IOException  {
    TableLayout t1 = new TableLayout(1,4);
    t1.cc().widthPercentage(10);
        Container holder = new Container(BoxLayout.x());

     
        
        Container f;

        

Form hi = new Form(ReponseService.getInstance().getUserM(c.getUser_id())+" a repondu :", new BoxLayout(BoxLayout.Y_AXIS));
hi.setScrollable(false);
Label likee = new Label(nbr+"");
Label dislikee = new Label(nbrr+"");
        Container png = new Container(BoxLayout.x());
        EncodedImage enc;
        EncodedImage enc1;
        enc= EncodedImage.createFromImage(MyApplication.theme.getImage("like.png"),false).scaledEncoded(70, 70);
        ImageViewer image = new ImageViewer();
        image.setImage(enc);
 
        enc1= EncodedImage.createFromImage(MyApplication.theme.getImage("dislike.png"),false).scaledEncoded(70, 70);
        ImageViewer imagee = new ImageViewer();
        imagee.setImage(enc1);
        
        Button like =new Button(image.getImage());
        Button dislike =new Button(imagee.getImage());
        like.addActionListener(e-> {
           
         reponse_like_Service.getInstance().addreactionlike(c.getId());
         nbr+=1;
         likee.setText(""+nbr);
//            AfficheReponse aff = new AfficheReponse(idd);
//        aff.show();
            System.out.println(nbr);
           });    
        
        dislike.addActionListener(e-> {
            reponse_like_Service.getInstance().addreactiondislike(c.getId());  
         nbrr+=1;
         dislikee.setText(""+nbrr);
           
           });    
        
     png.addAll(like,likee,dislike,dislikee);
               
            
        
hi.addAll(new Label(c.getReponse()),png);

        return hi;
}   
}
