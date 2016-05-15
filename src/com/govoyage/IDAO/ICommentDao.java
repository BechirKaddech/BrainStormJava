/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.IDAO;


import com.govoyage.ENTITIES.Commentaire;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public interface ICommentDao {
    ArrayList<Commentaire> findPostById(Integer id);
    void addPost(Commentaire p);
    void removeCommentById(int id_c);
        void updateDepot(Commentaire depot,int id_c);
    String findCommentUser(String titre);

    
}
