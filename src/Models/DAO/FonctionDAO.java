package Models.DAO;

import Models.DBConnection;
import Models.Fonction;
import com.mysql.jdbc.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Allam on 13/03/2017.
 */
public class FonctionDAO implements DAO<Fonction>
{
    //Recupération des information de la fonction à partir de l'Id
    @Override
    public Fonction find(int fonctionId) {
        Connection conn = null;
        PreparedStatement ps;
        Fonction fonction = new Fonction();
        String sql = "SELECT * FROM fonction WHERE fonctionId = ?";

        try {
            conn = (Connection) DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, fonctionId);
            ResultSet rs = ps.executeQuery();

            if (rs.next())
            {
                fonction.setFonctionId(rs.getInt("fonctionId"));
                fonction.setFonctionNom(rs.getString("fonctionNom"));
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
    public Fonction update(Fonction fonction) {
        Connection conn = null;
        PreparedStatement ps;
        String sql = "UPDATE fonction SET fonctionNom = ? WHERE fonctionId = ?";

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
    public boolean delete(Fonction fonction) {
        Connection conn = null;
        PreparedStatement ps;
        String sql = "DELETE FROM fonction WHERE fonctionId = ?";

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
}