/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.User;
import java.util.List;

/**
 *
 * @author rayen
 */
public interface InterfaceUser {
    public int ajouterUser(User p);
    public boolean modifierUser(String nom,User p);
    public boolean supprimerUser(User p);
    public List<User>afficherUser();
}
