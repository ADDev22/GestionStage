package Views.Profil;

import Models.Administrateur;
import Models.DAO.AdministrateurDAO;
import Models.DAO.DAO;
import Models.DAO.EntrepriseDAO;
import Models.DAO.EtudiantDAO;
import Models.Entreprise;
import Models.Etudiant;
import Models.Utilisateur;
import Views.Administrateur.AdministrateurAccueilView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Allam on 31/03/2017.
 */
public class ProfilView extends JFrame
{
    private JPanel container;
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menu = new JMenu("Fichier");
    private JMenuItem sousMenu1 = new JMenuItem("Profil");
    private JMenuItem sousMenu2 = new JMenuItem("Déconnexion");

    public ProfilView(JPanel utilisateurPanel)
    {
        this.setTitle("Gestion Stage");
        this.setSize(500, 500);

        this.container = utilisateurPanel;
        this.setContentPane(container);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        sousMenu1.addActionListener(new SousMenu1ActionListener());
        sousMenu2.addActionListener(new SousMenu2ActionListener());

        //Menu
        menuBar.add(menu);
        //Ajout des sous menus
        menu.add(sousMenu1);
        menu.add(sousMenu2);
        //Définition à l'intérieur du panel
        this.setJMenuBar(menuBar);

        this.pack();
        this.setVisible(true);
    }

    class SousMenu1ActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Utilisateur u = new Utilisateur();
            if (u.getDroit() == 1)
            {
                Administrateur admin = new AdministrateurDAO().find(u.getIdU());
                ProfilView profilView = new ProfilView(new ProfilAdministrateurView(admin).getpProfilAdministrateur());
                ProfilView.this.dispose();
            }
            else if (u.getDroit() == 2)
            {
                Entreprise ent = new EntrepriseDAO().find(u.getIdU());
                ProfilView profilView = new ProfilView(new ProfilEntrepriseView(ent).getpProfilEntreprise());
                ProfilView.this.dispose();
            }
            else
            {
                Etudiant et = new EtudiantDAO().find(u.getIdU());
                ProfilView profilView = new ProfilView(new ProfilEtudiantView(et).getpProfilEtudiant());
                ProfilView.this.dispose();
            }
        }
    }

    class SousMenu2ActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {

        }
    }
}
