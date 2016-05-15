/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.IDAO;


import com.govoyage.ENTITIES.Voiture;
import java.util.List;

/**
 *
 * @author alaa
 */
public interface IGestionVoiture {
    public void AjouterVoiture(Voiture v);
    public void supprimerVoiture(int id);
    public void ModifierVoiture(Voiture v);
    public List<Voiture> AfficherVoiture();
     public List<Voiture> RechercherVoiture(String find);
 

}
