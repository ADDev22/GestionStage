package Models.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Models.Entreprise;
import Models.EtuPostStage;
import Models.OffreStage;
import Models.Etudiant;
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
							st.setValide(result.getBoolean("valide"));
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
			            ps.setBoolean(7, obj.isValide());
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
						("UPDATE offre_stage SET libelle = ?, domaine =? , descriptif = ? , dateDebut = ?,duree= ?, cheminStockage = ?, valide = ? WHERE id = ?");
						ps.setString(1, obj.getLibelleOffre());
				        ps.setString(2, obj.getDomaineOffre());
				        ps.setString(3, obj.getDescriptifOffre());
				        ps.setString(4, obj.getDateDebut());
				        ps.setString(5, obj.getDureeOffre());
				        ps.setString(6, obj.getCheminOffre());
				        ps.setBoolean(7, obj.isValide());
				        ps.setInt(8, obj.getIdOffreStage());
				        ps.executeUpdate();
				        ps.close();
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
				     obj.addPostulant(of);	     
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}
}

