package Views.Compte;

import Controllers.EntrepriseController;
import Controllers.EtudiantController;
import Models.DAO.FonctionDAO;
import Models.Fonction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Allam on 24/03/2017.
 */
public class StatutInscriptionView extends JFrame
{
    private JPanel container;
    private JLabel lAnnonce;
    private JLabel lStatut;
    private JComboBox cbStatut;
    private JButton bAnnuler;
    private JButton bSuivant;
    private JPanel pBouttons;
    private FonctionDAO fDAO = new FonctionDAO();
    private List<Fonction> listeDroit = new ArrayList<>();

    public StatutInscriptionView()
    {
        this.setTitle("Gestion Stage");
        this.setSize(500, 500);
        this.setContentPane(container);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        bSuivant.addActionListener(new BSuivantListener());
        bAnnuler.addActionListener(new BAnnulerListener());

        listeDroit = fDAO.listeFonction();
        for (Fonction f : listeDroit)
        {
            if (!"Administrateur".equals(f.getFonctionNom()))
                cbStatut.addItem(f.getFonctionNom());
        }

        this.pack();
        this.setVisible(true);
    }

    class BSuivantListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (cbStatut.getSelectedItem().equals("Etudiant"))
            {
                EtudiantController etudiantController = new EtudiantController();
                InscriptionEtudiantView inscriptionEtudiantView = new InscriptionEtudiantView(etudiantController);
                StatutInscriptionView.this.dispose();
            }
            else
            {
              //  EntrepriseController entrepriseController = new EntrepriseController();
                //InscriptionEntrepriseView inscriptionEntrepriseView = new InscriptionEntrepriseView(entrepriseController);
               // StatutInscriptionView.this.dispose();
            }
        }
    }

    class BAnnulerListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
        }
    }
}