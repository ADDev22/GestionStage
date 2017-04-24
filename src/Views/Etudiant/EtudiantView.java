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
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//EntrepriseView frame = new EntrepriseView();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public EtudiantView(EtudiantController etC) {
		etC.setEtView(this);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.setTitle("ACCUEIL");
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
			setSize(1090,595);
			setResizable(false);
			setVisible(true); 
	}

}
