/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.IDAO;


import com.govoyage.ENTITIES.Post;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public interface IPostDao {
        void addPost(Post depot);
         ArrayList<Post> displayAllPosts();
   Post findPostByTitre(String titre);
  int findPostByid(String titre);
  int findPostImage(String titre);
  String SelectImage(Integer image_id);
  int findPostVideo(String titre);
  String SelectVideo(Integer v_id);
  
   void removePostById(int id);
    
}
