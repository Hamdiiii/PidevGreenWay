/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Entite.User;
import Service.UserService;



/**
 *
 * @author rayen
 */
public class Main {
     public static void main(String[] args) {
     
         UserService f = new UserService();
         User r = new User("arbi.ferchichi@esprit.tn","rztzt","ahmed","mohamed","ahmed","mourouj",12,18,8,12,12);
     
        f.ajouterUser(r);
        //f.supprimerUser(r);
     //f.modifierUser(r);
     
      System.out.println(f.afficherUser());
     }
     
}
