package Models;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Administrateur extends Utilisateur
{
	//D�claration
	
	private int administrateurId;
	private String administrateurNom;
	private String administrateurPrenom;
	private int adresseNoRue;
	private String adresseRue;
	private String adresseComplement;
	private int adresseCdePostal;
	private String adresseVille;
	private String adressePays;
	private String administrateurMail;
	private int administrateurTel;
	
	//Getter
	
	public int getAdminstrateurId()
	{
		return this.administrateurId;
	}
	
	public String getAdministrateurNom()
	{
		return this.administrateurNom;
	}
	
	public String getAdministrateurPrenom()
	{
		return this.administrateurPrenom;
	}
	
	public int getAdresseNoRue()
	{
		return this.adresseNoRue;
	}
	
	public String getAdresseRue()
	{
		return this.adresseRue;
	}
	
	public String getAdresseComplement()
	{
		return this.adresseComplement;
	}
	
	public int getAdresseCdePostal()
	{
		return this.adresseCdePostal;
	}
	
	public String getAdresseVille()
	{
		return this.adresseVille;
	}
	
	public String getAdressePays()
	{
		return this.adressePays;
	}
	
	public String getAdministrateurMail()
	{
		return this.administrateurMail;
	}
	
	public int getAdministrateurTel()
	{
		return this.administrateurTel;
	}
	
	//Setter

	public void setAdministrateurId(int administrateurId) { this.administrateurId = administrateurId; }
	
	public void setAdministrateurNom(String administrateurNom)
	{
		this.administrateurNom = administrateurNom;
	}
	
	public void setAdministrateurPrenom(String administrateurPrenom)
	{
		this.administrateurPrenom = administrateurPrenom;
	}
	
	public void setAdresseNoRue(int adresseNoRue)
	{
		this.adresseNoRue = adresseNoRue;
	}
	
	public void setAdresseRue(String adresseRue)
	{
		this.adresseRue = adresseRue;
	}
	
	public void setAdresseComplement(String adresseComplement)
	{
		this.adresseComplement = adresseComplement;
	}
	
	public void setAdresseCdePostal(int adresseCdePostal)
	{
		this.adresseCdePostal = adresseCdePostal;
	}
	
	public void setAdresseVille(String adresseVille)
	{
		this.adresseVille = adresseVille;
	}
	
	public void setAdressePays(String adressePays)
	{
		this.adressePays = adressePays;
	}
	
	public void setAdministrateurMail(String administrateurMail)
	{
		this.administrateurMail = administrateurMail;
	}
	
	public void setAdministrateurTel(int administrateurTel)
	{
		this.administrateurTel = administrateurTel;
	}

	//Ceation d'un nouvel administrateur
	public void create(Administrateur administrateur)
    {
        Connection conn = null;
        PreparedStatement ps;
        //Enregistrement de l'utilisateur correspondant pour l'assigner à l'administrateur
		this.setUtilisateurUserName(administrateur.getUtilisateurUserName());
		this.setUtilisateurMdp(administrateur.getUtilisateurMdp());
		this.setFonction(administrateur.getFonction());
		this.create();

        String sql = "INSERT INTO administrateur(administrateurNom, administrateurPrenom, adresseNoRue, adresseRue, adresseComplement, adresseCdePostal, adresseVille, adressePays, administrateurMail, administrateurTel, utilisateur_utilisateurId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?))";
        try
        {
            conn = (Connection) DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, this.getAdministrateurNom());
            ps.setString(2, this.getAdministrateurPrenom());
            ps.setInt(3, this.getAdresseNoRue());
            ps.setString(4, this.getAdresseRue());
            ps.setString(5, this.getAdresseComplement());
            ps.setInt(6, this.getAdresseCdePostal());
            ps.setString(7, this.getAdresseVille());
            ps.setString(8, this.getAdressePays());
            ps.setString(9, this.getAdministrateurMail());
            ps.setInt(10, this.getAdministrateurTel());
            ps.setInt(11, this.getUitilisateurId());
            ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            DBConnection.close(conn);
        }
    }
}