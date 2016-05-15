/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.govoyage.DAO;


import com.govoyage.ENTITIES.circuitvip;
import com.govoyage.IDAO.IcircuitvipDAO;
import com.govoyage.IDAO.IvilleDAO;
import com.govoyage.UTIL.MyConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author dell
 */
public class circuitvipDAO implements IcircuitvipDAO{

    private Connection cnx;

    public circuitvipDAO() {
        cnx=MyConnection.getInstance();
    }    

    
    @Override
    public boolean insertCircuit(circuitvip cv) {
 
    String query ="INSERT INTO circuitvip (nomcircuit, villedepart, destination1, destination2, destination3, description1, description2, description3, latitudevd, longitudevd, latitude1, longitude1, latitude2, longitude2, latitude3, longitude3) "
                 + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    
         try {
            PreparedStatement pSt = cnx.prepareStatement(query);
            
            pSt.setString(1, cv.getNomcircuit());
            
            pSt.setInt(2, cv.getVilledepart().getId());
            pSt.setInt(3, cv.getDestination1().getId());
            pSt.setInt(4, cv.getDestination2().getId());
            pSt.setInt(5, cv.getDestination3().getId());
            
            pSt.setString(6, cv.getDescription1());
            pSt.setString(7, cv.getDescription2());   
            pSt.setString(8, cv.getDescription3());
            
            pSt.setDouble(9, cv.getLatitudevd());
            pSt.setDouble(10, cv.getLongitudevd());
            pSt.setDouble(11, cv.getLatitude1());  
            pSt.setDouble(12, cv.getLongitude1());
            pSt.setDouble(13, cv.getLatitude2());
            pSt.setDouble(14, cv.getLongitude2()); 
            pSt.setDouble(15, cv.getLatitude3());
            pSt.setDouble(16, cv.getLongitude3()); 
            
            pSt.executeUpdate();
            
             System.out.println("circuit vip ajouteee");
            return true;
            
        } catch (SQLException ex) {
            System.out.println("CIRCUIT non ajouté!");
            return false;
        }  
    }
    
    @Override
    public boolean updateCircuitvip(circuitvip cv) {
  
    String query = "UPDATE circuitvip SET nomcircuit=? ,villedepart=? ,destination1=? ,destination2=? ,destination3=? ,description1=? ,description2=? ,description3=?,latitudevd=? ,longitudevd=? ,latitude1=? ,longitude1=? ,latitude2=? ,longitude2=? ,latitude3=? ,longitude3=? WHERE id=? ";
        
         try {
            PreparedStatement pSt = cnx.prepareStatement(query);
            pSt.setString(1, cv.getNomcircuit());
            
            pSt.setInt(2, cv.getVilledepart().getId());
            pSt.setInt(3, cv.getDestination1().getId());
            pSt.setInt(4, cv.getDestination2().getId());
            pSt.setInt(5, cv.getDestination3().getId());
            
            pSt.setString(6, cv.getDescription1());
            pSt.setString(7, cv.getDescription2());   
            pSt.setString(8, cv.getDescription3());
            
            
            
            pSt.setDouble(9, cv.getLatitudevd());
            pSt.setDouble(10, cv.getLongitudevd());
            pSt.setDouble(11, cv.getLatitude1());  
            pSt.setDouble(12, cv.getLongitude1());
            pSt.setDouble(13, cv.getLatitude2());
            pSt.setDouble(14, cv.getLongitude2()); 
            pSt.setDouble(15, cv.getLatitude3());
            pSt.setDouble(16, cv.getLongitude3()); 
            
            pSt.setDouble(17, cv.getId()); 
            
            pSt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println("echec de la modification!!!");
            return false;
        }         
    }    

