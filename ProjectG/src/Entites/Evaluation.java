/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

/**
 *
 * @author Sirine
 */
public class Evaluation {
    public int idEvaluation ;
    public String contenu;
    public int rating;
    public int id_personne;

    public Evaluation(int idEvaluation, String contenu, int rating, int id_personne) {
        this.idEvaluation = idEvaluation;
        this.contenu = contenu;
        this.rating = rating;
        this.id_personne = id_personne;
    }

    public Evaluation() {
    }

    public Evaluation(String contenu, int rating, int id_personne) {
        this.contenu = contenu;
        this.rating = rating;
        this.id_personne = id_personne;
    }

   

    public int getIdEvaluation() {
        return idEvaluation;
    }

    public String getContenu() {
        return contenu;
    }

    public int getRating() {
        return rating;
    }

    public int getId_personne() {
        return id_personne;
    }

    public void setId_personne(int id_personne) {
        this.id_personne = id_personne;
    }

  

    public void setIdEvaluation(int idEvaluation) {
        this.idEvaluation = idEvaluation;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

  

    @Override
    public String toString() {
        return "Evaluation{" + "idEvaluation=" + idEvaluation + ", contenu=" + contenu + ", rating=" + rating + ", id_personne=" + id_personne + '}';
    }

  
   
    
}
