package Models.DAO;

import Models.Entreprise;
import Models.Etudiant;
import Models.OffreStage;

public class TestDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Entreprise e1 = new  Entreprise(); e1.setRaisonSociale("ORANGE");
		e1.setMail("org@mail.com");e1.setAdresseCodePostaleEnt(75000);e1.setAdresseRueEnt("322");e1.setTel("06545444");e1.setAdresseVilleEnt("PARIS");
		e1.setSecteurActivite("INFO");
		
	 // Test EntrepriseDAO
		EntrepriseDAO e1DAO = new EntrepriseDAO();
		           e1DAO.create(e1);  //Work !!!
		           System.out.println(e1.getIdEntreprise());
		          //  Entreprise e1f= e1DAO.find(2); Work !!!  System.out.println(e1f.getRaisonSociale());
		         e1.setIdEntreprise(27);
		       // e1.setAdresseCodePostaleEnt(75008);
		        //e1DAO.update(e1);  Work !!!
		         //e1DAO.delete(e1); Work !!!
		        // e1DAO.getAllOffreStage(e1);

	  //Test EtudiantDAO
	             // EtudiantDAO etDAO = new EtudiantDAO();
	               // Etudiant et = new Etudiant(); 
	                 // et.setNom("ALAM");et.setPrenom("MHD");et.setUtilisateurId(2);
	                   //etDAO.create(et);// Work !!!
	                  // System.out.println(etDAO.find(3).getNom()); Work !!!
	                  // et.setDomEtude("INFO");
	                   //et.setIdEtudiant(3); //etDAO.update(et); Work !!!
	                     // etDAO.delete(et); Work !!!
	// Test OffreStageDAO
	                   //OffreStageDAO ofDAO = new OffreStageDAO();
	                   //OffreStage of = new  OffreStage();
	                   //of.setDateDebut("020817"); of.setDescriptifOffre("PHP");of.setEntreprise(e1);
	                  // ofDAO.create(of);  Work !!!
                  // of.setDescriptifOffre("Blabla");of.setIdOffreStage(1);ofDAO.update(of); Work !!!
	                  // System.out.println(ofDAO.find(1).getDateDebut()); Work !!!
	                   //of.setIdOffreStage(1); ofDAO.delete(of); Work !!!
                   
	}	                

}
