package Controllers;

import Models.DAO.DAO;
import Models.DAO.EntrepriseDAO;
import Models.Entreprise;

import javax.swing.*;

public class EntrepriseController {
	  
	//Déclaration
	DAO<Entreprise> DAO = new EntrepriseDAO();

	public void deposeOffre()
	{
		// IHM ->pour deposer un offre
	}

	//Ajout d'une entreprise
	public void insert(Entreprise e)
	{
		DAO.create(e);

		//Affichage de la boite de dialogue
		JOptionPane jOP = new JOptionPane();
		jOP.showMessageDialog(null, "Enregistrement réussie", "Information", JOptionPane.INFORMATION_MESSAGE);
	}
}
