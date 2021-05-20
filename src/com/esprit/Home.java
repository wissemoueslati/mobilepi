/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;
import com.esprit.gui.ListProduits;


/**
 *
 * @author WSI
 */
public class Home extends Form{
    public Home() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public Home(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

    protected com.codename1.ui.Button gui_Button = new com.codename1.ui.Button();
    Form current;

    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        current = this;
        setTitle("Home");
        setLayout(BoxLayout.y());
       
        
      
        Button btnListProduit = new Button("Afficher Produits");
       
        btnListProduit.addActionListener(e-> new ListProduits(current).show());
        addAll(btnListProduit);
    }// </editor-fold>
    
    
    
    
}
