package Models.DAO;

import Models.DBConnection;
import Models.Utilisateur;
import com.mysql.jdbc.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Allam on 13/03/2017.
 */
public class UtilisateurDAO extends Utilisateur implements IAuthentification, DAO<Utilisateur>
{
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
            Statement s = conn.createStatement();
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

    //Consultation utilisateur
    @Override
    public Utilisateur find(int utilisateurId)
    {
        Connection conn = null;
        PreparedStatement ps;
        Utilisateur utilisateur = new Utilisateur();
        String sql = "SELECT * FROM utilisateur WHERE utilisateurId = ?";

        try {
            conn = (Connection) DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, utilisateurId);
            ResultSet rs = ps.executeQuery();

            if (rs.next())
            {
                utilisateur = traitementLigne(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            DBConnection.close(conn);
        }

        return utilisateur;
    }

    //Methode insertion utilisateur
    @Override
    public Utilisateur create(Utilisateur utilisateur)
    {
        Connection conn = null;
        PreparedStatement ps;
        Statement s;
        String sql = "INSERT INTO utilisateur (pseudo, mdp, idDroit) VALUES (?, ?, ?)";

        try {
            conn = (Connection) DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, utilisateur.getUtilisateurUserName());
            ps.setString(2, utilisateur.getUtilisateurMdp());
            ps.setInt(3, utilisateur.getFonction().getFonctionId());
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            DBConnection.close(conn);
        }

        //Recuperation de l'id
        String sqlRecuperation = "SELECT MAX(id) AS id FROM utilisateur";

        try {
            conn = (Connection) DBConnection.getConnection();
            s = conn.createStatement();
            ResultSet rs = s.executeQuery(sqlRecuperation);
            if (rs.next())
                utilisateur.setUtilisateurId(rs.getInt("id"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            DBConnection.close(conn);
        }

        return utilisateur;
    }

    @Override
    public Utilisateur update(Utilisateur utilisateur)
    {
        Connection conn = null;
        PreparedStatement ps;
        String sql = "UPDATE utilisateur SET utilisateurUserName = ?, utilisateurMdp = ?, fonction_fonctionId = ? WHERE utilisateurId = ?";

        try {
            conn = (Connection) DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, utilisateur.getUtilisateurUserName());
            ps.setString(2, utilisateur.getUtilisateurMdp());
            ps.setInt(3, utilisateur.getFonction().getFonctionId());
            ps.setInt(4, utilisateur.getUitilisateurId());
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            DBConnection.close(conn);
        }

        return utilisateur;
    }

    @Override
    public boolean delete(Utilisateur utilisateur)
    {
        Connection conn = null;
        PreparedStatement ps;
        String sql = "DELETE FROM utilisateur WHERE utilisateurId = ?";

        try {
            conn = (Connection) DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, utilisateur.getUitilisateurId());
            ps.execute();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            DBConnection.close(conn);
        }

        //return true;
    }

    //Traitement du resultat renvoyé par une requ�te --> correspodance avec un objet
    private Utilisateur traitementLigne(ResultSet rs) throws SQLException
    {
        Utilisateur utilisateur = new Utilisateur();
        FonctionDAO fDAO = new FonctionDAO();
        utilisateur.setUtilisateurId(rs.getInt("utilisateurId"));
        utilisateur.setUtilisateurUserName(rs.getString("utilisateurUserName"));
        utilisateur.setUtilisateurMdp(rs.getString("utilisateurMdp"));
        utilisateur.setFonction(fDAO.find(rs.getInt("fonction_fonctionId")));

        return utilisateur;
    }
}