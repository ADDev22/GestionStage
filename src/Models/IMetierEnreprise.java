package Models;

import java.util.ArrayList;

public interface IMetierEnreprise {

	public void proposerStage(OffreStage obj);
	public void stoperdOffre(OffreStage obj);
	public ArrayList< EtuPostStage> recruter(OffreStage obj);
}
