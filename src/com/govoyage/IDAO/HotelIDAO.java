/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.IDAO;

import com.govoyage.ENTITIES.Hotel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fadoua
 */
public interface HotelIDAO {
    
    void AjouterHotel (Hotel h);
    
    boolean ModifierHotel (Hotel h);
    
    void SupprimerHotel (int id);
    
    Hotel ChercherHotel (int id);
    
   List<Hotel> ChercherHotel2 (String nom);
    
     List<Hotel> AfficherHotel();
     
     ArrayList<Hotel> displayAllhotel();
     Hotel findhotelById(int id) ;
     int count();
   
}
