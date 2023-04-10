/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author Sirine
 */
public class Materiaux {

    public int idMateriaux;
    public String type;
    public String taux_recyclage;
    public String duree_vie;
    public String condition_utilisation;
   


    public Materiaux(String type, String taux_recyclage, String duree_vie, String condition_utilisation, String dateAjoutée, int duréeVie) {
        this.type = type;
        this.taux_recyclage = taux_recyclage;
        this.duree_vie = duree_vie;
        this.condition_utilisation = condition_utilisation;
    }

  

    

    public void setIdMateriaux(int idMateriaux) {
        this.idMateriaux = idMateriaux;
    }

    

    public Materiaux(String type, String taux_recyclage, String duree_vie, String condition_utilisation) {
        this.type = type;
        this.taux_recyclage = taux_recyclage;
        this.duree_vie = duree_vie;
        this.condition_utilisation = condition_utilisation;
    }

    public Materiaux() {
    }

    public int getIdMateriaux() {
        return idMateriaux;
    }

    public String getType() {
        return type;
    }

    public String getTaux_recyclage() {
        return taux_recyclage;
    }

    public String getDuree_vie() {
        return duree_vie;
    }

    public String getCondition_utilisation() {
        return condition_utilisation;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTaux_recyclage(String taux_recyclage) {
        this.taux_recyclage = taux_recyclage;
    }

    public void setDuree_vie(String duree_vie) {
        this.duree_vie = duree_vie;
    }

    public void setCondition_utilisation(String condition_utilisation) {
        this.condition_utilisation = condition_utilisation;
    }

    @Override
    public String toString() {
        return "Materiaux{" + "type=" + type + ", taux_recyclage=" + taux_recyclage + ", duree_vie=" + duree_vie + ", condition_utilisation=" + condition_utilisation + '}';
    }

   
    
   
}
