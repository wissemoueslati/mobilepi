/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

/**
 *
 * @author Mohamed
 */
public class Site {
           private int id ;
   private String nom,place,description,image;

    public Site() {
    }

    public Site( int id ,String nom, String place, String description, String image) {
       this.id= id ;
        this.nom = nom;
        this.place = place;
        this.image=image;
       
        this.description = description;
    }

   

    

  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    

   

    
   
    

   

   

    public String getNom() {
        return nom;
    }
     public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Gmusee{" +  ", nom=" + nom + ", place=" + place +  ",description=" + description+'}';
    }
    
}

