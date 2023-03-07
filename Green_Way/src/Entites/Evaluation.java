/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

/**
 *
 * @author Sirine
 */
public class Evaluation {
    public int idEvaluation ;
    public String contenu;
    public int idClient;

    public Evaluation(int idEvaluation, String contenu, int idClient) {
        this.idEvaluation = idEvaluation;
        this.contenu = contenu;
        this.idClient = idClient;
    }

    public Evaluation() {
    }
    public Evaluation(String contenu, int idClient) {
        this.contenu = contenu;
        this.idClient = idClient;
    }

  
    public int getIdEvaluation() {
        return idEvaluation;
    }

    public String getContenu() {
        return contenu;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdEvaluation(int idEvaluation) {
        this.idEvaluation = idEvaluation;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    @Override
    public String toString() {
        return "Evaluation{" + "idEvaluation=" + idEvaluation + ", contenu=" + contenu + ", idClient=" + idClient + '}';
    }
    
}
