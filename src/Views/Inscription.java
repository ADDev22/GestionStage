package Views;

import Controllers.AuthentificationController;
import Models.DAO.FonctionDAO;
import Models.Fonction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Allam on 17/03/2017.
 */
public class Inscription extends JFrame
{
    private JPanel container = new JPanel();
    private JLabel lStatut = new JLabel("Veuillez selectionner votre statut");
    private JComboBox cbStatut = new JComboBox();
    JPanel entrepriseContainer = new JPanel();
    JPanel etudiantContainer = new JPanel();
    private JButton s = new JButton ("Suivant");
    private FonctionDAO fDAO = new FonctionDAO();
    private List<Fonction> listeDroit = new ArrayList<>();

    //Instation de notre objet controlleur
    private AuthentificationController authController;

    public Inscription(AuthentificationController authController)
    {
        this.authController = authController;
        cbStatut.addActionListener(new ComboBoxStatutListener());
        listeDroit = fDAO.listeFonction();
        this.setTitle("Inscription");
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        container.setBackground(Color.white);
        container.setLayout(new BorderLayout());
        cbStatut.setPreferredSize(new Dimension(100, 20));

        for (Fonction f : listeDroit)
        {
            if (!"Administrateur".equals(f.getFonctionNom()))
                cbStatut.addItem(f.getFonctionNom());
        }

        JPanel top = new JPanel();
        top.add(lStatut);
        top.add(cbStatut);

        container.add(top, BorderLayout.NORTH);

        this.setContentPane(container);
        this.setVisible(true);
    }

    /*private void afficherFormulaireAdmin()
    {
        //Définition du container du formulaire
        JPanel adminContainer = new JPanel();
        adminContainer.setLayout(new GridLayout(11, 2));

        //Ligne Nom
        JLabel lNom = new JLabel("Nom");
        JTextField tfNom = new JTextField();
        tfNom.setPreferredSize(new Dimension(150, 30));
        //Ligne Prenom
        JLabel lPrenom = new JLabel("Prenom");
        JTextField tfPrenom = new JTextField();
        tfPrenom.setPreferredSize(new Dimension(150, 30));
        //Ligne Adresse No Rue et Rue
        JLabel lAdresse = new JLabel("Adresse");
        JPanel pAdresseL1 = new JPanel();
        JTextField tfNoRue = new JTextField("No");
        tfNoRue.setPreferredSize(new Dimension(40, 30));
        JTextField tfRue = new JTextField("Rue");
        tfRue.setPreferredSize(new Dimension(150, 30));
        pAdresseL1.add(tfNoRue);
        pAdresseL1.add(tfRue);
        //Ligne adresse complement
        JLabel lVide = new JLabel("   ");
        JTextField tfComplement = new JTextField("Complement");
        tfComplement.setPreferredSize(new Dimension(150, 30));
        //Ligne adresse Code Postal Ville
        JLabel lVide2 = new JLabel("   ");
        JPanel pAdresseL3 = new JPanel();
        JTextField tfCdePostal = new JTextField("Cde Postal");
        tfCdePostal.setPreferredSize(new Dimension(80, 30));
        JTextField tfVille = new JTextField("Ville");
        tfVille.setPreferredSize(new Dimension(100, 30));
        pAdresseL3.add(tfCdePostal);
        pAdresseL3.add(tfVille);
        //Ligne adresse pays
        JLabel lVide3 = new JLabel("   ");
        JTextField tfPays = new JTextField("Pays");
        tfPays.setPreferredSize(new Dimension(100, 30));
        //Ligne mail
        JLabel lMail = new JLabel("Mail");
        JTextField tfMail = new JTextField();
        tfMail.setPreferredSize(new Dimension(190, 30));
        //Ligne Tel
        JLabel lTel = new JLabel("Télephone");
        JTextField tfTel = new JTextField();
        tfTel.setPreferredSize(new Dimension(170, 30));
        //Ligne nom d'utilisateur
        JLabel lUserName = new JLabel("Nom d'utilisateur");
        JTextField tfUserName = new JTextField();
        tfUserName.setPreferredSize(new Dimension(150, 30));
        //Ligne mot de passe
        JLabel lMdp = new JLabel("Mot de passe");
        JPasswordField pfMdp = new JPasswordField();
        pfMdp.setPreferredSize(new Dimension(150, 30));
        //Ligne confirmation Mot de passe
        JLabel lConfMdp = new JLabel("Confirmez le mot de passe");
        JPasswordField pfConfMdp = new JPasswordField();
        pfConfMdp.setPreferredSize(new Dimension(150, 30));

        //Mise en place dans le container
        adminContainer.add(lNom);
        adminContainer.add(tfNom);
        adminContainer.add(lPrenom);
        adminContainer.add(tfPrenom);
        adminContainer.add(lAdresse);
        adminContainer.add(pAdresseL1);
        adminContainer.add(lVide);
        adminContainer.add(tfComplement);
        adminContainer.add(lVide2);
        adminContainer.add(pAdresseL3);
        adminContainer.add(lVide3);
        adminContainer.add(tfPays);
        adminContainer.add(lMail);
        adminContainer.add(tfMail);
        adminContainer.add(lTel);
        adminContainer.add(tfTel);
        adminContainer.add(lUserName);
        adminContainer.add(tfUserName);
        adminContainer.add(lMdp);
        adminContainer.add(pfMdp);
        adminContainer.add(lConfMdp);
        adminContainer.add(pfConfMdp);

        //Ajout à la fenêtre principal
        this.container.add(adminContainer, BorderLayout.CENTER);
    }*/

