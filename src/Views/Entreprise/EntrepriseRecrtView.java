package Views.Entreprise;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.sun.media.jfxmedia.events.NewFrameEvent;

import Controllers.EntrepriseController;
import Models.EtuPostStage;
import Models.Etudiant;
import Models.OffreStage;
import Models.DAO.EtuPostStageDAO;

public class EntrepriseRecrtView extends JFrame {

	private JPanel contentPane;
	private EntrepriseController eCont;
	private JTable table;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EntrepriseRecrtView frame = new EntrepriseRecrtView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public EntrepriseRecrtView(EntrepriseController e) {
		this.setName("RECRUTEMENT");
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.eCont = e;
		eCont.setEtView(this);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelDetails = new JPanel();
		contentPane.add(panelDetails, BorderLayout.CENTER);
		panelDetails.setLayout(new GridLayout(11, 1, 0, 0));
		
		JLabel lblDetailsOffre = new JLabel("Details Of Etudiant");
		panelDetails.add(lblDetailsOffre);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setHgap(10);
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelDetails.add(panel);
		
		JLabel lblRfrence = new JLabel("Référence:");
		lblRfrence.setHorizontalAlignment(SwingConstants.TRAILING);
		panel.add(lblRfrence);
		
		final JLabel id = new JLabel("");
		panel.add(id);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setHgap(10);
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panelDetails.add(panel_1);
		
		JLabel lbl = new JLabel("Nom:");
		panel_1.add(lbl);
		
		final JLabel lbNom = new JLabel("");
		panel_1.add(lbNom);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
		flowLayout_2.setHgap(10);
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panelDetails.add(panel_2);
		
		JLabel lblNewLabel = new JLabel("Prenom:");
		panel_2.add(lblNewLabel);
		
		final JLabel lbPren = new JLabel("");
		panel_2.add(lbPren);
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_4.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		panelDetails.add(panel_4);
		
		JLabel lbll = new JLabel("Domaine:");
		panel_4.add(lbll);
		
		JLabel lbDomaine = new JLabel("");
		panel_4.add(lbDomaine);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_3.getLayout();
		flowLayout_4.setHgap(10);
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		panelDetails.add(panel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Niveau:");
		panel_3.add(lblNewLabel_4);
		
		final JLabel lbNiv = new JLabel("");
		panel_3.add(lbNiv);
		
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel_5.getLayout();
		flowLayout_5.setHgap(10);
		flowLayout_5.setAlignment(FlowLayout.LEFT);
		panelDetails.add(panel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Mail:");
		panel_5.add(lblNewLabel_6);
		
		final JLabel lbMail = new JLabel("");
		panel_5.add(lbMail);
		
		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panel_6.getLayout();
		flowLayout_6.setHgap(10);
		flowLayout_6.setAlignment(FlowLayout.LEFT);
		panelDetails.add(panel_6);
		
		JLabel lblNewLabel_8 = new JLabel("Tel:");
		panel_6.add(lblNewLabel_8);
		
		final JLabel lbTel = new JLabel("");
		panel_6.add(lbTel);
		
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout_7 = (FlowLayout) panel_7.getLayout();
		flowLayout_7.setHgap(10);
		flowLayout_7.setAlignment(FlowLayout.LEFT);
		panelDetails.add(panel_7);
		
		JLabel lblNewLabel_1 = new JLabel("Details Complet:");
		panel_7.add(lblNewLabel_1);
		
		JPanel panelRech = new JPanel();
		contentPane.add(panelRech, BorderLayout.NORTH);
		
		final JLabel lblDomaine = new JLabel("Niveau :");
		panelRech.add(lblDomaine);
		
		final JComboBox<String> comboBox = new JComboBox<String>();
		         comboBox.addItem("BAC+1");
		         comboBox.addItem("BAC+2");
		         comboBox.addItem("BAC+3");
		         comboBox.addItem("BAC+4");
		         comboBox.addItem("BAC+5");
		panelRech.add(comboBox);
		
		JButton btnRecherche = new JButton("Recherche");
		btnRecherche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eCont.rechercheEt((String)comboBox.getSelectedItem());
			}
		});
		panelRech.add(btnRecherche);
		
		JPanel panelAct = new JPanel();
		contentPane.add(panelAct, BorderLayout.EAST);
		panelAct.setLayout(new GridLayout(4, 1, 0, 0));
		
		JButton btnCV = new JButton("CV");
		panelAct.add(btnCV);
		btnCV.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()==-1)
				{
					JOptionPane.showMessageDialog(eCont.getEntView(), "Selectionner un etudiant");
				}
				else
				{
					eCont.voirCV(eCont.geteTModel().getListEt().get(table.getSelectedRow()).getCv());
				}
				
			}
		});
		
		JButton btnRecruter = new JButton("RECRUTER");
		btnRecruter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()==-1)
				{
					JOptionPane.showMessageDialog(eCont.getEntView(), "Selectionner un etudiant");
				}
				else
				{
	EtuPostStage can = new EtuPostStageDAO().findWithOfEt(eCont.getOffreSelec().getIdOffreStage(), eCont.geteTModel().getListEt().get(table.getSelectedRow()).getIdEtudiant());
	           can.setIsAccept(1);             
	new EtuPostStageDAO().update(can);			   
	eCont.suppEt(table.getSelectedRow());
				}
			}
		});
		panelAct.add(btnRecruter);
		
		JButton btnAjouter = new JButton("DECLINER");
		panelAct.add(btnAjouter);
		btnAjouter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) { // refuser l'offre
				if(table.getSelectedRow()==-1)
				{
					//Apeel de pop pup
				}
				else
				{
					EtuPostStage can = new EtuPostStageDAO().findWithOfEt(eCont.getOffreSelec().getIdOffreStage(), 
							eCont.geteTModel().getListEt().get(table.getSelectedRow()).getIdEtudiant());
		           can.setIsAccept(2);             
		       new EtuPostStageDAO().update(can);	
					eCont.suppEt(table.getSelectedRow());
			    }
				
			}
		});
		
		JButton btnRecrt = new JButton("EN ATTENTE");
		panelAct.add(btnRecrt);
		btnRecrt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(table.getSelectedRow()==-1)
				{
					//Apeel de pop pup
				}	
				else
				{
						
				}
			}
		});
		
		JPanel panelListOf = new JPanel();
		contentPane.add(panelListOf, BorderLayout.WEST);
		table = new JTable(eCont.geteTModel());
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				Etudiant et =new Etudiant();
				et=eCont.geteTModel().getListEt().get(table.getSelectedRow());
			
			id.setText(String.valueOf(et.getIdEtudiant()));
			lbNom.setText(et.getNom());
			lbPren.setText(et.getPrenom());
			lblDomaine.setText(et.getDomEtude());
		    lbNiv.setText(et.getNivEtude());
		    lbMail.setText(et.getMail());
		    lbTel.setText(et.getTel());	
		    
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
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eCont.geteTModel().getListEt().clear();
				eCont.geteTModel().removeRowAll();
				eCont.getEntView().setVisible(true);
				eCont.getEtView().dispose();
			   
				
			}
		});
		panelDec.add(btnRetour);
		
		btnDeconnexion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
	       // rediriger vers connex		
			}
		} );
	
		setSize(1090,595);
		setResizable(false);
		setVisible(true); 
	}

}
