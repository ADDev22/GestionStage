package Views.Profil;

import Controllers.AdministrateurController;
import Models.Administrateur;
import Models.DAO.AdministrateurDAO;
import Models.DAO.DAO;
import Models.DAO.UtilisateurDAO;
import Models.Utilisateur;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Allam on 31/03/2017.
 */
public class ProfilAdministrateurView extends JPanel
{
    private JPanel pProfilAdministrateur;
    private JLabel lAnnonce;
    private JPanel pContenu;
    private JLabel lNom;
    private JTextField tfNom;
    private JLabel lPrenom;
    private JTextField tfPrenom;
    private JLabel lAdresse;
    private JPanel pAdresse1;
    private JTextField tfNoRue;
    private JTextField tfRue;
    private JTextField tfComplement;
    private JPanel pAdresse2;
    private JTextField tfCdePostal;
    private JTextField tfVille;
    private JTextField tfPays;
    private JLabel lMail;
    private JTextField tfMail;
    private JLabel lTel;
    private JTextField tfTel;
    private JPanel pBouttons;
    private JButton bCreationAdmin;
    private JButton bModifier;
    private JButton bModifierPseudoMdp;
    private JPanel pBouttonsValidation;
    private JButton bValider;
    private JButton bAnnuler;

    public ProfilAdministrateurView(Administrateur admin)
    {
        tfNom.setText(admin.getAdministrateurNom());
        tfPrenom.setText(admin.getAdministrateurPrenom());
        tfNoRue.setText(String.valueOf(admin.getAdresseNoRue()));
        tfRue.setText(admin.getAdresseRue());
        tfComplement.setText(admin.getAdresseComplement());
        tfCdePostal.setText(String.valueOf(admin.getAdresseCdePostal()));
        tfVille.setText(admin.getAdresseVille());
        tfPays.setText(admin.getAdressePays());
        tfMail.setText(admin.getAdministrateurMail());
        tfTel.setText(String.valueOf(admin.getAdministrateurTel()));

        bCreationAdmin.addActionListener(new BCreationAdminListener());
        bModifier.addActionListener(new BModifierListener());
        bModifierPseudoMdp.addActionListener(new BModifierPseudoMdpListener());
        bValider.addActionListener(new BValiderListener());
        bAnnuler.addActionListener(new BAnnulerListener());
    }

    public JPanel getpProfilAdministrateur()
    {
        return pProfilAdministrateur;
    }

    class BCreationAdminListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            AdministrateurDAO aDAO = new AdministrateurDAO();
            AdministrateurController administrateurController = new AdministrateurController(aDAO);
            InscriptionAdminView inscriptionAdminView = new InscriptionAdminView(administrateurController);
        }
    }

    class BModifierListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            tfNom.setEnabled(true);
            tfPrenom.setEnabled(true);
            tfNoRue.setEnabled(true);
            tfRue.setEnabled(true);
            tfComplement.setEnabled(true);
            tfCdePostal.setEnabled(true);
            tfVille.setEnabled(true);
            tfPays.setEnabled(true);
            tfMail.setEnabled(true);
            tfTel.setEnabled(true);
            bValider.setEnabled(true);
            bAnnuler.setEnabled(true);
        }
    }

    class BModifierPseudoMdpListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            UtilisateurDAO uDAO = new UtilisateurDAO();
            Utilisateur utilisateur = uDAO.find(new Utilisateur().getId());
            ChangementMdpView changementMdpView = new ChangementMdpView(utilisateur);
        }
    }

    class BValiderListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Utilisateur u = new Utilisateur();
            DAO<Administrateur> aDAO = new AdministrateurDAO();
            Administrateur admin = aDAO.find(u.getIdU());

            admin.setAdministrateurNom(tfNom.getText());
            admin.setAdministrateurPrenom(tfPrenom.getText());
            admin.setAdresseNoRue(Integer.valueOf(tfNoRue.getText()));
            admin.setAdresseRue(tfRue.getText());
            admin.setAdresseComplement(tfComplement.getText());
            admin.setAdresseCdePostal(Integer.valueOf(tfCdePostal.getText()));
            admin.setAdresseVille(tfVille.getText());
            admin.setAdressePays(tfPays.getText());
            admin.setAdministrateurMail(tfMail.getText());
            admin.setAdministrateurTel(Integer.valueOf(tfTel.getText()));

            aDAO.update(admin);

            tfNom.setEnabled(false);
            tfPrenom.setEnabled(false);
            tfNoRue.setEnabled(false);
            tfRue.setEnabled(false);
            tfComplement.setEnabled(false);
            tfCdePostal.setEnabled(false);
            tfVille.setEnabled(false);
            tfPays.setEnabled(false);
            tfMail.setEnabled(false);
            tfTel.setEnabled(false);
            bValider.setEnabled(false);
            bAnnuler.setEnabled(false);
        }
    }

    class BAnnulerListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            tfNom.setEnabled(false);
            tfPrenom.setEnabled(false);
            tfNoRue.setEnabled(false);
            tfRue.setEnabled(false);
            tfComplement.setEnabled(false);
            tfCdePostal.setEnabled(false);
            tfVille.setEnabled(false);
            tfPays.setEnabled(false);
            tfMail.setEnabled(false);
            tfTel.setEnabled(false);
            bValider.setEnabled(false);
            bAnnuler.setEnabled(false);
        }
    }
}