    private void afficherFormulaireEtudiant()
    {
        //Définition du container du formulaire
        etudiantContainer.setLayout(new GridLayout(9, 2));

        //Ligne Nom
        JLabel lNom = new JLabel("Nom");
        JTextField tfNom = new JTextField();
        tfNom.setPreferredSize(new Dimension(150, 30));
        //Ligne Prenom
        JLabel lPrenom = new JLabel("Prenom");
        JTextField tfPrenom = new JTextField();
        tfPrenom.setPreferredSize(new Dimension(150, 30));
        //Ligne Domaine étude
        JLabel lDomEtude = new JLabel("Domaine d'etude");
        JTextField tfDomEtude = new JTextField();
        tfDomEtude.setPreferredSize(new Dimension(150, 30));
        //Ligne Niveau étude
        JLabel lNivEtude = new JLabel("Niveau d'etude");
        JTextField tfNivEtude = new JTextField();
        tfNivEtude.setPreferredSize(new Dimension(150, 30));
        //Ligne mail
        JLabel lMail = new JLabel("Mail");
        JTextField tfMail = new JTextField();
        tfMail.setPreferredSize(new Dimension(190, 30));
        //Ligne Tel
        JLabel lTel = new JLabel("Télephone");
        JTextField tfTel = new JTextField();
        tfTel.setPreferredSize(new Dimension(170, 30));
        //Ligne nom d'utilisateur
        JLabel lUserName = new JLabel("Nom d'utilisateur");
        JTextField tfUserName = new JTextField();
        tfUserName.setPreferredSize(new Dimension(150, 30));
        //Ligne mot de passe
        JLabel lMdp = new JLabel("Mot de passe");
        JPasswordField pfMdp = new JPasswordField();
        pfMdp.setPreferredSize(new Dimension(150, 30));
        //Ligne confirmation Mot de passe
        JLabel lConfMdp = new JLabel("Confirmez le mot de passe");
        JPasswordField pfConfMdp = new JPasswordField();
        pfConfMdp.setPreferredSize(new Dimension(150, 30));

        //Mise en place dans le container
        etudiantContainer.add(lNom);
        etudiantContainer.add(tfNom);
        etudiantContainer.add(lPrenom);
        etudiantContainer.add(tfPrenom);
        etudiantContainer.add(lDomEtude);
        etudiantContainer.add(tfDomEtude);
        etudiantContainer.add(lNivEtude);
        etudiantContainer.add(tfNivEtude);
        etudiantContainer.add(lMail);
        etudiantContainer.add(tfMail);
        etudiantContainer.add(lTel);
        etudiantContainer.add(tfTel);
        etudiantContainer.add(lUserName);
        etudiantContainer.add(tfUserName);
        etudiantContainer.add(lMdp);
        etudiantContainer.add(pfMdp);
        etudiantContainer.add(lConfMdp);
        etudiantContainer.add(pfConfMdp);

        //Ajout à la fenêtre principal
        this.container.add(etudiantContainer, BorderLayout.CENTER);
    }

