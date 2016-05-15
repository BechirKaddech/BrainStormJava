/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.DAO;


import com.govoyage.ENTITIES.Voiture;
import com.govoyage.IDAO.IGestionVoiture;
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
public class GestionVoiture implements IGestionVoiture{
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


private Connection Connection;

    public GestionVoiture() {
        Connection=MyConnection.getInstance();
    }

    
    
   

    @Override
    public void AjouterVoiture(Voiture v) {
        
     String req ="insert into voiture values (null,?,?,?,?,?,?)";
     
    try {
        PreparedStatement ps=Connection.prepareStatement(req);
           ps.setString(1,v.getMatricule());
           ps.setString(2,v.getMarque());
           ps.setString(3,v.getModel());
           ps.setFloat(4,v.getPrix());
           ps.setString(5,v.getDisponibilite());
           ps.setInt(6,v.getId_garage());
           ps.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(GestionVoiture.class.getName()).log(Level.SEVERE, null, ex);
       
    }
     
    }
    @Override
      public List<Voiture> AfficherVoiture() {
        
      List<Voiture> L = new ArrayList<Voiture>();
        try {

            String req = "select * from voiture ";
          PreparedStatement ps=Connection.prepareStatement(req);
            ResultSet rst = ps.executeQuery();
            while (rst.next()) {
                int id = rst.getInt("id");
                String matricule = rst.getString("matricule");
                String marque = rst.getString("marque");
                String model = rst.getString("model");
                Float prix = Float.parseFloat(rst.getString("prix")) ;
                String disponibilite = rst.getString("etat");
                Voiture v = new Voiture(id,matricule, marque, model, prix, disponibilite);
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
    public void supprimerVoiture(int id) {
     
        String req1 ="delete from voiture where id=?";

         
    try {
        PreparedStatement ps=Connection.prepareStatement(req1);
           ps.setInt(1,id);
          
      ps.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(GestionVoiture.class.getName()).log(Level.SEVERE, null, ex);
     
    }
     
          
    
    }

    @Override
    public void ModifierVoiture(Voiture v) {
      
    
 
          String req ="update voiture set matricule=?,marque=?,model=?,prix=?,etat=? where id=?";
         
    try {
        PreparedStatement ps=Connection.prepareStatement(req);
           ps.setString(1,v.getMatricule());
           ps.setString(2,v.getMarque());
           ps.setString(3,v.getModel());
           ps.setFloat(4,v.getPrix());
           ps.setString(5, v.getDisponibilite());
           ps.setInt(6,v.getId());
      ps.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(GestionVoiture.class.getName()).log(Level.SEVERE, null, ex);
       
    }
     
   
    
    
    }

    @Override
    public List<Voiture> RechercherVoiture(String rech) {
     List<Voiture> L = new ArrayList<Voiture>();
        try {

            String req = "select * from voiture v where (Upper(v.matricule) like '%"+rech.toUpperCase()+"%' "
                    + "or Upper(v.marque) like '%"+rech.toUpperCase()+"%' "
                    + "or Upper(v.model) like '%"+rech.toUpperCase()+"%' "
                    + "or (v.prix) like '%"+rech+"%' "
                    + "or Upper(v.etat) like '%"+rech.toUpperCase()+"%' )";
          PreparedStatement ps=Connection.prepareStatement(req);
            ResultSet rst = ps.executeQuery();
            while (rst.next()) {
                int id = rst.getInt("id");
                String matricule = rst.getString("matricule");
                String marque = rst.getString("marque");
                String model = rst.getString("model");
                Float prix = Float.parseFloat(rst.getString("prix")) ;
                String disponibilite = rst.getString("etat");
                Voiture v = new Voiture(id,matricule, marque, model, prix, disponibilite);
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
    }


