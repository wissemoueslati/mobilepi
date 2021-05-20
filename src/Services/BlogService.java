/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import Entites.blog;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import utils.DataSource;

/**
 *
 * @author Iheb
 */
public class BlogService {
    
    private ConnectionRequest req;
         private Form current;
    public ArrayList <blog> afficheblogs (){
        ArrayList <blog> result =new ArrayList <>();
        req=new ConnectionRequest();
        String url= DataSource.BASE_URL+"/mob/mobile/Blog";

        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp;
                jsonp=new JSONParser();
                try{
                    Map<String,Object> mapRese=jsonp.parseJSON(new CharArrayReader(new String (req.getResponseData()).toCharArray()));
                    List <Map<String,Object>> listOfMap =(List <Map<String,Object>>) mapRese.get("root");
                  
                    for( Map<String,Object> obj :listOfMap){
                        blog r =new blog();
                        
                         float id=Float.parseFloat(obj.get("id").toString());
                          String titre=obj.get("titre").toString();
                           String contenu=obj.get("contenu").toString();
//                           String tags=obj.get("tags").toString();
                         
                           
                        //    String DateCon =obj.get("date_creation").toString().substring(obj.get("dateV").toString().indexOf("timestamp")+10,obj.get("dateV").toString().lastIndexOf("}"));
                     //   Date currenttime =new Date(Double.valueOf(DateCon).longValue()*1000);
                       // SimpleDateFormat formater=new SimpleDateFormat("yyyy-MM-dd");
                        //String DateS=formater.format(currenttime);
                        
                        r.setId((int)id);
                        r.setContenu(contenu);
                      
                        r.setTitre(titre);
                       
                 
                       result.add(r);
                        
                    
                    }
                    
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return result;
        
                    }
    /*
    public void supprimerRes(int id){
        
        req=new ConnectionRequest();
        String url= DataSource.BASE_URL+"/mobile/suppR?id="+id;

        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp;
                jsonp=new JSONParser();
                String Json = new String(req.getResponseData()) + "";
                
                    }
        });
        
          NetworkManager.getInstance().addToQueueAndWait(req);
    }
    public void ajouterRes(TextField email,TextField cin,TextField tel){
         req=new ConnectionRequest();
        String url= DataSource.BASE_URL+"/mobile/reservation/ajouterRes?email="+email.getText().toString()+"&cin="+cin.getText().toString()+"&tel="+tel.getText().toString();

        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp;
                jsonp=new JSONParser();
                 SendMail m=new SendMail() ;
                   m.send(email.getText(),"Activation du compte",tel.getText(),"jihenedorgham72@gmail.com","181JMT1043",12);
                
                    }
        });
         NetworkManager.getInstance().addToQueueAndWait(req);
    }
    
        public void UpdateRes(TextField email,TextField cin,TextField tel,int id){
         req=new ConnectionRequest();
        String url= DataSource.BASE_URL+"/mobile/reservation/updateRes?id="+id+"&email="+email.getText().toString()+"&cin="+cin.getText().toString()+"&tel="+tel.getText().toString();

        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp;
                jsonp=new JSONParser();
           
                
               }});
         NetworkManager.getInstance().addToQueueAndWait(req);
    }*/
}
