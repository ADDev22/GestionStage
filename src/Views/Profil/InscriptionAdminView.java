package Views.Profil;

import Controllers.AdministrateurController;
import Models.Administrateur;
import Models.Fonction;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Allam on 01/04/2017.
 */
public class InscriptionAdminView extends JFrame {
    private JPanel container;
    private JLabel lAnnonce;
    private JLabel lNom;
    private JTextField tfNom;
    private JLabel lPrenom;
    private JTextField tfPrenom;
    private JLabel lAdresse;
    private JPanel pAdresse1;
    private JTextField tfNoRue;
    private JTextField tfRue;
    private JTextField tfComplement;
    private JPanel pAdresse2;
    private JTextField tfCdePostal;
    private JTextField tfVille;
    private JTextField tfPays;
    private JTextField tfMail;
    private JLabel lMail;
    private JLabel lTel;
    private JTextField tfTel;
    private JLabel lUserName;
    private JTextField tfUserName;
    private JLabel lMdp;
    private JPasswordField pfMdp;
    private JLabel lConfMdp;
    private JPasswordField pfConfMdp;
    private JPanel pBouttons;
    private JButton bCreer;
    private JButton bAnnuler;

    //Instation de notre objet controlleur
    private AdministrateurController adminController;

    public InscriptionAdminView(AdministrateurController administrateurController) {
        this.adminController = administrateurController;
        this.setTitle("Gestion Stage");
        this.setSize(500, 500);
        this.setContentPane(container);
        this.setLocationRelativeTo(null);
        bCreer.addActionListener(new BCreerListener());
        bAnnuler.addActionListener(new BAnnulerListener());
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
        container.setLayout(new GridLayoutManager(16, 5, new Insets(0, 0, 0, 0), -1, -1));
        container.setPreferredSize(new Dimension(925, 535));
        lAnnonce = new JLabel();
        lAnnonce.setText("Ajout d'un nouvel administrateur");
        container.add(lAnnonce, new GridConstraints(1, 1, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        container.add(spacer1, new GridConstraints(15, 1, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        lNom = new JLabel();
        lNom.setText("Nom");
        container.add(lNom, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        tfNom = new JTextField();
        container.add(tfNom, new GridConstraints(3, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        lPrenom = new JLabel();
        lPrenom.setText("Prenom");
        container.add(lPrenom, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        tfPrenom = new JTextField();
        container.add(tfPrenom, new GridConstraints(4, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        lAdresse = new JLabel();
        lAdresse.setText("Adresse");
        container.add(lAdresse, new GridConstraints(5, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        pAdresse1 = new JPanel();
        pAdresse1.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        container.add(pAdresse1, new GridConstraints(5, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        tfNoRue = new JTextField();
        tfNoRue.setText("No Rue");
        pAdresse1.add(tfNoRue, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        tfRue = new JTextField();
        tfRue.setText("Rue");
        pAdresse1.add(tfRue, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        tfComplement = new JTextField();
        tfComplement.setText("Complement");
        container.add(tfComplement, new GridConstraints(6, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        pAdresse2 = new JPanel();
        pAdresse2.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        container.add(pAdresse2, new GridConstraints(7, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        tfCdePostal = new JTextField();
        tfCdePostal.setText("Code Postal");
        pAdresse2.add(tfCdePostal, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        tfVille = new JTextField();
        tfVille.setText("Ville");
        pAdresse2.add(tfVille, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        tfPays = new JTextField();
        tfPays.setText("Pays");
        pAdresse2.add(tfPays, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        tfMail = new JTextField();
        tfMail.setText("");
        container.add(tfMail, new GridConstraints(8, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        lMail = new JLabel();
        lMail.setText("Mail");
        container.add(lMail, new GridConstraints(8, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        lTel = new JLabel();
        lTel.setText("Téléphone");
        container.add(lTel, new GridConstraints(9, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        tfTel = new JTextField();
        container.add(tfTel, new GridConstraints(9, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        lUserName = new JLabel();
        lUserName.setText("Nom d'utilisateur");
        container.add(lUserName, new GridConstraints(10, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        tfUserName = new JTextField();
        container.add(tfUserName, new GridConstraints(10, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        lMdp = new JLabel();
        lMdp.setText("Mot de passe");
        container.add(lMdp, new GridConstraints(11, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        pfMdp = new JPasswordField();
        container.add(pfMdp, new GridConstraints(11, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        lConfMdp = new JLabel();
        lConfMdp.setText("Confirmer le mot de passe");
        container.add(lConfMdp, new GridConstraints(12, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        pfConfMdp = new JPasswordField();
        container.add(pfConfMdp, new GridConstraints(12, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        pBouttons = new JPanel();
        pBouttons.setLayout(new GridLayoutManager(1, 4, new Insets(0, 0, 0, 0), -1, -1));
        container.add(pBouttons, new GridConstraints(14, 1, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        bCreer = new JButton();
        bCreer.setText("Créer");
        pBouttons.add(bCreer, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        bAnnuler = new JButton();
        bAnnuler.setText("Annuler");
        pBouttons.add(bAnnuler, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        pBouttons.add(spacer2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer3 = new Spacer();
        pBouttons.add(spacer3, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer4 = new Spacer();
        container.add(spacer4, new GridConstraints(0, 1, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer5 = new Spacer();
        container.add(spacer5, new GridConstraints(2, 1, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer6 = new Spacer();
        container.add(spacer6, new GridConstraints(3, 0, 10, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer7 = new Spacer();
        container.add(spacer7, new GridConstraints(3, 4, 10, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer8 = new Spacer();
        container.add(spacer8, new GridConstraints(13, 1, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer9 = new Spacer();
        container.add(spacer9, new GridConstraints(3, 2, 10, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return container;
    }

    class BCreerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Administrateur admin = new Administrateur();
            Fonction f = new Fonction();

            f.setFonctionId(1);
            f.setFonctionNom("Administrateur");

            admin.setUtilisateurUserName(tfUserName.getText());
            if (pfMdp.getText().equals(pfConfMdp.getText()))
                admin.setUtilisateurMdp(pfMdp.getText());
            admin.setFonction(f);
            admin.setAdministrateurNom(tfNom.getText());
            admin.setAdministrateurPrenom(tfPrenom.getText());
            admin.setAdresseNoRue(Integer.valueOf(tfNoRue.getText()));
            admin.setAdresseRue(tfRue.getText());
            admin.setAdresseComplement(tfComplement.getText());
            admin.setAdresseCdePostal(Integer.valueOf(tfCdePostal.getText()));
            admin.setAdresseVille(tfVille.getText());
            admin.setAdressePays(tfPays.getText());
            admin.setAdministrateurMail(tfMail.getText());
            admin.setAdministrateurTel(Integer.valueOf(tfTel.getText()));

            adminController.insert(admin);
        }
    }

    class BAnnulerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            InscriptionAdminView.this.dispose();
        }
    }
}
