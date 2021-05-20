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
public class Produit {
    private int id ,refProd,qteProd;
    private String nomProd;
    private Float prixProd;
    private Categorie categorie;
    private Images images;

    public Produit(int id, int refProd, int qteProd, String nomProd, Float prixProd) {
        this.id = id;
        this.refProd = refProd;
        this.qteProd = qteProd;
        this.nomProd = nomProd;
        this.prixProd = prixProd;
    }

    public Produit(int refProd, int qteProd, String nomProd, Float prixProd) {
        this.refProd = refProd;
        this.qteProd = qteProd;
        this.nomProd = nomProd;
        this.prixProd = prixProd;
    }

    public Produit() {
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRefProd() {
        return refProd;
    }

    public void setRefProd(int refProd) {
        this.refProd = refProd;
    }

    public int getQteProd() {
        return qteProd;
    }

    public void setQteProd(int qteProd) {
        this.qteProd = qteProd;
    }


  
    public String getNomProd() {
        return nomProd;
    }

    public void setNomProd(String nomProd) {
        this.nomProd = nomProd;
    }

    public Float getPrixProd() {
        return prixProd;
    }

    public void setPrixProd(Float prixProd) {
        this.prixProd = prixProd;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

 

   

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", ref_prod=" + refProd + ", qte_prod=" + qteProd + ", nom_prod=" + nomProd+ ", prix_prod=" + prixProd + '}';
    }
    
    
    
}
