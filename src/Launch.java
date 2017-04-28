import Controllers.AuthentificationController;
import Models.DAO.UtilisateurDAO;
import Views.Compte.AuthentificationView;

public class Launch {

	public static void main(String[] args) {
		/*Fentre Authentification*/
        UtilisateurDAO uDAO = new UtilisateurDAO();
        AuthentificationController authController = new AuthentificationController(uDAO);
        AuthentificationView authentificationView = new AuthentificationView(authController);

	}

}
