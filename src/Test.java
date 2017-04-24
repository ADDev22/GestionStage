import Controllers.AuthentificationController;
import Models.DAO.UtilisateurDAO;
import Views.Compte.AuthentificationView;

/**
 * Created by Allam on 14/03/2017.
 */
public class Test
{
    public static void main(String[] args)
    {
        /*Fentre Authentification*/
        UtilisateurDAO uDAO = new UtilisateurDAO();
        AuthentificationController authController = new AuthentificationController(uDAO);
        AuthentificationView authentificationView = new AuthentificationView(authController);
    }
}