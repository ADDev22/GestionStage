package Views.Administrateur;

import Models.OffreStage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Allam on 06/04/2017.
 */
public class DetailsOffreView extends JPanel
{
    private JPanel pDetailsOffre;
    private JLabel lAnnonce;
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
    private JPanel pBouttons;
    private JButton bModifier;

    public JPanel getpDetailsOffre()
    {
        return this.pDetailsOffre;
    }

    public DetailsOffreView(OffreStage os)
    {
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

        bValider.addActionListener(new BValiderListener());
        bAnnuler.addActionListener(new BAnnulerListener());
        bModifier.addActionListener(new BModifierListener());
    }

    class BValiderListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {

        }
    }

    class BAnnulerListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {

        }
    }

    class BModifierListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {

        }
    }
}