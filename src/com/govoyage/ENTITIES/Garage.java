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
public class Garage {
    
private int id;
private int capacite;
private int emplacement_voiture;
private String nom_garage;
    public Garage(int id,String nom_garage, int capacite, int emplacement_voiture) {
        this.id = id;
        this.capacite = capacite;
        this.nom_garage = nom_garage;
        this.emplacement_voiture = emplacement_voiture;
    }
     public Garage(String nom_garage, int capacite, int emplacement_voiture) {
        this.capacite = capacite;
        this.nom_garage = nom_garage;
        this.emplacement_voiture = emplacement_voiture;
    }

    public void setNom_garage(String nom_garage) {
        this.nom_garage = nom_garage;
    }

    public int getId() {
        return id;
    }

    public String getNom_garage() {
        return nom_garage;
    }

    public int getCapacite() {
        return capacite;
    }

    public int getEmplacement_voiture() {
        return emplacement_voiture;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public void setEmplacement_voiture(int emplacement_voiture) {
        this.emplacement_voiture = emplacement_voiture;
    }

    @Override
    public String toString() {
        return  nom_garage ;
    }




    
}
