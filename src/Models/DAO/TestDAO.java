package Models.DAO;

import Controllers.EntrepriseController; 
import Controllers.EtudiantController;
import Models.Entreprise;
import Models.EtuPostStage;
import Models.Etudiant;
import Models.Fonction;
import Models.OffreStage;
import Views.Compte.AuthentificationView;
import Views.Entreprise.EntrepriseInscView;
import Views.Entreprise.EntrepriseView;
import Views.Etudiant.EtudiantView;

public class TestDAO {

	public static void main(String[] args) {		// TODO Auto-generated method stub
	Fonction f1 =new Fonction(); f1.setFonctionId(2); f1.setFonctionNom("Entreprise");
		Entreprise e1 = new  Entreprise(); e1.setRaisonSociale("ORANGE"); e1.setIdEntreprise(3);
		e1.setMail("org@mail.com");e1.setAdresseCodePostaleEnt(75000);e1.setAdresseRueEnt("322");e1.setTel("06545444");e1.setAdresseVilleEnt("PARIS");
		e1.setSecteurActivite("INFO");
		e1.setUtilisateurUserName("Sanva");e1.setUtilisateurMdp("root");e1.setFonction(f1);
      EntrepriseController e = new EntrepriseController(e1);
	 // Test EntrepriseDAO
		 // EntrepriseDAO e1DAO = new EntrepriseDAO();
		        //e1DAO.create(e1);  //Work !!!
		    ///       System.out.println(e1.getIdEntreprise());
		          //  Entreprise e1f= e1DAO.find(2); Work !!!  System.out.println(e1f.getRaisonSociale());
		        // e1.setIdEntreprise(27);
		       // e1.setAdresseCodePostaleEnt(75008);
		        //e1DAO.update(e1);  Work !!!
		         //e1DAO.delete(e1); Work !!!
		        // e1DAO.getAllOffreStage(e1);

	  //Test EtudiantDAO
	             //EtudiantDAO etDAO = new EtudiantDAO(); Fonction f =new Fonction(); f.setFonctionNom("Etudiant");
	               // Etudiant et = new Etudiant(); f.setFonctionId(3);
	                 // et.setNom("ALAM");et.setPrenom("MHD"); et.setFonction(f);
	                   //etDAO.create(et);// Work !!!
	                  // System.out.println(etDAO.find(3).getNom()); Work !!!
	                  //et.setDomEtude("INFO");
	                   //et.setIdEtudiant(3); //etDAO.update(et); Work !!!
	                     // etDAO.delete(et); Work !!!
	     //Test OffreStageDAO
	                  // OffreStageDAO ofDAO = new OffreStageDAO();
	                  //OffreStage of = new  OffreStage();
	                   //of.setDateDebut("020817"); of.setDescriptifOffre("PHP");of.setEntreprise(e1);of.setLibelleOffre("Dev");
	                   //of.setDescriptifOffre("Dev en language en R");of.setDureeOffre("30 mois");
	                   //ofDAO.create(of);  //Work !!!
	                 //  new EntrepriseInscView();
                  // of.setDescriptifOffre("Blabla");of.setIdOffreStage(1);ofDAO.update(of); Work !!!
	                  // System.out.println(ofDAO.find(1).getDateDebut()); Work !!!
	                   //of.setIdOffreStage(1); ofDAO.delete(of); Work !!!
// Test EtuPostStage    
	                  ///EtuPostStageDAO ofEtD =new EtuPostStageDAO();
	                  //EtuPostStage ofEt = new EtuPostStage();
	                  //ofEt.setEtudiant(et);ofEt.setOffre(of);
	                  //ofEtD.create(ofEt);
                   
	                  //new EntrepriseInscView();
		             Etudiant es = new EtudiantDAO().find(2);
		             //EtudiantController et = new EtudiantController(es);
		
		              //new EtudiantView(et);
	                  //new EntrepriseView(e).setVisible(true);
		  //new EntrepriseView().setVisible(true);;
		     //UtilisateurDAO uDAO = new UtilisateurDAO();
		     //AuthentificationController auC = new AuthentificationController(uDAO);
		       //AuthentificationView aVi = new AuthentificationView(auC);
	}	                

}
