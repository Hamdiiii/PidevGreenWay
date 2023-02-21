/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.categorie;
import java.util.List;

/**
 *
 * @author 21695
 */
public interface Icategorieservice {
        public int ajoutercategorie(categorie c );
    public boolean modifiercategorie(categorie c);
    public boolean supprimercategorie(categorie c);
    public List<categorie> affichercategorie();
}
