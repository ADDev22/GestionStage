package Views.Entreprise;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Controllers.EntrepriseController;
import Models.EtuPostStage;
import Models.Etudiant;
import Models.OffreModel;
import Models.OffreStage;
import Models.DAO.EtudiantDAO;
import jdk.nashorn.internal.scripts.JS;

import javax.swing.JTabbedPane;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class EntrepriseView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private EntrepriseController eCont;

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
	public EntrepriseView(final EntrepriseController eCont) {
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.eCont = eCont;
		eCont.setEntView(this);
		
		
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelDetails = new JPanel();
		contentPane.add(panelDetails, BorderLayout.CENTER);
		panelDetails.setLayout(new GridLayout(11, 1, 0, 0));
		
		JLabel lblDetailsOffre = new JLabel("Details Offre");
		panelDetails.add(lblDetailsOffre);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setHgap(10);
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelDetails.add(panel);
		
		JLabel lblRfrence = new JLabel("Référence:");
		lblRfrence.setHorizontalAlignment(SwingConstants.TRAILING);
		panel.add(lblRfrence);
		
		final JLabel id = new JLabel("id");
		panel.add(id);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setHgap(10);
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panelDetails.add(panel_1);
		
		JLabel lblLibel = new JLabel("Libelé:");
		panel_1.add(lblLibel);
		
		final JLabel libele = new JLabel("libele");
		panel_1.add(libele);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
		flowLayout_2.setHgap(10);
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panelDetails.add(panel_2);
		
		JLabel lblNewLabel = new JLabel("Domaine:");
		panel_2.add(lblNewLabel);
		
		final JLabel domaine = new JLabel("");
		panel_2.add(domaine);
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_4.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		panelDetails.add(panel_4);
		
		JLabel desc = new JLabel("Descriptif:");
		panel_4.add(desc);
		
		JLabel descriptif = new JLabel("");
		panel_4.add(descriptif);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_3.getLayout();
		flowLayout_4.setHgap(10);
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		panelDetails.add(panel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Date de debut:");
		panel_3.add(lblNewLabel_4);
		
		final JLabel dateDebut = new JLabel("");
		panel_3.add(dateDebut);
		
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel_5.getLayout();
		flowLayout_5.setHgap(10);
		flowLayout_5.setAlignment(FlowLayout.LEFT);
		panelDetails.add(panel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Durée:");
		panel_5.add(lblNewLabel_6);
		
		final JLabel duree = new JLabel("");
		panel_5.add(duree);
		
		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panel_6.getLayout();
		flowLayout_6.setHgap(10);
		flowLayout_6.setAlignment(FlowLayout.LEFT);
		panelDetails.add(panel_6);
		
		JLabel lblNewLabel_8 = new JLabel("Status:");
		panel_6.add(lblNewLabel_8);
		
		final JLabel isValide = new JLabel("");
		panel_6.add(isValide);
		
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout_7 = (FlowLayout) panel_7.getLayout();
		flowLayout_7.setHgap(10);
		flowLayout_7.setAlignment(FlowLayout.LEFT);
		panelDetails.add(panel_7);
		
		JLabel lblNewLabel_1 = new JLabel("Details Complet:");
		panel_7.add(lblNewLabel_1);
		
		JPanel panel_8 = new JPanel();
		FlowLayout flowLayout_8 = (FlowLayout) panel_8.getLayout();
		flowLayout_8.setAlignment(FlowLayout.LEFT);
		panelDetails.add(panel_8);
		
		JPanel panelRech = new JPanel();
		contentPane.add(panelRech, BorderLayout.NORTH);
		
		JLabel lblDomaine = new JLabel("Domaine :");
		panelRech.add(lblDomaine);
		
		final JComboBox<String> comboBox = new JComboBox<String>();
		  comboBox.addItem("INFORMATIQUE");
		  comboBox.addItem("ECONOMIE");
		  comboBox.addItem("GESTION");
		  comboBox.addItem("DROIT");
		  comboBox.addItem("FINANCE");
		  comboBox.addItem("AERONAUTIQUE");
		  comboBox.addItem("ELECTRONIQUE");
		  comboBox.addItem("AUTRES");
		  
		panelRech.add(comboBox);
		
		JButton btnRecherche = new JButton("Recherche");
		btnRecherche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eCont.rechercheOf((String)comboBox.getSelectedItem());
				eCont.getOfModel().fireTableChanged(null);
			    
			}
		});
		panelRech.add(btnRecherche);
		
		JPanel panelAct = new JPanel();
		contentPane.add(panelAct, BorderLayout.EAST);
		panelAct.setLayout(new GridLayout(4, 1, 0, 0));
		
		final JButton btnEditer = new JButton("EDITER");
		panelAct.add(btnEditer);
		btnEditer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() == -1)
				{
					JOptionPane.showMessageDialog(eCont.getEntView(), "Veuillez selectioner une offre");
				}
				else
				eCont.modifierOffre();
				
			}
		});
		
		JButton btnSupp = new JButton("SUPPRIMER");
		btnSupp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() == -1)
				{
					JOptionPane.showMessageDialog(eCont.getEntView(), "Veuillez selectioner un offre");
				}
				else
				eCont.suppOf(table.getSelectedRow());
			}
		});
		panelAct.add(btnSupp);
		
		JButton btnAjouter = new JButton("AJOUTER");
		panelAct.add(btnAjouter);
		btnAjouter.addActionListener(new  ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					eCont.ajouter();
			}
		});
		
		final JButton btnRecrt = new JButton("RECRUTER");
		btnRecrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//String status =(String)eCont.getOfModel().getValueAt(table.getSelectedRow(),2);
			if(table.getSelectedRow() == -1)
			{
				JOptionPane.showMessageDialog(eCont.getEntView(), "Veuillez selectioner un offre");
			}
		 /*  else  if( status == "Attente")
					{
				JOptionPane.showMessageDialog(eCont.getEntView(), "Cette Offre n'a pas été encore validé par l'Administrateur");
					}
			else if(status == "REFUSER")
			{
		JOptionPane.showMessageDialog(eCont.getEntView(), "Cette offre n'a pas était validé. Il sera supprimé dans 2 jours");
			}*/
			else
				eCont.recruter();
			}
		});
		panelAct.add(btnRecrt);
		
		JPanel panelListOf = new JPanel();
		contentPane.add(panelListOf, BorderLayout.WEST);
		table = new JTable(eCont.getOfModel());
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				OffreStage of = eCont.getOfModel().getListOf().get(table.getSelectedRow());
			    eCont.setOffreSelec(of);
			
			id.setText(String.valueOf(of.getIdOffreStage()));
			libele.setText(of.getLibelleOffre());
			domaine.setText(of.getDomaineOffre());
			descriptif.setText(of.getDescriptifOffre());
		    dateDebut.setText(of.getDateDebut());
		    duree.setText(of.getDureeOffre());
		    isValide.setText(String.valueOf(of.isValide()));
		    if(of.isValide()==0 | of.isValide()==2)
		    {
		    	btnRecrt.setEnabled(false);
		    	//btnEditer.setEnabled(false);
		    }
		    }
		});
		JScrollPane  js = new JScrollPane(table);
		//contentPane.add(js, BorderLayout.CENTER);
		panelListOf.add(js);
		
		JPanel panelDec = new JPanel();
		FlowLayout fl_panelDec = (FlowLayout) panelDec.getLayout();
		fl_panelDec.setAlignment(FlowLayout.LEFT);
		contentPane.add(panelDec, BorderLayout.SOUTH);
		JButton btnDeconnexion = new JButton("Deconnexion");
		panelDec.add(btnDeconnexion);
		btnDeconnexion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				eCont.deconnexion();
			}
		}); 
		setSize(1090,595);
		setResizable(false);
		setVisible(true); 
	}
	
}
