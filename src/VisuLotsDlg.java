/**
    Classe dérivée de jDialog pour visualiser les lots disponibles
**/
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
/**
 *
 * @author thomasnicolle
 */
public class VisuLotsDlg extends javax.swing.JDialog {
    
    // Constructeurs
    private VisuLotsDlg(JFrame jFrame, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public VisuLotsDlg(java.awt.Frame parent, boolean modal, LesLots lots) {
        super(parent, modal);
        initComponents();
        //Récupère le nombre de lots à afficher
        int nb = lots.getNbLot();
        //Définit la disposition du panneau « PGalerie » en fonction du nombre de lot 
        int n = (int) Math.sqrt(nb) + 1; // ou (int)Math.ceil(Math.sqrt(nb)) ; 
        PGalerie.setLayout(new GridLayout(n, n + 1));
        //Pour chaque lots
        for (int i = 0; i < nb; i++) {
            //Crée un panneau de type « PanneauImage »
            PanneauImage pani = new PanneauImage();
            //Affecte la photo du lot à ce panneau.
            pani.setImage(lots.getLot(i).getPhoto().getImage());
            //Fixe la propriété « Name » du panneau au numéro du lot
            pani.setName("" + i);
            //Fixe la dimension préférée du panneau
            pani.setPreferredSize(new Dimension(120, 120));
            //Ajoute le panneau ainsi construit au panneau « PGalerie »
            PGalerie.add(pani);
        }
        //Pour « reconstruire » l’interface correctement
        pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        fermer = new javax.swing.JButton();
        PGalerie = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Photo des cadeaux à gagner");
        jLabel1.setToolTipText("");
        getContentPane().add(jLabel1, java.awt.BorderLayout.PAGE_START);

        fermer.setText("Fermer");
        fermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fermerActionPerformed(evt);
            }
        });
        getContentPane().add(fermer, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout PGalerieLayout = new javax.swing.GroupLayout(PGalerie);
        PGalerie.setLayout(PGalerieLayout);
        PGalerieLayout.setHorizontalGroup(
            PGalerieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 463, Short.MAX_VALUE)
        );
        PGalerieLayout.setVerticalGroup(
            PGalerieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 282, Short.MAX_VALUE)
        );

        getContentPane().add(PGalerie, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fermerActionPerformed
        // TODO add your handling code here:
        this.setVisible(false); // Cache la fenêtre
        this.dispose(); // "Tue" la fenêtre
    }//GEN-LAST:event_fermerActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VisuLotsDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisuLotsDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisuLotsDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisuLotsDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VisuLotsDlg dialog = new VisuLotsDlg(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PGalerie;
    private javax.swing.JButton fermer;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}