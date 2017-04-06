package Views.Profil;

import Models.DAO.EtudiantDAO;
import Models.DAO.UtilisateurDAO;
import Models.Etudiant;
import Models.Utilisateur;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Allam on 31/03/2017.
 */
public class ProfilEtudiantView extends JPanel
{
    private JPanel pProfilEtudiant;
    private JLabel lAnnonce;
    private JLabel lNom;
    private JTextField tfNom;
    private JLabel lPrenom;
    private JTextField tfPrenom;
    private JLabel lDomEtude;
    private JTextField tfDomEtude;
    private JLabel lNivEtude;
    private JLabel lMail;
    private JTextField tfMail;
    private JLabel lTel;
    private JTextField tfTel;
    private JPanel pBouttonsValidation;
    private JButton bValider;
    private JButton bAnnuler;
    private JButton bModifier;
    private JPanel pBouttons;
    private JButton bModifierPseudoMdp;
    private JComboBox cbNivEtude;

    public ProfilEtudiantView(Etudiant e)
    {
        tfNom.setText(e.getNom());
        tfPrenom.setText(e.getPrenom());
        tfDomEtude.setText(e.getDomEtude());
        cbNivEtude.setSelectedItem(e.getNivEtude().toString());
        tfMail.setText(e.getMail());
        tfTel.setText(e.getTel());

        bValider.addActionListener(new BValiderListener());
        bAnnuler.addActionListener(new BAnnulerListener());
        bModifier.addActionListener(new BModifierListener());
        bModifierPseudoMdp.addActionListener(new BModifierPseudoMdpListener());
    }

    public JPanel getpProfilEtudiant()
    {
        return pProfilEtudiant;
    }

    class BModifierListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            tfNom.setEnabled(true);
            tfPrenom.setEnabled(true);
            tfDomEtude.setEnabled(true);
            cbNivEtude.setEnabled(true);
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
            EtudiantDAO eDAO = new EtudiantDAO();
            Etudiant et = new Etudiant();

            et.setIdEtudiant(new Utilisateur().getIdU());
            et.setNom(tfNom.getText());
            et.setPrenom(tfPrenom.getText());
            et.setDomEtude(tfDomEtude.getText());
            et.setNivEtude(cbNivEtude.getSelectedItem().toString());
            et.setMail(tfMail.getText());
            et.setTel(tfTel.getText());

            eDAO.update(et);

            //Affichage de la boite de dialogue
            JOptionPane jOP = new JOptionPane();
            jOP.showMessageDialog(null, "Modification enregistrées avec succes", "Information", JOptionPane.INFORMATION_MESSAGE);

            tfNom.setEnabled(false);
            tfPrenom.setEnabled(false);
            tfDomEtude.setEnabled(false);
            cbNivEtude.setEnabled(false);
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
            tfDomEtude.setEnabled(false);
            cbNivEtude.setEnabled(false);
            tfMail.setEnabled(false);
            tfTel.setEnabled(false);

            bValider.setEnabled(false);
            bAnnuler.setEnabled(false);
        }
    }
}