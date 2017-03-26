package Controllers;

import Models.DAO.DAO;
import Models.DAO.EtudiantDAO;
import Models.Etudiant;

import javax.swing.*;

/**
 * Created by Allam on 24/03/2017.
 */
public class EtudiantController
{
    //Déclaration

    DAO<Etudiant> DAO = new EtudiantDAO();

    /*//Constructeur

    public EtudiantController(EtudiantDAO eDAO)
    {
        this.DAO = eDAO;
    }*/

    public void insert(Etudiant e)
    {
        DAO.create(e);

        //Affichage de la boite de dialogue
        JOptionPane jOP = new JOptionPane();
        jOP.showMessageDialog(null, "Enregistrement réussie", "Information", JOptionPane.INFORMATION_MESSAGE);
    }
}