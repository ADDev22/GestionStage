package Models;

public class Utilisateur
{
	//Déclaration

	/*Variables qui vont servir de session*/
	private static int id;
	private static String nom;
	private static int droit;

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

	public int getId() { return this.id; }

	public String getNom() { return this.nom; }

	public int getDroit() { return this.droit; }
		
	public int getUitilisateurId()
	{
		return this.utilisateurId;
	}
		
	public String getUtilisateurUserName()
	{
		return this.utilisateurUserName;
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

	public void setId(int id) { this.id = id; }

	public void setNom(String nom) { this.nom = nom; }

	public void setDroit(int droit) { this.droit = droit; }
		
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