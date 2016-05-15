/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.ENTITIES;

import java.sql.Timestamp;

/**
 *
 * @author user
 */
public class Commentaire {
    private int id ; 
    private String Body ; 
      private Timestamp date_p;
    private int Poste_id;
    private String user;

    public Commentaire() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return Body;
    }

    public void setBody(String Body) {
        this.Body = Body;
    }

    public Timestamp getDate_p() {
        return date_p;
    }

    public void setDate_p(Timestamp date_p) {
        this.date_p = date_p;
    }

    public int getPoste_id() {
        return Poste_id;
    }

    public void setPoste_id(int Poste_id) {
        this.Poste_id = Poste_id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

  
    
}
