package Models.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

<<<<<<< HEAD
import Models.Entreprise;
=======
import Models.DBConnection;
>>>>>>> 61d0e3918d7f6748ab4c7dc9efdc6bf7b118de8e
import Models.EtuPostStage;
import Models.OffreStage;
import com.mysql.jdbc.Connection;

public class OffreStageDAO implements DAO<OffreStage> {

	@Override
	public OffreStage find(int id) {
		   try {
				PreparedStatement ps = connect.prepareStatement
						   	("SELECT * FROM offre_stage WHERE id = ?");
				            ps.setInt(1, id);
							ResultSet result =ps.executeQuery();
							if(result.next())
							{	
							OffreStage st = new OffreStage();
							st.setLibelleOffre(result.getString("libelle"));
							st.setDomaineOffre(result.getString("domaine"));
							st.setDescriptifOffre(result.getString("descriptif"));
							st.setDureeOffre(result.getString("duree"));
							st.setCheminOffre(result.getString("cheminStockage"));
							st.setValide(result.getInt("valide"));
							st.setIdOffreStage(result.getInt("id"));
							st.setDateDebut(result.getString("dateDebut"));
							ps.close();
							return st; // Peut etre on doit recuperer la liste des postulant , je ne prefere car lourd.
							}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   return null;
		}

	@Override
	public OffreStage create(OffreStage obj) { // Faut creer la clonne idEnt entre comme clé etranger
		try {
			PreparedStatement ps = connect.prepareStatement
					   ("INSERT INTO offre_stage (libelle, domaine,	descriptif,	dateDebut,	duree,	cheminStockage,	valide,	idEntreprise)  VALUES(?,?,?,?,?,?,?,?)");
			            ps.setString(1, obj.getLibelleOffre());
			            ps.setString(2, obj.getDomaineOffre());
			            ps.setString(3, obj.getDescriptifOffre());
			            ps.setString(4, obj.getDateDebut());
			            ps.setString(5, obj.getDureeOffre());
			            ps.setString(6, obj.getCheminOffre());
			            ps.setInt(7, obj.isValide());
			            ps.setInt(8, obj.getEntreprise().getIdEntreprise());
			            ps.executeUpdate();
			            ps.close();
			        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*
		 try {
				Statement s = connect.createStatement();
				ResultSet rs = s.executeQuery("select last(id) from offre_stage");
				    if(rs.next())
				    	obj.setIdOffreStage(rs.getInt("id"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		return obj;
	}

	@Override
	public OffreStage update(OffreStage obj) {
		try {
			PreparedStatement ps = connect.prepareStatement
						("UPDATE offre_stage SET libelle = ?, domaine =? , descriptif = ? , dateDebut = ?,duree= ?, cheminStockage = ?, valide = ?, commentaire =? WHERE id = ?");
						ps.setString(1, obj.getLibelleOffre());
				        ps.setString(2, obj.getDomaineOffre());
				        ps.setString(3, obj.getDescriptifOffre());
				        ps.setString(4, obj.getDateDebut());
				        ps.setString(5, obj.getDureeOffre());
				        ps.setString(6, obj.getCheminOffre());
				        ps.setInt(7, obj.isValide());
				        ps.setString(8, obj.getCommentaire());
				        ps.setInt(9, obj.getIdOffreStage());
				
				        
				        ps.executeUpdate();
				        ps.close();
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 Statement s = (Statement) connect.createStatement();
				ResultSet rs = s.executeQuery("SELECT MAX(id)  As idMax FROM offre_stage");
				    if(rs.next())
				    	obj.setIdOffreStage(rs.getInt("idMax"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return obj;
	}

	@Override
	public boolean delete(OffreStage obj) {
	      try {
			PreparedStatement ps = connect.prepareStatement("DELETE FROM offre_stage WHERE id = ?");
					ps.setInt(1, obj.getIdOffreStage());
					ps.executeUpdate();
					ps.close();
					return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public OffreStage findTypeUser(int utilisateurId) {
		return null;
	}

	public  void getAllPostulans(OffreStage obj){
		try {
			PreparedStatement ps =connect.prepareStatement("SELECT * FROM candidature WHERE idOffre = ?");
			ps.setInt(1, obj.getIdOffreStage());
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{   EtuPostStage of =new EtuPostStage();
				     of.setIdEtuPostStage(rs.getInt("id"));
				     of.setEtudiant(new EtudiantDAO().find(rs.getInt("idEtudiant")));
				     of.setOffre(obj);
				     of.setDatePostule(rs.getDate("dateCandidature"));
				     of.setIsAccept(rs.getInt("isAccept"));
				     obj.addPostulant(of);	     
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
<<<<<<< HEAD
}
	public  ArrayList<OffreStage> getAllOffreStage(){
		try {
			ArrayList<OffreStage> listOf = new ArrayList<OffreStage>();
			PreparedStatement ps =connect.prepareStatement("SELECT * FROM offre_stage");
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
				     of.setEntreprise(new EntrepriseDAO().find(rs.getInt("idEntreprise")));     
				     listOf.add(of);
			}
			return listOf;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	
}
public  ArrayList<OffreStage> getAllOffreStage(String domaine){
	try {
		ArrayList<OffreStage> listOf = new ArrayList<OffreStage>();
		PreparedStatement ps =connect.prepareStatement("SELECT * FROM offre_stage WHERE domaine =domaine");
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
			     of.setEntreprise(new EntrepriseDAO().find(rs.getInt("idEntreprise")));     
			     listOf.add(of);
			         
		}
		return listOf;
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;

}
=======
	}

	//Méthode renvoyant un ResultSet pour l'affichage sous forme d'un table dans l'interface
	public ResultSet listeOffres()
	{
		Connection conn = null;
		String sql = "SELECT libelle, domaine, dateDebut FROM offre_stage";
		ResultSet rs;
		try
		{
			conn = (Connection) DBConnection.getConnection();
			Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = s.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return rs;
	}
>>>>>>> 61d0e3918d7f6748ab4c7dc9efdc6bf7b118de8e
}

