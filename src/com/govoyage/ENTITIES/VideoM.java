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
public class VideoM {
        public static final String CURRENT_DIR ="c:/wamp/www/VersionFinale/web/uploads";
    public static final double MAX_IMAGE_SIZE = 512;
    
    private Integer id ; 
     private Timestamp updated_at;
     
        private String name;
    private String path;

    public VideoM() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
}
