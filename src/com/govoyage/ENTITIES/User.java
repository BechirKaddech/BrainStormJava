/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.ENTITIES;

/**
 *
 * @author user
 */
public class User {
    private static int id ; 
    private static String name ;
    private static  String role;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

      public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    
    
}