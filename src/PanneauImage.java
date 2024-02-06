/**
    Classe dérivée de jPanel pour afficher parfaitement une image sur un jPanel
**/
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author thomasnicolle
 */
public class PanneauImage extends JPanel {//
    
    // Attributs
    private Image img; //attribut de type Image
    
    // Guetters
    public Image getImage() {
        return this.img;
    }
    
    // Setters
    public void setImage(Image im) {
        this.img = im;
        this.repaint(); //Appel à la méthode paint qu’on doit surcharger, rafraichit l’affichage (sinon il ne se fait automatiquement) }
    }
    
    // Constructeurs
    public PanneauImage() { // par défaut
        super();
        this.img = null;
    }

    public PanneauImage(Image im) {
        super();
        this.img = im;
    }

    // Méthodes
    @Override
    //surcharge de la méthode paint
    public void paint(Graphics g) {
        super.paint(g); //appel de la méthode paint de la classe mère (JPanel)
        if (img != null) {
            g.drawImage(img,0,0, this.getWidth(), this.getHeight(),this);//place l’image img sur le JPanel en redimensionnant l’image aux dimensions du panneau (à partie du coin supérieur gauche du composant)
        }
    }
}
