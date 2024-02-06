/**
    Classe qui définit une collection de cartes
**/
import java.util.ArrayList;

/**
 *
 * @author thomasnicolle
 */
public class LesCartes {
    
    // Attributs
    private ArrayList<CarteLoto> lst; // permet de stocker des cartes lotos
    
    // Guetters
    public int getTaille() { // retourne le nombre de cartes
        return this.lst.size();
    }

    public CarteLoto getCarte(int i) { 
        if (i < getTaille() && i>=0) {
            return this.lst.get(i); // equivalent à tab[i]
        } else {
            return null;
        }
    }
    
    // Setters
    public void ajouteCarte(CarteLoto c) { // ajouter une carte
        this.lst.add(c);
    }

    public void retireCarte(CarteLoto c) { // supprimer une carte
        this.lst.remove(c);
    }

    public void retireCartes() { // supprime toute les cartes
        this.lst.clear();
    }

    // Méthodes
    public LesCartes rechCartes(int num) { // recherche si une carte est présente
        LesCartes lc = new LesCartes();
        for (int i = 0; i < getTaille(); i++) {
            if (getCarte(i).estDans(num)) {
                lc.ajouteCarte(getCarte(i));
            }
        }
        return lc;
    }

    public void initLesCartes(int n, int nbcol, int nbval) { // ajoutes n carte(s) voulu avec le nombre de colonnes et de nombres choisi
        for (int i = 0; i < n; i++) {
            CarteLoto carte = new CarteLoto(nbcol, nbval);
            this.ajouteCarte(carte);
        }
    }

    public String toString() { // retourne le nombre de cartes de la collection sous forme de String
        String res = "";
        for (int i = 0; i < getTaille(); i++) {
            res += "Carte n°" + i + "\n";
        }
        return res;
    }   

    // Constructeurs
    public LesCartes() {
        lst = new ArrayList<CarteLoto>();
    }
}
