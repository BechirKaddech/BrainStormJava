/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.ENTITIES;

import java.util.Date;

/**
 *
 * @author ashref
 */
public class vol {

    private int id;
    private String nomCompagnie;
    private ville villeDepart;
    private ville villeArrivee;
    private Date dateDepart;
    private Date dateArrivee;
    private String nomAeroport;
    private float note;
    private float nvote;
     private float prixVol;

    public vol(int id, String nomCompagnie, ville villeDepart, ville villeArrivee, Date dateDepart, Date dateArrivee, String nomAeroport, float prixVol) {
        this.id = id;
        this.nomCompagnie = nomCompagnie;
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
        this.dateDepart = dateDepart;
        this.dateArrivee = dateArrivee;
        this.nomAeroport = nomAeroport;
        this.prixVol = prixVol;
    }
   

    public vol(int id, String nomCompagnie, ville villeDepart, ville villeArrivee, Date dateDepart, Date dateArrivee, String nomAeroport, float note, float nvote, float prixVol) {
        this.id = id;
        this.nomCompagnie = nomCompagnie;
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
        this.dateDepart = dateDepart;
        this.dateArrivee = dateArrivee;
        this.nomAeroport = nomAeroport;
        this.note = note;
        this.nvote = nvote;
        this.prixVol = prixVol;
    }

    public float getPrixVol() {
        return prixVol;
    }

    public void setPrixVol(float prixVol) {
        this.prixVol = prixVol;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public float getNvote() {
        return nvote;
    }

    public void setNvote(float nvote) {
        this.nvote = nvote;
    }

    public vol() {

    }

    public vol(int id, String nomCompagnie, ville villeDepart, ville villeArrivee, Date dateDepart, Date dateArrivee, String nomAeroport) {
        this.id = id;
        this.nomCompagnie = nomCompagnie;
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
        this.dateDepart = dateDepart;
        this.dateArrivee = dateArrivee;
        this.nomAeroport = nomAeroport;
    }

    public vol(String nomCompagnie, ville villeDepart, ville villeArrivee, Date dateDepart, Date dateArrivee, String nomAeroport) {
        this.nomCompagnie = nomCompagnie;
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
        this.dateDepart = dateDepart;
        this.dateArrivee = dateArrivee;
        this.nomAeroport = nomAeroport;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomCompagnie() {
        return nomCompagnie;
    }

    public void setNomCompagnie(String nomCompagnie) {
        this.nomCompagnie = nomCompagnie;
    }

    public ville getVilleDepart() {
        return villeDepart;
    }

    public void setVilleDepart(ville villeDepart) {
        this.villeDepart = villeDepart;
    }

    public ville getVilleArrivee() {
        return villeArrivee;
    }

    public void setVilleArrivee(ville villeArrivee) {
        this.villeArrivee = villeArrivee;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public Date getDateArrivee() {
        return dateArrivee;
    }

    public void setDateArrivee(Date dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    public String getNomAeroport() {
        return nomAeroport;
    }

    public void setNomAeroport(String nomAeroport) {
        this.nomAeroport = nomAeroport;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id;
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
        final vol other = (vol) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vol{" + "id=" + id + ", nomCompagnie=" + nomCompagnie + ", villeDepart=" + villeDepart + ", villeArrivee=" + villeArrivee + ", dateDepart=" + dateDepart + ", dateArrivee=" + dateArrivee + ", nomAeroport=" + nomAeroport + ", note =" + note + ", nvote =" + nvote  + ", prixVol =" + prixVol +'}';
    }

}
