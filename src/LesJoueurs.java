/**
    Classe pour une collection de joueurs
**/
import java.util.ArrayList;
/**
 *
 * @author thomasnicolle
 */
public class LesJoueurs {
    
    // Attributs
    private ArrayList<Joueur> lstJ; // stock les infos du joueurs
    
    // Guetters
    public int getNbJoueur() {
        return this.lstJ.size(); // Obtenir le nombre de joueur ajoutés
    }

    public ArrayList<Joueur> getLstJ() {
        return this.lstJ;
    }

    public Joueur getJoueur(int i) {
        if (i < getNbJoueur() && i >= 0) {
            return this.lstJ.get(i); // equivalent à tab[i]
        } else {
            return null;
        }
    }
    
    // Setters
    public void setLstJ(ArrayList<Joueur> lstJ) {
        this.lstJ = lstJ;
    }

    public void AjoutJoueur(Joueur j) { // Ajoute le joueur dans la BDD
        this.lstJ.add(j);
    }

    public void SupprimeJoueur(Joueur j) { // Supprime le joueur voulu
        this.lstJ.remove(j);
    }
    
    // Méthodes
    public Joueur rechJoueur(String pseudo) { // Recherche le joueur si present 
        Joueur j = null;
        for (int i = 0; i < getNbJoueur(); i++) {
            if (getJoueur(i).getPseudo().equals(pseudo)) {
                j = new Joueur(getJoueur(i));
            } 
        }
        return j;
    }

    // Constructeurs
    public LesJoueurs() {
        lstJ = new ArrayList<Joueur>(); // instancie une "liste" de joueur
    }
}
