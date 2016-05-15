/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.ENTITIES;

/**
 *
 * @author Fadoua
 */
public class Hotel {
    private int id;
    private String nomHotel;
    private String Description;
    private String Categorie;
    private String Disponibilite;
    private double longitude;
    private double latitude;
    private int Ville_id;
    private int prix;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomHotel() {
        return nomHotel;
    }

    public void setNomHotel(String nomHotel) {
        this.nomHotel = nomHotel;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getCategorie() {
        return Categorie;
    }

    public void setCategorie(String Categorie) {
        this.Categorie = Categorie;
    }

    public String getDisponibilite() {
        return Disponibilite;
    }

    public void setDisponibilite(String Disponibilite) {
        this.Disponibilite = Disponibilite;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getVille_id() {
        return Ville_id;
    }

    public void setVille_id(int Ville_id) {
        this.Ville_id = Ville_id;
    }

    public Hotel(int id,String nomHotel, String Description, String Categorie, String Disponibilite, double longitude, double latitude, int Ville_id) {
        this.id = id;
        this.nomHotel = nomHotel;
        this.Description = Description;
        this.Categorie = Categorie;
        this.Disponibilite = Disponibilite;
        this.longitude = longitude;
        this.latitude = latitude;
        this.Ville_id = Ville_id;
    }

    public Hotel(String nomHotel, String Description, String Categorie, int Ville_id) {
        this.nomHotel = nomHotel;
        this.Description = Description;
        this.Categorie = Categorie;
        this.Ville_id = Ville_id;
    }

    @Override
    public String toString() {
    return nomHotel;    
    }

    
    
    public Hotel() {
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public Hotel(int id, String nomHotel, String Description, String Categorie, String Disponibilite, double longitude, double latitude, int Ville_id, int prix) {
        this.id = id;
        this.nomHotel = nomHotel;
        this.Description = Description;
        this.Categorie = Categorie;
        this.Disponibilite = Disponibilite;
        this.longitude = longitude;
        this.latitude = latitude;
        this.Ville_id = Ville_id;
        this.prix = prix;
    }

    
    
    
    
}
