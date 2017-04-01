package Models.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Statement;

import Models.Entreprise;
import Models.OffreStage;
import Models.Utilisateur;

public class EntrepriseDAO implements DAO<Entreprise> {
public Entreprise create(Entreprise obj) {
	try {
		   // On insere d'abord Utilisateur puis on recupere last id utilisateur
		            new UtilisateurDAO().create(obj);
		PreparedStatement ps = connect.prepareStatement
				   ("INSERT INTO entreprise(raisonSociale,adresseVille,adresseRue,adresseCdePostal,mail,tel,secteurActivite,idUtilisateur) VALUES(?,?,?,?,?,?,?,?)");
		            ps.setString(1, obj.getRaisonSociale());
		            ps.setString(2, obj.getAdresseVilleEnt());
		            ps.setString(3, obj.getAdresseRueEnt());
		            ps.setInt(4, obj.getAdresseCodePostaleEnt());
		            ps.setString(5, obj.getMail());
		            ps.setString(6, obj.getTel());
		            ps.setString(7, obj.getSecteurActivite());
		             ps.setInt(8,obj.getUitilisateurId());
		            ps.executeUpdate();
		            ps.close();
		            
		        
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 try {
		Statement s = (Statement) connect.createStatement();
		ResultSet rs = s.executeQuery("SELECT MAX(id) As idMax FROM entreprise");
		    if(rs.next())
		    	obj.setIdEntreprise(rs.getInt("idMax"));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return obj;		
 }


public Entreprise find(int id) {
	   try {
		PreparedStatement ps = connect.prepareStatement
				   	("SELECT * FROM entreprise WHERE id = ?");
		            ps.setInt(1, id);
					ResultSet result =ps.executeQuery();
					if(result.next())
					{	
					Entreprise e = new Entreprise();
					e.setRaisonSociale(result.getString("raisonSociale"));
					e.setAdresseVilleEnt(result.getString("adresseVille"));
					e.setAdresseRueEnt(result.getString("adresseRue"));
					e.setAdresseCodePostaleEnt(result.getInt("adresseCdePostal"));
					e.setMail(result.getString("mail"));
					e.setTel(result.getString("tel"));
					e.setSecteurActivite(result.getString("secteurActivite"));
					 e.setUtilisateurId(result.getInt("idUtilisateur"));
					ps.close();
					// On remplit les valeue des on pere ->HERITAGE
					UtilisateurDAO uDAO = new UtilisateurDAO();
			        Utilisateur u = uDAO.find(e.getUitilisateurId());
			        e.setFonction(u.getFonction());
			        e.setUtilisateurUserName(u.getUtilisateurUserName());
			        e.setUtilisateurMdp(u.getUtilisateurMdp());
					return e;
					}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   return null;
}
public Entreprise update(Entreprise obj) { 
	  try {
		PreparedStatement ps = connect.prepareStatement
					("UPDATE entreprise SET raisonSociale = ?, adresseVille =? , adresseRue = ? , adresseCdePostal = ?, mail = ?, tel = ?, secteurActivite = ? WHERE id = ?");
					ps.setString(1, obj.getRaisonSociale());
			        ps.setString(2, obj.getAdresseVilleEnt());
			        ps.setString(3, obj.getAdresseRueEnt());
			        ps.setInt(4, obj.getAdresseCodePostaleEnt());
			        ps.setString(5, obj.getMail());
			        ps.setString(6, obj.getTel());
			        ps.setString(7, obj.getSecteurActivite());
			        ps.setInt(8, obj.getIdEntreprise());
			        ps.executeUpdate();
			        ps.close();
					
	} catch (SQLException e) {
		
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return obj;
}
public boolean delete(Entreprise obj) {
	      try {
			PreparedStatement ps = connect.prepareStatement("DELETE FROM entreprise WHERE id = ?");
					ps.setInt(1, obj.getIdEntreprise());
					ps.executeUpdate();
					ps.close();
					return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      return false;
}
public  void getAllOffreStage(Entreprise obj){
		try {
			PreparedStatement ps =connect.prepareStatement("SELECT * FROM offre_stage WHERE idEntreprise = ?");
			ps.setInt(1, obj.getIdEntreprise());
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{   OffreStage of =new OffreStage();
				     of.setIdOffreStage(rs.getInt("id"));
				     of.setDescriptifOffre(rs.getString("descriptif"));
				     of.setDomaineOffre(rs.getString("domaine"));
				     of.setLibelleOffre(rs.getString("libelle"));
				     of.setDureeOffre(rs.getString("duree"));
				     of.setValide(rs.getInt("valide"));
				     of.setCheminOffre(rs.getString("cheminStockage"));
				     of.setCommentaire(rs.getString("commentaire"));
				     of.setEntreprise(obj);
				     obj.addOffreStage(of);	     
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}
public  void getAllOffreStage(Entreprise obj,String domaine){
	try {
		PreparedStatement ps =connect.prepareStatement("SELECT * FROM offre_stage WHERE idEntreprise = ? && domaine =domaine");
		ps.setInt(1, obj.getIdEntreprise());
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{   OffreStage of =new OffreStage();
			     of.setIdOffreStage(rs.getInt("id"));
			     of.setDescriptifOffre(rs.getString("descriptif"));
			     of.setDomaineOffre(rs.getString("domaine"));
			     of.setLibelleOffre(rs.getString("libelle"));
			     of.setDureeOffre(rs.getString("duree"));
			     of.setValide(rs.getInt("valide"));
			     of.setCheminOffre(rs.getString("cheminStockage"));
			     of.setCommentaire(rs.getString("commentaire"));
			     of.setEntreprise(obj);
			     obj.addOffreStage(of);	     
		}
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
}