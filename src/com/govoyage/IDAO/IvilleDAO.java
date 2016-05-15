/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.IDAO;

import com.govoyage.ENTITIES.ImageM;
import com.govoyage.ENTITIES.ville;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sirine
 */
public interface IvilleDAO {
    boolean insertVille(ville v);
    void deleteVille(int id);
    boolean updateVille(ville v);
   ArrayList<ville> displayAllvilles();
    ville findvilleById(int id);
    ville findvilleBynom(String nom);
   public int countVilles();
   public int countPaysTunisie();
    public int countPays(String p);
    public int countLangue(String p);
  
    public void ajoutervilleimage(ImageM p, ville v);
    
    List<ville> AfficherVille() ;
    public int returnid(String s);

    ArrayList<ville> displayAllvilless();
    ville findvilleByIdss(int id);
int findVilleImage(int id);
String SelectImage(Integer image_id);
    
}
