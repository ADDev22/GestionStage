package Controllers;

import Models.DAO.IAuthentification;
import Models.DAO.UtilisateurDAO;
import Models.Utilisateur;

public class AuthentificationController
{
	//Déclaration

	IAuthentification iAuth;

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
			return true;
		}

		return false;
	}
}
