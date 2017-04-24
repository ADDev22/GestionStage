package Models;

import java.util.Date;

public class EtuPostStage {
	private int idEtuPostStage;
	private Etudiant etudiant;
	private OffreStage offre;
	private String datePostule;
	private int isAccept;
	public int getIsAccept() {
		return isAccept;
	}
	public void setIsAccept(int isAccept) {
		this.isAccept = isAccept;
	}
	public EtuPostStage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EtuPostStage(int idEtuPostStage, Etudiant etudiant, OffreStage offre, String datePostule) {
		super();
		this.idEtuPostStage = idEtuPostStage;
		this.etudiant = etudiant;
		this.offre = offre;
		this.datePostule = datePostule;
	}
	public int getIdEtuPostStage() {
		return idEtuPostStage;
	}
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public OffreStage getOffre() {
		return offre;
	}
	public String getDatePostule() {
		return datePostule;
	}
	public void setIdEtuPostStage(int idEtuPostStage) {
		this.idEtuPostStage = idEtuPostStage;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	public void setOffre(OffreStage offre) {
		this.offre = offre;
	}
	public void setDatePostule(String datePostule) {
		this.datePostule = datePostule;
	}
	

}
