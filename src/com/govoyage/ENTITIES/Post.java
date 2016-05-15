/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.ENTITIES;

import java.sql.Timestamp;
import javax.print.attribute.standard.DateTimeAtCompleted;

/**
 *
 * @author user
 */
public class Post {
        private int id;
 
    private Integer image_id ; 
    private Integer v_id;
       private String titre;
    private String Contenu;
    private Timestamp date_published;
    private String user ;
    
    
      public Post() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getImage_id() {
        return image_id;
    }

    public void setImage_id(Integer image_id) {
        this.image_id = image_id;
    }

    public Integer getV_id() {
        return v_id;
    }

    public void setV_id(Integer v_id) {
        this.v_id = v_id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContenu() {
        return Contenu;
    }

    public void setContenu(String Contenu) {
        this.Contenu = Contenu;
    }

    public Timestamp getDate_published() {
        return date_published;
    }

    public void setDate_published(Timestamp date_published) {
        this.date_published = date_published;
    }


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

 
      
      
    
}
