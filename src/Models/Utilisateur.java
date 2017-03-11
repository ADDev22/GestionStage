package Models;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

public class Utilisateur implements IAuthentification
{
	//D�claration
	
	protected int utilisateurId;
	protected String utilisateurUserName;
	protected String utilisateurMdp;
	protected Fonction fonction;

	//Constructeurs

    public Utilisateur()
    {

    }

	public Utilisateur(int utilisateurId, String utilisateurUserName, String utilisateurMdp, Fonction fonction)
	{
		this.utilisateurId = utilisateurId;
		this.utilisateurUserName = utilisateurUserName;
		this.utilisateurMdp = utilisateurMdp;
		this.fonction = fonction;
	}
		
	//Getter
		
	public int getUitilisateurId()
	{
		return this.utilisateurId;
	}
		
	public String getUtilisateurUserName()
	{
		return this.utilisateurUserName;
	}
		
	public String getUtilisateurMdp()
	{
		return this.utilisateurMdp;
	}
		
	public Fonction getFonction()
	{
		return this.fonction;
	}
		
	//Setter
		
	public void setUtilisateurId(int utilisateurId)
	{
		this.utilisateurId = utilisateurId;
	}
		
	public void setUtilisateurUserName(String utilisateurUserName)
	{
		this.utilisateurUserName = utilisateurUserName;
	}
		
	public void setUtilisateurMdp(String utilisateurMdp)
	{
		this.utilisateurMdp = utilisateurMdp;
	}
		
	public void setFonction(Fonction fonction)
	{
		this.fonction = fonction;
	}
		
	//Authentification
	@Override
	public Boolean connexion(String userName, String mdp)
	{
		Connection conn = null;
		List<Utilisateur> listeUtilisateur = new ArrayList<>();
		String sql = "SELECT * FROM utilisateur";
		try
		{
			conn = (Connection) DBConnection.getConnection();
			Statement s = (Statement) conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while (rs.next())
			{
				listeUtilisateur.add(traitementLigne(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
	        throw new RuntimeException(e);
	    } finally {
	        DBConnection.close(conn);
	    }
			
		for (Utilisateur u : listeUtilisateur)
	    {
	        if (u.getUtilisateurUserName() == userName)
	            if (u.getUtilisateurMdp() == mdp)
	            	return true;
	    }
			
		return false;		
	}

	//Methode insertion utilisateur
	public void create()
	{
		Connection conn = null;
		PreparedStatement ps = null;
		Statement s = null;
		//Enregistrement de l'utilisateur
		String sql = "INSERT INTO utilisateur (utilisateurUserName, utilisateurMdp, fonction_fonctionId) VALUES (?, ?, ?)";

		try {
			conn = (Connection) DBConnection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, this.getUtilisateurUserName());
			ps.setString(2, this.getUtilisateurMdp());
			ps.setInt(3, this.getFonction().getFonctionId());
			ps.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DBConnection.close(conn);
		}

		//Recuperation de l'id
		String sqlRecuperation = "SELECT LAST(utilisateurId) FROM utilisateur";

		try {
			conn = (Connection) DBConnection.getConnection();
			s = (Statement) conn.createStatement();
			ResultSet rs = s.executeQuery(sqlRecuperation);
			if (rs.next())
				this.setUtilisateurId(rs.getInt("utilisateurId"));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DBConnection.close(conn);
		}
	}

	//Recup�ration des information de la fonction � partir de l'Id
	private Fonction getFonction(int fonctionId)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		Fonction fonction = new Fonction();
		String sql = "SELECT * FROM fonction WHERE fonctionId = ?";

		try {
			conn = (Connection) DBConnection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, fonctionId);
			ResultSet rs = ps.executeQuery();

			if (rs.next())
			{
				fonction.setFonctionId(rs.getInt("fonctionId"));
				fonction.setFonctionNom(rs.getString("fonctionNom"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DBConnection.close(conn);
		}

		return fonction;
	}
		
	//Traitement du resultat renvoy� par une requ�te --> correspodance avec un objet
	private Utilisateur traitementLigne(ResultSet rs) throws SQLException 
	{
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setUtilisateurId(rs.getInt("utilisateurId"));
		utilisateur.setUtilisateurUserName(rs.getString("utilisateurUserName"));
		utilisateur.setUtilisateurMdp(rs.getString("utilisateurMdp"));
		utilisateur.setFonction(getFonction(rs.getInt("fonction_fonctionId")));
		    
		return utilisateur;
	}
}