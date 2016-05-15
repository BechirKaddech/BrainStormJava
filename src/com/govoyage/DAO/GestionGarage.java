/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.DAO;

import com.govoyage.ENTITIES.Garage;
import com.govoyage.IDAO.IGestionGarage;
import com.govoyage.UTIL.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author alaa
 */
public class GestionGarage implements IGestionGarage{

    private Connection Connection;

    public GestionGarage() {
        Connection=MyConnection.getInstance();
    }
    
    @Override
    public void AjouterGarage(Garage g) {
         String req ="insert into garage values (null,?,?,?)";
     
    try {
        PreparedStatement ps=Connection.prepareStatement(req);
           ps.setString(1,g.getNom_garage());
           ps.setInt(2,g.getCapacite());
           
           ps.setInt(3,g.getEmplacement_voiture());
           
      ps.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(GestionVoiture.class.getName()).log(Level.SEVERE, null, ex);
       
    }
    }

    @Override
    public void supprimerGarage(int id) {
          String req1 ="delete from garage where id=?";

         
    try {
        PreparedStatement ps=Connection.prepareStatement(req1);
           ps.setInt(1,id);
          
      ps.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(GestionVoiture.class.getName()).log(Level.SEVERE, null, ex);
     
    }
    }

    @Override
    public void ModifierGarage(Garage v) {
        String req ="update garage set nom_garage=?,capacite=?,emplacament_voiture=? where id=?";
         
    try {
        PreparedStatement ps=Connection.prepareStatement(req);
           ps.setString(1,v.getNom_garage());
           ps.setInt(2,v.getCapacite());
           ps.setInt(3,v.getEmplacement_voiture());
           ps.setInt(4,v.getId());
      ps.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(GestionVoiture.class.getName()).log(Level.SEVERE, null, ex);
       
    }
    }

    @Override
    public List<Garage> AfficherGarage() {
        List<Garage> L = new ArrayList<Garage>();
        try {

            String req = "select * from garage ";
          PreparedStatement ps=Connection.prepareStatement(req);
            ResultSet rst = ps.executeQuery();
            while (rst.next()) {
                int id = rst.getInt("id");
                String nomGarage = rst.getString("nom_garage");
                int capacite = rst.getInt("capacite");
                int emplacament_voiture = rst.getInt("emplacament_voiture");
                
                Garage v = new Garage(id,nomGarage, capacite, emplacament_voiture);
                //System.out.println(m.getMot_de_passe());
                //System.out.println(m.getLogin());
                //System.out.println(pro.toString());
                L.add(v);
            }

        } catch (SQLException ex) {
            Logger.getLogger(GestionVoiture.class.getName()).log(Level.SEVERE, null, ex);
        }
        return L;
    }

    @Override
    public List<Garage> RechercherGarage(String find) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
