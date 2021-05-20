/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import com.codename1.components.InfiniteProgress;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionListener;
import Entites.Categorie;
import utils.DataSource;
import java.util.ArrayList;
import org.json.JSONArray;

/**
 *
 * @author 21624
 */
public class CategorieService {
    
 private ConnectionRequest req;
 public ArrayList<Categorie> categorie;
 public static CategorieService instance=null;
 public boolean resultOK;
 
    public CategorieService() {
        req = new ConnectionRequest();
    }
    
   public static CategorieService getInstance() {
        if (instance == null) {
            instance = new CategorieService();
        }
        return instance;
    }
   
   public ArrayList<Categorie> parseCategorie(String jsonText){
      
            categorie=new ArrayList<>();
            System.out.println(jsonText);
            JSONArray arr = new JSONArray(jsonText);
            
            for (int i = 0; i < arr.length(); i++) {
                Categorie v=new Categorie();
               v.setId(arr.getJSONObject(i).getInt("id"));
                v.setNameCategorie(arr.getJSONObject(i).getString("nameCategorie"));
   
                v.setNbr_question(arr.getJSONObject(i).getInt("nbrQuestion"));
                v.setNbr_vue_categorie(arr.getJSONObject(i).getInt("nbrVueCategorie"));
                v.setTag(arr.getJSONObject(i).getString("Tag"));

                categorie.add(v);
                
        }
                
        
        return categorie;
    }
   
   public ArrayList<Categorie> getListVelo(){
        String url = DataSource.BASE_URL+"/categorie/listC";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                categorie = parseCategorie(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return categorie;
    }
   
   public boolean addcat(Categorie v) {
        String url = DataSource.BASE_URL + "/categorie/newCategorieM?nameCategorie=" + v.getNameCategorie()+ "&tagC=" + v.getTag(); //création de l'URL
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
             
                resultOK = req.getResponseCode() == 200; 
                req.removeResponseListener(this); 
                
            }
        });
        InfiniteProgress prog = new InfiniteProgress();
    Dialog dlg = prog.showInifiniteBlocking();
    req.setDisposeOnCompletion(dlg);
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
}
