package Views.Profil;

import Models.DAO.UtilisateurDAO;
import Models.Utilisateur;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Allam on 04/04/2017.
 */
public class ChangementMdpView extends JFrame
{
    private JPanel container;
    private JLabel lAnnonce;
    private JLabel lAncienMdp;
    private JLabel lNouvMdp;
    private JPasswordField pfNouvMdp;
    private JPasswordField pfAncienMdp;
    private JLabel lConfNouvMdp;
    private JPasswordField pfConfNouvMdp;
    private JPanel pBouttons;
    private JButton bChanger;
    private JButton bAnnuler;
    private JLabel lPseudo;
    private JTextField tfPseudo;

    public ChangementMdpView(Utilisateur u)
    {
        this.setTitle("Gestion Stage");
        this.setSize(500, 500);
        this.setContentPane(container);
        this.setLocationRelativeTo(null);

        tfPseudo.setText(u.getUtilisateurUserName());

        bChanger.addActionListener(new BChangerActionListener());
        bAnnuler.addActionListener(new BAnnulerActionListener());

        this.pack();
        this.setVisible(true);
    }

    class BChangerActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            UtilisateurDAO uDAO = new UtilisateurDAO();
            Utilisateur u = uDAO.find(new Utilisateur().getId());
            if (u.getUtilisateurMdp().equals(pfAncienMdp.getText()))
            {
                if (pfNouvMdp.getText().equals(pfConfNouvMdp.getText()))
                {
                    uDAO.changementLoginMdp(tfPseudo.getText(), pfNouvMdp.getText());
                    //Affichage de la boite de dialogue
                    JOptionPane jOP = new JOptionPane();
                    jOP.showMessageDialog(null, "Changement du mot de passe effectué avec succes", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    //Affichage de la boite de dialogue
                    JOptionPane jOP = new JOptionPane();
                    jOP.showMessageDialog(null, "Les champs 'Mot de passe' et 'Confirmation' doivent avoir les meme valeurs", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
            else
            {
                //Affichage de la boite de dialogue
                JOptionPane jOP = new JOptionPane();
                jOP.showMessageDialog(null, "L'ancien mot de passe ne correspond pas", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    class BAnnulerActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            ChangementMdpView.this.dispose();
        }
    }
}