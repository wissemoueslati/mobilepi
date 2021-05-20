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
import Entites.ProduitM;
import utils.DataSource;
import java.util.ArrayList;
import org.json.JSONArray;

/**
 *
 * @author gorgi
 */
public class ProduitService {
    public ArrayList<ProduitM> produit;
     public ArrayList<ProduitM> prodd;
    ProduitM v=new ProduitM();
    private ConnectionRequest req;
    public static ProduitService instance=null;
    public String retour=""; 
    public boolean resultOK;
    
    
    public ProduitService() {
        req = new ConnectionRequest();
} 
    
 public static ProduitService getInstance() {
        if (instance == null) {
            instance = new ProduitService();
        }
        return instance;
    }   
    
  public ArrayList<ProduitM> parseProduit(String jsonText){
      
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
  
  
  public ArrayList<ProduitM> getListProduit(){
        String url = DataSource.BASE_URL+"/listproduitmobile";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                produit = parseProduit(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return produit;
    }
  
  public ProduitM parseoneVeloav(String jsonText){
      
            
            System.out.println(jsonText);
            JSONArray arr = new JSONArray(jsonText);
            //JSONArray arr = obj.getJSONArray("list_velo");
            
                 for (int i = 0; i < arr.length(); i++) {
               
               v.setId(arr.getJSONObject(i).getInt("id"));
                v.setNom_prod(arr.getJSONObject(i).getString("nom_prod"));
                v.setDescription_prod(arr.getJSONObject(i).getString("description_prod"));
                v.setQte_prod(arr.getJSONObject(i).getInt("qte_prod"));
                v.setPrix_prod(arr.getJSONObject(i).getDouble("prix_prod"));
                v.setImg_prod(arr.getJSONObject(i).getString("img_prod"));
        
        }
               
                
        
                
        
        return v;
    }
  public ProduitM getListProduit_by_id(int id){
        String url = DataSource.BASE_URL+"/det_prod"+id;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                v = parseoneVeloav(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return v;
    }


   public ArrayList<ProduitM> parseProduitsearch(String jsonText){
      
            prodd=new ArrayList<>();
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
                
                prodd.add(v);
                
        }
                
        
        return prodd;
    }
   public ArrayList<ProduitM> searchproduit(String value ){
       
        String url = DataSource.BASE_URL+"/recherchemobile/mahmoud?searchValue="+value;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                prodd = parseProduitsearch(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return prodd;
    }
}
