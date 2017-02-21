package Models;

public class Admin extends Utilisateur{
	private String nom;
	private String prenom;
	private String profession;
	private String tel;
	private String mail;
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(int idType, String pseudo, String mdp, String nom, String prenom, String profession, String tel,
			String mail) {
		super(idType, pseudo, mdp);
		this.nom = nom;
		this.prenom = prenom;
		this.profession = profession;
		this.tel = tel;
		this.mail = mail;
	}
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public String getProfession() {
		return profession;
	}
	public String getTel() {
		return tel;
	}
	public String getMail() {
		return mail;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	

}
