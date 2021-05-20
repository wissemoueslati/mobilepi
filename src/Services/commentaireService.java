/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entites.SendMail;
import Entites.blog;
import Entites.blogcomment;
import Entites.mailer;
import static Services.UserService.userconnected;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import utils.DataSource;

/**
 *
 * @author Iheb
 */
public class commentaireService {
       private ConnectionRequest req;
         private Form current;
    
        public void Ajouter(TextField contenu ,TextField email,TextField name){
        int code=10;
        req=new ConnectionRequest();
        String url= DataSource.BASE_URL+"/mob/mobile/Ajouc?=contenu="+contenu.getText()+"&name="+name.getText()+"&email="+email.getText();

        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp;
                jsonp=new JSONParser();
                String Json = new String(req.getResponseData()) + "";
                
                    }
                               
        });
         mailer m=new mailer() ;

          m.sendll(email.getText(),"Commentaire ajouter","fcfcf","azizhammami621@gmail.com","181JMT1043",code);
     NetworkManager.getInstance().addToQueueAndWait(req);
}
          public ArrayList <blogcomment> afficheblogcoemm (){
        ArrayList <blogcomment> result =new ArrayList <>();
        req=new ConnectionRequest();
        String url= DataSource.BASE_URL+"/mob/mobile/Blogcomment";

        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp;
                jsonp=new JSONParser();
                try{
                    Map<String,Object> mapRese=jsonp.parseJSON(new CharArrayReader(new String (req.getResponseData()).toCharArray()));
                    List <Map<String,Object>> listOfMap =(List <Map<String,Object>>) mapRese.get("root");
                    System.out.println("blogscoem"+mapRese.toString());
                    System.out.println(""+listOfMap.toString());
                    for( Map<String,Object> obj :listOfMap){
                        blogcomment r =new blogcomment();
                        
                      //   float id=Float.parseFloat(obj.get("id").toString());
                          String email=obj.get("email").toString();
                           String contenu=obj.get("Contenu").toString();
                          String name=obj.get("Name").toString();
                         
                            
                        //    String DateCon =obj.get("date_creation").toString().substring(obj.get("dateV").toString().indexOf("timestamp")+10,obj.get("dateV").toString().lastIndexOf("}"));
                     //   Date currenttime =new Date(Double.valueOf(DateCon).longValue()*1000);
                       // SimpleDateFormat formater=new SimpleDateFormat("yyyy-MM-dd");
                        //String DateS=formater.format(currenttime);
                        
                        r.setEmail(email);
                        r.setContenu(contenu);
                      
                        r.setName(name);
                       
                      
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
}
