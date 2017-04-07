package Views.Administrateur;

import Controllers.AdministrateurController;
import Models.*;
import Models.DAO.*;
import Views.Profil.ProfilAdministrateurView;
import Views.Profil.ProfilEntrepriseView;
import Views.Profil.ProfilEtudiantView;
import Views.Profil.ProfilView;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Allam on 26/03/2017.
 */
public class AdministrateurAccueilView extends JFrame
{
    private JButton bListeOffres;
    private JButton bListeEntreprises;
    private JButton bListeEtudiants;
    private JPanel container;
    private JLabel lAnnonce;
    private JPanel pBouttons;
    private JPanel pContenu;
    private JTable tContenu;
    private JPanel pDetails;
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menu = new JMenu("Fichier");
    private JMenuItem sousMenu1 = new JMenuItem("Profil");
    private JMenuItem sousMenu2 = new JMenuItem("Déconnexion");


    //Instanciation de notre objet contrôleur
    private AdministrateurController adminController;

    public AdministrateurAccueilView(AdministrateurController administrateurController, TableModel model)
    {
        this.adminController = administrateurController;
        this.setTitle("Gestion Stage");
        this.setSize(500, 500);
        this.setContentPane(container);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        bListeOffres.addActionListener(new BListeOffresListener());
        bListeEntreprises.addActionListener(new BListeEntreprisesListener());
        bListeEtudiants.addActionListener(new BListeEtudiantsListener());
        sousMenu1.addActionListener(new SousMenu1ActionListener());
        sousMenu2.addActionListener(new SousMenu2ActionListener());

        //Menu
        menuBar.add(menu);
        //Ajout des sous menus
        menu.add(sousMenu1);
        menu.add(sousMenu2);
        //Définition à l'intérieur du panel
        this.setJMenuBar(menuBar);

        //Traitement du tabeleau
        tContenu = new JTable(model);
        tContenu.setLayout(new BorderLayout());
        pContenu.add(new JScrollPane(tContenu), BorderLayout.CENTER);

        tContenu.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                String valeurId = String.valueOf(tContenu.getModel().getValueAt(tContenu.getSelectedRow(), tContenu.getSelectedColumn()));
                OffreStage os = new OffreStageDAO().find(Integer.valueOf(valeurId));
                DetailsOffreView detailsOffreView = new DetailsOffreView(os);
                pDetails = detailsOffreView.getpDetailsOffre();

                AdministrateurAccueilView.this.getContentPane().removeAll();

                AdministrateurAccueilView.this.pDetails.updateUI();
                AdministrateurAccueilView.this.pDetails.revalidate();
                AdministrateurAccueilView.this.getContentPane().revalidate();
                //AdministrateurAccueilView.this.setContentPane(container);
                AdministrateurAccueilView.this.getContentPane().repaint();
                AdministrateurAccueilView.this.setVisible(true);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        this.pack();
        this.setVisible(true);
    }

    class BListeOffresListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            AdministrateurDAO administrateurDAO = new AdministrateurDAO();
            AdministrateurController administrateurController = new AdministrateurController(administrateurDAO);
            ResultSetTableModel offresRS = new ResultSetTableModel(new OffreStageDAO().listeOffres());
            AdministrateurAccueilView administrateurAccueilView = new AdministrateurAccueilView(administrateurController, offresRS);
            AdministrateurAccueilView.this.dispose();
        }
    }

    class BListeEntreprisesListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            AdministrateurDAO administrateurDAO = new AdministrateurDAO();
            AdministrateurController administrateurController = new AdministrateurController(administrateurDAO);
            ResultSetTableModel entreprisesRS = new ResultSetTableModel(new EntrepriseDAO().listeEntreprises());
            AdministrateurAccueilView administrateurAccueilView = new AdministrateurAccueilView(administrateurController, entreprisesRS);
            AdministrateurAccueilView.this.dispose();
        }
    }

    class BListeEtudiantsListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            AdministrateurDAO administrateurDAO = new AdministrateurDAO();
            AdministrateurController administrateurController = new AdministrateurController(administrateurDAO);
            ResultSetTableModel etudiantRS = new ResultSetTableModel(new EtudiantDAO().listeEtudiants());
            AdministrateurAccueilView administrateurAccueilView = new AdministrateurAccueilView(administrateurController, etudiantRS);
            AdministrateurAccueilView.this.dispose();
        }
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
                AdministrateurAccueilView.this.dispose();
            }
            else if (u.getDroit() == 2)
            {
                Entreprise ent = new EntrepriseDAO().find(u.getIdU());
                ProfilView profilView = new ProfilView(new ProfilEntrepriseView(ent).getpProfilEntreprise());
                AdministrateurAccueilView.this.dispose();
            }
            else
            {
                Etudiant et = new EtudiantDAO().find(u.getIdU());
                ProfilView profilView = new ProfilView(new ProfilEtudiantView(et).getpProfilEtudiant());
                AdministrateurAccueilView.this.dispose();
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