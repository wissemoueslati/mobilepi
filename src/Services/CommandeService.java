/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import Entites.Commande;
import Entites.ProduitM;
import utils.DataSource;
//import com.esprit.entities.Commande;
import java.util.ArrayList;
import org.json.JSONArray;



public class CommandeService {
    
      public static CommandeService instance=null;
      private ConnectionRequest req;
        public boolean resultOK;
        public ArrayList<ProduitM> produit;

    public CommandeService() {
        req = new ConnectionRequest();
    }
    
    public static CommandeService getInstance() {
        if (instance == null) {
            instance = new CommandeService();
        }
        return instance;
    }
    
   public boolean addvelo(int id, Commande c) {
        String url = DataSource.BASE_URL + "/commande/commandeajoutmobile"+id+"?modepaiement=" +c.getModepaiement()+ "&address=" + c.getAddressecom()+ "&num=" + c.getNumtel()+ "&mail=" + c.getMail(); //création de l'URL
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
             
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this); //Supprimer cet actionListener
                /* une fois que nous avons terminé de l'utiliser.
                La ConnectionRequest req est unique pour tous les appels de 
                n'importe quelle méthode du Service task, donc si on ne supprime
                pas l'ActionListener il sera enregistré et donc éxécuté même si 
                la réponse reçue correspond à une autre URL(get par exemple)*/
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
       public void ajouterpanier(int id){
        String url = DataSource.BASE_URL+"/panier/add/"+id;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
           @Override
            public void actionPerformed(NetworkEvent evt) {
             
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this); //Supprimer cet actionListener
                /* une fois que nous avons terminé de l'utiliser.
                La ConnectionRequest req est unique pour tous les appels de 
                n'importe quelle méthode du Service task, donc si on ne supprime
                pas l'ActionListener il sera enregistré et donc éxécuté même si 
                la réponse reçue correspond à une autre URL(get par exemple)*/
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
       System.out.println("produit ajoutee");
    } 
      
   public ArrayList<ProduitM> parsepanier(String jsonText){
      
            produit=new ArrayList<>();
            System.out.println(jsonText);
            JSONArray arr = new JSONArray(jsonText);
            //JSONArray arr = obj.getJSONArray("list_velo");
            for (int i = 0; i < arr.length(); i++) {
                ProduitM v=new ProduitM();
                v.setId(arr.getJSONObject(i).getInt("id"));
                v.setNom_prod(arr.getJSONObject(i).getString("nom_prod"));
                v.setDescription_prod(arr.getJSONObject(i).getString("description_prod"));
                v.setQte_prod(arr.getJSONObject(i).getInt("qte_prod"));
                v.setPrix_prod(arr.getJSONObject(i).getDouble("prix_prod"));
                v.setImg_prod(arr.getJSONObject(i).getString("img_prod"));
                produit.add(v);
                
        }
            return produit;
}

public ArrayList<ProduitM> getlistpanier(){
        String url = DataSource.BASE_URL+"/panniermobilef";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                produit = parsepanier(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return produit;
    }

 public boolean supprimerpanier(int id) {
        String url = DataSource.BASE_URL +"/removemobile/"+id; //création de l'URL
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
             
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this); //Supprimer cet actionListener
                /* une fois que nous avons terminé de l'utiliser.
                La ConnectionRequest req est unique pour tous les appels de 
                n'importe quelle méthode du Service task, donc si on ne supprime
                pas l'ActionListener il sera enregistré et donc éxécuté même si 
                la réponse reçue correspond à une autre URL(get par exemple)*/
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

}
 