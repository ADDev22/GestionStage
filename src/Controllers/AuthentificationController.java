package Controllers;

import Models.Administrateur;
import Models.DAO.*;
import Models.Entreprise;
import Models.Etudiant;
import Models.Utilisateur;
import Views.Administrateur.AdministrateurAccueilView;
import Views.Administrateur.ResultSetTableModel;
import Views.Profil.ProfilEntrepriseView;
import Views.Profil.ProfilEtudiantView;
import Views.Profil.ProfilView;

import javax.swing.*;

public class AuthentificationController
{
	//Déclaration

	IAuthentification iAuth;
	Utilisateur utilisateur = new Utilisateur();
	UtilisateurDAO uDAO = new UtilisateurDAO();

	//Constructeur

	public AuthentificationController(UtilisateurDAO uDao)
	{
		this.iAuth = uDao;
	}

	//Tentative de connexion
	public boolean authentification(Utilisateur u)
	{
		if(iAuth.connexion(u.getUtilisateurUserName(), u.getUtilisateurMdp()))
		{
			utilisateur = this.iAuth.find(u.getUtilisateurUserName());
			if (utilisateur.getFonction().getFonctionId() == 1)
			{
				Administrateur admin = new Administrateur();
				DAO<Administrateur> aDAO = new AdministrateurDAO();
				admin = (Administrateur) aDAO.findTypeUser(utilisateur.getUitilisateurId());

				//Attribution des variables statiques qui vont servir de session
				utilisateur.setId(admin.getUtilisateur().getUitilisateurId());
				utilisateur.setIdU(admin.getAdminstrateurId());
				utilisateur.setNom(admin.getAdministrateurNom() + " " + admin.getAdministrateurPrenom());
				utilisateur.setDroit(admin.getUtilisateur().getFonction().getFonctionId());

				//Affichage de la boite de dialogue
				JOptionPane jOP = new JOptionPane();
				jOP.showMessageDialog(null, "Connexion réussie : " + admin.getAdministrateurNom() + " " + admin.getAdministrateurPrenom(), "Information", JOptionPane.INFORMATION_MESSAGE);

				AdministrateurDAO administrateurDAO = new AdministrateurDAO();
				AdministrateurController administrateurController = new AdministrateurController(administrateurDAO);
				ResultSetTableModel offresRS = new ResultSetTableModel(new OffreStageDAO().listeOffres());
				AdministrateurAccueilView administrateurAccueilView = new AdministrateurAccueilView(administrateurController, offresRS);
			}
			else if (utilisateur.getFonction().getFonctionId() == 2)
			{
				Entreprise ent = new Entreprise();
				DAO<Entreprise> eDAO = new EntrepriseDAO();
				ent = (Entreprise) eDAO.findTypeUser(utilisateur.getUitilisateurId());

				//Attribution des variables statiques qui vont servir de session
				utilisateur.setId(ent.getUitilisateurId());
				utilisateur.setIdU(ent.getIdEntreprise());
				utilisateur.setNom(ent.getRaisonSociale());
				utilisateur.setDroit(2);

				//Affichage de la boite de dialogue
				JOptionPane jOP = new JOptionPane();
				jOP.showMessageDialog(null, "Connexion réussie : " +ent.getRaisonSociale(), "Information", JOptionPane.INFORMATION_MESSAGE);

				ProfilView profilView = new ProfilView(new ProfilEntrepriseView(ent).getpProfilEntreprise());
			}
			else
			{
				Etudiant et = new Etudiant();
				DAO<Etudiant> eDAO = new EtudiantDAO();
				et = (Etudiant) eDAO.findTypeUser(utilisateur.getUitilisateurId());

				//Attribution des variables statiques qui vont servir de session
				utilisateur.setId(et.getUitilisateurId());
				utilisateur.setIdU(et.getIdEtudiant());
				utilisateur.setNom(et.getNom() + " " + et.getPrenom());
				utilisateur.setDroit(3);

				//Affichage de la boite de dialogue
				JOptionPane jOP = new JOptionPane();
				jOP.showMessageDialog(null, "Connexion réussie : " + et.getNom() + " " + et.getPrenom(), "Information", JOptionPane.INFORMATION_MESSAGE);

				ProfilView profilView = new ProfilView(new ProfilEtudiantView(et).getpProfilEtudiant());
			}
			return true;
		}
		return false;
	}
}