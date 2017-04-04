package Controllers;

import Models.Administrateur;
import Models.DAO.*;
import Models.Entreprise;
import Models.Etudiant;
import Models.Utilisateur;
import Views.Administrateur.AdministrateurAccueilView;
import Views.Administrateur.ResultSetTableModel;

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
				admin = aDAO.findTypeUser(utilisateur.getUitilisateurId());

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
				ent = eDAO.findTypeUser(utilisateur.getUitilisateurId());
			}
			else
			{
				Etudiant et = new Etudiant();
				DAO<Etudiant> eDAO = new EtudiantDAO();
				et = eDAO.findTypeUser(utilisateur.getUitilisateurId());
			}
			return true;
		}
		return false;
	}
}
