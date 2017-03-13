package Models.DAO;

import Models.Administrateur;
import Models.DBConnection;
import com.mysql.jdbc.Connection;

import java.sql.PreparedStatement;

/**
 * Created by Allam on 13/03/2017.
 */
public class AdministrateurDAO extends Administrateur {
    //Ceation d'un nouvel administrateur
    public void create(Administrateur administrateur)
    {
        UtilisateurDAO uDAO = new UtilisateurDAO();
        Connection conn = null;
        PreparedStatement ps;
        //Enregistrement de l'utilisateur correspondant pour l'assigner à l'administrateur
        this.setUtilisateurUserName(administrateur.getUtilisateurUserName());
        this.setUtilisateurMdp(administrateur.getUtilisateurMdp());
        this.setFonction(administrateur.getFonction());
        this.create();

        String sql = "INSERT INTO administrateur(administrateurNom, administrateurPrenom, adresseNoRue, adresseRue, adresseComplement, adresseCdePostal, adresseVille, adressePays, administrateurMail, administrateurTel, utilisateur_utilisateurId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?))";
        try
        {
            conn = (Connection) DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, this.getAdministrateurNom());
            ps.setString(2, this.getAdministrateurPrenom());
            ps.setInt(3, this.getAdresseNoRue());
            ps.setString(4, this.getAdresseRue());
            ps.setString(5, this.getAdresseComplement());
            ps.setInt(6, this.getAdresseCdePostal());
            ps.setString(7, this.getAdresseVille());
            ps.setString(8, this.getAdressePays());
            ps.setString(9, this.getAdministrateurMail());
            ps.setInt(10, this.getAdministrateurTel());
            ps.setInt(11, this.getUitilisateurId());
            ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            DBConnection.close(conn);
        }
    }
}
