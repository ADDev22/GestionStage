package Views.Compte;

import Controllers.EtudiantController;
import Models.Etudiant;
import Models.Fonction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Allam on 24/03/2017.
 */
public class InscriptionEtudiantView extends JFrame
{
    private JLabel lAnnonce;
    private JLabel lNom;
    private JTextField tfNom;
    private JLabel lPrenom;
    private JTextField tfPrenom;
    private JLabel lDomEtude;
    private JTextField tfDomEtude;
    private JLabel lNivEtude;
    private JComboBox cbNivEtude;
    private JLabel lMail;
    private JTextField tfMail;
    private JLabel lTel;
    private JFormattedTextField ftfTel;
    private JPanel pBouttons;
    private JButton bValider;
    private JButton bRetour;
    private JPanel container;
    private JLabel lUserName;
    private JTextField tfUserName;
    private JLabel lMdp;
    private JPasswordField pfMdp;
    private JLabel lConfMdp;
    private JPasswordField pfConfMdp;

    //Instanciation de notre objet contrôleur
    private EtudiantController etController;

    public InscriptionEtudiantView(EtudiantController etudiantController)
    {
        this.etController = etudiantController;

        this.setTitle("Gestion Stage");
        this.setSize(500, 500);
        this.setContentPane(container);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        bValider.addActionListener(new BValiderListener());
        bRetour.addActionListener(new BRetourListener());
        this.pack();
        this.setVisible(true);
    }

    class BValiderListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Etudiant etudiant = new Etudiant();
            Fonction fonction = new Fonction();

            fonction.setFonctionId(3);
            fonction.setFonctionNom("Etudiant");

            etudiant.setUtilisateurUserName(tfUserName.getText());
            if (pfMdp.getText().equals(pfConfMdp.getText()))
                etudiant.setUtilisateurMdp(pfMdp.getText());
            etudiant.setFonction(fonction);
            etudiant.setNom(tfNom.getText());
            etudiant.setPrenom(tfPrenom.getText());
            etudiant.setDomEtude(tfDomEtude.getText());
            etudiant.setNivEtude(cbNivEtude.getSelectedItem().toString());
            etudiant.setMail(tfMail.getText());
            etudiant.setTel(ftfTel.getText());

            etController.insert(etudiant);
        }
    }

    class BRetourListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {

        }
    }
}