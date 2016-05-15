/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.ENTITIES;

/**
 *
 * @author sirine
 */
public class ville {
    private int id;
    private Integer image_id ; 
    private String nom;
    private String pays;
    private double latitude;
    private double longitude;
    private String description;
    private String type;
    private String langue;

    public ville(int id, String nom, String pays, double latitude, double longitude, String description, String type, String langue) {
        this.id = id;
        this.nom = nom;
        this.pays = pays;
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = description;
        this.type = type;
        this.langue = langue;
    }

    public ville(int id, Integer image_id, String nom, String pays, double latitude, double longitude, String description, String type, String langue) {
        this.id = id;
        this.image_id = image_id;
        this.nom = nom;
        this.pays = pays;
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = description;
        this.type = type;
        this.langue = langue;
    }
    

    public ville() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public Integer getImage_id() {
        return image_id;
    }

    public void setImage_id(Integer image_id) {
        this.image_id = image_id;
    }
    

    @Override
    public String toString() {
        return  nom ;   
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ville other = (ville) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
}
