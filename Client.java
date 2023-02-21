/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;
import java.text.SimpleDateFormat;
import java.sql.Date;

/**
 *
 * @author Sirine
 */
public class Client {
    public int idClient;
    public Date dateCreation;

    public Client(int idClient, Date dateCreation) {
        this.idClient = idClient;
        this.dateCreation = dateCreation;
    }

    public Client(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

  
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public int getIdClient() {
        return idClient;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public Client() {
    }
     @Override
    public String toString() {
        return "Client{" + "idClient=" + idClient + ", dateCreation=" + dateCreation + '}';
    }

}
