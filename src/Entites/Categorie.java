/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;



/**
 *
 * @author 21624
 */
public class Categorie {
 private int id;
 private int user_id;
 private String nameCategorie;
 private int nbr_question;
private int nbr_vue_categorie;
private String tag;

    public Categorie() {
    }

    public Categorie(int id, int user_id, String nameCategorie, int nbr_question, int nbr_vue_categorie, String tag) {
        this.id = id;
        this.user_id = user_id;
        this.nameCategorie = nameCategorie;
        this.nbr_question = nbr_question;
        this.nbr_vue_categorie = nbr_vue_categorie;
        this.tag = tag;
    }

    public Categorie(int user_id, String nameCategorie, int nbr_question, int nbr_vue_categorie, String tag) {
        this.user_id = user_id;
        this.nameCategorie = nameCategorie;
        this.nbr_question = nbr_question;
        this.nbr_vue_categorie = nbr_vue_categorie;
        this.tag = tag;
    }

    public Categorie(int user_id,String nameCategorie, String tag) {
        this.user_id = user_id;
        this.nameCategorie = nameCategorie;
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

    public String getNameCategorie() {
        return nameCategorie;
    }

    public void setNameCategorie(String nameCategorie) {
        this.nameCategorie = nameCategorie;
    }

    public int getNbr_question() {
        return nbr_question;
    }

    public void setNbr_question(int nbr_question) {
        this.nbr_question = nbr_question;
    }

    public int getNbr_vue_categorie() {
        return nbr_vue_categorie;
    }

    public void setNbr_vue_categorie(int nbr_vue_categorie) {
        this.nbr_vue_categorie = nbr_vue_categorie;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
    

}
