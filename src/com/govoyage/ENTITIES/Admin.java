/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.ENTITIES;

/**
 *
 * @author Fadoua
 */
public class Admin extends Compte{

    public Admin() {
    }

    public Admin(int id, String nom, String prenom, String username, String password, String email) {
        super(id, nom, prenom, username, password, email);
    }

    
}
