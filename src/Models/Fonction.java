package Models;

public class Fonction
{
	//D�claration
	
	private int fonctionId;
	private String fonctionNom;
		
	//Getter
		
	public int getFonctionId()
	{
		return this.fonctionId;
	}
		
	public String getFonctionNom()
	{
		return this.fonctionNom;
	}
		
	//Setter
	public void setFonctionId(int fonctionId)
	{
		this.fonctionId = fonctionId;
	}
		
	public void setFonctionNom(String fonctionNom)
	{
		this.fonctionNom = fonctionNom;
	}
}