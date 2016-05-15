/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.IDAO;


import com.govoyage.ENTITIES.Abonne;
import java.util.List;

/**
 *
 * @author Fadoua
 */
public interface AbonneIDAO {
    void insertAbonne(Abonne a);
    void modifierAbonne(Abonne a,int id);
    void deleteAbonne(Abonne c);
    Abonne getAbonneEnCours(String username, String password);

    public List<Abonne> displayAllAbonne();
    
}
