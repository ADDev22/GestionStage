package Models;

public class Utilisateur
{
	//Déclaration
	
		protected int utilisateurId;
		protected String utilisateurUserName;
		protected String utilisateurMdp;
		protected Fonction fonction;
		
		//Getter
		
		public int getUitilisateurId()
		{
			return this.utilisateurId;
		}
		
		public String getUtilisateurUserName()
		{
			return this.utilisateurUserName;
		}
		
		public Fonction getFonction()
		{
			return this.fonction;
		}
		
		//Setter
		
		public void setUtilisateurUserName(String utilisateurUserName)
		{
			this.utilisateurUserName = utilisateurUserName;
		}
		
		public void setUtilisateurMdp(String utilisateurMdp)
		{
			this.utilisateurMdp = utilisateurMdp;
		}
		
		public void setFonction(Fonction fonction)
		{
			this.fonction = fonction;
		}
}