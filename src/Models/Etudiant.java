package Models;

import java.util.ArrayList;

public class Etudiant  extends Utilisateur{
private String nom;
private String prenom;
private int idEtudiant;
private String domEtude;
private String nivEtude;
private String tel;
private String mail;
private ArrayList<EtuPostStage> listStagePostule = new ArrayList<EtuPostStage>();
public Etudiant(int idType, int idEtudiant, String pseudo, String mdp, String nom, String prenom, String nivEtude,
		String tel, String mail) {
	//super(idType, pseudo, mdp);
	this.nom = nom;
	this.prenom = prenom;
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

public String getDomEtude() {
	return domEtude;
}
public void setDomEtude(String domEtude) {
	this.domEtude = domEtude;
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
public ArrayList<EtuPostStage> getListStagePostule() {
	return listStagePostule;
}
public void setNom(String nom) {
	this.nom = nom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
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
public void setListStagePostule(ArrayList<EtuPostStage> listStagePostule) {
	this.listStagePostule = listStagePostule;
}
// Ajouter un offre qu'on a postulé
public void addStagePostule(EtuPostStage stagePostule){
	this.listStagePostule.add(stagePostule);
}
// Obtenir un offre qu'on a postulé
public EtuPostStage getPostulant(int indice){
return this.listStagePostule.get(indice);
}
}
