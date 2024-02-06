/**
    Classe qui définit un joueur dans le contexte du jeu
**/
import java.awt.*;
import javax.swing.*;

public class Joueur {

    // Attributs
    private String pseudo;
    private Color couleur;
    private double solde;
    private ImageIcon photo;
    private LesCartes mesC;
    private LesLots mesL;

    // Getters
    public String getPseudo() {
        return this.pseudo;
    }

    public Color getCouleur() {
        return this.couleur;
    }

    public double getSolde() {
        return this.solde;
    }

    public ImageIcon getPhoto() {
        return this.photo;
    }

    public LesCartes getMesCartes() {
        return mesC;
    }

    public LesLots getMesLots() {
        return mesL;
    }

    // Setters
    public void setPseudo(String p) {
        this.pseudo = p;
    }

    public void setCouleur(Color c) {
        this.couleur = c;
    }

    public void setPhoto(ImageIcon p) {
        this.photo = p;
    }

    public void setSolde(double s) {
        this.solde = s;
    }
    
    // Constructeur
    public Joueur() { // constructeur par defaut
        this.pseudo = "";
        this.couleur = Color.blue;
        this.solde = 20;
        this.photo = new ImageIcon(getClass().getResource("Image/Joueur/joueurDefaut.png"));
        this.mesC = new LesCartes();
        this.mesL = new LesLots();
    }

    public Joueur(String p) { // constructeur avec pseudonyme
        this.pseudo = p;
        this.couleur = Color.blue;
        this.solde = 20;
        this.photo = new ImageIcon(getClass().getResource("Image/Joueur/joueurDefaut.png"));
        this.mesC = new LesCartes();
        this.mesL = new LesLots();
    }

    public Joueur(String p, Color c, double s) { // constructeur infos joueurs
        this.pseudo = p;
        this.couleur = c;
        this.solde = s;
        this.photo = new ImageIcon(getClass().getResource("Image/Joueur/joueurDefaut.png"));
        this.mesC = new LesCartes();
        this.mesL = new LesLots();
    }

    public Joueur(Joueur j) { // constructeur par clonage
        this.pseudo = j.getPseudo();
        this.couleur = j.getCouleur();
        this.solde = j.getSolde();
        this.photo = j.getPhoto();
        this.mesC = j.getMesCartes();
        this.mesL = j.getMesLots();
    }

    public boolean acheter(CarteLoto c) { // Ajout de la carte aux cartes du joueur 
        if (this.solde >= c.getPrix() && this.mesC.getTaille() < 2) { // si son solde le permet compte tenu du prix de la carte
            this.solde = this.solde - c.getPrix(); // et qu'il possède moins de deux cartes
            this.mesC.ajouteCarte(c);  // débit du solde et ajout de la carte
            return true;
        } else {
            return false;
        }
    }

    public String toString() { // retourne infos sur le joueur
        String res = "\nJoueur " + this.pseudo;
        res += "\nCouleur " + this.couleur;
        res += "\nSolde " + this.solde;
        res += "\nNombre de cartes " + this.mesC.getTaille();
        return res;
    }
}
