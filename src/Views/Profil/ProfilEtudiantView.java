package Views.Profil;

import Models.DAO.EtudiantDAO;
import Models.DAO.UtilisateurDAO;
import Models.Etudiant;
import Models.Utilisateur;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Allam on 31/03/2017.
 */
public class ProfilEtudiantView extends JPanel {
    private JPanel pProfilEtudiant;
    private JLabel lAnnonce;
    private JLabel lNom;
    private JTextField tfNom;
    private JLabel lPrenom;
    private JTextField tfPrenom;
    private JLabel lDomEtude;
    private JTextField tfDomEtude;
    private JLabel lNivEtude;
    private JLabel lMail;
    private JTextField tfMail;
    private JLabel lTel;
    private JTextField tfTel;
    private JPanel pBouttonsValidation;
    private JButton bValider;
    private JButton bAnnuler;
    private JButton bModifier;
    private JPanel pBouttons;
    private JButton bModifierPseudoMdp;
    private JComboBox cbNivEtude;

    public ProfilEtudiantView(Etudiant e) {
        tfNom.setText(e.getNom());
        tfPrenom.setText(e.getPrenom());
        tfDomEtude.setText(e.getDomEtude());
        cbNivEtude.setSelectedItem(e.getNivEtude().toString());
        tfMail.setText(e.getMail());
        tfTel.setText(e.getTel());

        bValider.addActionListener(new BValiderListener());
        bAnnuler.addActionListener(new BAnnulerListener());
        bModifier.addActionListener(new BModifierListener());
        bModifierPseudoMdp.addActionListener(new BModifierPseudoMdpListener());
    }

