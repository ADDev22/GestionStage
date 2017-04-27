package Views.Administrateur;

import Controllers.AdministrateurController;
import Controllers.AuthentificationController;
import Models.*;
import Models.DAO.*;
import Views.Compte.AuthentificationView;
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
    private JPanel pDetailsOffre;
    private JLabel lId;
    private JTextField tfId;
    private JLabel lLibelle;
    private JTextField tfLibelle;
    private JLabel lDomaine;
    private JTextField tfDomaine;
    private JLabel lDescriptif;
    private JTextArea taDescriptif;
    private JLabel lDateDebut;
    private JTextField tfDateDebut;
    private JLabel lDuree;
    private JTextField tfDuree;
    private JLabel lValide;
    private JComboBox cbValide;
    private JPanel pBouttonsValidation;
    private JButton bValider;
    private JButton bAnnuler;
    private JButton bModifier;
    private JComboBox cbFiltre;
    private JButton bFiltrer;
    private JButton bListeAdmin;
    private JPanel pDetailsAdmin;
    private JLabel lAnnonceAdmin;
    private JLabel lNomAdmin;
    private JTextField tfNomAdmin;
    private JLabel lPrenomAdmin;
    private JTextField tfPrenomAdmin;
    private JLabel lAdresseAdmin;
    private JPanel pAdresse1;
    private JTextField tfNoRueAdmin;
    private JTextField tfRueAdmin;
    private JTextField tfComplementAdmin;
    private JPanel pAdresse2;
    private JTextField tfCdePostalAdmin;
    private JTextField tfPaysAdmin;
    private JLabel lMailAdmin;
    private JTextField tfMailAdmin;
    private JLabel lTelAdmin;
    private JTextField tfTelAdmin;
    private JButton bSupprimerAdmin;
    private JTextField tfVilleAdmin;
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

        pDetailsOffre.setVisible(false);
        pDetailsAdmin.setVisible(false);

        bFiltrer.addActionListener(new BFiltrerListener());
        bListeOffres.addActionListener(new BListeOffresListener());
        bListeAdmin.addActionListener(new BListeAdminsListener());
        bListeEntreprises.addActionListener(new BListeEntreprisesListener());
        bListeEtudiants.addActionListener(new BListeEtudiantsListener());
        sousMenu1.addActionListener(new SousMenu1ActionListener());
        sousMenu2.addActionListener(new SousMenu2ActionListener());

        //Bouttons des détails de l'offre
        bValider.addActionListener(new BValiderListener());
        bAnnuler.addActionListener(new BAnnulerListener());
        bModifier.addActionListener(new BModifierListener());

        //Bouttons des détails de l'administrateur
        bSupprimerAdmin.addActionListener(new BSupprimerAdminListener());

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
                if (String.valueOf(tContenu.getColumnName(1)).equals("libelle"))
                {
                    pDetailsOffre.setVisible(true);
                    String valeurId = String.valueOf(tContenu.getModel().getValueAt(tContenu.getSelectedRow(), 0)); //tContenu.getSelectedColumn()
                    OffreStage os = new OffreStageDAO().find(Integer.valueOf(valeurId));

                    tfId.setText(String.valueOf(os.getIdOffreStage()));
                    tfLibelle.setText(os.getLibelleOffre());
                    tfDomaine.setText(os.getDomaineOffre());
                    taDescriptif.setText(os.getDescriptifOffre());
                    tfDateDebut.setText(os.getDateDebut());
                    tfDuree.setText(os.getDureeOffre());
                    int validite = os.getIsValide();
                    if (validite == 0)
                        cbValide.setSelectedItem("En Attente");
                    else if (validite == 1)
                        cbValide.setSelectedItem("Acceptée");
                    else
                        cbValide.setSelectedItem("Declinée");

                /*DetailsOffreView detailsOffreView = new DetailsOffreView(os);
                pDetails = detailsOffreView.getpDetailsOffre();

                AdministrateurAccueilView.this.getContentPane().removeAll();

                AdministrateurAccueilView.this.pDetails.updateUI();
                AdministrateurAccueilView.this.pDetails.revalidate();
                AdministrateurAccueilView.this.getContentPane().revalidate();
                //AdministrateurAccueilView.this.setContentPane(container);
                AdministrateurAccueilView.this.getContentPane().repaint();
                AdministrateurAccueilView.this.setVisible(true);*/
                }
                else if (String.valueOf(tContenu.getColumnName(1)).equals("nom"))
                {
                    pDetailsAdmin.setVisible(true);
                    String valeurId = String.valueOf(tContenu.getModel().getValueAt(tContenu.getSelectedRow(), 0)); //tContenu.getSelectedColumn()
                    Administrateur a = new AdministrateurDAO().find(Integer.valueOf(valeurId));

                    tfNomAdmin.setText(a.getAdministrateurNom());
                    tfPrenomAdmin.setText(a.getAdministrateurPrenom());
                    tfNoRueAdmin.setText(String.valueOf(a.getAdresseNoRue()));
                    tfRueAdmin.setText(a.getAdresseRue());
                    tfComplementAdmin.setText(a.getAdresseComplement());
                    tfCdePostalAdmin.setText(String.valueOf(a.getAdresseCdePostal()));
                    tfVilleAdmin.setText(a.getAdresseVille());
                    tfPaysAdmin.setText(a.getAdressePays());
                    tfMailAdmin.setText(a.getAdministrateurMail());
                    tfTelAdmin.setText(String.valueOf(a.getAdministrateurTel()));

                /*DetailsOffreView detailsOffreView = new DetailsOffreView(os);
                pDetails = detailsOffreView.getpDetailsOffre();

                AdministrateurAccueilView.this.getContentPane().removeAll();

                AdministrateurAccueilView.this.pDetails.updateUI();
                AdministrateurAccueilView.this.pDetails.revalidate();
                AdministrateurAccueilView.this.getContentPane().revalidate();
                //AdministrateurAccueilView.this.setContentPane(container);
                AdministrateurAccueilView.this.getContentPane().repaint();
                AdministrateurAccueilView.this.setVisible(true);*/
                }
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

    class BFiltrerListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            AdministrateurDAO administrateurDAO = new AdministrateurDAO();
            AdministrateurController administrateurController = new AdministrateurController(administrateurDAO);

            int isValide;
            String motCle = cbFiltre.getSelectedItem().toString();
            if (motCle.equals("En Attente"))
                isValide = 0;
            else if (motCle.equals("Validée"))
                isValide = 1;
            else
                isValide = 2;

            ResultSetTableModel offresRS = new ResultSetTableModel(new OffreStageDAO().listeOffres(isValide));
            AdministrateurAccueilView administrateurAccueilView = new AdministrateurAccueilView(administrateurController, offresRS);
            AdministrateurAccueilView.this.dispose();
        }
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

    class BListeAdminsListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            AdministrateurDAO administrateurDAO = new AdministrateurDAO();
            AdministrateurController administrateurController = new AdministrateurController(administrateurDAO);
            ResultSetTableModel adminsRS = new ResultSetTableModel(new AdministrateurDAO().listeAdmins());
            AdministrateurAccueilView administrateurAccueilView = new AdministrateurAccueilView(administrateurController, adminsRS);
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
            //Attribution des variables statiques qui vont servir de session
            new Utilisateur().setId(0);
            new Utilisateur().setIdU(0);
            new Utilisateur().setNom("");
            new Utilisateur().setDroit(0);

            /*Fentre Authentification*/
            UtilisateurDAO uDAO = new UtilisateurDAO();
            AuthentificationController authController = new AuthentificationController(uDAO);
            AuthentificationView authentificationView = new AuthentificationView(authController);
            AdministrateurAccueilView.this.dispose();
        }
    }

    class BValiderListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            OffreStage os = new OffreStage();
            OffreStageDAO osDAO = new OffreStageDAO();

            os.setIdOffreStage(Integer.valueOf(tfId.getText()));
            os.setLibelleOffre(tfLibelle.getText());
            os.setDomaineOffre(tfDomaine.getText());
            os.setDescriptifOffre(taDescriptif.getText());
            os.setDateDebut(tfDateDebut.getText());
            os.setDureeOffre(tfDuree.getText());
            os.setEntreprise(new EntrepriseDAO().find(new Utilisateur().getIdU()));
            if (cbValide.getSelectedItem().toString().equals("En Attente"))
                os.setIsValide(0);
            else if (cbValide.getSelectedItem().toString().equals("Validée"))
                os.setIsValide(1);
            else
                os.setIsValide(2);

            osDAO.update(os);

            cbValide.setEnabled(false);
            bValider.setEnabled(false);
            bAnnuler.setEnabled(false);
        }
    }

    class BAnnulerListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            cbValide.setEnabled(false);
            bValider.setEnabled(false);
            bAnnuler.setEnabled(false);
        }
    }

    class BModifierListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            bValider.setEnabled(true);
            bAnnuler.setEnabled(true);
            cbValide.setEditable(false);
            cbValide.setEnabled(true);
        }
    }

    class BSupprimerAdminListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(JOptionPane.showConfirmDialog(null, "L'administrateur sera supprimé définitivement, en êtes-vous sûr ?")==JOptionPane.YES_OPTION)
            {
                String valeurId = String.valueOf(tContenu.getModel().getValueAt(tContenu.getSelectedRow(), 0)); //tContenu.getSelectedColumn()
                Administrateur a = new AdministrateurDAO().find(Integer.valueOf(valeurId));
                Utilisateur u = new UtilisateurDAO().find(a.getUtilisateur().getUitilisateurId());
                new AdministrateurDAO().delete(a);
                new UtilisateurDAO().delete(u);
            }
        }
    }
}