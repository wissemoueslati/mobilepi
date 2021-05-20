/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entites.Exposee;
import Entites.SendMail;
import Entites.User;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.sun.mail.smtp.SMTPTransport;
import gui.ExposeeForm;
import gui.MenuForm;
import gui.loginform;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import utils.DataSource;

/**
 *
 * @author Admin
 */
public class UserService {

    private ConnectionRequest req;
    static User userconnected;
    static String Mailer;
     private Form current;

    public void register(TextField email, TextField name, TextField mdp, TextField tel,TextField image) {
        req = new ConnectionRequest();
        String url = DataSource.BASE_URL + "/mob/user/mobile/inscription?email=" + email.getText().toString() + "&username=" + name.getText().toString() + "&password=" + mdp.getText().toString() + "&tel=" + tel.getText().toString()+"&image="+image.getText();
        req.setUrl(url);
        req.addResponseListener((e) -> {
            JSONParser jsonp = new JSONParser();
            String Json = new String(req.getResponseData()) + "";
            try {
                Map<String, Object> user = jsonp.parseJSON(new CharArrayReader(Json.toCharArray()));

                if (user.size() > 0) {
                    System.out.println("lkal user");
                    User us = new User();
                        float id = Float.parseFloat(user.get("id").toString());
                        float code = Float.parseFloat(user.get("code").toString());
                        float telus = Float.parseFloat(user.get("tel").toString());
                        us.setId((int) id);
                        us.setEmail(user.get("email").toString());
                        us.setName(user.get("name").toString());
                        us.setRoles(user.get("roles").toString());
                        us.setCode((int) code);
                        us.setPassword(user.get("password").toString());
                        us.setTel((int) telus);
                        Mailer=us.getEmail();
                        

                        userconnected = us;
                     SendMail m=new SendMail() ;
                   m.send(userconnected.getEmail(),"Activation du compte",String.valueOf(code),"azizhammami621@gmail.com","181JMT1043",userconnected.getCode());
                     

                }
            } catch (IOException ex) {

            }

        });

        NetworkManager.getInstance().addToQueueAndWait(req);

    }

    public User check() {
        return userconnected;
    }
     public String getmailer(){
        return Mailer;
    }

    public void login(TextField email, TextField mdp) {
        req = new ConnectionRequest();
        String url = DataSource.BASE_URL + "/mob/user/mobile/login?email=" + email.getText().toString() + "&password=" + mdp.getText().toString();
        req.setUrl(url);
        req.addResponseListener((e) -> {
            JSONParser jsonp;
            jsonp = new JSONParser();
            String Json = new String(req.getResponseData()) + "";
            try {
                if (Json.equals("failed")) {
                    Dialog.show("Echec", "email ou mdp eronne", "OK", null);
                } else {
                    Map<String, Object> user = jsonp.parseJSON(new CharArrayReader(Json.toCharArray()));

                    String ss = user.get("roles").toString();

                    if (user.size() > 0) {

                        User us = new User();
                        float id = Float.parseFloat(user.get("id").toString());
                        float code = Float.parseFloat(user.get("code").toString());
                        float tel = Float.parseFloat(user.get("tel").toString());
                        us.setId((int) id);
                        us.setEmail(user.get("email").toString());
                        us.setName(user.get("name").toString());
                        us.setRoles(user.get("roles").toString());
                        us.setCode((int) code);
                        us.setPassword(user.get("password").toString());
                        us.setTel((int) tel);
                        Mailer=us.getEmail();
                      
               new MenuForm(current).show();

                        

                        userconnected = us;
                        if (userconnected.getRoles().equals("[ROLE_USER]")) {
                           
                        }

                    } else {
                        System.out.println("ma fam chay sahby");
                    }
                }

            } catch (IOException ex) {
            }

        });
        NetworkManager.getInstance().addToQueueAndWait(req);

    }
    
    public boolean verifcode(TextField code){
        int testcode=Integer.parseInt(code.getText());
        if(testcode==userconnected.getCode()){
            return true;
        }else{
            return false;
        }
    }
    
    public void verifcodeuser(TextField code){
         req = new ConnectionRequest();
        String url = DataSource.BASE_URL + "/mob/activation?code=" + code.getText().toString();
        req.setUrl(url);
        req.addResponseListener((e) -> {
            JSONParser jsonp;
            jsonp = new JSONParser();
            String Json = new String(req.getResponseData()) + ""; });
    NetworkManager.getInstance().addToQueueAndWait(req);
    }
    public void logout(){
        User u=new User();
        userconnected =u;
    }
    
    public void changepsword(TextField newmdp,TextField password,TextField email){
        req = new ConnectionRequest();
        String url = DataSource.BASE_URL + "/mob/mdpoublier?email=" +email.getText().toString()+"&password="+password.getText().toString()+"&nwpassword="+newmdp.getText().toString();
        req.setUrl(url);
        req.addResponseListener((e) -> {
            JSONParser jsonp;
            jsonp = new JSONParser();
            String Json = new String(req.getResponseData()) + ""; });
    NetworkManager.getInstance().addToQueueAndWait(req); 
    }
    
      
}
