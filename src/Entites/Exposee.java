/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author Admin
 */
public class Exposee {

    private int id;
    private String datec;
    private String nom;
    private String description;
    private String[] images;

    public Exposee() {
    }

    public Exposee(int id, String datec, String nom, String description, String[] images) {
        this.id = id;
        this.datec = datec;
        this.nom = nom;
        this.description = description;
        this.images = images;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDatec() {
        return datec;
    }

    public void setDatec(String datec) {
        this.datec = datec;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "Exposee{" + "id=" + id + ", datec=" + datec + ", nom=" + nom + ", description=" + description + ", images=" + images + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.datec);
        hash = 37 * hash + Objects.hashCode(this.nom);
        hash = 37 * hash + Objects.hashCode(this.description);
        hash = 37 * hash + Arrays.deepHashCode(this.images);
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
        final Exposee other = (Exposee) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.datec, other.datec)) {
            return false;
        }
        if (!Arrays.deepEquals(this.images, other.images)) {
            return false;
        }
        return true;
    }
    
    

}
