/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.IDAO;

import com.govoyage.ENTITIES.Compte;



/**
 *
 * @author Fadoua
 */
public interface CompteIDAO {
     Compte veriflogin( String username,String password);
     String veriflogin2( String username,String password);
     Compte getCompte(String username,String password);
     void modifierCompte(Compte c, int id);
     void supprimerCompte(int id);
 
}
