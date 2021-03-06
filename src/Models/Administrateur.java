package Models;

public class Administrateur extends Utilisateur
{
	//Déclaration
	
	private int administrateurId;
	private String administrateurNom;
	private String administrateurPrenom;
	private int adresseNoRue;
	private String adresseRue;
	private String adresseComplement;
	private int adresseCdePostal;
	private String adresseVille;
	private String adressePays;
	private String administrateurMail;
	private int administrateurTel;
	private Utilisateur utilisateur;

	//Constructeurs
	public Administrateur()
	{

	}

	public Administrateur(int administrateurId, String administrateurNom, String administrateurPrenom, int adresseNoRue, String adresseRue, String adresseComplement, int adresseCdePostal, String adresseVille, String adressePays, String administrateurMail, int administrateurTel, Utilisateur utilisateur)
	{
		this.administrateurId = administrateurId;
		this.administrateurNom = administrateurNom;
		this.administrateurPrenom = administrateurPrenom;
		this.adresseNoRue = adresseNoRue;
		this.adresseRue = adresseRue;
		this.adresseComplement = adresseComplement;
		this.adresseCdePostal = adresseCdePostal;
		this.adresseVille = adresseVille;
		this.adressePays = adressePays;
		this.administrateurMail = administrateurMail;
		this.administrateurTel = administrateurTel;
		this.utilisateur = utilisateur;
	}
	
	//Getter
	
	public int getAdminstrateurId()
	{
		return this.administrateurId;
	}
	
	public String getAdministrateurNom()
	{
		return this.administrateurNom;
	}
	
	public String getAdministrateurPrenom()
	{
		return this.administrateurPrenom;
	}
	
	public int getAdresseNoRue()
	{
		return this.adresseNoRue;
	}
	
	public String getAdresseRue()
	{
		return this.adresseRue;
	}
	
	public String getAdresseComplement()
	{
		return this.adresseComplement;
	}
	
	public int getAdresseCdePostal()
	{
		return this.adresseCdePostal;
	}
	
	public String getAdresseVille()
	{
		return this.adresseVille;
	}
	
	public String getAdressePays()
	{
		return this.adressePays;
	}
	
	public String getAdministrateurMail()
	{
		return this.administrateurMail;
	}
	
	public int getAdministrateurTel()
	{
		return this.administrateurTel;
	}

	public Utilisateur getUtilisateur() { return this.utilisateur; }
	
	//Setter

	public void setAdministrateurId(int administrateurId) { this.administrateurId = administrateurId; }
	
	public void setAdministrateurNom(String administrateurNom)
	{
		this.administrateurNom = administrateurNom;
	}
	
	public void setAdministrateurPrenom(String administrateurPrenom)
	{
		this.administrateurPrenom = administrateurPrenom;
	}
	
	public void setAdresseNoRue(int adresseNoRue)
	{
		this.adresseNoRue = adresseNoRue;
	}
	
	public void setAdresseRue(String adresseRue)
	{
		this.adresseRue = adresseRue;
	}
	
	public void setAdresseComplement(String adresseComplement)
	{
		this.adresseComplement = adresseComplement;
	}
	
	public void setAdresseCdePostal(int adresseCdePostal)
	{
		this.adresseCdePostal = adresseCdePostal;
	}
	
	public void setAdresseVille(String adresseVille)
	{
		this.adresseVille = adresseVille;
	}
	
	public void setAdressePays(String adressePays)
	{
		this.adressePays = adressePays;
	}
	
	public void setAdministrateurMail(String administrateurMail)
	{
		this.administrateurMail = administrateurMail;
	}
	
	public void setAdministrateurTel(int administrateurTel)
	{
		this.administrateurTel = administrateurTel;
	}

	public void setUtilisateur(Utilisateur utilisateur) { this.utilisateur = utilisateur; }
}