package Models.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Models.EtuPostStage;

public class EtuPostStageDAO implements DAO<EtuPostStage> {

	@Override
	public EtuPostStage find(int id) {
		try {
			   int idEt=0, idOf=0;
			PreparedStatement ps = connect.prepareStatement
					   	("SELECT * FROM candidature WHERE id = ?");
			            ps.setInt(1, id);
						ResultSet result =ps.executeQuery();
						if(result != null)
						{	
						EtuPostStage  etPos = new EtuPostStage();
						idOf=result.getInt("idOffre");
						idEt=result.getInt("idEtudiant");
						etPos.setDatePostule(result.getDate("dateCandidature"));
					    etPos.setEtudiant(new EtudiantDAO().find(idEt));
					    etPos.setOffre(new OffreStageDAO().find(idOf));
						ps.close();
						return etPos;
						}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   return null;
	           
	}

	@Override
	public EtuPostStage create(EtuPostStage obj) {
		try {
			PreparedStatement ps = connect.prepareStatement
					   ("INSERT INTO candidature(idOffre,idEtudiant,dateCandidature)   VALUES(?,?,?)");
			            ps.setInt(1, obj.getEtudiant().getIdEtudiant());
			            ps.setInt(2, obj.getOffre().getIdOffreStage());
			            ps.setDate(3, (Date) obj.getDatePostule());
			            ps.executeUpdate();
			            ps.close();
			        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 Statement s = (Statement) connect.createStatement();
				ResultSet rs = s.executeQuery("SELECT MAX(id)  As idMax FROM candidature");
				    if(rs.next())
				    	obj.setIdEtuPostStage(rs.getInt("idMax"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return obj;
	}

	@Override
	public EtuPostStage update(EtuPostStage obj) {
		try {
			PreparedStatement ps = connect.prepareStatement
						("UPDATE candidature SET idOffre = ?, idEtudiant =? , dateCandidature = ? WHERE id = ?");
						ps.setInt(1, obj.getOffre().getIdOffreStage());
				        ps.setInt(2, obj.getEtudiant().getIdEtudiant());
				        ps.setDate(3, (Date) obj.getDatePostule());
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
	public boolean delete(EtuPostStage obj) {
		 try {
				PreparedStatement ps = connect.prepareStatement("DELETE FROM candidature WHERE id = ?");
						ps.setInt(1, obj.getIdEtuPostStage());
						ps.executeUpdate();
						return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return false;
	}

	@Override
	public EtuPostStage findTypeUser(int utilisateurId) {
		return null;
	}


}
