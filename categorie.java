/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.util.Objects;

/**
 *
 * @author 21695
 */
public class categorie {
   private int  idCategorie;
            private String nomCategorie;

    public categorie() {
    }

    public categorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
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
        final categorie other = (categorie) obj;
        if (this.idCategorie != other.idCategorie) {
            return false;
        }
        if (!Objects.equals(this.nomCategorie, other.nomCategorie)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "categorie{" + "nomCategorie=" + nomCategorie + '}';
    }
            
}
