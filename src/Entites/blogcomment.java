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
public class blogcomment {
    private int id;
    private int blog_id;
    private String contenu;
    private Date time;
    private String name;
    private String email;

    public blogcomment() {
    }

    public blogcomment(int id, int blog_id, String contenu, Date time, String name, String email) {
        this.id = id;
        this.blog_id = blog_id;
        this.contenu = contenu;
        this.time = time;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public int getBlog_id() {
        return blog_id;
    }

    public String getContenu() {
        return contenu;
    }

    public Date getTime() {
        return time;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBlog_id(int blog_id) {
        this.blog_id = blog_id;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.id;
        hash = 37 * hash + this.blog_id;
        hash = 37 * hash + Objects.hashCode(this.contenu);
        hash = 37 * hash + Objects.hashCode(this.time);
        hash = 37 * hash + Objects.hashCode(this.name);
        hash = 37 * hash + Objects.hashCode(this.email);
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
        final blogcomment other = (blogcomment) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.blog_id != other.blog_id) {
            return false;
        }
        if (!Objects.equals(this.contenu, other.contenu)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.time, other.time)) {
            return false;
        }
        return true;
    }
    
}
