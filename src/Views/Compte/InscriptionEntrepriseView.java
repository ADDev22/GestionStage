package Views.Compte;

import Controllers.EntrepriseController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Allam on 24/03/2017.
 */
public class InscriptionEntrepriseView extends JFrame
{
    private JPanel container;
    private JLabel lAnnonce;
    private JLabel lRaisonSociale;
    private JTextField tfRaisonSociale;
    private JLabel lAdresse;
    private JPanel pAdresse;
    private JTextField tfRue;
    private JTextField tfCdePostal;
    private JTextField tfVille;
    private JLabel lMail;
    private JTextField tfMail;
    private JLabel lTel;
    private JFormattedTextField ftfTel;
    private JButton bValider;
    private JButton bRetour;
    private JPanel pBouttons;

    //Instation de notre objet controlleur
    private EntrepriseController entController;

    public InscriptionEntrepriseView(EntrepriseController entrepriseController)
    {
        this.entController = entrepriseController;
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

        }
    }

    class BRetourListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {

        }
    }
}
