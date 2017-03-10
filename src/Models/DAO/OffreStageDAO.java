package Models.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Models.OffreStage;
public class OffreStageDAO implements DAO<OffreStage> {

	@Override
	public OffreStage find(int id) {
		   try {
				PreparedStatement ps = connect.prepareStatement
						   	("SELECT * FROM offre_stage WHERE id = ?");
				            ps.setInt(1, id);
							ResultSet result =ps.executeQuery();
							if(result != null)
							{	
							OffreStage st = new OffreStage();
							st.setLibelleOffre(result.getString("libelle"));
							st.setDomaineOffre(result.getString("domaine"));
							st.setDescriptifOffre(result.getString("descriptif"));
							st.setDureeOffre(result.getString("duree"));
							st.setCheminOffre(result.getString("cheminStockage"));
							st.setValide(result.getBoolean("valide"));
							st.setIdOffreStage(result.getInt("id"));
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
					   ("INSERT INTO offre_stage   VALUES(?,?,?,?,?,?,?)");
			            ps.setString(1, obj.getLibelleOffre());
			            ps.setString(2, obj.getDomaineOffre());
			            ps.setString(3, obj.getDescriptifOffre());
			            ps.setString(4, obj.getDureeOffre());
			            ps.setString(5, obj.getCheminOffre());
			            ps.setBoolean(6, obj.isValide());
			            ps.setInt(7, obj.getEntreprise().getIdEntreprise());
			            ps.executeUpdate();
			            ps.close();
			        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
				Statement s = connect.createStatement();
				ResultSet rs = s.executeQuery("select last(id) from offre_stage");
				    if(rs.next())
				    	obj.setIdOffreStage(rs.getInt("id"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return obj;
	}

	@Override
	public OffreStage update(OffreStage obj) {
		try {
			PreparedStatement ps = connect.prepareStatement
						("UPDATE offre_stage SET libelle = ?, domaine =? , descriptif = ? , duree= ?, cheminStockage = ?, valide = ? WHERE id = ?");
						ps.setString(1, obj.getLibelleOffre());
				        ps.setString(2, obj.getDomaineOffre());
				        ps.setString(3, obj.getDescriptifOffre());
				        ps.setString(4, obj.getDureeOffre());
				        ps.setString(5, obj.getCheminOffre());
				        ps.setBoolean(6, obj.isValide());
				        ps.executeUpdate();
				        ps.close();
						
						ps.executeUpdate();
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public void delete(OffreStage obj) {
	      try {
			PreparedStatement ps = connect.prepareStatement("DELETE FROM offre_stage WHERE id = ?");
					ps.setInt(1, obj.getIdOffreStage());
					ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

