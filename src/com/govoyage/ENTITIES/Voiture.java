/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.ENTITIES;

/**
 *
 * @author alaa
 */
public class Voiture {
private int id;
    private String matricule;
    private String marque;
    private String model;
    float prix;
    private String disponibilite;
    private Garage garage;
    private int id_garage;
    public Voiture(String matricule, String marque, String model, float prix, String disponibilite, Garage garage) {
        this.matricule = matricule;
        this.marque = marque;
        this.model = model;
        this.prix = prix;
        this.disponibilite = disponibilite;
        this.garage=garage;
    }
    
    public Voiture(String matricule, String marque, String model, float prix, String disponibilite) {
        this.matricule = matricule;
        this.marque = marque;
        this.model = model;
        this.prix = prix;
        this.disponibilite = disponibilite;
       
    }

    public Voiture(int id,String matricule, String marque, String model, float prix, String disponibilite,Garage garage) {
       this.id=id;
        this.matricule = matricule;
        this.marque = marque;
        this.model = model;
        this.prix = prix;
        this.disponibilite = disponibilite;
        this.garage=garage;
        
    }
    public Voiture(int id,String matricule, String marque, String model, float prix, String disponibilite) {
       this.id=id;
        this.matricule = matricule;
        this.marque = marque;
        this.model = model;
        this.prix = prix;
        this.disponibilite = disponibilite;
       
        
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }

    public Garage getGarage() {
        return garage;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(String disponibilite) {
        this.disponibilite = disponibilite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_garage() {
        return id_garage;
    }

    public void setId_garage(int id_garage) {
        this.id_garage = id_garage;
    }

    public Voiture(String matricule, String marque, String model, float prix, String disponibilite, int id_garage) {
        this.matricule = matricule;
        this.marque = marque;
        this.model = model;
        this.prix = prix;
        this.disponibilite = disponibilite;
        this.id_garage = id_garage;
    }

  

    
}
