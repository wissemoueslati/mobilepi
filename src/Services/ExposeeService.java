/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entites.Exposee;
import com.codename1.io.CharArrayReader;
import java.util.ArrayList;
import utils.DataSource;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.ui.events.ActionListener;
import java.util.List;
import java.util.Map;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Admin
 */
public class ExposeeService {
     
    private ConnectionRequest req;
    public ArrayList <Exposee> afficheExposee (){
        ArrayList <Exposee> result =new ArrayList <>();
        req=new ConnectionRequest();
        String url= DataSource.BASE_URL+"/mob/afficheexposee";

        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp;
                jsonp=new JSONParser();
                try{
                    Map<String,Object> mapExposee=jsonp.parseJSON(new CharArrayReader(new String (req.getResponseData()).toCharArray()));
                    List <Map<String,Object>> listOfMap =(List <Map<String,Object>>) mapExposee.get("root");
                  
                    for( Map<String,Object> obj :listOfMap){
                        Exposee e=new Exposee();
                        float id=Float.parseFloat(obj.get("id").toString());
                        String Desc= obj.get("description").toString();
                        String nom= obj.get("nom").toString();
                     
                        String DateCon =obj.get("dateC").toString().substring(obj.get("dateC").toString().indexOf("timestamp")+10,obj.get("dateC").toString().lastIndexOf("}"));
                        Date currenttime =new Date(Double.valueOf(DateCon).longValue()*1000);
                        SimpleDateFormat formater=new SimpleDateFormat("yyyy-MM-dd");
                        String DateS=formater.format(currenttime);
                        System.out.println(DateS);
                       e.setDatec(DateS);
                       e.setDescription(Desc);
                       e.setId((int)id);
                       e.setNom(nom);
                   
                       result.add(e);
                        
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
