package Models;

import java.util.ArrayList;

import Models.DAO.OffreStageDAO;

public class EntrepriseMetier implements IMetierEnreprise {

	@Override
	public void proposerStage(OffreStage obj) {
		new OffreStageDAO().create(obj);
	}
    @Override
	public void stoperdOffre(OffreStage obj) {
		new OffreStageDAO().delete(obj);
	}

	@Override
	public ArrayList<EtuPostStage>recruter(OffreStage obj) {
		 new OffreStageDAO().getAllPostulans(obj);
		 return obj.getListPostulant();	
	}
	
	

}
