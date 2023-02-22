/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;



/**
 *
 * @author rayen
 */
public class User {
    String email;
  private String motdepasse;
   private String nom;
   private String Prenom;
  private String telephone;
   private String adresse;
   private int id_fournisseur;
   private int id_personne;
   private int id_livreur;
  private int id_admin;
   private int id_client;

    public User() {
    }
   

    public User(String email, String motdepasse, String nom, String Prenom, String telephone, String adresse, int id_fournisser, int id_personne, int id_livreur, int id_admin, int id_client) {
        this.email=email;
        this.motdepasse = motdepasse;
        this.nom = nom;
        this.Prenom = Prenom;
        this.telephone = telephone;
        this.adresse = adresse;
        this.id_fournisseur = id_fournisser;
        this.id_personne = id_personne;
        this.id_livreur = id_livreur;
        this.id_admin = id_admin;
        this.id_client = id_client;
        
        
    }

    public User(int id, String username, String email, String phone) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getEmail() {
        return email;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getId_fournisser() {
        return id_fournisseur;
    }

    public int getId_personne() {
        return id_personne;
    }

    public int getId_livreur() {
        return id_livreur;
    }

    public int getId_admin() {
        return id_admin;
    }

    public int getId_client() {
        return id_client;
    }

    public void setEmail(String eMail) {
        this.email = eMail;
    }

    public void setMotdepasse(String motDePasse) {
        this.motdepasse = motDePasse;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setId_fournisser(int id_fournisser) {
        this.id_fournisseur = id_fournisser;
    }

    public void setId_personne(int id_personne) {
        this.id_personne = id_personne;
    }

    public void setId_livreur(int id_livreur) {
        this.id_livreur = id_livreur;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    @Override
    public String toString() {
        return "User{" + "email=" + email + ", motDePasse=" + motdepasse + ", nom=" + nom + ", Prenom=" + Prenom + ", telephone=" + telephone + ", adresse=" + adresse + ", id_fournisser=" + id_fournisseur + ", id_personne=" + id_personne + ", id_livreur=" + id_livreur + ", id_admin=" + id_admin + ", id_client=" + id_client + '}';
    }

  

 

   
    }
   
   
   
   
   
   

