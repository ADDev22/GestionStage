package Controllers;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Models.DAO.EtudiantDAO;
import Models.CandModel;
import Models.Entreprise;
import Models.EtuPostStage;
import Models.Etudiant;
import Models.EtudiantModel;
import Models.OffreEtuModel;
import Models.OffreModel;
import Models.OffreStage;
import Models.DAO.EntrepriseDAO;
import Models.DAO.EtuPostStageDAO;
import Models.DAO.EtudiantDAO;
import Models.DAO.OffreStageDAO;
import Views.Etudiant.EtudiantView;

public class EtudiantController {
private Etudiant et;
private EtudiantView etView;
private OffreEtuModel ofModel;
private CandModel etCand;

public Etudiant getEt() {
	return et;
}
public CandModel getEtCand() {
	return etCand;
}
public void setEtCand(CandModel etCand) {
	this.etCand = etCand;
}
public EtudiantView getEtView() {
	return etView;
}
public void setEt(Etudiant et) {
	this.et = et;
}
public void setEtView(EtudiantView etView) {
	this.etView = etView;
}
public EtudiantController(Etudiant e)
{   this.et=e;
    this.etCand = new CandModel();
    this.etCand.loadCand(et.getListStagePostule());
	this.ofModel = new OffreEtuModel();
	this.ofModel.loadOffre(new OffreStageDAO().getAllOffreStage());
	this.etView =new EtudiantView(this);
	
}
public OffreEtuModel getOfModel() {
	return ofModel;
}
public void setOfModel(OffreEtuModel ofModel) {
	this.ofModel = ofModel;
}
public void postuler(OffreStage of)
{ 
	EtuPostStage cand = new EtuPostStage();
	cand.setEtudiant(et);
	cand.setOffre(of);
	//cand.setDatePostule(datePostule);
	new EtuPostStageDAO().create(cand);
}

public void mettreCV()
{
	JFileChooser choix = new JFileChooser();
	int retour=choix.showOpenDialog(this.getEtView());
	if(retour==JFileChooser.APPROVE_OPTION){
	   // un fichier a été choisi (sortie par OK)
	   // nom du fichier  choisi 
	  // 
	   // chemin absolu du fichier choisi
	   et.setCv(choix.getSelectedFile().getName());
	}
	else {
		} ;// pas de fichier choisi}
	}
public void visualiser(OffreStage of)
{
	
}
public void recherche(String domaine)
{
	ofModel.loadOffre(new OffreStageDAO().getAllOffreStage(domaine));
	}
public static  void insert(Etudiant e)
{
	new EtudiantDAO().create(e);

	//Affichage de la boite de dialogue
	JOptionPane jOP = new JOptionPane();
	jOP.showMessageDialog(null, "Enregistrement réussie", "Information", JOptionPane.INFORMATION_MESSAGE);
}
}
