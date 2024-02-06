/**
    Classe qui définit un lot à gagner
**/
import javax.swing.ImageIcon;
/**
 *
 * @author thomasnicolle
 */
public class Lot {
    
    // Attributs
    private String description; // descriptif du lot
    private int categorie, niveau; // bon achat(1) ou objet(2) | Niveau 1, 2 ou 3
    private int prix; // prix du lot
    private ImageIcon photo; // image du lot
    private boolean win; // savoir si le lot est remporté
    
    // Getters
    public String getDescription() {
        return description;
    }

    public int getCategorie() {
        return categorie;
    }

    public int getNiveau() {
        return niveau;
    }

    public ImageIcon getPhoto() {
        return photo;
    }

    public int getPrix() {
        return prix;
    }

    public boolean getWin() {
        return win;
    }

    // Setters
    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategorie(int categorie) {
        this.categorie = categorie;
    }

    public void setNiveau(int niveau) {
        if (niveau > 0 && niveau <= 3) {
            this.niveau = niveau;
        } else {
            System.out.println("Erreur, bon achat(1) et Objet(2)");
        }

    }

    public void setPhoto(ImageIcon image) {
        this.photo = image;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    // Constructeurs
    public Lot() { // par défaut
        setDescription("Bon achat Carrefour");
        setCategorie(1);
        setNiveau(1);
        setPrix(10);
        setPhoto(new ImageIcon(getClass().getResource("Image/Lot/bonachat.jpg")));
        setWin(false);
    }

    public Lot(String desc, int nv, int prix) { // pour un bon achat
        setDescription(desc);
        setCategorie(1);
        setNiveau(nv);
        setPhoto(new ImageIcon(getClass().getResource("Image/Lot/bonachat.jpg")));
        setPrix(prix);
        setWin(false);
    }

    public Lot(String desc, int nv, ImageIcon img) { // pour un objet
        setDescription(desc);
        setCategorie(2);
        setNiveau(nv);
        setPhoto(img);
        setWin(false);
    }
    
    public Lot(Lot l) { // par clonage
        setDescription(l.getDescription());
        setCategorie(l.getCategorie());
        setNiveau(l.getNiveau());
        setPrix(l.getPrix());
        setPhoto(l.getPhoto());
        setWin(l.getWin());
    }
}