    @Override
    public ArrayList<circuitvip> displayAllcircuitsVip() {
        
        
        ArrayList<circuitvip> listecircuit = new ArrayList<>();

        String requete = "select * from circuitvip";
        try {
            Statement statement = cnx.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            IvilleDAO villedao = new villeDAO();

            while (resultat.next()) {
                circuitvip crv = new circuitvip();
                
                crv.setId(resultat.getInt(1));
                
                
                crv.setVilledepart(villedao.findvilleById(resultat.getInt(2)));
                crv.setDestination1(villedao.findvilleById(resultat.getInt(3)));
                crv.setDestination2(villedao.findvilleById(resultat.getInt(4)));
                crv.setDestination3(villedao.findvilleById(resultat.getInt(5)));
               
                crv.setNomcircuit(resultat.getString(6));
                
                crv.setDescription1(resultat.getString(7));
                crv.setDescription2(resultat.getString(8));
                crv.setDescription3(resultat.getString(9));
                
       
                
                crv.setLatitudevd(resultat.getDouble(10));
                crv.setLongitudevd(resultat.getDouble(11));
                crv.setLatitude1(resultat.getDouble(12));
                crv.setLongitude1(resultat.getDouble(13));
                crv.setLatitude2(resultat.getDouble(14));
                crv.setLongitude2(resultat.getDouble(15));
                crv.setLatitude3(resultat.getDouble(16));
                crv.setLongitude3(resultat.getDouble(17));


                listecircuit.add(crv);
            
    /*   for(circuitvip elem: listecircuit)
       {
       	 System.out.println (elem);
       }*/
            }
            return listecircuit;
            
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement de la liste des circuit " + ex.getMessage());
            return null;
        }         
    
    }

    @Override
    public void deleteCircuitvip(int id) {
        String requete = "DELETE FROM circuitvip WHERE id=? ";
        
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("CIRCUIT supprimée");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }          
    }

    @Override
    public circuitvip findcircuitById(int id) {
        
        circuitvip cr = new circuitvip();
        String requete = "select * from circuitvip where id=? ";
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            IvilleDAO villedao = new villeDAO();
            
            while (resultat.next()) {
                
                cr.setId(resultat.getInt(1));
                
                
                cr.setVilledepart(villedao.findvilleById(resultat.getInt(2)));
                cr.setDestination1(villedao.findvilleById(resultat.getInt(3)));
                cr.setDestination2(villedao.findvilleById(resultat.getInt(4)));
                cr.setDestination3(villedao.findvilleById(resultat.getInt(5)));
                
                cr.setNomcircuit(resultat.getString(6));
                
                cr.setDescription1(resultat.getString(7));
                cr.setDescription2(resultat.getString(8));
                cr.setDescription3(resultat.getString(9));
                
             
               
                cr.setLatitudevd(resultat.getDouble(10));
                cr.setLongitudevd(resultat.getDouble(11));
                cr.setLatitude1(resultat.getDouble(12));
                cr.setLongitude1(resultat.getDouble(13));
                cr.setLatitude2(resultat.getDouble(14));
                cr.setLongitude2(resultat.getDouble(15));
                cr.setLatitude3(resultat.getDouble(16));
                cr.setLongitude3(resultat.getDouble(17));
            }
            System.out.println("ok");
            return cr;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du circuit " + ex.getMessage());
            return null;
        }        
    }

    @Override
    public circuitvip findcircuitByvilledep(String villedepart) {
        circuitvip cr = new circuitvip();
        String requete = "select * from circuitvip where villedepart=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setString(1, villedepart);
            ResultSet resultat = ps.executeQuery();
            IvilleDAO villedao = new villeDAO();
            
            while (resultat.next()) {
                
                cr.setId(resultat.getInt(1));
                
                
                cr.setVilledepart(villedao.findvilleById(resultat.getInt(2)));
                cr.setDestination1(villedao.findvilleById(resultat.getInt(3)));
                cr.setDestination2(villedao.findvilleById(resultat.getInt(4)));
                cr.setDestination3(villedao.findvilleById(resultat.getInt(5)));
                
                cr.setNomcircuit(resultat.getString(6));
                
                cr.setDescription1(resultat.getString(7));
                cr.setDescription2(resultat.getString(8));
                cr.setDescription3(resultat.getString(9));
                
            
                
                cr.setLatitudevd(resultat.getDouble(10));
                cr.setLongitudevd(resultat.getDouble(11));
                cr.setLatitude1(resultat.getDouble(12));
                cr.setLongitude1(resultat.getDouble(13));
                cr.setLatitude2(resultat.getDouble(14));
                cr.setLongitude2(resultat.getDouble(15));
                cr.setLatitude3(resultat.getDouble(16));
                cr.setLongitude3(resultat.getDouble(17));
            }
            return cr;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du circuit " + ex.getMessage());
            return null;
        }     
    }

    @Override
    public int countCircuit() {
        String query = "select count(*) as nbrCircuits from circuit ;";
        int nombre = 0;
        try{
            PreparedStatement prep = cnx.prepareStatement(query);
            ResultSet result = prep.executeQuery();
            while(result.next())
            {
                nombre = result.getInt("nbrCircuits");
            }
        } catch (SQLException ex) {
            return nombre;
        }
        return nombre;        
    }
    
    


    
    
    
    
    
}
