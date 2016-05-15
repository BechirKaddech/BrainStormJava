/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.IDAO;


import com.govoyage.ENTITIES.sejour;
import java.util.ArrayList;

/**
 *
 * @author Saidi
 */
public interface IsejourDAO {
     void add(sejour p);
   
    
boolean updateSejour(sejour se);
//    
    void deleteSejour(int id);
    
    ArrayList<sejour> displayAllsejour();
    
    sejour findsejourById(int id);
    int count();
//   sejour findsejourBynom(String nomVille);
////    
}
