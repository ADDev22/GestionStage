package Views.Profil;

import Models.DAO.EntrepriseDAO;
import Models.DAO.UtilisateurDAO;
import Models.Entreprise;
import Models.Utilisateur;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Allam on 31/03/2017.
 */
public class ProfilEntrepriseView extends JPanel
{
    private JPanel pProfilEntreprise;
    private JLabel lAnnonce;
    private JTextField tfRaisonSociale;
    private JLabel lAdresse;
    private JTextField tfRue;
    private JPanel pAdresse;
    private JTextField tfCodePostal;
    private JTextField tfVille;
    private JLabel lMail;
    private JTextField tfMail;
    private JLabel lTel;
    private JTextField tfTel;
    private JLabel lSectAc;
    private JTextField tfSectAc;
    private JPanel pBouttons;
    private JButton bModifier;
    private JButton bModifierPseudoMdp;
    private JPanel pBouttonsValidation;
    private JButton bValider;
    private JButton bAnnuler;
    private JLabel lRaisonSociale;

    public ProfilEntrepriseView(Entreprise e)
    {
        tfRaisonSociale.setText(e.getRaisonSociale());
        tfRue.setText(e.getAdresseRueEnt());
        tfCodePostal.setText(String.valueOf(e.getAdresseCodePostaleEnt()));
        tfVille.setText(e.getAdresseVilleEnt());
        tfMail.setText(e.getMail());
        tfTel.setText(e.getTel());
        tfSectAc.setText(e.getSecteurActivite());

        bValider.addActionListener(new BValiderListener());
        bAnnuler.addActionListener(new BAnnulerListener());
        bModifier.addActionListener(new BModifierListener());
        bModifierPseudoMdp.addActionListener(new BModifierPseudoMdpListener());
    }

    public JPanel getpProfilEntreprise()
    {
        return pProfilEntreprise;
    }

    class BModifierListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            tfRaisonSociale.setEnabled(true);
            tfRue.setEnabled(true);
            tfCodePostal.setEnabled(true);
            tfVille.setEnabled(true);
            tfMail.setEnabled(true);
            tfTel.setEnabled(true);
            tfSectAc.setEnabled(true);

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
            EntrepriseDAO eDAO = new EntrepriseDAO();
            Entreprise ent = new Entreprise();

            ent.setIdEntreprise(new Utilisateur().getIdU());
            ent.setRaisonSociale(tfRaisonSociale.getText());
            ent.setAdresseRueEnt(tfRue.getText());
            ent.setAdresseCodePostaleEnt(Integer.valueOf(tfCodePostal.getText()));
            ent.setAdresseVilleEnt(tfVille.getText());
            ent.setMail(tfMail.getText());
            ent.setTel(tfTel.getText());
            ent.setSecteurActivite(tfSectAc.getText());

            eDAO.update(ent);

            //Affichage de la boite de dialogue
            JOptionPane jOP = new JOptionPane();
            jOP.showMessageDialog(null, "Modification enregistrées avec succes", "Information", JOptionPane.INFORMATION_MESSAGE);

            tfRaisonSociale.setEnabled(false);
            tfRue.setEnabled(false);
            tfCodePostal.setEnabled(false);
            tfVille.setEnabled(false);
            tfMail.setEnabled(false);
            tfTel.setEnabled(false);
            tfSectAc.setEnabled(false);

            bValider.setEnabled(false);
            bAnnuler.setEnabled(false);
        }
    }

    class BAnnulerListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            tfRaisonSociale.setEnabled(false);
            tfRue.setEnabled(false);
            tfCodePostal.setEnabled(false);
            tfVille.setEnabled(false);
            tfMail.setEnabled(false);
            tfTel.setEnabled(false);
            tfSectAc.setEnabled(false);

            bValider.setEnabled(false);
            bAnnuler.setEnabled(false);
        }
    }
}
