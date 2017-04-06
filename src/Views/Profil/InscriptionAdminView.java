package Views.Profil;

import Controllers.AdministrateurController;
import Models.Administrateur;
import Models.Fonction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Allam on 01/04/2017.
 */
public class InscriptionAdminView extends JFrame
{
    private JPanel container;
    private JLabel lAnnonce;
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
    private JTextField tfMail;
    private JLabel lMail;
    private JLabel lTel;
    private JTextField tfTel;
    private JLabel lUserName;
    private JTextField tfUserName;
    private JLabel lMdp;
    private JPasswordField pfMdp;
    private JLabel lConfMdp;
    private JPasswordField pfConfMdp;
    private JPanel pBouttons;
    private JButton bCreer;
    private JButton bAnnuler;

    //Instation de notre objet controlleur
    private AdministrateurController adminController;

    public InscriptionAdminView(AdministrateurController administrateurController)
    {
        this.adminController = administrateurController;
        this.setTitle("Gestion Stage");
        this.setSize(500, 500);
        this.setContentPane(container);
        this.setLocationRelativeTo(null);
        bCreer.addActionListener(new BCreerListener());
        bAnnuler.addActionListener(new BAnnulerListener());
        this.pack();
        this.setVisible(true);
    }

    class BCreerListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Administrateur admin = new Administrateur();
            Fonction f = new Fonction();

            f.setFonctionId(1);
            f.setFonctionNom("Administrateur");

            admin.setUtilisateurUserName(tfUserName.getText());
            if (pfMdp.getText().equals(pfConfMdp.getText()))
                admin.setUtilisateurMdp(pfMdp.getText());
            admin.setFonction(f);
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

            adminController.insert(admin);
        }
    }

    class BAnnulerListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            InscriptionAdminView.this.dispose();
        }
    }
}
