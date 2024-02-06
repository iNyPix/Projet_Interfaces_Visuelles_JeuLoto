
/**
 * Classe représentant une carte loto
 * */
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author thomasnicolle
 */
public class CarteLoto {

    // Attributs
    private int tab[][];
    private int jetons[][];
    private int nbCol;
    private int nbLig;
    private int nbNumeros;
    private double prix;
    private final int valMax = 90;

    // Guetters
    public double getPrix() {
        return this.prix;
    }

    public int getNbNumeros() {
        return this.nbNumeros;
    }

    public int getNbCol() {
        return this.nbCol;
    }

    public int getCase(int i, int j) {
        if (i >= 0 && i < nbLig && j >= 0 && j < nbCol) {
            return tab[i][j];
        } else {
            return -1;
        }
    }

    // Setters
    public void setNbNumeros(int nbNumeros) {
        if (nbNumeros < 3 || nbNumeros > (3 * this.nbCol)) {
            try {
                throw new Exception("Erreur");
            } catch (Exception ex) {
                Logger.getLogger(CarteLoto.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            this.nbNumeros = nbNumeros;
        }
    }

    // Constructeurs
    public CarteLoto() { // par defaut
        this.nbNumeros = 15;
        this.nbCol = 9;
        this.nbLig = 3;
        this.tab = new int[nbLig][nbCol];
        this.jetons = new int[nbLig][nbCol];
        this.prix = 5;
        initValeursCarte();
    }

    public CarteLoto(int nbc, int nbVal) {
        this.nbNumeros = nbVal;
        this.nbCol = nbc;
        this.nbLig = nbNumeros / nbCol;
        this.tab = new int[nbLig][nbCol];
        this.jetons = new int[nbLig][nbCol];
        this.prix = 5;
        initValeursCarte();
    }

    // Méthodes
    public void dessineCarte(JPanel jp, Color coul) { // affiche la carte dans le panneau jp, avec la couleur coul pour les boutons
        jp.removeAll();
        jp.setLayout(new java.awt.GridLayout(this.nbLig, this.nbCol));
        JButton bt;
        for (int i = 0; i < this.nbLig; i++) {
            for (int j = 0; j < this.nbCol; j++) {
                bt = new JButton();
                int val = this.getCase(i, j); // set valeur de la carte
                if (val == 0) {
                    bt.setText("");
                } else {
                    bt.setText("" + val);
                }
                if (this.jetons[i][j] == val) {
                    bt.setBackground(Color.white);
                } else {
                    bt.setBackground(coul);
                }
                // set couleur blanche si pion
                jp.add(bt);
            }
        }
    }

    @Override
    public String toString() { // Représenation d'une carte sous forme de chaînes de caractères
        String res = "";
        for (int i = 0; i < this.nbLig; i++) {
            for (int j = 0; j < this.nbCol; j++) {
                if (tab[i][j] < 10) {
                    res += "  " + tab[i][j];
                } else {
                    res += " " + tab[i][j];
                }
            }
            res += "\n";
        }
        return res;
    }

    public boolean estDans(int val) { // valeur presente sur la carte
        boolean res = false;
        int i = 0, j;
        do {
            j = 0;
            while (j < this.nbCol && this.tab[i][j] != val) {
                j++;
            }
            if (j < this.nbCol) {
                res = true;
            } else {
                i++;
            }
        } while (i < this.nbLig && res == false);
        return res;
    }

    public void initValeursCarte() { // initialisation  valeur carte loto
        int i, j, k, n;
        for (i = 0; i < this.nbLig; i++) {
            for (j = 0; j < this.nbCol; j++) {
                this.tab[i][j] = 0;
                this.jetons[i][j] = 0;
            }
        }
        i = 0;
        for (k = 0; k < this.nbNumeros; k++) { // Pour la ligne courante, on recherche aléatoirement une case vide pour placer ce numéro (à itérer si la case n’est pas vide)
            do {
                j = (int) (Math.random() * this.nbCol);
            } while (this.tab[i][j] != 0); //On génère aléatoirement ce numéro: un nombre compris entre 1 et la valeur maximum de numéros possibles (à itérer si ce numéro est déjà présent dans la carte)    
            do {
                n = (int) (Math.random() * this.valMax + 1);
            } while (estDans(n)); //On place ce nombre dans la case vide
            this.tab[i][j] = n; //on passe à la ligne suivante (ou à la première si nous sommes à la dernière)
            i++;
            if (i == this.nbLig) {
                i = 0;
            }
        }//ou i = (i+1)%this.nbLig;}}
    }

    public boolean placePion(int val) { // Simule le palcement d'un pion si le nombre est présent sur la carte
        boolean res = false;
        for (int i = 0; i < this.nbLig; i++) {
            for (int j = 0; j < this.nbCol; j++) {
                if (tab[i][j] == val) {
                    res = true;
                    jetons[i][j] = val;
                }
            }
        }
        return res;
    }

    public boolean estLignePleine(int lig) { // Verif si queen
        boolean res = true; //on suppose la ligne pleine      
        for (int j = 0; j < this.nbCol; j++) {
            if (jetons[lig][j] != tab[lig][j]) {
                res = false;
            }
        } // parcours de la ligne              
        return res;
    }

    public int getNbLignesPleines() { // Nombre de queen
        int compter = 0;
        for (int i = 0; i < this.nbLig; i++) {
            if (estLignePleine(i) == true) {
                compter++;
            }
        }
        return compter;
    }

    public boolean cartonGagnant(int option) {
        boolean res = false;
        switch (option) {
            case 1: // Pour 1 queen
                res = (getNbLignesPleines() == 1);
                break; //si le nb de lignes pleines est 1 et que l’option 1 a été choisie (gagnant avec une ligne pleine), on donne la valeur true à res
            case 2: // Pour double queen
                res = getNbLignesPleines() == 2;
                break; //idem avec 2 lignes et option 2 choisie
            case 3: // Pour carton plein (3 queen)
                res = getNbLignesPleines() == 3; //idem avec 3 lignes et option 3 choisie        
        }
        return res;
    }

    public void resetJeton() {
        for (int i = 0; i < this.nbLig; i++) {
            for (int j = 0; j < this.nbCol; j++) {
                jetons[i][j] = 0;
                
            }
        }
    }

}
