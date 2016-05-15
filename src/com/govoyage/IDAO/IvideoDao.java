/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.IDAO;

import com.govoyage.ENTITIES.VideoM;

/**
 *
 * @author user
 */
public interface IvideoDao {
    void addVideo(VideoM p);
     void removeVideoById(int id_v);
    
    
}
