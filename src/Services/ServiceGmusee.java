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
import Entites.Gmusee;
import utils.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bhk
 */
public class ServiceGmusee {

    public ArrayList<Gmusee> gmusee;
        public ArrayList<Gmusee> musee;

    public static ServiceGmusee instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    public ServiceGmusee() {
         req = new ConnectionRequest();
    }

    public static ServiceGmusee getInstance() {
        if (instance == null) {
            instance = new ServiceGmusee();
        }
        return instance;
    }

    

   
    
    
   
    public ArrayList<Gmusee> parseTasks(String jsonText){
        try {
            gmusee=new ArrayList<>();
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

 
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
           
            for(Map<String,Object> obj : list){
                //Création des tâches et récupération de leurs données
                Gmusee t = new Gmusee();
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
    
    public ArrayList<Gmusee>        getAllTasks(){
        String url = DataSource.BASE_URL+"/gmusee/mobile";
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
    public ArrayList<Gmusee> Recherche(String item){        
        ConnectionRequest con = new ConnectionRequest();
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceGmusee ser = new ServiceGmusee();
                musee= ser.parseTasks(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return musee
              ;
    }

}

