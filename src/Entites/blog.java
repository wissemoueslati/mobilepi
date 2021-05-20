/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;


import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Admin
 */
public class blog {
    private int id;
    private String titre;
    private String contenu;
    private String tags;
    private Date date_creation; 

    public blog(int id, String titre, String contenu, String tags, Date date_creation) {
        this.id = id;
        this.titre = titre;
        this.contenu = contenu;
        this.tags = tags;
        this.date_creation = date_creation;
    }

    public int getId() {
        return id;
    }

    public blog() {
    }

    public String getTitre() {
        return titre;
    }

    public String getContenu() {
        return contenu;
    }

    public String getTags() {
        return tags;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.id;
        hash = 53 * hash + Objects.hashCode(this.titre);
        hash = 53 * hash + Objects.hashCode(this.contenu);
        hash = 53 * hash + Objects.hashCode(this.tags);
        hash = 53 * hash + Objects.hashCode(this.date_creation);
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
        final blog other = (blog) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        if (!Objects.equals(this.contenu, other.contenu)) {
            return false;
        }
        if (!Objects.equals(this.tags, other.tags)) {
            return false;
        }
        if (!Objects.equals(this.date_creation, other.date_creation)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "blog{" + "id=" + id + ", titre=" + titre + ", contenu=" + contenu + ", tags=" + tags + ", date_creation=" + date_creation + '}';
    }

 
}
