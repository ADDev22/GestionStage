package Views.Etudiant;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Controllers.AuthentificationController;
import Controllers.EntrepriseController;
import Controllers.EtudiantController;
import Models.Administrateur;
import Models.DAO.AdministrateurDAO;
import Models.DAO.EntrepriseDAO;
import Models.DAO.EtudiantDAO;
import Models.DAO.UtilisateurDAO;
import Models.Entreprise;
import Models.Etudiant;
import Models.Utilisateur;
import Views.Administrateur.AdministrateurAccueilView;
import Views.Compte.AuthentificationView;
import Views.Profil.ProfilAdministrateurView;
import Views.Profil.ProfilEntrepriseView;
import Views.Profil.ProfilEtudiantView;
import Views.Profil.ProfilView;

public class EtudiantView extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menu = new JMenu("Fichier");
	private JMenuItem sousMenu1 = new JMenuItem("Profil");
	private JMenuItem sousMenu2 = new JMenuItem("Déconnexion");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//EntrepriseView frame = new EntrepriseView();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public EtudiantView(EtudiantController etC) {
		etC.setEtView(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.setTitle("ACCUEIL");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JTabbedPane onglets = new JTabbedPane();
		 PannelOffreEtuView ongletOf = new PannelOffreEtuView(etC);
		 ongletOf.setEt(etC);
		 PannelMesCandEtuView ongletCand = new PannelMesCandEtuView(etC);
		 ongletCand.setEt(etC);
		 //onglets.setVisible(true);
		 onglets.addTab("Offres", ongletOf);
		 onglets.add("Mes Candidatures", ongletCand);
		 getContentPane().add(onglets);
			setSize(1090,595);
			setResizable(false);
			setVisible(true);

		sousMenu1.addActionListener(new SousMenu1ActionListener());
		sousMenu2.addActionListener(new SousMenu2ActionListener());

		//Menu
		menuBar.add(menu);
		//Ajout des sous menus
		menu.add(sousMenu1);
		menu.add(sousMenu2);
		//Définition à l'intérieur du panel
		this.setJMenuBar(menuBar);
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
				EtudiantView.this.dispose();
			}
			else if (u.getDroit() == 2)
			{
				Entreprise ent = new EntrepriseDAO().find(u.getIdU());
				ProfilView profilView = new ProfilView(new ProfilEntrepriseView(ent).getpProfilEntreprise());
				EtudiantView.this.dispose();
			}
			else
			{
				Etudiant et = new EtudiantDAO().find(u.getIdU());
				ProfilView profilView = new ProfilView(new ProfilEtudiantView(et).getpProfilEtudiant());
				EtudiantView.this.dispose();
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
			EtudiantView.this.dispose();
		}
	}

}
