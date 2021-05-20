/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

import java.util.Date;



 
 
public class Commande {
       
    private int id;
    private  float prixtot;
    private Date datecomm;
    private String modepaiement;
    private String etatcomm;
    private String addressecom;
    private int numtel;
    private String mail;

    public Commande() {
    }

    public Commande(int id, float prixtot, Date datecomm, String modepaiement, String etatcomm, String addressecom, int numtel, String mail) {
        this.id = id;
        this.prixtot = prixtot;
        this.datecomm = datecomm;
        this.modepaiement = modepaiement;
        this.etatcomm = etatcomm;
        this.addressecom = addressecom;
        this.numtel = numtel;
        this.mail = mail;
    }

    public Commande(Date datecomm,String etatcomm,String modepaiement,String addressecom,String mail, int numtel,float prixtot) {
        
        this.datecomm = datecomm;
        this.etatcomm = etatcomm;
        this.modepaiement = modepaiement;
        this.addressecom = addressecom;
        this.mail = mail;
        this.numtel = numtel;
        this.prixtot = prixtot;
    }

    public Commande(Date datecomm, String addressecom, String mail, int numtel ,float prixtot) {
        
        
        this.prixtot = prixtot;
        this.datecomm = datecomm;
        this.addressecom = addressecom;
        this.numtel = numtel;
        this.mail = mail;
    }
    

    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrixtot() {
        return prixtot;
    }

    public void setPrixtot(float prixtot) {
        this.prixtot = prixtot;
    }

    public Date getDatecomm() {
        return datecomm;
    }

    public void setDatecomm(Date datecomm) {
        this.datecomm = datecomm;
    }

    public String getModepaiement() {
        return modepaiement;
    }

    public void setModepaiement(String modepaiement) {
        this.modepaiement = modepaiement;
    }

    public String getEtatcomm() {
        return etatcomm;
    }

    public void setEtatcomm(String etatcomm) {
        this.etatcomm = etatcomm;
    }

    public String getAddressecom() {
        return addressecom;
    }

    public void setAddressecom(String addressecom) {
        this.addressecom = addressecom;
    }

    public int getNumtel() {
        return numtel;
    }

    public void setNumtel(int numtel) {
        this.numtel = numtel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Commande{" + "id=" + id + ", prixtot=" + prixtot + ", datecomm=" + datecomm + ", modepaiement=" + modepaiement + ", etatcomm=" + etatcomm + ", addressecom=" + addressecom + ", numtel=" + numtel + ", mail=" + mail + '}';
    }
   // Commande(prod.getPrix_prod(),"a la livraison",adress.getText(),Double.parseDouble(numtel.getText()),mail.getText());   

    public Commande(float prixtot, String modepaiement, String addressecom, int numtel, String mail) {
        this.prixtot = prixtot;
        this.modepaiement = modepaiement;
        this.addressecom = addressecom;
        this.numtel = numtel;
        this.mail = mail;
    }
    
    
    
    
}
