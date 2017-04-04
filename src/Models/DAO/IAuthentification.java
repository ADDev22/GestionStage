package Models.DAO;

import Models.Utilisateur;

public interface IAuthentification
{
	public Boolean connexion(String userName, String mdp);
	public Utilisateur find(String userName);
}
