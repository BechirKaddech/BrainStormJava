/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.IDAO;


import com.govoyage.ENTITIES.circuitvip;
import java.util.ArrayList;

/**
 *
 * @author dell
 */
public interface IcircuitvipDAO {
    
    boolean insertCircuit(circuitvip cv);
    
    ArrayList<circuitvip> displayAllcircuitsVip();
    
    void deleteCircuitvip(int id);
    
    boolean updateCircuitvip(circuitvip cv);
    
    circuitvip findcircuitById(int id);
    
    circuitvip findcircuitByvilledep(String villedepart);
    
    int countCircuit();
    
}
