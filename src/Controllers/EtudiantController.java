package Controllers;

import java.util.Date;
import java.text.SimpleDateFormat;

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
import Views.LecteurPDF;
import Views.Etudiant.EtudiantView;

public class EtudiantController {
private Etudiant et;
private EtudiantView etView;
private OffreEtuModel ofModel;
private CandModel etCand;

public Etudiant getEt() {
	return et;
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
public CandModel getEtCand() {
	return etCand;
}
public void setEtCand(CandModel etCand) {
	this.etCand = etCand;
}
public EtudiantController(Etudiant e)
{   this.et=e;
    this.etCand = new CandModel();
    new EtudiantDAO().getAllMesCandidatures(et); // ->recup lis de mes cand
    this.etCand.loadCand(et.getListStagePostule());
	this.ofModel = new OffreEtuModel();
	this.ofModel.loadOffre(new OffreStageDAO().getAllOffreStagePourEt());
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
	for(EtuPostStage pos : etCand.getListCand())
	{
      if(pos.getOffre().getIdOffreStage()==of.getIdOffreStage())
      {
    		JOptionPane.showMessageDialog(null, "Vous avez deja postulé pour cette offre", "Information", JOptionPane.INFORMATION_MESSAGE);
    		return;
      }
	}
	EtuPostStage cand = new EtuPostStage();
	cand.setEtudiant(et);
	cand.setOffre(of);
	Date aujourdhui = new Date();
	SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
	cand.setDatePostule(formater.format(aujourdhui).toString());
	new EtuPostStageDAO().create(cand);
      new EtudiantDAO().getAllMesCandidatures(et); // ->recup lis de mes cand
   this.etCand.loadCand(et.getListStagePostule());
	JOptionPane.showMessageDialog(null, "Votre candidature a été prise en compte","INFORMATIONS", JOptionPane.INFORMATION_MESSAGE);
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
	   et.setCv(choix.getSelectedFile().getAbsolutePath());
	   new EtudiantDAO().update(et);
	}
	else {
		} ;// pas de fichier choisi}
	}
public void visualiser(OffreStage of)
{
	if(of.getCheminOffre()=="")
		JOptionPane.showMessageDialog(null, "Pas de descriptif complet ", "Information", JOptionPane.INFORMATION_MESSAGE);
		
	try {
		new LecteurPDF(of.getCheminOffre());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void recherche(String domaine)
{
	ofModel.loadOffre(new OffreStageDAO().getAllOffreStage(domaine));
	}
public static  void insert(Etudiant e)
{
	new EtudiantDAO().create(e);

	//Affichage de la boite de dialogue

	JOptionPane.showMessageDialog(null, "Enregistrement réussie", "Information", JOptionPane.INFORMATION_MESSAGE);
}
}
