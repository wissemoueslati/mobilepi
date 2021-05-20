/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entités;

/**
 *
 * @author 21624
 */
public class Reponse_like {
        private int id;
        private int reponse_id;
    private int user_id;
    private int reaction;

    public Reponse_like() {
    }

    public Reponse_like(int id, int reponse_id, int user_id, int reaction) {
        this.id = id;
        this.reponse_id = reponse_id;
        this.user_id = user_id;
        this.reaction = reaction;
    }

    public Reponse_like(int reponse_id, int user_id, int reaction) {
        this.reponse_id = reponse_id;
        this.user_id = user_id;
        this.reaction = reaction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReponse_id() {
        return reponse_id;
    }

    public void setReponse_id(int reponse_id) {
        this.reponse_id = reponse_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getReaction() {
        return reaction;
    }

    public void setReaction(int reaction) {
        this.reaction = reaction;
    }

    @Override
    public String toString() {
        return "Reponse_like{" + "id=" + id + ", reponse_id=" + reponse_id + ", user_id=" + user_id + ", reaction=" + reaction + '}';
    }

    
    
    
}