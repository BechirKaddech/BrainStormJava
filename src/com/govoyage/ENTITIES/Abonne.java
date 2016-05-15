/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.ENTITIES;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.govoyage.UTIL.MyConnection;
/**
 *
 * @author Fadoua
 */
public class Abonne extends Compte{
    
     
    
    private String etat;
  
    
    public Abonne() {
    }


    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Abonne{" + "etat=" + etat + '}';
    }

    public Abonne(String etat, String url, int id, String nom, String prenom, String username, String password, String email) {
        super(id, nom, prenom, username, password, email);
        this.etat = etat;
        
    }
   
    
    
}
