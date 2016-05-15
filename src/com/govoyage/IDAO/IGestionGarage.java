/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.IDAO;


import com.govoyage.ENTITIES.Garage;
import java.util.List;

/**
 *
 * @author alaa
 */
public interface IGestionGarage {
    public void AjouterGarage(Garage g);
    public void supprimerGarage(int id);
    public void ModifierGarage(Garage v);
    public List<Garage> AfficherGarage();
    public List<Garage> RechercherGarage(String find);

}