    public JPanel getpProfilEtudiant() {
        return pProfilEtudiant;
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
        pProfilEtudiant = new JPanel();
        pProfilEtudiant.setLayout(new GridLayoutManager(12, 5, new Insets(0, 0, 0, 0), -1, -1));
        pProfilEtudiant.setPreferredSize(new Dimension(1090, 595));
        lAnnonce = new JLabel();
        lAnnonce.setText("Mon profil");
        pProfilEtudiant.add(lAnnonce, new GridConstraints(1, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        pProfilEtudiant.add(spacer1, new GridConstraints(11, 0, 1, 5, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        lNom = new JLabel();
        lNom.setText("Nom");
        pProfilEtudiant.add(lNom, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        tfNom = new JTextField();
        tfNom.setEnabled(false);
        pProfilEtudiant.add(tfNom, new GridConstraints(3, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        lPrenom = new JLabel();
        lPrenom.setText("Prenom");
        pProfilEtudiant.add(lPrenom, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        tfPrenom = new JTextField();
        tfPrenom.setEnabled(false);
        pProfilEtudiant.add(tfPrenom, new GridConstraints(4, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        lDomEtude = new JLabel();
        lDomEtude.setText("Domaine d'étude");
        pProfilEtudiant.add(lDomEtude, new GridConstraints(5, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        tfDomEtude = new JTextField();
        tfDomEtude.setEnabled(false);
        pProfilEtudiant.add(tfDomEtude, new GridConstraints(5, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        lNivEtude = new JLabel();
        lNivEtude.setText("Niveau d'étude");
        pProfilEtudiant.add(lNivEtude, new GridConstraints(6, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        lMail = new JLabel();
        lMail.setText("Mail");
        pProfilEtudiant.add(lMail, new GridConstraints(7, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        tfMail = new JTextField();
        tfMail.setEnabled(false);
        pProfilEtudiant.add(tfMail, new GridConstraints(7, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        lTel = new JLabel();
        lTel.setText("Téléphone");
        pProfilEtudiant.add(lTel, new GridConstraints(8, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        tfTel = new JTextField();
        tfTel.setEnabled(false);
        pProfilEtudiant.add(tfTel, new GridConstraints(8, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        pBouttonsValidation = new JPanel();
        pBouttonsValidation.setLayout(new GridLayoutManager(1, 4, new Insets(0, 0, 0, 0), -1, -1));
        pProfilEtudiant.add(pBouttonsValidation, new GridConstraints(10, 1, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        bValider = new JButton();
        bValider.setEnabled(false);
        bValider.setText("Valider");
        pBouttonsValidation.add(bValider, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        bAnnuler = new JButton();
        bAnnuler.setEnabled(false);
        bAnnuler.setText("Annuler");
        pBouttonsValidation.add(bAnnuler, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        pBouttonsValidation.add(spacer2, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer3 = new Spacer();
        pBouttonsValidation.add(spacer3, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        pBouttons = new JPanel();
        pBouttons.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        pProfilEtudiant.add(pBouttons, new GridConstraints(3, 3, 6, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        bModifier = new JButton();
        bModifier.setText("Modifier mes informations");
        pBouttons.add(bModifier, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        bModifierPseudoMdp = new JButton();
        bModifierPseudoMdp.setText("Modifier mon login et mon mot de passe");
        pBouttons.add(bModifierPseudoMdp, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer4 = new Spacer();
        pProfilEtudiant.add(spacer4, new GridConstraints(0, 0, 1, 5, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer5 = new Spacer();
        pProfilEtudiant.add(spacer5, new GridConstraints(3, 0, 6, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer6 = new Spacer();
        pProfilEtudiant.add(spacer6, new GridConstraints(2, 0, 1, 5, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer7 = new Spacer();
        pProfilEtudiant.add(spacer7, new GridConstraints(3, 4, 6, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer8 = new Spacer();
        pProfilEtudiant.add(spacer8, new GridConstraints(9, 0, 1, 5, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        cbNivEtude = new JComboBox();
        cbNivEtude.setEditable(true);
        cbNivEtude.setEnabled(false);
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("Bac");
        defaultComboBoxModel1.addElement("Bac+1");
        defaultComboBoxModel1.addElement("Bac+2");
        defaultComboBoxModel1.addElement("Bac+3");
        defaultComboBoxModel1.addElement("Bac+4");
        defaultComboBoxModel1.addElement("Bac+5");
        cbNivEtude.setModel(defaultComboBoxModel1);
        pProfilEtudiant.add(cbNivEtude, new GridConstraints(6, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return pProfilEtudiant;
    }

    class BModifierListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            tfNom.setEnabled(true);
            tfPrenom.setEnabled(true);
            tfDomEtude.setEnabled(true);
            cbNivEtude.setEnabled(true);
            tfMail.setEnabled(true);
            tfTel.setEnabled(true);

            bValider.setEnabled(true);
            bAnnuler.setEnabled(true);
        }
    }

    class BModifierPseudoMdpListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            UtilisateurDAO uDAO = new UtilisateurDAO();
            Utilisateur utilisateur = uDAO.find(new Utilisateur().getId());
            ChangementMdpView changementMdpView = new ChangementMdpView(utilisateur);
        }
    }

    class BValiderListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            EtudiantDAO eDAO = new EtudiantDAO();
            Etudiant et = new Etudiant();

            et.setIdEtudiant(new Utilisateur().getIdU());
            et.setNom(tfNom.getText());
            et.setPrenom(tfPrenom.getText());
            et.setDomEtude(tfDomEtude.getText());
            et.setNivEtude(cbNivEtude.getSelectedItem().toString());
            et.setMail(tfMail.getText());
            et.setTel(tfTel.getText());

            eDAO.update(et);

            //Affichage de la boite de dialogue
            JOptionPane jOP = new JOptionPane();
            jOP.showMessageDialog(null, "Modification enregistrées avec succes", "Information", JOptionPane.INFORMATION_MESSAGE);

            tfNom.setEnabled(false);
            tfPrenom.setEnabled(false);
            tfDomEtude.setEnabled(false);
            cbNivEtude.setEnabled(false);
            tfMail.setEnabled(false);
            tfTel.setEnabled(false);

            bValider.setEnabled(false);
            bAnnuler.setEnabled(false);
        }
    }

    class BAnnulerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            tfNom.setEnabled(false);
            tfPrenom.setEnabled(false);
            tfDomEtude.setEnabled(false);
            cbNivEtude.setEnabled(false);
            tfMail.setEnabled(false);
            tfTel.setEnabled(false);

            bValider.setEnabled(false);
            bAnnuler.setEnabled(false);
        }
    }
}