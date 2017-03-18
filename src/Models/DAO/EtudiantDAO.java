package Models.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Models.EtuPostStage;
import Models.Etudiant;
import Models.Utilisateur;
public class EtudiantDAO implements DAO<Etudiant> {

	public Etudiant create(Etudiant obj) {
						new UtilisateurDAO().create(obj);
		try {
			PreparedStatement ps = connect.prepareStatement
					   ("INSERT INTO etudiant (nom,	prenom, domEtude, niveauEtude,	mail, tel, idUtilisateur\n" + 
					   		")VALUES(?,?,?,?,?,?,?)");
			            ps.setString(1, obj.getPrenom());
			            ps.setString(2, obj.getNom());
			            ps.setString(3, obj.getDomEtude());
			            ps.setString(4, obj.getNivEtude());  
			            ps.setString(5, obj.getMail());
			            ps.setString(6, obj.getTel());
			            ps.setInt(7, obj.getUitilisateurId());
			            ps.executeUpdate();
			            ps.close();
			        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			 Statement s = (Statement) connect.createStatement();
				ResultSet rs = s.executeQuery("SELECT MAX(id)  As idMax FROM etudiant");
				    if(rs.next())
				    	obj.setIdEtudiant(rs.getInt("idMax"));
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
						if(result.next())
						{	
						Etudiant e = new Etudiant();
						e.setIdEtudiant(result.getInt("id"));
						e.setPrenom(result.getString("prenom"));
						e.setNom(result.getString("nom"));
						e.setNivEtude(result.getString("niveauEtude"));
						e.setMail(result.getString("mail"));
						e.setTel(result.getString("tel"));
						e.setDomEtude(result.getString("domEtude"));
				        e.setUtilisateurId(result.getInt("idUtilisateur"));
				        ps.close();
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
public Etudiant update(Etudiant obj) {
	  try {
		PreparedStatement ps = connect.prepareStatement
					("UPDATE etudiant SET prenom = ?, nom =? , domEtude = ?, niveauEtude = ?,  mail = ?, tel = ? WHERE id = ?");
					ps.setString(1, obj.getPrenom());
			        ps.setString(2, obj.getNom());
			        ps.setString(3, obj.getDomEtude());
			        ps.setString(4, obj.getNivEtude());
			        ps.setString(5, obj.getMail());
			        ps.setString(6, obj.getTel());
			        ps.setInt(7, obj.getIdEtudiant());
			        ps.executeUpdate();
			        ps.close();
	} catch (SQLException e) {
		
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return obj;
}
public boolean delete(Etudiant obj) {
    try {
		PreparedStatement ps = connect.prepareStatement("DELETE FROM etudiant WHERE id = ?");
				ps.setInt(1, obj.getIdEtudiant());
				ps.executeUpdate();
				ps.close();
				return true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
    }
    return false;
  }
public  void getAllMesCandidatures(Etudiant obj){
	try {
		PreparedStatement ps =connect.prepareStatement("SELECT * FROM candidature WHERE idEtudiant = ?");
		ps.setInt(1, obj.getIdEtudiant());
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{   EtuPostStage of =new EtuPostStage();
			     of.setIdEtuPostStage(rs.getInt("id"));
			     of.setOffre(new OffreStageDAO().find(rs.getInt("idEtudiant")));
			     of.setEtudiant(obj);
			     of.setDatePostule(rs.getDate("dateCandidature"));
			     obj.addStagePostule(of);	     
		}
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
}