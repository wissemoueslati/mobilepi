/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.entities;

import java.util.Objects;

/**
 *
 * @author gorgi
 */
public class ProduitM {
     
    private int id ,qte_prod ,categorie_id ;
    private String nom_prod ,description_prod,img_prod;
    private Double prix_prod ;
    private int categoriep;
    public ProduitM() {
        
    }

    
    

    public ProduitM(int id, int qte_prod, int categorie_id, String nom_prod, String description_prod, Double prix_prod,String img_prod) {
        this.id = id;
        
        this.qte_prod = qte_prod;
        this.categorie_id = categorie_id;
        this.nom_prod = nom_prod;
        this.description_prod = description_prod;
        this.prix_prod = prix_prod;
         this.img_prod = img_prod;
    }

    public ProduitM( int qte_prod, int categorie_id, String nom_prod, String description_prod, String img_prod, Double prix_prod) {
     
        this.qte_prod = qte_prod;
        this.categorie_id = categorie_id;
        this.nom_prod = nom_prod;
        this.description_prod = description_prod;
        this.img_prod = img_prod;
        this.prix_prod = prix_prod;
    }
    
     public ProduitM(int id, String nom_prod,String description_prod,int qte_prod ,double prix_prod, String img_prod) {
        this.id = id;
        this.nom_prod = nom_prod;
        this.qte_prod = qte_prod;
        this.description_prod = description_prod;
        this.prix_prod = prix_prod;
        this.img_prod = img_prod;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getQte_prod() {
        return qte_prod;
    }

    public void setQte_prod(int qte_prod) {
        this.qte_prod = qte_prod;
    }

    public int getCategorie_id() {
        return categorie_id;
    }

    public void setCategorie_id(int categorie_id) {
        this.categorie_id = categorie_id;
    }

    public String getNom_prod() {
        return nom_prod;
    }

    public void setNom_prod(String nom_prod) {
        this.nom_prod = nom_prod;
    }

    public String getDescription_prod() {
        return description_prod;
    }

    public void setDescription_prod(String description_prod) {
        this.description_prod = description_prod;
    }

    public String getImg_prod() {
        return img_prod;
    }

    public void setImg_prod(String img_prod) {
        this.img_prod = img_prod;
    }

    public Double getPrix_prod() {
        return prix_prod;
    }

    public void setPrix_prod(Double prix_prod) {
        this.prix_prod = prix_prod;
    }

    
   

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", qte_prod=" + qte_prod + ", categorie_id=" + categorie_id + ", nom_prod=" + nom_prod + ", description_prod=" + description_prod + ", img_prod=" + img_prod + ", prix_prod=" + prix_prod + '}';
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProduitM other = (ProduitM) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.qte_prod != other.qte_prod) {
            return false;
        }
        if (this.categorie_id != other.categorie_id) {
            return false;
        }
        if (!Objects.equals(this.nom_prod, other.nom_prod)) {
            return false;
        }
        if (!Objects.equals(this.description_prod, other.description_prod)) {
            return false;
        }
        if (!Objects.equals(this.img_prod, other.img_prod)) {
            return false;
        }
        if (!Objects.equals(this.prix_prod, other.prix_prod)) {
            return false;
        }
        return true;
    }

    public void getId(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getCategoriep() {
        return categoriep;
    }

    public void setCategoriep(int categoriep) {
        this.categoriep = categoriep;
    }
    
    
    
}
