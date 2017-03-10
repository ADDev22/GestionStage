package Models.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Models.Entreprise;

public class EntrepriseDAO implements DAO<Entreprise> {
public Entreprise create(Entreprise obj) {
	try {
		   // On insere d'abord Utilisateur puis on recupere last id utilisateur
		            //new UtilisateurDAO().create(obj);
		PreparedStatement ps = connect.prepareStatement
				   ("INSERT INTO entreprise()   VALUES(?,?,?,?,?,?,?)");
		            ps.setString(1, obj.getRaisonSociale());
		            ps.setString(2, obj.getAdresseVilleEnt());
		            ps.setString(3, obj.getAdresseRueEnt());
		            ps.setString(4, obj.getAdresseCodePostaleEnt());
		            ps.setString(5, obj.getMail());
		            ps.setString(6, obj.getTel());
		            ps.setString(7, obj.getSecteurActivite());
		            ps.setInt(8, obj.getUitilisateurId());
		            ps.executeUpdate();
		            ps.close();
		            
		        
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 try {
		Statement s = connect.createStatement();
		ResultSet rs = s.executeQuery("select last(id) from entreprise");
		    if(rs.next())
		    	obj.setIdEntreprise(rs.getInt("id"));
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
					if(result != null)
					{	
					Entreprise e = new Entreprise();
					e.setRaisonSociale(result.getString("raisonSociale"));
					e.setAdresseVilleEnt(result.getString("adresseVille"));
					e.setAdresseRueEnt(result.getString("adresseRue"));
					e.setAdresseCodePostaleEnt(result.getString("adresseCdePostal"));
					e.setMail(result.getString("mail"));
					e.setTel(result.getString("tel"));
					e.setSecteurActivite(result.getString("secteurActivite"));
					ps.close();
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
			        ps.setString(4, obj.getAdresseCodePostaleEnt());
			        ps.setString(5, obj.getMail());
			        ps.setString(6, obj.getTel());
			        ps.setString(7, obj.getSecteurActivite());
			        ps.setInt(8, obj.getIdEntreprise());
			        ps.executeUpdate();
			        ps.close();
					
					ps.executeUpdate();
	} catch (SQLException e) {
		
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return obj;
}
public void delete(Entreprise obj) {
	      try {
			PreparedStatement ps = connect.prepareStatement("DELETE FROM entreprise WHERE id = ?");
					ps.setInt(1, obj.getIdEntreprise());
					ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}



}