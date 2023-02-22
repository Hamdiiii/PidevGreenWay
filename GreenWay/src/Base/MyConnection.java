/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

/**
 *
 * @author rayen
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mhcab
 */
public class MyConnection {

    String url = "jdbc:mysql://localhost:3306/greenway_db";
    String login = "root";
    String password = "";
    Connection myconnex;
    public static MyConnection x;

    public MyConnection() {
      try {
            myconnex =DriverManager.getConnection(url, login, password);
              System.out.println("reussie");
        } catch (SQLException e) {
             System.out.println(e.getMessage());

        }
        }

    public static MyConnection getInstance() {
        if (x == null) {
            x = new MyConnection();
        }
        return x;
    }

    public Connection getCnx() {
        return myconnex;
    }

}
