package Models.DAO;

import Models.DBConnection;
import Models.Fonction;
import Models.Utilisateur;
import com.mysql.jdbc.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Allam on 13/03/2017.
 */
public class FonctionDAO implements DAO<Fonction>
{
    //Recupération de la liste des fonctions
    public List<Fonction> listeFonction()
    {
        Connection conn = null;
        List<Fonction> listeFonction = new ArrayList<>();
        String sql = "SELECT * FROM droit_utilisateur";
        try
        {
            conn = (Connection) DBConnection.getConnection();
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next())
            {
                Fonction f = new Fonction();
                f.setFonctionId(rs.getInt("idDroit"));
                f.setFonctionNom(rs.getString("droit"));
                listeFonction.add(f);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            DBConnection.close(conn);
        }

        return listeFonction;
    }

    //Recupération des information de la fonction à partir de l'Id
    @Override
    public Fonction find(int fonctionId)
    {
        Connection conn = null;
        PreparedStatement ps;
        Fonction fonction = new Fonction();
        String sql = "SELECT * FROM droit_utilisateur WHERE idDroit = ?";

        try {
            conn = (Connection) DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, fonctionId);
            ResultSet rs = ps.executeQuery();

            if (rs.next())
            {
                fonction.setFonctionId(rs.getInt("idDroit"));
                fonction.setFonctionNom(rs.getString("droit"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            DBConnection.close(conn);
        }

        return fonction;
    }

    @Override
    public Fonction create(Fonction fonction) {
        Connection conn = null;
        PreparedStatement ps;
        String sql = "INSERT INTO droit_utilisateur (droit) VALUES (?)";

        try {
            conn = (Connection) DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, fonction.getFonctionNom());
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            DBConnection.close(conn);
        }

        return fonction;
    }

    @Override
    public Fonction update(Fonction fonction)
    {
        Connection conn = null;
        PreparedStatement ps;
        String sql = "UPDATE droit_utilisateur SET droit = ? WHERE idDroit = ?";

        try {
            conn = (Connection) DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, fonction.getFonctionNom());
            ps.setInt(2, fonction.getFonctionId());
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            DBConnection.close(conn);
        }

        return fonction;
    }

    @Override
    public boolean delete(Fonction fonction)
    {
        Connection conn = null;
        PreparedStatement ps;
        String sql = "DELETE FROM droit_utilisateur WHERE idDroit = ?";

        try {
            conn = (Connection) DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, fonction.getFonctionId());
            ps.execute();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            DBConnection.close(conn);
        }
    }

    @Override
    public Fonction findTypeUser(int utilisateurId) {
        return null;
    }
}