package Models;

public class Etudiant  extends Utilisateur{
private String nom;
private String prenom;
private int idEtudiant;
private String nivEtude;
private String tel;
private String mail;
public Etudiant(int idType, String pseudo, String mdp, String nom, String prenom, int idEtudiant, String nivEtude,
		String tel, String mail) {
	super(idType, pseudo, mdp);
	this.nom = nom;
	prenom = prenom;
	this.idEtudiant = idEtudiant;
	this.nivEtude = nivEtude;
	this.tel = tel;
	this.mail = mail;
}
public Etudiant() {
	super();
	// TODO Auto-generated constructor stub
}
public String getNom() {
	return nom;
}
public String getPrenom() {
	return prenom;
}
public int getIdEtudiant() {
	return idEtudiant;
}
public String getNivEtude() {
	return nivEtude;
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
	prenom = prenom;
}
public void setIdEtudiant(int idEtudiant) {
	this.idEtudiant = idEtudiant;
}
public void setNivEtude(String nivEtude) {
	this.nivEtude = nivEtude;
}
public void setTel(String tel) {
	this.tel = tel;
}
public void setMail(String mail) {
	this.mail = mail;
}

}
