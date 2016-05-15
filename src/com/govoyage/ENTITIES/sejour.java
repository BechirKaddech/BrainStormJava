
package com.govoyage.ENTITIES;


import java.util.Date;

/**
 *
 * @author Saidi
 */
public class sejour {
    private  int id;
    private Date dateDepart;
    private Date dateArrive;
    private double prix;
    private Hotel Hotel;
    private ville Ville;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public Date getDateArrive() {
        return dateArrive;
    }

    public void setDateArrive(Date dateArrive) {
        this.dateArrive = dateArrive;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Hotel getHotel() {
        return Hotel;
    }

    public void setHotel(Hotel Hotel) {
        this.Hotel = Hotel;
    }

    public ville getVille() {
        return Ville;
    }

    public void setVille(ville Ville) {
        this.Ville = Ville;
    }

    public sejour() {
    }

    public sejour(int id, Date dateDepart, Date dateArrive, double prix, Hotel Hotel, ville Ville) {
        this.id = id;
        this.dateDepart = dateDepart;
        this.dateArrive = dateArrive;
        this.prix = prix;
        this.Hotel = Hotel;
        this.Ville = Ville;
    }

    @Override
    public String toString() {
        return "sejour{" + "id=" + id + ", dateDepart=" + dateDepart + ", dateArrive=" + dateArrive + ", prix=" + prix + ", Hotel=" + Hotel + ", Ville=" + Ville + '}';
    }
   
}