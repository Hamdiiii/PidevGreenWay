/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.awt.TextField;
import java.sql.Date;

/**
 *
 * @author 21695
 */
public class produit {

    private int id_produit;
    private String name;
    private int prix;
    private String desc_p;
    private String image;

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public void setImage(String image) {
        this.image = image;
    }
    private int idFournisseur;
    private int idCommande;
    private int idActualite;
    private int idPanier ;
    private int idCategorie;
 public produit() {
    }

    public produit(int prix,String name, String desc_p, String image, int idFournisseur, int idCommande, int idActualite, int idPanier, int idCategorie) {
        
        this.name = name;
        this.prix = prix;
        //this.ajouter_date = ajouter_date;
        this.desc_p = desc_p;
        this.image = image;
        this.idFournisseur = idFournisseur;
        this.idCommande = idCommande;
        this.idActualite = idActualite;
        this.idPanier = idPanier;
        this.idCategorie = idCategorie;
    }

    public int getId_produit() {
        return id_produit;
    }

    public int getPrix() {
        return prix;
    }
    
//    public String getAjouter_date(){
//        return ajouter_date;
//    }
    
 

     public String getName() {
        return name;
    }  
    public String getDesc_p() {
        return desc_p;
    }

      public String getImage() {
           return image;
     }
       public String setImage() {
           return image;
     }

    public int getIdFournisseur() {
        return idFournisseur;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public int getIdActualite() {
        return idActualite;
    }

    public int getIdPanier() {
        return idPanier;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

  

    public void setDesc_p(String desc_p) {
        this.desc_p = desc_p;
    }
    public void setName(String name) {
        this.name = name;
    }
//    public void setImage(String image) {
//        this.image = image;
//    }

    public void setIdFournisseur(int idFournisseur) {
        this.idFournisseur = idFournisseur;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public void setIdActualite(int idActualite) {
        this.idActualite = idActualite;
    }

    public void setIdPanier(int idPanier) {
        this.idPanier = idPanier;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

  

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final produit other = (produit) obj;
        if (this.name != other.name) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "produit{" + "prix=" + prix + ", desc_p=" + desc_p + ", image=" + image + ", idFournisseur=" + idFournisseur + ", idCommande=" + idCommande + ", idActualite=" + idActualite + ", idPanier=" + idPanier + ", idCategorie=" + idCategorie + '}';
    }

    public void setPrix(TextField prix) {
       
    }
 
}
