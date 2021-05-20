/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.entities;

/**
 *
 * @author WSI
 */
public class Categorie {
    private int id,ref_cat ; 
    private String nom_cat;

    public Categorie(int id, int ref_cat, String nom_cat) {
        this.id = id;
        this.ref_cat = ref_cat;
        this.nom_cat = nom_cat;
    }

    public Categorie(int ref_cat, String nom_cat) {
        this.ref_cat = ref_cat;
        this.nom_cat = nom_cat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRef_cat() {
        return ref_cat;
    }

    public void setRef_cat(int ref_cat) {
        this.ref_cat = ref_cat;
    }

    public String getNom_cat() {
        return nom_cat;
    }

    public void setNom_cat(String nom_cat) {
        this.nom_cat = nom_cat;
    }
    
    
}
