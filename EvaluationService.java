/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import Entites.Evaluation;
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
public class EvaluationService {

    Connection x = My_connection.getInstance().getCnx();

    public int ajouterEvaluation(Evaluation e) {
        int id = -1;
        try {
            //String req1 = "INSERT INTO `client`( `dateCreation`) VALUES ('"+ c.getDateCreation()+"')";
            String req1 = "INSERT INTO `evaluation`( `contenu`, `idClient`) VALUES ('" + e.getContenu() + "','" + e.getIdClient() + "')";
            Statement st = x.createStatement();
            id = st.executeUpdate(req1);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return id;
    }

    public void modifierEvaluation(int idEvaluation, Evaluation e) throws SQLException {
        String update = "UPDATE `evaluation` set contenu =? , `idClient` = ? where idEvaluation = '" + idEvaluation + "';";
        try {
            PreparedStatement st = x.prepareStatement(update);

            st.setString(1, e.getContenu());
            st.setInt(2, e.getIdClient());

            st.executeUpdate();
            System.out.println("Evaluation modifiée avec succée!");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public boolean supprimerEvaluation(int idEvaluation) {
        try {
            String req = " DELETE FROM evaluation WHERE idEvaluation =?";
            PreparedStatement st = x.prepareStatement(req);
            st.setInt(1, idEvaluation);
            st.executeUpdate();
            System.out.println("La supression d'Evaluation est effectuée");
            return true;
        } catch (SQLException ex) {
            System.out.println("Echec de supression");
        }
        return false;
    }

//    public List<Evaluation> afficherEvaluation() throws SQLException {
//        String req;
//        req = "Select * from Evaluation";
//        Statement st = x.createStatement();
//        ResultSet rst = st.executeQuery(req);
//        System.out.println(rst.toString());
//        List<Evaluation> Evaluation = new ArrayList<Evaluation>();
//        while (rst.next()) {
//
//            Evaluation e = new Evaluation(rst.getInt("idEvaluation"), rst.getString("contenu"), rst.getInt("idClient"));
//            Evaluation.add(e);
//
//        }
//        return Evaluation;
//    } 
    public List<Evaluation> afficherEvaluation() throws SQLException {
        List<Evaluation> list = new ArrayList<>();

        String req = "Select * from evaluation";
        PreparedStatement ps = x.prepareStatement(req);
        ResultSet rst = ps.executeQuery();
        while (rst.next()) {
            Evaluation ev = new Evaluation();
            ev.setContenu(rst.getString("contenu"));
            ev.setIdClient(rst.getInt("idClient"));
            ev.setIdEvaluation(rst.getInt("idEvaluation"));
            list.add(ev);

        }
        return list;
    } 
    

}
