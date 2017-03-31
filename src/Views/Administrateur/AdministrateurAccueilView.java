package Views.Administrateur;

import Controllers.AdministrateurController;
import Models.DAO.AdministrateurDAO;
import Models.DAO.EntrepriseDAO;
import Models.DAO.EtudiantDAO;
import Models.DAO.OffreStageDAO;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Allam on 26/03/2017.
 */
public class AdministrateurAccueilView extends JFrame
{
    private JButton bListeOffres;
    private JButton bListeEntreprises;
    private JButton bListeEtudiants;
    private JPanel container;
    private JLabel lAnnonce;
    private JPanel pBouttons;
    private JPanel pContenu;
    private JTable tContenu;
    private JPanel pDetails;

    //Instanciation de notre objet contrôleur
    private AdministrateurController adminController;

    public AdministrateurAccueilView(AdministrateurController administrateurController, TableModel model)
    {
        this.adminController = administrateurController;
        this.setTitle("Gestion Stage");
        this.setSize(500, 500);
        this.setContentPane(container);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        bListeOffres.addActionListener(new BListeOffresListener());
        bListeEntreprises.addActionListener(new BListeEntreprisesListener());
        bListeEtudiants.addActionListener(new BListeEtudiantsListener());

        //Traitement du tabeleau
        tContenu = new JTable(model);
        tContenu.setLayout(new BorderLayout());
        pContenu.add(new JScrollPane(tContenu), BorderLayout.CENTER);

        this.pack();
        this.setVisible(true);
    }

    class BListeOffresListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            AdministrateurDAO administrateurDAO = new AdministrateurDAO();
            AdministrateurController administrateurController = new AdministrateurController(administrateurDAO);
            ResultSetTableModel offresRS = new ResultSetTableModel(new OffreStageDAO().listeOffres());
            AdministrateurAccueilView administrateurAccueilView = new AdministrateurAccueilView(administrateurController, offresRS);
            AdministrateurAccueilView.this.dispose();
        }
    }

    class BListeEntreprisesListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            AdministrateurDAO administrateurDAO = new AdministrateurDAO();
            AdministrateurController administrateurController = new AdministrateurController(administrateurDAO);
            ResultSetTableModel entreprisesRS = new ResultSetTableModel(new EntrepriseDAO().listeEntreprises());
            AdministrateurAccueilView administrateurAccueilView = new AdministrateurAccueilView(administrateurController, entreprisesRS);
            AdministrateurAccueilView.this.dispose();
        }
    }

    class BListeEtudiantsListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            AdministrateurDAO administrateurDAO = new AdministrateurDAO();
            AdministrateurController administrateurController = new AdministrateurController(administrateurDAO);
            ResultSetTableModel etudiantRS = new ResultSetTableModel(new EtudiantDAO().listeEtudiants());
            AdministrateurAccueilView administrateurAccueilView = new AdministrateurAccueilView(administrateurController, etudiantRS);
            AdministrateurAccueilView.this.dispose();
        }
    }
}
