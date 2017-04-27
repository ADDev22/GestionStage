package Views.Compte;

import Controllers.AdministrateurController;
import Controllers.AuthentificationController;
import Models.DAO.AdministrateurDAO;
import Models.DAO.OffreStageDAO;
import Models.Utilisateur;
import Views.Administrateur.AdministrateurAccueilView;
import Views.Administrateur.ResultSetTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Allam on 24/03/2017.
 */
public class AuthentificationView extends JFrame
{
    private JLabel lAnnonce;
    private JLabel lAuthentification;
    private JLabel lUserName;
    private JLabel lMdp;
    private JTextField tfUserName;
    private JButton bConnexion;
    private JButton bInscription;
    private JPanel container;
    private JPanel pBouttons;
    private JPasswordField pfMdp;

    //Instanciation de notre objet contrôleur
    private AuthentificationController authController;

    public AuthentificationView(AuthentificationController authentificationController)
    {
        this.authController = authentificationController;
        this.setTitle("Gestion Stage");
        this.setSize(500, 500);
        this.setContentPane(container);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        bConnexion.addActionListener(new BConnexionListener());
        bInscription.addActionListener(new BInscriptionListener());
        this.pack();
        this.setVisible(true);
    }

    class BConnexionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setUtilisateurUserName(tfUserName.getText());
            utilisateur.setUtilisateurMdp(pfMdp.getText());

            if(!authController.authentification(utilisateur))
            {
			    //Affichage de la boite de dialogue
                JOptionPane jOP = new JOptionPane();
                jOP.showMessageDialog(null, "Nom d'utilisateur ou mot de passe incorrecte", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
            else
                AuthentificationView.this.dispose();
        }
    }

    class BInscriptionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            StatutInscriptionView statutInscriptionView = new StatutInscriptionView();
            AuthentificationView.this.dispose();
        }
    }
}