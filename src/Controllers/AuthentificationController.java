package Controllers;

import Models.DAO.IAuthentification;
import Models.Utilisateur;

public class AuthentificationController {
	IAuthentification iAuth = (IAuthentification) new Utilisateur();
	private String userName;
	private String mdp;
	
	public AuthentificationController()
	{
		//
	}
	
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	
	public void setMdp(String mdp)
	{
		this.mdp = mdp;
	}
	
	public void authentification()
	{
		if(iAuth.connexion(this.userName, this.mdp)){}
	}
}
