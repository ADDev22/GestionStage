package Models.DAO;

import Models.DBConnection;
import Models.Fonction;
import com.mysql.jdbc.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Allam on 13/03/2017.
 */
public class FonctionDAO
{
    //Recupération des information de la fonction à partir de l'Id
    public Fonction getFonction(int fonctionId)
    {
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
}