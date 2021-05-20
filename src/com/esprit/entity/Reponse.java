/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.entity;

import com.esprit.entity.Question;
import java.util.Date;

/**
 *
 * @author 21624
 */
public class Reponse {
    






 private int id;
private int question_id;
private int user_id;
private String reponse;
private Question question;
private Date datereponse;

    public Reponse() {
    }

  

    
    
        public Reponse( int user_id, String reponse, Question question, Date datereponse) {
       
        this.user_id = user_id;
        this.reponse = reponse;
        this.question = question;
        this.datereponse = datereponse;
    }
        public Reponse( int user_id, String reponse, Question question) {
       
        this.user_id = user_id;
        this.reponse = reponse;
        this.question = question;
    
    }
    


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Date getDatereponse() {
        return datereponse;
    }

    public void setDatereponse(Date datereponse) {
        this.datereponse = datereponse;
    }




}
