package Views.Administrateur;

import Controllers.AdministrateurController;
import Controllers.AuthentificationController;
import Models.*;
import Models.DAO.*;
import Views.Compte.AuthentificationView;
import Views.Profil.ProfilAdministrateurView;
import Views.Profil.ProfilEntrepriseView;
import Views.Profil.ProfilEtudiantView;
import Views.Profil.ProfilView;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Allam on 26/03/2017.
 */
public class AdministrateurAccueilView extends JFrame {
    private JButton bListeOffres;
    private JButton bListeEntreprises;
    private JButton bListeEtudiants;
    private JPanel container;
    private JLabel lAnnonce;
    private JPanel pBouttons;
    private JPanel pContenu;
    private JTable tContenu;
    private JPanel pDetails;
    private JPanel pDetailsOffre;
    private JLabel lId;
    private JTextField tfId;
    private JLabel lLibelle;
    private JTextField tfLibelle;
    private JLabel lDomaine;
    private JTextField tfDomaine;
    private JLabel lDescriptif;
    private JTextArea taDescriptif;
    private JLabel lDateDebut;
    private JTextField tfDateDebut;
    private JLabel lDuree;
    private JTextField tfDuree;
    private JLabel lValide;
    private JComboBox cbValide;
    private JPanel pBouttonsValidation;
    private JButton bValider;
    private JButton bAnnuler;
    private JButton bModifier;
    private JComboBox cbFiltre;
    private JButton bFiltrer;
    private JButton bListeAdmin;
    private JPanel pDetailsAdmin;
    private JLabel lAnnonceAdmin;
    private JLabel lNomAdmin;
    private JTextField tfNomAdmin;
    private JLabel lPrenomAdmin;
    private JTextField tfPrenomAdmin;
    private JLabel lAdresseAdmin;
    private JPanel pAdresse1;
    private JTextField tfNoRueAdmin;
    private JTextField tfRueAdmin;
    private JTextField tfComplementAdmin;
    private JPanel pAdresse2;
    private JTextField tfCdePostalAdmin;
    private JTextField tfPaysAdmin;
    private JLabel lMailAdmin;
    private JTextField tfMailAdmin;
    private JLabel lTelAdmin;
    private JTextField tfTelAdmin;
    private JButton bSupprimerAdmin;
    private JTextField tfVilleAdmin;
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menu = new JMenu("Fichier");
    private JMenuItem sousMenu1 = new JMenuItem("Profil");
    private JMenuItem sousMenu2 = new JMenuItem("Déconnexion");


    //Instanciation de notre objet contrôleur
    private AdministrateurController adminController;

