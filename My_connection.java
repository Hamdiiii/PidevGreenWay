/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Sirine
 */
public class My_connection {
     String url = "jdbc:mysql://localhost:3306/greenway_d";
    String login = "root";
    String password = "";
    Connection myconnex;
    public static My_connection x;

    public My_connection() {
        try {
            myconnex = DriverManager.getConnection(url, login, password);
                        System.out.println("Reussie! ");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static My_connection getInstance() {
        if (x == null) {
            x = new My_connection();
        }
        return x;
    }

    public Connection getCnx() {
        return myconnex;
    }

   

}
