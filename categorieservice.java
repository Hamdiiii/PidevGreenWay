/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.Personne;
import entites.categorie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MyConnection;

/**
 *
 * @author 21695
 */
public class categorieservice implements Icategorieservice{
   Connection myconnex = 
           MyConnection.getInstance().getConnection();
    @Override
    public int ajoutercategorie(categorie c) {

 int id=-1;
        try {
            
           String req1 ="INSERT INTO `categorie` ( `nomCategorie`) VALUES ( '"+c.getNomCategorie()+"'); ";
           
           Statement ste = myconnex.createStatement();
          id= ste.executeUpdate(req1);
       } catch (SQLException ex) {
           System.out.println(ex);
       }
       return id;
    }

   
    @Override
    public boolean modifiercategorie(categorie c) {
           try  {
                        String nom="hamadiiiiii";
                        
String req = "UPDATE `categorie` SET `nomCategorie` = ? WHERE `categorie`.`nomCategorie` = '"+c.getNomCategorie()+"';";
			 PreparedStatement ps = myconnex
                   .prepareStatement(req);
			ps.setString(1, nom);
                        
			ps.executeUpdate();

			int rowsUpdated = ps.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("An existing user was updated successfully!");
			
                        }

return true;
		} catch (SQLException ex) {
			ex.printStackTrace();
                   return false;    
		}
 

    }

    @Override
    public boolean supprimercategorie(categorie c) {
 try {
           String req="delete from categorie where nomCategorie= ? ";
           PreparedStatement ps = myconnex
                   .prepareStatement(req);
           ps.setInt(1, c.getIdCategorie());
           ps.executeUpdate();
       return true;
       
       
       } catch (SQLException ex) {
           System.out.println(ex); return false;
       }
       
      
    } 

    @Override
    public List<categorie> affichercategorie() {
List<categorie> list = new ArrayList<>();
        try {
           String req = "select * from categorie";
           Statement ste = myconnex.createStatement();
           ResultSet res=  ste.executeQuery(req);
           while (res.next()) {
               categorie c = new categorie();
               c.setNomCategorie(res.getString("nomCategorie"));

               list.add(c);           
           }
       } catch (SQLException ex) {
       }
        return list;    }
    
}
