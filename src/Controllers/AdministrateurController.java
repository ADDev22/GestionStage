package Controllers;

import Models.Administrateur;
import Models.DAO.AdministrateurDAO;
import Models.DAO.DAO;
import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;

/**
 * Created by Allam on 26/03/2017.
 */
public class AdministrateurController
{
    //Déclaration

    DAO<Administrateur> DAO;

    //Constructeur

    public AdministrateurController(AdministrateurDAO aDAO)
    {
        this.DAO = aDAO;

    }
}