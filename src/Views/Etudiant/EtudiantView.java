package Views.Etudiant;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import Controllers.EntrepriseController;
import Controllers.EtudiantController;

public class EtudiantView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public EtudiantView(EtudiantController etC) {
		etC.setEtView(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JTabbedPane onglets = new JTabbedPane();
		 PannelOffreEtuView ongletOf = new PannelOffreEtuView(etC);
		 ongletOf.setEt(etC);
		 PannelMesCandEtuView ongletCand = new PannelMesCandEtuView(etC);
		 ongletCand.setEt(etC);
		 //onglets.setVisible(true);
		 onglets.addTab("Offres", ongletOf);
		 onglets.add("Mes Candidatures", ongletCand);
		 getContentPane().add(onglets);
		 this.setVisible(true);
	}

}
