/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.Personne;
import entites.produit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyConnection;

/**
 *
 * @author 21695
 */
public class produitservice implements Iproduitservice
{
Connection myconnex = 
           MyConnection.getInstance().getConnection();
    @Override

    
        public int ajouterproduit(produit p) {
            int id=-1;
        try {
            String req = "INSERT INTO `produit` (`name`, `prix`, `desc_p`, `image`) VALUES (?,?,?,?)";
            PreparedStatement pstm = myconnex.prepareStatement(req);
            pstm.setString(1, p.getName());
            pstm.setInt(2, p.getPrix());
            pstm.setString(3, p.getDesc_p());
            pstm.setString(4, p.getImage());
           
            
            pstm.executeUpdate();

            System.out.println("Produit Ajouté");
            return id=1;

        } catch (SQLException ex) {
            Logger.getLogger(produitservice.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur d'ajout du produit");
            return id=-1;
        }

    }
    

    @Override
    public boolean modifierproduit(produit p) {
            try  {
                    String name="hamadiiiiii";
                    int prix=12;
                    int id_produit =1;
                    String desc_p="blablabla";
                    String image="image";
                        
                    String req = "UPDATE produit SET name = ?, prix = ?,`desc_p` = ? ,`image` = ? WHERE id_produit = ?";
			 PreparedStatement pstm = myconnex
                   .prepareStatement(req);
			pstm.setString(1, p.getName());
                        pstm.setInt(2, p.getPrix());
                        pstm.setString(3, p.getDesc_p());
                        pstm.setString(4, p.getImage());
                        pstm.setInt(5, p.getId_produit());
                        
			pstm.executeUpdate();

			int rowsUpdated = pstm.executeUpdate();
			if (rowsUpdated > 0) {
                            
				System.out.println("An existing produit was updated successfully!");
			
                        }

return true;
		} catch (SQLException ex) {
			ex.printStackTrace();
                   return false;    
		}
 

    }

    @Override
    public List<produit> afficherproduit() {
List<produit> list = new ArrayList<>();
        try {
            
           String req = "select * from produit";

            PreparedStatement pstm = myconnex.prepareStatement(req);
            ResultSet rs = pstm.executeQuery();
           while (rs.next()) {
               produit p = new produit();
                            p.setName(rs.getString("name"));
                            p.setPrix(rs.getInt("prix"));
                            p.setDesc_p(rs.getString("desc_p"));
                            p.setImage(rs.getString("image"));                           
                               
               list.add(p);           
           }
       } catch (SQLException ex) {
                       Logger.getLogger(produitservice.class.getName()).log(Level.SEVERE, null, ex);
                       System.out.println("Erreur d'affichage des produits");
       }
        return list;
    }


    @Override
    public boolean supprimerproduit(produit p) {
            try {
            String req = "DELETE FROM `produit` WHERE name = ?";
            PreparedStatement pstm = myconnex.prepareStatement(req);
            pstm.setInt(1, p.getId_produit());
            pstm.executeUpdate();
            System.out.println("Produit Supprimé");
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur de supression");
        }
        return false;

    }
    
    
}
