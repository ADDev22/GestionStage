package Models.DAO;

import Models.DBConnection;
import Models.Fonction;
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
public class UtilisateurDAO extends Utilisateur implements IAuthentification, DAO<Utilisateur> {
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
            Statement s = (Statement) conn.createStatement();
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

    //Methode insertion utilisateur
    @Override
    public Utilisateur create(Utilisateur obj) {
        Connection conn = null;
        PreparedStatement ps = null;
        Statement s = null;
        //Enregistrement de l'utilisateur
        String sql = "INSERT INTO utilisateur (utilisateurUserName, utilisateurMdp, fonction_fonctionId) VALUES (?, ?, ?)";

        try {
            conn = (Connection) DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, this.getUtilisateurUserName());
            ps.setString(2, this.getUtilisateurMdp());
            ps.setInt(3, this.getFonction().getFonctionId());
            ps.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            DBConnection.close(conn);
        }

        //Recuperation de l'id
        String sqlRecuperation = "SELECT LAST(utilisateurId) FROM utilisateur";

        try {
            conn = (Connection) DBConnection.getConnection();
            s = (Statement) conn.createStatement();
            ResultSet rs = s.executeQuery(sqlRecuperation);
            if (rs.next())
                this.setUtilisateurId(rs.getInt("utilisateurId"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            DBConnection.close(conn);
        }

        return null;
    }

    //Recup�ration des information de la fonction � partir de l'Id
    private Fonction getFonction(int fonctionId)
    {
        Connection conn = null;
        PreparedStatement ps = null;
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

    //Traitement du resultat renvoy� par une requ�te --> correspodance avec un objet
    private Utilisateur traitementLigne(ResultSet rs) throws SQLException
    {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setUtilisateurId(rs.getInt("utilisateurId"));
        utilisateur.setUtilisateurUserName(rs.getString("utilisateurUserName"));
        utilisateur.setUtilisateurMdp(rs.getString("utilisateurMdp"));
        utilisateur.setFonction(getFonction(rs.getInt("fonction_fonctionId")));

        return utilisateur;
    }

    @Override
    public Utilisateur find(int id) {
        return null;
    }

    @Override
    public Utilisateur update(Utilisateur obj) {
        return null;
    }

    @Override
    public void delete(Utilisateur obj) {

    }
}
