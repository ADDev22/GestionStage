package Views.Entreprise;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.java.swing.plaf.windows.WindowsBorders.ProgressBarBorder;

import Controllers.EntrepriseController;
import Models.OffreStage;
import Models.DAO.EtudiantDAO;
import Models.DAO.OffreStageDAO;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDialog;
import java.awt.BorderLayout;
import javax.swing.JComboBox;

public class EntreprisePropOffreView extends JFrame {

	private JPanel contentPane;
	private JTextField libelele;
	private JTextField dateDebutT;
	private JTextField dureeT;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public EntreprisePropOffreView(final EntrepriseController eCont) {
		final OffreStage of =new OffreStage();
		of.setEntreprise(eCont.getE());
		final JFrame f =this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(8, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panel_1.getLayout();
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Edition d'un Offre de Stage");
		panel_1.add(lblNewLabel_3);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setHgap(10);
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel_2);
		
		JLabel lblNewLabel = new JLabel("Libelele :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(lblNewLabel);
		
		libelele = new JTextField();
		panel_2.add(libelele);
		libelele.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel_3);
		
		JLabel lblNewLabel_1 = new JLabel("Domaine :");
		panel_3.add(lblNewLabel_1);
		
		final JComboBox<String> comboBox = new JComboBox<String>();
		  comboBox.addItem("INFORMATIQUE");
		  comboBox.addItem("ECONOMIE");
		  comboBox.addItem("GESTION");
		  comboBox.addItem("DROIT");
		  comboBox.addItem("FINANCE");
		  comboBox.addItem("AERONAUTIQUE");
		  comboBox.addItem("ELECTRONIQUE");
		  comboBox.addItem("AUTRES");
		
		panel_3.add(comboBox);
		
		JPanel domaine = new JPanel();
		contentPane.add(domaine);
		domaine.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblDescriptif = new JLabel("Descriptif :");
		domaine.add(lblDescriptif);
		
		final JTextArea descripT = new JTextArea();
		descripT.setColumns(15);
		descripT.setRows(6);
		
		JScrollPane scrollPane = new JScrollPane(descripT);
		domaine.add(scrollPane);
		
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_5.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel_5);
		
		JLabel lblDateDeDebut = new JLabel("Date de debut :");
		panel_5.add(lblDateDeDebut);
		
		dateDebutT = new JTextField();
		panel_5.add(dateDebutT);
		dateDebutT.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_6.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel_6);
		
		JLabel lblNewLabel_2 = new JLabel("Durée :");
		panel_6.add(lblNewLabel_2);
		
		dureeT = new JTextField();
		panel_6.add(dureeT);
		dureeT.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_7.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel_7);
		
		JLabel chemin = new JLabel("Descriptif Complet :");
		panel_7.add(chemin);
		final EntreprisePropOffreView v =this;
		JButton seletFichier = new JButton("Seletionner fichier");
		seletFichier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				JFileChooser choix = new JFileChooser();
				int retour=choix.showOpenDialog(f);
				if(retour==JFileChooser.APPROVE_OPTION);
				   of.setCheminOffre(choix.getSelectedFile().getAbsolutePath());				
			}	
		});
		panel_7.add(seletFichier);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel.getLayout();
		contentPane.add(panel);

		
		JButton btnAnnuler = new JButton("Annuler");
		panel.add(btnAnnuler);
	    btnAnnuler.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				eCont.getEntView().setVisible(true);
				v.setVisible(false);
				v.dispose();
			}
		});
		
		JButton btnOk = new JButton("Valider");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				of.setLibelleOffre(libelele.getText());
				of.setDomaineOffre(comboBox.getSelectedItem().toString());
				of.setDescriptifOffre(descripT.getText());
				of.setDateDebut(dateDebutT.getText());
				of.setDureeOffre(dureeT.getText());
				of.setEntreprise(eCont.getE());
		  
				new OffreStageDAO().create(of);
				
				v.setVisible(true);
				v.dispose();
			}
		});
		panel.add(btnOk);
		setSize(1090,595);
		setResizable(false);
		setVisible(true); 
	
	}

}
