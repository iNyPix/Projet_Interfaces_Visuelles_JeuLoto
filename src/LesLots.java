/**
    Classe qui défninit un ensemble de lots
**/
import java.util.ArrayList;
/**
 *
 * @author thomasnicolle
 */
public class LesLots {
    
    // Attributs
    private ArrayList<Lot> lstL; // permet de stocker des lots
    
    // Guetters
    public int getNbLot() {
        return this.lstL.size(); // Obtenir le nombre de lots ajoutés
    }

    public ArrayList<Lot> getLstL() {
        return this.lstL;
    }

    public Lot getLot(int i) {
        
            return this.lstL.get(i); // equivalent à tab[i]
        
    }
    
    // Setters
    public void setLstL(ArrayList<Lot> lstL) {
        this.lstL = lstL;
    }
    
    public void AjoutLot(Lot l) { // Ajoute le lot dans la liste de lots
        this.lstL.add(l);
    }

    public void supprimeLot(Lot l) { // Supprime le lot voulu
        this.lstL.remove(l);
    }
    
    // Constructeur
    public LesLots() {
        lstL = new ArrayList<Lot>(); // instancie une "liste" de joueur
    }
}
