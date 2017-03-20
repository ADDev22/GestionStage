package Controllers;

import Models.DAO.IAuthentification;
import Models.DAO.UtilisateurDAO;
import Models.Utilisateur;

public class AuthentificationController
{
	//Déclaration

	IAuthentification iAuth;
	private String userName;
	private String mdp;

	//Constructeur

	public AuthentificationController(UtilisateurDAO uDao)
	{
		this.iAuth = uDao;
	}

	//Setter

	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	
	public void setMdp(String mdp)
	{
		this.mdp = mdp;
	}

	//Tentative de connexion
	public void authentification()
	{
		if(iAuth.connexion(this.userName, this.mdp))
		{
			System.out.println("Connexion réussi");
		}
	}
}
