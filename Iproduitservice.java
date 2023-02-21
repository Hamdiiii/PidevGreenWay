/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.produit;
import java.util.List;

/**
 *
 * @author 21695
 */
public interface Iproduitservice {
        public int ajouterproduit(produit p);
    public boolean modifierproduit(produit p);
    public boolean supprimerproduit(produit p);
    public List<produit> afficherproduit();
}
