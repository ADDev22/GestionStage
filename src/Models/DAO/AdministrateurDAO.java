package Models.DAO;

import Models.Administrateur;
import Models.DBConnection;
import Models.Utilisateur;
import com.mysql.jdbc.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Allam on 13/03/2017.
 */
public class AdministrateurDAO extends Administrateur implements DAO<Administrateur> {
    @Override
    public Administrateur find(int administrateurId)
    {
        Connection conn = null;
        PreparedStatement ps;
        Administrateur admin = new Administrateur();
        String sql = "SELECT * FROM administrateur WHERE administrateurId = ?";

        try {
            conn = (Connection) DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, administrateurId);
            ResultSet rs = ps.executeQuery();

            if (rs.next())
            {
                admin = traitementLigne(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            DBConnection.close(conn);
        }

        return admin;
    }

    //Ceation d'un nouvel administrateur
    public Administrateur create(Administrateur admin)
    {
        UtilisateurDAO uDAO = new UtilisateurDAO();
        Connection conn = null;
        PreparedStatement ps;

        //Enregistrement des informations utilisateur associés
        uDAO.create(admin);

        String sql = "INSERT INTO administrateur(administrateurNom, administrateurPrenom, adresseNoRue, adresseRue, adresseComplement, adresseCdePostal, adresseVille, adressePays, administrateurMail, administrateurTel, utilisateur_utilisateurId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?))";
        try
        {
            conn = (Connection) DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, admin.getAdministrateurNom());
            ps.setString(2, admin.getAdministrateurPrenom());
            ps.setInt(3, admin.getAdresseNoRue());
            ps.setString(4, admin.getAdresseRue());
            ps.setString(5, admin.getAdresseComplement());
            ps.setInt(6, admin.getAdresseCdePostal());
            ps.setString(7, admin.getAdresseVille());
            ps.setString(8, admin.getAdressePays());
            ps.setString(9, admin.getAdministrateurMail());
            ps.setInt(10, admin.getAdministrateurTel());
            ps.setInt(11, admin.getUitilisateurId());
            ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            DBConnection.close(conn);
        }

        return admin;
    }

    @Override
    public Administrateur update(Administrateur admin)
    {
        Connection conn = null;
        PreparedStatement ps;
        String sql = "UPDATE administrateur SET administrateurNom = ?, administrateurPrenom = ?, adresseNoRue = ?, adresseRue = ?, adresseComplement = ?, adresseCdePostal = ?, adresseVille = ?, adressePays = ?, administrateurMail = ?, administrateurTel = ? WHERE administrateurId = ?";

        try {
            conn = (Connection) DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, admin.getAdministrateurNom());
            ps.setString(2, admin.getAdministrateurPrenom());
            ps.setInt(3, admin.getAdresseNoRue());
            ps.setString(4, admin.getAdresseRue());
            ps.setString(5, admin.getAdresseComplement());
            ps.setInt(6, admin.getAdresseCdePostal());
            ps.setString(7, admin.getAdresseVille());
            ps.setString(8, admin.getAdressePays());
            ps.setString(9, admin.getAdministrateurMail());
            ps.setInt(10, admin.getAdministrateurTel());
            ps.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            DBConnection.close(conn);
        }

        return admin;
    }

    @Override
    public boolean delete(Administrateur admin)
    {
        Connection conn = null;
        PreparedStatement ps;
        String sql = "DELETE FROM administrateur WHERE administrateurId = ?";

        try {
            conn = (Connection) DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, admin.getAdminstrateurId());
            ps.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            DBConnection.close(conn);
        }

        return true;
    }

    //Traitement du resultat renvoyé par une requête --> correspodance avec un objet
    private Administrateur traitementLigne(ResultSet rs) throws SQLException
    {
        Administrateur admin = new Administrateur();
        UtilisateurDAO uDAO = new UtilisateurDAO();
        admin.setUtilisateurId(rs.getInt("administrateurId"));
        admin.setAdministrateurNom(rs.getString("administrateurNom"));
        admin.setAdministrateurPrenom(rs.getString("administrateurPrenom"));
        admin.setAdresseNoRue(rs.getInt("adresseNoRue"));
        admin.setAdresseRue(rs.getString("adresseRue"));
        admin.setAdresseComplement(rs.getString("adresseComplement"));
        admin.setAdresseCdePostal(rs.getInt("adresseCdePostal"));
        admin.setAdresseVille(rs.getString("adresseVille"));
        admin.setAdressePays(rs.getString("adressePays"));
        admin.setAdministrateurMail(rs.getString("administrateurMail"));
        admin.setAdministrateurTel(rs.getInt("administrateurTel"));
        admin.setUtilisateur(uDAO.find(rs.getInt("utilisateur_utilisateurId")));

        return admin;
    }
}