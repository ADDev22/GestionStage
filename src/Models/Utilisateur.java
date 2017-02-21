package Models;

public class Utilisateur {
	protected int id;
	protected int idType; // Etudiant ou Admin ou Entre
	protected  String pseudo;
	protected String mdp;
	protected Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Utilisateur(int idType, String pseudo, String mdp) {
		super();
		this.idType = idType;
		this.pseudo = pseudo;
		this.mdp = mdp;
	}
	private int getIdType() {
		return idType;
	}
	private String getPseudo() {
		return pseudo;
	}
	private String getMdp() {
		return mdp;
	}
	private void setIdType(int idType) {
		this.idType = idType;
	}
	private void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	private void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	
	

}
