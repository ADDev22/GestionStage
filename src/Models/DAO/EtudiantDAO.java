package Models.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Models.Etudiant;
public class EtudiantDAO implements DAO<Etudiant> {

	public Etudiant create(Etudiant obj) {
		try {
			PreparedStatement ps = connect.prepareStatement
					   ("INSERT INTO entreprise VALUES(?,?,?,?,?,?)");
			            ps.setInt(1, obj.getIdEtudiant());
			            ps.setString(2, obj.getPrenom());
			            ps.setString(3, obj.getNom());
			            ps.setString(4, obj.getNivEtude());
			            ps.setString(5, obj.getMail());
			            ps.setString(6, obj.getTel());
			            ps.executeUpdate();
			            ps.close();
			        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
				Statement s = connect.createStatement();
				ResultSet rs = s.executeQuery("select last(id) from etutdiant");
				    if(rs.next())
				    	obj.setIdEtudiant(rs.getInt("id"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return obj;
				
}

public Etudiant find(int id) {
	  try {
			PreparedStatement ps = connect.prepareStatement
					   	("SELECT * FROM etudiant WHERE id = ?");
			            ps.setInt(1, id);
						ResultSet result =ps.executeQuery();
						if(result != null)
						{	
						Etudiant e = new Etudiant();
						e.setIdEtudiant(result.getInt("id"));
						e.setPrenom(result.getString("prenom"));
						e.setNom(result.getString("nom"));
						e.setNivEtude(result.getString("niveauEtude"));
						e.setMail(result.getString("mail"));
						e.setTel(result.getString("tel"));
						ps.close();
						return e;
						}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   return null;
}
public Etudiant update(Etudiant obj) {
	  try {
		PreparedStatement ps = connect.prepareStatement
					("UPDATE etudiant SET prenom = ?, nom =? , niveauEtude = ?,  mail = ?, tel = ? WHERE id = ?");
					ps.setString(1, obj.getPrenom());
			        ps.setString(2, obj.getNom());
			        ps.setString(3, obj.getNivEtude());
			        ps.setString(4, obj.getMail());
			        ps.setString(6, obj.getTel());
			        ps.setInt(7, obj.getIdEtudiant());
			        ps.executeUpdate();
			        ps.close();
					
					ps.executeUpdate();
	} catch (SQLException e) {
		
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return obj;
}
public void delete(Etudiant obj) {
    try {
		PreparedStatement ps = connect.prepareStatement("DELETE FROM entreprise WHERE id = ?");
				ps.setInt(1, obj.getIdEtudiant());
				ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
    }
  }
}