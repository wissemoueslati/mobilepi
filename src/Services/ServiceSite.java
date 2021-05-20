/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import Entites.Site;
import utils.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Mohamed
 */
public class ServiceSite {
    
 public ArrayList<Site> gmusee;
        public ArrayList<Site> musee;

    public static ServiceSite instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    public ServiceSite() {
         req = new ConnectionRequest();
    }

    public static ServiceSite getInstance() {
        if (instance == null) {
            instance = new ServiceSite();
        }
        return instance;
    }

    

   
    
    
   
    public ArrayList<Site> parseTasks(String jsonText){
        try {
            gmusee=new ArrayList<>();
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

 
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
           
            for(Map<String,Object> obj : list){
                //Création des tâches et récupération de leurs données
                Site t = new Site();
                t.setNom(obj.get("nom").toString());
                t.setPlace(obj.get("place").toString());
                                t.setDescription(obj.get("description").toString());

                //Ajouter la tâche extraite de la réponse Json à la liste
                gmusee.add(t);
            }
            
            
        } catch (IOException ex) {
            
        }
         /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
        return gmusee;
    }
//------------------------------------------------------------
    
    public ArrayList<Site>        getAllTasks(){
        String url = DataSource.BASE_URL+"/siteh/mobile";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                gmusee= parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return gmusee;
    }
 

//***********Recherche***********************
    public ArrayList<Site> Recherche(String item){        
        ConnectionRequest con = new ConnectionRequest();
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceSite ser = new ServiceSite ();
                musee= ser.parseTasks(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return musee
              ;
    }

}


