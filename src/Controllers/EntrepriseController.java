package Controllers;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Models.Entreprise;
import Models.EtuPostStage;
import Models.Etudiant;
import Models.EtudiantModel;
import Models.OffreModel;
import Models.OffreStage;
import Models.DAO.EntrepriseDAO;
import Models.DAO.EtuPostStageDAO;
import Models.DAO.EtudiantDAO;
import Models.DAO.OffreStageDAO;
import Views.Entreprise.EntrepriseModifOffre;
import Views.Entreprise.EntreprisePropOffreView;
import Views.Entreprise.EntrepriseRecrtView;
import Views.Entreprise.EntrepriseView;

public class EntrepriseController {
	private OffreModel ofModel;
	private EtudiantModel eTModel;
	private EntrepriseView entView;
	private EntrepriseRecrtView etView;
	public EntrepriseView getEntView() {
		return entView;
	}

	public void setEntView(EntrepriseView entView) {
		this.entView = entView;
	}

	public EntrepriseRecrtView getEtView() {
		return etView;
	}

	public void setEtView(EntrepriseRecrtView etView) {
		this.etView = etView;
	}
	private Entreprise e;
	public EtudiantModel geteTModel() {
		return eTModel;
	}

	public void seteTModel(EtudiantModel eTModel) {
		this.eTModel = eTModel;
	}
	private OffreStage offreSelec;
	
	public Entreprise getE() {
		return e;
	}
	public OffreStage getOffreSelec() {
		return offreSelec;
	}

	public void setE(Entreprise e) {
		this.e = e;
	}

	public void setOffreSelec(OffreStage offreSelec) {
		this.offreSelec = offreSelec;
	}

	public EntrepriseController(Entreprise e) {
		super();
		this.e=e;
		ofModel= new OffreModel();
		new EntrepriseDAO().getAllOffreStage(e);
		ofModel.loadOffre(e.getListOfOffreSTage());
		eTModel = new EtudiantModel();
		this.setEntView(new EntrepriseView(this));
	}
  
	public void rechercheOf(String domaine)
	{   
		ofModel.removeRowAll();
		if(domaine=="AUTRES")
		{
		  new EntrepriseDAO().getAllOffreStage(e);
		}
		else
		{
		   new EntrepriseDAO().getAllOffreStage(e,domaine);
		}
		  this.ofModel.loadOffre(e.getListOfOffreSTage());
	}
	public void rechercheEt(String domaine)
	{   
		
		if(domaine=="")
		{
		  new EntrepriseDAO().getAllOffreStage(e);
		}
		else
		{
		   new EntrepriseDAO().getAllOffreStage(e,domaine);
		}
		  this.ofModel.loadOffre(e.getListOfOffreSTage());
		  this.ofModel.setListOf(e.getListOfOffreSTage());
	}
	public void deconnexion()
	{
	  etView.dispose();
	  
	}
	public void ajouter()
	{
		new EntreprisePropOffreView(this);
	}
	public OffreModel getOfModel() {
		return ofModel;
	}
	public void setOfModel(OffreModel ofModel) {
		this.ofModel = ofModel;
	}
	public void suppOf(int row)
	{
		if(JOptionPane.showConfirmDialog(null, "L'offre sera supprimé definitivement dans notre base de donnée Voulez vous supprimer ?")==JOptionPane.YES_OPTION)
		{
			new OffreStageDAO().delete(offreSelec);
			this.ofModel.removeRow(row);
			this.ofModel.getListOf().remove(row);
		}
		
	}
	public void suppEt(int row) // -> L'entrepise pour l'enlever dans le Modele ou BD lorsqu'un recrute ou Decline
	{}
	public void recruter()
	{	
		ArrayList<Etudiant> listEt = new ArrayList<Etudiant>();
		ArrayList<EtuPostStage> listCand = new ArrayList<EtuPostStage>();
		new OffreStageDAO().getAllPostulans(offreSelec);
		listCand= offreSelec.getListPostulant();
		for(EtuPostStage cand : listCand)
		{
			listEt.add(new EtudiantDAO().find(cand.getEtudiant().getIdEtudiant()));
		}
		// On passe la lise d'etudiant crees au modele
		eTModel.loadEtud(listEt);
		new EntrepriseRecrtView(this).setVisible(true);
		this.getEntView().setVisible(false);
	}
	public void modifierOffre()
	{
		new EntrepriseModifOffre(this);
		
	}
	public static  void insert(Entreprise e)
	{
		new EntrepriseDAO().create(e);

		//Affichage de la boite de dialogue
		JOptionPane jOP = new JOptionPane();
		jOP.showMessageDialog(null, "Enregistrement réussie", "Information", JOptionPane.INFORMATION_MESSAGE);
	}
}
