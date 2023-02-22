/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import Entites.Client;
import java.util.List;
import java.sql.*;
import outils.My_connection;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author Sirine
 */
public class ClientService {

    Connection x = My_connection.getInstance().getCnx();

//    public void ajouterClient(Client c) {
//         try {
//          //  String sql = "insert into client(idClient,dateCreation)" + "values ("+c.getIdClient()+","+c.getDateCreation()+")";
//          String sql = "insert into client(idClient,dateCreation)" + "values (?,?)";
//             PreparedStatement PreparedStatement = x.prepareStatement(sql);
//            PreparedStatement.setInt(1, c.getIdClient());
//            PreparedStatement.setDate(2, (Date) c.getDateCreation());
//           
//            PreparedStatement.executeUpdate();
//            System.out.println("********************Client ajoutée*******************************");
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }  
//       
//    }
    public int ajouterClient(Client c) {
        int id = -1;
        try {
            String req1 = "INSERT INTO `client`( `dateCreation`) VALUES ('" + c.getDateCreation() + "')";
            Statement st = x.createStatement();
            id = st.executeUpdate(req1);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return id;
    }

    public void modifierClient(int idClient, Client c) throws SQLException {
        String update = "UPDATE `client` set dateCreation =? where idClient = ?";
        try {
            PreparedStatement st = x.prepareStatement(update);
            st.setDate(1, (Date) c.getDateCreation());
            st.setInt(2, idClient);
            st.executeUpdate();
            System.out.println("client modifie avec succée!");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public boolean supprimerClient(int idClient) {
        try {
            String req = " DELETE FROM client WHERE idClient =? ";
            PreparedStatement st = x.prepareStatement(req);
            st.setInt(1, idClient);
            st.executeUpdate();
            System.out.println("La supression du client est effectuée");
            return true;
        } catch (SQLException ex) {
            System.out.println("Echec de supression");
        }
        return false;
    }

    public List<Client> afficherClient() throws SQLException {
        List<Client> list = new ArrayList<>();

        String req = "Select * from client";
        PreparedStatement ps = x.prepareStatement(req);
        ResultSet rst = ps.executeQuery();
        while (rst.next()) {
            Client cl = new Client();
            cl.setDateCreation(rst.getDate("dateCreation"));
            cl.setIdClient(rst.getInt("idClient"));
            list.add(cl);
        }
        return list;
    }
}
