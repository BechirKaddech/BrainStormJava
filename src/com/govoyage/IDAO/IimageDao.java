/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.IDAO;

import com.govoyage.ENTITIES.ImageM;
import com.govoyage.ENTITIES.Post;

/**
 *
 * @author user
 */
public interface IimageDao {
    void addImage(ImageM p);
    void ajouterMedia2(ImageM p, Post C);
    void removeImageById(int id);
    
    
}
