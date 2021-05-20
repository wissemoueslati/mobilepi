/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.PIDEVM.myapp.MyApplication;
import com.codename1.components.ImageViewer;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.util.DateUtil;
import com.esprit.entities.Commande;
import com.esprit.entities.ProduitM;
import com.esprit.service.CommandeService;
import com.esprit.service.ProduitService;
import com.esprit.utils.image_static;
import java.util.Date;
//import java.time.LocalDate;
import java.util.Map;

/**
 *
 * @author gorgi
 */
public class acheter_prod extends Form {
    EncodedImage enc;
    Form current;
     public acheter_prod(int id, Form previous)   {
         current= this;
        current.getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, 4, e-> previous.showBack());
        setLayout(BoxLayout.y());
        setTitle("achat d'un produit");
        ProduitM prod = ProduitService.getInstance().getListProduit_by_id(id);
        TextField datee = new TextField();
        String pattern = "dd-MM-yyyy";
SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
String date = simpleDateFormat.format(new Date());
         Label dt = new Label("date : ");
         Label pr = new Label("prix : ");
         Label email = new Label("E-mail");
         Label num = new Label("numero de telephone ");
         Label add = new Label("adress");
        datee.setText(date);
        
        datee.setEditable(false);
        TextField mail = new TextField("","E-mail");
        TextField numtel= new TextField("", "numero de telephone");
        TextField adresse = new TextField("","adresse");
       ComboBox<String> combo = new ComboBox<> ();
       combo.addItem("en ligne ");
       combo.addItem("à la livraison ");
          Button btnvalider = new Button("payer à la livraison");
          Button btnenligne  = new Button("payer en ligne");
          btnvalider.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    double prix= prod.getPrix_prod();
                    int prixx= (int) (float) prix;
                 Commande c = new Commande(prixx,"a la livraison",adresse.getText(),Integer.parseInt(numtel.getText()),mail.getText());   
                     CommandeService.getInstance().addvelo(prod.getId(),c);
                     Dialog.show("achat", "achat effectue ! ", "OK", null);
                      Afficher_ProduitGUI f1= new Afficher_ProduitGUI();
       f1.show();   
                }
            });
           Container imagev = new Container(BoxLayout.x());
          enc= EncodedImage.createFromImage(MyApplication.theme.getImage("loading.jpg").scaled(1000, 700),true);
        Image imgs = URLImage.createToStorage(enc, image_static.IMAGE_BASE_URL+"/"+prod.getImg_prod(),  image_static.IMAGE_BASE_URL+"/"+prod.getImg_prod()).scaled(1200, 1200);
        ImageViewer image = new ImageViewer(imgs);
        imagev.add(image);
          Container details = new Container(BoxLayout.y());
          Label marque = new Label(prod.getNom_prod());
           details.addAll(marque,imagev);
          TextField prr = new TextField();
           prr.setEditable(false);
          prr.setText(prod.getPrix_prod()+" DT");
          Container timedate = new Container(BoxLayout.y());
          timedate.addAll(dt,datee);
           Container maill = new Container(BoxLayout.y());
          maill.addAll(email,mail);
           Container numm = new Container(BoxLayout.y());
          numm.addAll(num,numtel);
           Container addd = new Container(BoxLayout.y());
          addd.addAll(add,adresse);
          Container prixxx = new Container(BoxLayout.y());
          prixxx.addAll(pr,prr);
          Container buttons = new Container(BoxLayout.x());
          prixxx.addAll(btnvalider);
          addAll(details,timedate,maill,numm,addd,prixxx,buttons);
    
}
}
