/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.ENTITIES;

import java.util.Date;

/**
 *
 * @author dell
 */
public class circuitvip {
    
    private int id;
    private String nomcircuit;
    
    private ville villedepart;
    private ville destination1;
    private ville destination2;
    private ville destination3;
    
    private String description1;
    private String description2;
    private String description3;
   
    
    private double latitudevd;
    private double longitudevd;
    private double latitude1;
    private double longitude1;
    private double latitude2;
    private double longitude2;
    private double latitude3;
    private double longitude3;

    public circuitvip(int id, String nomcircuit, ville villedepart, ville destination1, ville destination2, ville destination3, String description1, String description2, String description3, double latitudevd, double longitudevd, double latitude1, double longitude1, double latitude2, double longitude2, double latitude3, double longitude3) {
        this.id = id;
        this.nomcircuit = nomcircuit;
        this.villedepart = villedepart;
        this.destination1 = destination1;
        this.destination2 = destination2;
        this.destination3 = destination3;
        this.description1 = description1;
        this.description2 = description2;
        this.description3 = description3;
    
        this.latitudevd = latitudevd;
        this.longitudevd = longitudevd;
        this.latitude1 = latitude1;
        this.longitude1 = longitude1;
        this.latitude2 = latitude2;
        this.longitude2 = longitude2;
        this.latitude3 = latitude3;
        this.longitude3 = longitude3;
    }

    public circuitvip() {
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomcircuit() {
        return nomcircuit;
    }

    public void setNomcircuit(String nomcircuit) {
        this.nomcircuit = nomcircuit;
    }

    public ville getVilledepart() {
        return villedepart;
    }

    public void setVilledepart(ville villedepart) {
        this.villedepart = villedepart;
    }

    public ville getDestination1() {
        return destination1;
    }

    public void setDestination1(ville destination1) {
        this.destination1 = destination1;
    }

    public ville getDestination2() {
        return destination2;
    }

    public void setDestination2(ville destination2) {
        this.destination2 = destination2;
    }

    public ville getDestination3() {
        return destination3;
    }

    public void setDestination3(ville destination3) {
        this.destination3 = destination3;
    }

    public String getDescription1() {
        return description1;
    }

    public void setDescription1(String description1) {
        this.description1 = description1;
    }

    public String getDescription2() {
        return description2;
    }

    public void setDescription2(String description2) {
        this.description2 = description2;
    }

    public String getDescription3() {
        return description3;
    }

    public void setDescription3(String description3) {
        this.description3 = description3;
    }


    public double getLatitudevd() {
        return latitudevd;
    }

    public void setLatitudevd(double latitudevd) {
        this.latitudevd = latitudevd;
    }

    public double getLongitudevd() {
        return longitudevd;
    }

    public void setLongitudevd(double longitudevd) {
        this.longitudevd = longitudevd;
    }

    public double getLatitude1() {
        return latitude1;
    }

    public void setLatitude1(double latitude1) {
        this.latitude1 = latitude1;
    }

    public double getLongitude1() {
        return longitude1;
    }

    public void setLongitude1(double longitude1) {
        this.longitude1 = longitude1;
    }

    public double getLatitude2() {
        return latitude2;
    }

    public void setLatitude2(double latitude2) {
        this.latitude2 = latitude2;
    }

    public double getLongitude2() {
        return longitude2;
    }

    public void setLongitude2(double longitude2) {
        this.longitude2 = longitude2;
    }

    public double getLatitude3() {
        return latitude3;
    }

    public void setLatitude3(double latitude3) {
        this.latitude3 = latitude3;
    }

    public double getLongitude3() {
        return longitude3;
    }

    public void setLongitude3(double longitude3) {
        this.longitude3 = longitude3;
    }

    @Override
    public String toString() {
        return "circuitvip{" + "id=" + id + ", nomcircuit=" + nomcircuit + ", villedepart=" + villedepart + ", destination1=" + destination1 + ", destination2=" + destination2 + ", destination3=" + destination3 + ", description1=" + description1 + ", description2=" + description2 + ", description3=" + description3 + ", latitudevd=" + latitudevd + ", longitudevd=" + longitudevd + ", latitude1=" + latitude1 + ", longitude1=" + longitude1 + ", latitude2=" + latitude2 + ", longitude2=" + longitude2 + ", latitude3=" + latitude3 + ", longitude3=" + longitude3 + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.id;
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
        final circuitvip other = (circuitvip) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }





    
    
    
    
}
