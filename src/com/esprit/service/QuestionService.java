/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.service;

import com.codename1.components.InfiniteProgress;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionListener;
import com.esprit.entity.Categorie;
import com.esprit.entity.Question;
import com.esprit.utils.Statics;
import java.util.ArrayList;
import org.json.JSONArray;

/**
 *
 * @author 21624
 */
public class QuestionService {
  private ConnectionRequest req;
 public ArrayList<Question> question;
 public static QuestionService instance=null;
  public boolean resultOK;
 
    public QuestionService() {
        req = new ConnectionRequest();
    }
    
   public static QuestionService getInstance() {
        if (instance == null) {
            instance = new QuestionService();
        }
        return instance;
    }
   
   public ArrayList<Question> parseQuestion(String jsonText){
      
            question=new ArrayList<>();
            System.out.println(jsonText);
            JSONArray arr = new JSONArray(jsonText);
            
            for (int i = 0; i < arr.length(); i++) {
                Question v=new Question();
              v.setId(arr.getJSONObject(i).getInt("id"));
                v.setQuestion(arr.getJSONObject(i).getString("question"));
   
                v.setNbr_reponse(arr.getJSONObject(i).getInt("nbrReponse"));
                v.setNbr_vue(arr.getJSONObject(i).getInt("nbrVue"));
                v.setTag(arr.getJSONObject(i).getString("Tag"));

                question.add(v);
                
        }
                
        
        return question;
    }
   
   public ArrayList<Question> getListQuestion(int id){
        String url = Statics.BASE_URL+"/question/listQ/"+id;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                question = parseQuestion(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return question;
    } 
   
      public boolean addques(Question v,int id) {
        String url = Statics.BASE_URL + "/question/newQuestionM/"+id+ "?question=" + v.getQuestion()+ "&tagQ=" + v.getTag(); //création de l'URL
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