    public AdministrateurAccueilView(AdministrateurController administrateurController, TableModel model) {
        this.adminController = administrateurController;
        this.setTitle("Gestion Stage");
        this.setSize(500, 500);
        this.setContentPane(container);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        pDetailsOffre.setVisible(false);
        pDetailsAdmin.setVisible(false);

        bFiltrer.addActionListener(new BFiltrerListener());
        bListeOffres.addActionListener(new BListeOffresListener());
        bListeAdmin.addActionListener(new BListeAdminsListener());
        bListeEntreprises.addActionListener(new BListeEntreprisesListener());
        bListeEtudiants.addActionListener(new BListeEtudiantsListener());
        sousMenu1.addActionListener(new SousMenu1ActionListener());
        sousMenu2.addActionListener(new SousMenu2ActionListener());

        //Bouttons des détails de l'offre
        bValider.addActionListener(new BValiderListener());
        bAnnuler.addActionListener(new BAnnulerListener());
        bModifier.addActionListener(new BModifierListener());

        //Bouttons des détails de l'administrateur
        bSupprimerAdmin.addActionListener(new BSupprimerAdminListener());

        //Menu
        menuBar.add(menu);
        //Ajout des sous menus
        menu.add(sousMenu1);
        menu.add(sousMenu2);
        //Définition à l'intérieur du panel
        this.setJMenuBar(menuBar);

        //Traitement du tabeleau
        tContenu = new JTable(model);
        tContenu.setLayout(new BorderLayout());
        pContenu.add(new JScrollPane(tContenu), BorderLayout.CENTER);

        tContenu.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (String.valueOf(tContenu.getColumnName(1)).equals("libelle")) {
                    pDetailsOffre.setVisible(true);
                    String valeurId = String.valueOf(tContenu.getModel().getValueAt(tContenu.getSelectedRow(), 0)); //tContenu.getSelectedColumn()
                    OffreStage os = new OffreStageDAO().find(Integer.valueOf(valeurId));

                    tfId.setText(String.valueOf(os.getIdOffreStage()));
                    tfLibelle.setText(os.getLibelleOffre());
                    tfDomaine.setText(os.getDomaineOffre());
                    taDescriptif.setText(os.getDescriptifOffre());
                    tfDateDebut.setText(os.getDateDebut());
                    tfDuree.setText(os.getDureeOffre());
                    int validite = os.getIsValide();
                    if (validite == 0)
                        cbValide.setSelectedItem("En Attente");
                    else if (validite == 1)
                        cbValide.setSelectedItem("Acceptée");
                    else
                        cbValide.setSelectedItem("Declinée");

                /*DetailsOffreView detailsOffreView = new DetailsOffreView(os);
                pDetails = detailsOffreView.getpDetailsOffre();

                AdministrateurAccueilView.this.getContentPane().removeAll();

                AdministrateurAccueilView.this.pDetails.updateUI();
                AdministrateurAccueilView.this.pDetails.revalidate();
                AdministrateurAccueilView.this.getContentPane().revalidate();
                //AdministrateurAccueilView.this.setContentPane(container);
                AdministrateurAccueilView.this.getContentPane().repaint();
                AdministrateurAccueilView.this.setVisible(true);*/
                } else if (String.valueOf(tContenu.getColumnName(1)).equals("nom")) {
                    pDetailsAdmin.setVisible(true);
                    String valeurId = String.valueOf(tContenu.getModel().getValueAt(tContenu.getSelectedRow(), 0)); //tContenu.getSelectedColumn()
                    Administrateur a = new AdministrateurDAO().find(Integer.valueOf(valeurId));

                    tfNomAdmin.setText(a.getAdministrateurNom());
                    tfPrenomAdmin.setText(a.getAdministrateurPrenom());
                    tfNoRueAdmin.setText(String.valueOf(a.getAdresseNoRue()));
                    tfRueAdmin.setText(a.getAdresseRue());
                    tfComplementAdmin.setText(a.getAdresseComplement());
                    tfCdePostalAdmin.setText(String.valueOf(a.getAdresseCdePostal()));
                    tfVilleAdmin.setText(a.getAdresseVille());
                    tfPaysAdmin.setText(a.getAdressePays());
                    tfMailAdmin.setText(a.getAdministrateurMail());
                    tfTelAdmin.setText(String.valueOf(a.getAdministrateurTel()));

                /*DetailsOffreView detailsOffreView = new DetailsOffreView(os);
                pDetails = detailsOffreView.getpDetailsOffre();

                AdministrateurAccueilView.this.getContentPane().removeAll();

                AdministrateurAccueilView.this.pDetails.updateUI();
                AdministrateurAccueilView.this.pDetails.revalidate();
                AdministrateurAccueilView.this.getContentPane().revalidate();
                //AdministrateurAccueilView.this.setContentPane(container);
                AdministrateurAccueilView.this.getContentPane().repaint();
                AdministrateurAccueilView.this.setVisible(true);*/
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        this.pack();
        this.setVisible(true);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        container = new JPanel();
        container.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(6, 10, new Insets(0, 0, 0, 0), -1, -1));
        container.setPreferredSize(new Dimension(1090, 595));
        lAnnonce = new JLabel();
        lAnnonce.setText("Bienvenue");
        container.add(lAnnonce, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 10, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        pBouttons = new JPanel();
        pBouttons.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 2, new Insets(0, 0, 0, 0), -1, -1));
        container.add(pBouttons, new com.intellij.uiDesigner.core.GridConstraints(4, 8, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 1, false));
        bListeOffres = new JButton();
        bListeOffres.setText("Liste des offres");
        pBouttons.add(bListeOffres, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        bListeEntreprises = new JButton();
        bListeEntreprises.setText("Liste des entreprises");
        pBouttons.add(bListeEntreprises, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        bListeEtudiants = new JButton();
        bListeEtudiants.setText("Liste des étudiants");
        pBouttons.add(bListeEtudiants, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        pBouttons.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 4, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        bListeAdmin = new JButton();
        bListeAdmin.setText("Liste des admins");
        pBouttons.add(bListeAdmin, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        pContenu = new JPanel();
        pContenu.setLayout(new BorderLayout(0, 0));
        container.add(pContenu, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        tContenu = new JTable();
        tContenu.setSelectionBackground(new Color(-259));
        tContenu.setShowHorizontalLines(true);
        tContenu.setShowVerticalLines(true);
        pContenu.add(tContenu, BorderLayout.CENTER);
        pDetails = new JPanel();
        pDetails.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        container.add(pDetails, new com.intellij.uiDesigner.core.GridConstraints(4, 3, 1, 4, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        pDetailsOffre = new JPanel();
        pDetailsOffre.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(13, 3, new Insets(0, 0, 0, 0), -1, -1));
        pDetails.add(pDetailsOffre, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Détails de l'offre");
        pDetailsOffre.add(label1, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        pDetailsOffre.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(12, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        lId = new JLabel();
        lId.setText("Identifiant");
        pDetailsOffre.add(lId, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        tfId = new JTextField();
        tfId.setEnabled(false);
        pDetailsOffre.add(tfId, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        lLibelle = new JLabel();
        lLibelle.setText("Libellé");
        pDetailsOffre.add(lLibelle, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        tfLibelle = new JTextField();
        tfLibelle.setEnabled(false);
        pDetailsOffre.add(tfLibelle, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        lDomaine = new JLabel();
        lDomaine.setText("Domaine");
        pDetailsOffre.add(lDomaine, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        tfDomaine = new JTextField();
        tfDomaine.setEnabled(false);
        pDetailsOffre.add(tfDomaine, new com.intellij.uiDesigner.core.GridConstraints(5, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        lDescriptif = new JLabel();
        lDescriptif.setText("Descriptif");
        pDetailsOffre.add(lDescriptif, new com.intellij.uiDesigner.core.GridConstraints(6, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTHWEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        taDescriptif = new JTextArea();
        taDescriptif.setEnabled(false);
        pDetailsOffre.add(taDescriptif, new com.intellij.uiDesigner.core.GridConstraints(6, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        lDateDebut = new JLabel();
        lDateDebut.setText("Date de début");
        pDetailsOffre.add(lDateDebut, new com.intellij.uiDesigner.core.GridConstraints(7, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        tfDateDebut = new JTextField();
        tfDateDebut.setEnabled(false);
        pDetailsOffre.add(tfDateDebut, new com.intellij.uiDesigner.core.GridConstraints(7, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        lDuree = new JLabel();
        lDuree.setText("Durée");
        pDetailsOffre.add(lDuree, new com.intellij.uiDesigner.core.GridConstraints(8, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        tfDuree = new JTextField();
        tfDuree.setEnabled(false);
        pDetailsOffre.add(tfDuree, new com.intellij.uiDesigner.core.GridConstraints(8, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        lValide = new JLabel();
        lValide.setText("Validité");
        pDetailsOffre.add(lValide, new com.intellij.uiDesigner.core.GridConstraints(9, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        cbValide = new JComboBox();
        cbValide.setEditable(true);
        cbValide.setEnabled(false);
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("En Attente");
        defaultComboBoxModel1.addElement("Validée");
        defaultComboBoxModel1.addElement("Declinée");
        cbValide.setModel(defaultComboBoxModel1);
        pDetailsOffre.add(cbValide, new com.intellij.uiDesigner.core.GridConstraints(9, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer3 = new com.intellij.uiDesigner.core.Spacer();
        pDetailsOffre.add(spacer3, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        pBouttonsValidation = new JPanel();
        pBouttonsValidation.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 4, new Insets(0, 0, 0, 0), -1, -1));
        pDetailsOffre.add(pBouttonsValidation, new com.intellij.uiDesigner.core.GridConstraints(11, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        bValider = new JButton();
        bValider.setEnabled(false);
        bValider.setText("Valider");
        pBouttonsValidation.add(bValider, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        bAnnuler = new JButton();
        bAnnuler.setEnabled(false);
        bAnnuler.setText("Annuler");
        pBouttonsValidation.add(bAnnuler, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer4 = new com.intellij.uiDesigner.core.Spacer();
        pBouttonsValidation.add(spacer4, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer5 = new com.intellij.uiDesigner.core.Spacer();
        pBouttonsValidation.add(spacer5, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer6 = new com.intellij.uiDesigner.core.Spacer();
        pDetailsOffre.add(spacer6, new com.intellij.uiDesigner.core.GridConstraints(10, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        pDetailsOffre.add(panel1, new com.intellij.uiDesigner.core.GridConstraints(3, 2, 9, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        bModifier = new JButton();
        bModifier.setText("Modifier");
        panel1.add(bModifier, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer7 = new com.intellij.uiDesigner.core.Spacer();
        pDetailsOffre.add(spacer7, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer8 = new com.intellij.uiDesigner.core.Spacer();
        container.add(spacer8, new com.intellij.uiDesigner.core.GridConstraints(5, 1, 1, 9, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer9 = new com.intellij.uiDesigner.core.Spacer();
        container.add(spacer9, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 10, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        cbFiltre = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel2 = new DefaultComboBoxModel();
        defaultComboBoxModel2.addElement("En Attente");
        defaultComboBoxModel2.addElement("Validée");
        defaultComboBoxModel2.addElement("Declinée");
        cbFiltre.setModel(defaultComboBoxModel2);
        container.add(cbFiltre, new com.intellij.uiDesigner.core.GridConstraints(2, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        bFiltrer = new JButton();
        bFiltrer.setText("Filtrer");
        container.add(bFiltrer, new com.intellij.uiDesigner.core.GridConstraints(2, 5, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer10 = new com.intellij.uiDesigner.core.Spacer();
        container.add(spacer10, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer11 = new com.intellij.uiDesigner.core.Spacer();
        container.add(spacer11, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 9, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        pDetailsAdmin = new JPanel();
        pDetailsAdmin.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(12, 2, new Insets(0, 0, 0, 0), -1, -1));
        container.add(pDetailsAdmin, new com.intellij.uiDesigner.core.GridConstraints(4, 7, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        lAnnonceAdmin = new JLabel();
        lAnnonceAdmin.setText("Détails de l'admin");
        pDetailsAdmin.add(lAnnonceAdmin, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer12 = new com.intellij.uiDesigner.core.Spacer();
        pDetailsAdmin.add(spacer12, new com.intellij.uiDesigner.core.GridConstraints(11, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        lNomAdmin = new JLabel();
        lNomAdmin.setText("Nom");
        pDetailsAdmin.add(lNomAdmin, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        tfNomAdmin = new JTextField();
        tfNomAdmin.setEnabled(false);
        pDetailsAdmin.add(tfNomAdmin, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        lPrenomAdmin = new JLabel();
        lPrenomAdmin.setText("Prénom");
        pDetailsAdmin.add(lPrenomAdmin, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        tfPrenomAdmin = new JTextField();
        tfPrenomAdmin.setEnabled(false);
        pDetailsAdmin.add(tfPrenomAdmin, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        lAdresseAdmin = new JLabel();
        lAdresseAdmin.setText("Adresse");
        pDetailsAdmin.add(lAdresseAdmin, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        pAdresse1 = new JPanel();
        pAdresse1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        pDetailsAdmin.add(pAdresse1, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        tfNoRueAdmin = new JTextField();
        tfNoRueAdmin.setEnabled(false);
        pAdresse1.add(tfNoRueAdmin, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        tfRueAdmin = new JTextField();
        tfRueAdmin.setEnabled(false);
        pAdresse1.add(tfRueAdmin, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        tfComplementAdmin = new JTextField();
        tfComplementAdmin.setEnabled(false);
        pDetailsAdmin.add(tfComplementAdmin, new com.intellij.uiDesigner.core.GridConstraints(5, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        pAdresse2 = new JPanel();
        pAdresse2.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        pDetailsAdmin.add(pAdresse2, new com.intellij.uiDesigner.core.GridConstraints(6, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        tfCdePostalAdmin = new JTextField();
        tfCdePostalAdmin.setEnabled(false);
        pAdresse2.add(tfCdePostalAdmin, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        tfPaysAdmin = new JTextField();
        tfPaysAdmin.setEnabled(false);
        pAdresse2.add(tfPaysAdmin, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        tfVilleAdmin = new JTextField();
        tfVilleAdmin.setEnabled(false);
        pAdresse2.add(tfVilleAdmin, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        lMailAdmin = new JLabel();
        lMailAdmin.setText("Mail");
        pDetailsAdmin.add(lMailAdmin, new com.intellij.uiDesigner.core.GridConstraints(7, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        tfMailAdmin = new JTextField();
        tfMailAdmin.setEnabled(false);
        pDetailsAdmin.add(tfMailAdmin, new com.intellij.uiDesigner.core.GridConstraints(7, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        lTelAdmin = new JLabel();
        lTelAdmin.setText("Téléphone");
        pDetailsAdmin.add(lTelAdmin, new com.intellij.uiDesigner.core.GridConstraints(8, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        tfTelAdmin = new JTextField();
        tfTelAdmin.setEnabled(false);
        pDetailsAdmin.add(tfTelAdmin, new com.intellij.uiDesigner.core.GridConstraints(8, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer13 = new com.intellij.uiDesigner.core.Spacer();
        pDetailsAdmin.add(spacer13, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        bSupprimerAdmin = new JButton();
        bSupprimerAdmin.setText("Supprimer");
        pDetailsAdmin.add(bSupprimerAdmin, new com.intellij.uiDesigner.core.GridConstraints(10, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer14 = new com.intellij.uiDesigner.core.Spacer();
        pDetailsAdmin.add(spacer14, new com.intellij.uiDesigner.core.GridConstraints(9, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return container;
    }

    class BFiltrerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            AdministrateurDAO administrateurDAO = new AdministrateurDAO();
            AdministrateurController administrateurController = new AdministrateurController(administrateurDAO);

            int isValide;
            String motCle = cbFiltre.getSelectedItem().toString();
            if (motCle.equals("En Attente"))
                isValide = 0;
            else if (motCle.equals("Validée"))
                isValide = 1;
            else
                isValide = 2;

            ResultSetTableModel offresRS = new ResultSetTableModel(new OffreStageDAO().listeOffres(isValide));
            AdministrateurAccueilView administrateurAccueilView = new AdministrateurAccueilView(administrateurController, offresRS);
            AdministrateurAccueilView.this.dispose();
        }
    }

    class BListeOffresListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            AdministrateurDAO administrateurDAO = new AdministrateurDAO();
            AdministrateurController administrateurController = new AdministrateurController(administrateurDAO);
            ResultSetTableModel offresRS = new ResultSetTableModel(new OffreStageDAO().listeOffres());
            AdministrateurAccueilView administrateurAccueilView = new AdministrateurAccueilView(administrateurController, offresRS);
            AdministrateurAccueilView.this.dispose();
        }
    }

    class BListeAdminsListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            AdministrateurDAO administrateurDAO = new AdministrateurDAO();
            AdministrateurController administrateurController = new AdministrateurController(administrateurDAO);
            ResultSetTableModel adminsRS = new ResultSetTableModel(new AdministrateurDAO().listeAdmins());
            AdministrateurAccueilView administrateurAccueilView = new AdministrateurAccueilView(administrateurController, adminsRS);
            AdministrateurAccueilView.this.dispose();
        }
    }

    class BListeEntreprisesListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            AdministrateurDAO administrateurDAO = new AdministrateurDAO();
            AdministrateurController administrateurController = new AdministrateurController(administrateurDAO);
            ResultSetTableModel entreprisesRS = new ResultSetTableModel(new EntrepriseDAO().listeEntreprises());
            AdministrateurAccueilView administrateurAccueilView = new AdministrateurAccueilView(administrateurController, entreprisesRS);
            AdministrateurAccueilView.this.dispose();
        }
    }

    class BListeEtudiantsListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            AdministrateurDAO administrateurDAO = new AdministrateurDAO();
            AdministrateurController administrateurController = new AdministrateurController(administrateurDAO);
            ResultSetTableModel etudiantRS = new ResultSetTableModel(new EtudiantDAO().listeEtudiants());
            AdministrateurAccueilView administrateurAccueilView = new AdministrateurAccueilView(administrateurController, etudiantRS);
            AdministrateurAccueilView.this.dispose();
        }
    }

    class SousMenu1ActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Utilisateur u = new Utilisateur();
            if (u.getDroit() == 1) {
                Administrateur admin = new AdministrateurDAO().find(u.getIdU());
                ProfilView profilView = new ProfilView(new ProfilAdministrateurView(admin).getpProfilAdministrateur());
                AdministrateurAccueilView.this.dispose();
            } else if (u.getDroit() == 2) {
                Entreprise ent = new EntrepriseDAO().find(u.getIdU());
                ProfilView profilView = new ProfilView(new ProfilEntrepriseView(ent).getpProfilEntreprise());
                AdministrateurAccueilView.this.dispose();
            } else {
                Etudiant et = new EtudiantDAO().find(u.getIdU());
                ProfilView profilView = new ProfilView(new ProfilEtudiantView(et).getpProfilEtudiant());
                AdministrateurAccueilView.this.dispose();
            }
        }
    }

    class SousMenu2ActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //Attribution des variables statiques qui vont servir de session
            new Utilisateur().setId(0);
            new Utilisateur().setIdU(0);
            new Utilisateur().setNom("");
            new Utilisateur().setDroit(0);

            /*Fentre Authentification*/
            UtilisateurDAO uDAO = new UtilisateurDAO();
            AuthentificationController authController = new AuthentificationController(uDAO);
            AuthentificationView authentificationView = new AuthentificationView(authController);
            AdministrateurAccueilView.this.dispose();
        }
    }

    class BValiderListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            OffreStage os = new OffreStage();
            OffreStageDAO osDAO = new OffreStageDAO();

            os.setIdOffreStage(Integer.valueOf(tfId.getText()));
            os.setLibelleOffre(tfLibelle.getText());
            os.setDomaineOffre(tfDomaine.getText());
            os.setDescriptifOffre(taDescriptif.getText());
            os.setDateDebut(tfDateDebut.getText());
            os.setDureeOffre(tfDuree.getText());
            os.setEntreprise(new EntrepriseDAO().find(new Utilisateur().getIdU()));
            if (cbValide.getSelectedItem().toString().equals("En Attente"))
                os.setIsValide(0);
            else if (cbValide.getSelectedItem().toString().equals("Validée"))
                os.setIsValide(1);
            else
                os.setIsValide(2);

            osDAO.update(os);

            cbValide.setEnabled(false);
            bValider.setEnabled(false);
            bAnnuler.setEnabled(false);
        }
    }

    class BAnnulerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cbValide.setEnabled(false);
            bValider.setEnabled(false);
            bAnnuler.setEnabled(false);
        }
    }

    class BModifierListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            bValider.setEnabled(true);
            bAnnuler.setEnabled(true);
            cbValide.setEditable(false);
            cbValide.setEnabled(true);
        }
    }

    class BSupprimerAdminListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (JOptionPane.showConfirmDialog(null, "L'administrateur sera supprimé définitivement, en êtes-vous sûr ?") == JOptionPane.YES_OPTION) {
                String valeurId = String.valueOf(tContenu.getModel().getValueAt(tContenu.getSelectedRow(), 0)); //tContenu.getSelectedColumn()
                Administrateur a = new AdministrateurDAO().find(Integer.valueOf(valeurId));
                Utilisateur u = new UtilisateurDAO().find(a.getUtilisateur().getUitilisateurId());
                new AdministrateurDAO().delete(a);
                new UtilisateurDAO().delete(u);
            }
        }
    }
}