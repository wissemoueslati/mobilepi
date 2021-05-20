/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.entity;

/**
 *
 * @author 21624
 */
public class Question {
    
    private int id;
    private int user_id;
    private int categorie_id;
    private String question;
    private Categorie categorie;
    private int nbr_vue;
    private int nbr_reponse;  
    private String tag;

    public Question() {
    }

    public Question(int user_id, int categorie_id, String question, Categorie categorie, int nbr_vue, int nbr_reponse, String tag) {
        this.user_id = user_id;
        this.categorie_id = categorie_id;
        this.question = question;
        this.categorie = categorie;
        this.nbr_vue = nbr_vue;
        this.nbr_reponse = nbr_reponse;
        this.tag = tag;
    }
        public Question(int user_id, int categorie_id, String question, int nbr_vue, int nbr_reponse, String tag) {
        this.user_id = user_id;
        this.categorie_id = categorie_id;
        this.question = question;
   
        this.nbr_vue = nbr_vue;
        this.nbr_reponse = nbr_reponse;
        this.tag = tag;
    }

    public Question(int id, int user_id, int categorie_id, String question, Categorie categorie, int nbr_vue, int nbr_reponse, String tag) {
        this.id = id;
        this.user_id = user_id;
        this.categorie_id = categorie_id;
        this.question = question;
        this.categorie = categorie;
        this.nbr_vue = nbr_vue;
        this.nbr_reponse = nbr_reponse;
        this.tag = tag;
    }
    
        public Question( int user_id, String question, Categorie categorie, String tag) {
        this.user_id = user_id;
        this.question = question;
        this.categorie = categorie;
        this.tag = tag;
    }
                public Question( int user_id, String question, String tag) {
        this.user_id = user_id;
        this.question = question;
       
        this.tag = tag;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCategorie_id() {
        return categorie_id;
    }

    public void setCategorie_id(int categorie_id) {
        this.categorie_id = categorie_id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public int getNbr_vue() {
        return nbr_vue;
    }

    public void setNbr_vue(int nbr_vue) {
        this.nbr_vue = nbr_vue;
    }

    public int getNbr_reponse() {
        return nbr_reponse;
    }

    public void setNbr_reponse(int nbr_reponse) {
        this.nbr_reponse = nbr_reponse;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
 
    
}