    private void afficherFormulaireEntreprise()
    {
        //Définition du container du formulaire
        entrepriseContainer.setLayout(new GridLayout(9, 2));

        //Ligne Raison Sociale
        JLabel lraisonSociale = new JLabel("Raison Sociale");
        JTextField tfRaisonSociale = new JTextField();
        tfRaisonSociale.setPreferredSize(new Dimension(150, 30));
        //Ligne adresse Rue
        JLabel lAdresse = new JLabel("Adresse");
        JTextField tfRue = new JTextField("Rue");
        tfRue.setPreferredSize(new Dimension(150, 30));
        //Ligne adresse Code Postal Ville
        JLabel lVide = new JLabel("   ");
        JPanel pAdresse = new JPanel();
        JTextField tfCdePostal = new JTextField("Cde Postal");
        tfCdePostal.setPreferredSize(new Dimension(80, 30));
        JTextField tfVille = new JTextField("Ville");
        tfVille.setPreferredSize(new Dimension(100, 30));
        pAdresse.add(tfCdePostal);
        pAdresse.add(tfVille);
        //Ligne mail
        JLabel lMail = new JLabel("Mail");
        JTextField tfMail = new JTextField();
        tfMail.setPreferredSize(new Dimension(190, 30));
        //Ligne Tel
        JLabel lTel = new JLabel("Télephone");
        JTextField tfTel = new JTextField();
        tfTel.setPreferredSize(new Dimension(170, 30));
        //Ligne Secteur Activité
        JLabel lSectAc = new JLabel("Secteur d'activité");
        JTextField tfSectAc = new JTextField();
        tfSectAc.setPreferredSize(new Dimension(150, 30));
        //Ligne nom d'utilisateur
        JLabel lUserName = new JLabel("Nom d'utilisateur");
        JTextField tfUserName = new JTextField();
        tfUserName.setPreferredSize(new Dimension(150, 30));
        //Ligne mot de passe
        JLabel lMdp = new JLabel("Mot de passe");
        JPasswordField pfMdp = new JPasswordField();
        pfMdp.setPreferredSize(new Dimension(150, 30));
        //Ligne confirmation Mot de passe
        JLabel lConfMdp = new JLabel("Confirmez le mot de passe");
        JPasswordField pfConfMdp = new JPasswordField();
        pfConfMdp.setPreferredSize(new Dimension(150, 30));

        //Mise en place dans le container
        entrepriseContainer.add(lraisonSociale);
        entrepriseContainer.add(tfRaisonSociale);
        entrepriseContainer.add(lAdresse);
        entrepriseContainer.add(tfRue);
        entrepriseContainer.add(lVide);
        entrepriseContainer.add(pAdresse);
        entrepriseContainer.add(lMail);
        entrepriseContainer.add(tfMail);
        entrepriseContainer.add(lTel);
        entrepriseContainer.add(tfTel);
        entrepriseContainer.add(lSectAc);
        entrepriseContainer.add(tfSectAc);
        entrepriseContainer.add(lUserName);
        entrepriseContainer.add(tfUserName);
        entrepriseContainer.add(lMdp);
        entrepriseContainer.add(pfMdp);
        entrepriseContainer.add(lConfMdp);
        entrepriseContainer.add(pfConfMdp);

        //Ajout à la fenêtre principal
        this.container.add(entrepriseContainer, BorderLayout.CENTER);
    }

    class ComboBoxStatutListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equals("Etudiant"))
            {
                Inscription.this.container.remove(entrepriseContainer);
                Inscription.this.validate();
                afficherFormulaireEtudiant();
                Inscription.this.validate();
            }
            else
            {
                Inscription.this.container.remove(etudiantContainer);
                Inscription.this.validate();
                afficherFormulaireEntreprise();
                Inscription.this.validate();
            }
        }
    }
}