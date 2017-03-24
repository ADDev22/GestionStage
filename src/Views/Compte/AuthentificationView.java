package Views.Compte;

import Controllers.AuthentificationController;
import Models.DAO.UtilisateurDAO;

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
    private JTextField tfMdp;
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
            authController.setUserName(tfUserName.getText());
            authController.setMdp(tfMdp.getText());

            authController.authentification();
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