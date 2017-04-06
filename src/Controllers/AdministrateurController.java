package Controllers;

import Models.Administrateur;
import Models.DAO.AdministrateurDAO;
import Models.DAO.DAO;
import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;

import javax.swing.*;

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

    public void insert(Administrateur a)
    {
        this.DAO.create(a);

        //Affichage de la boite de dialogue
        JOptionPane jOP = new JOptionPane();
        jOP.showMessageDialog(null, "Enregistrement réussie", "Information", JOptionPane.INFORMATION_MESSAGE);
    }
}