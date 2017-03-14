package Models;

public class Utilisateur
{
	//D�claration
	
	protected int utilisateurId;
	protected String utilisateurUserName;
	protected String utilisateurMdp;
	protected Fonction fonction;

	//Constructeurs

    public Utilisateur()
    {

    }

	public Utilisateur(int utilisateurId, String utilisateurUserName, String utilisateurMdp, Fonction fonction)
	{
		this.utilisateurId = utilisateurId;
		this.utilisateurUserName = utilisateurUserName;
		this.utilisateurMdp = utilisateurMdp;
		this.fonction = fonction;
	}
		
	//Getter
		
	public int getUitilisateurId()
	{
		return this.utilisateurId;
	}
		
	public String getUtilisateurUserName()
	{
		return this.utilisateurUserName;
	}
		
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUtilisateurMdp()
	{
		return this.utilisateurMdp;
	}
		
	public Fonction getFonction()
	{
		return this.fonction;
	}
		
	//Setter
		
	public void setUtilisateurId(int utilisateurId)
	{
		this.utilisateurId = utilisateurId;
	}
		
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