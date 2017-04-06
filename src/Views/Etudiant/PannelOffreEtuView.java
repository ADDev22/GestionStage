package Views.Etudiant;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Models.OffreEtuModel;
import Models.OffreStage;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextArea;
import javax.swing.JTextPane;

import Controllers.EtudiantController;

public class PannelOffreEtuView extends JPanel {
	private OffreEtuModel ofModel;
	private OffreStage ofSelect;
	EtudiantController et;

	public EtudiantController getEt() {
		return et;
	}


	public void setEt(EtudiantController et) {
		this.et = et;
	}


	public OffreEtuModel getOfModel() {
		return ofModel;
	}


	public OffreStage getOfSelect() {
		return ofSelect;
	}


	public void setOfModel(OffreEtuModel ofModel) {
		this.ofModel = ofModel;
	}


	public void setOfSelect(OffreStage ofSelect) {
		this.ofSelect = ofSelect;
	}


	/**
	 * Create the panel.
	 */
	public PannelOffreEtuView(EtudiantController etuCont) {
		et=etuCont;
		ofModel = et.getOfModel();
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		JLabel lblDomaine = new JLabel("Domaine :");
		panel.add(lblDomaine);
		
		final JComboBox <String>comboBox = new JComboBox<String>();
		        comboBox.setSelectedItem("INFORMATIQUE");
		panel.add(comboBox);
		
		JButton btnRecherche = new JButton("Recherche");
		panel.add(btnRecherche);
		btnRecherche.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				et.recherche((String)comboBox.getSelectedItem());
				
			}
		});
		
		JPanel panelCenter = new JPanel();
		add(panelCenter, BorderLayout.CENTER);
		 
		final JTable table =  new JTable(ofModel);
		JScrollPane scrollPane = new JScrollPane(table);
		panelCenter.add(scrollPane);
		
		JPanel panelEst = new JPanel();
		add(panelEst, BorderLayout.EAST);
		panelEst.setLayout(new GridLayout(0, 1, 0, 1));
		
		JPanel panDesc = new JPanel();
		panelEst.add(panDesc);
		final JLabel desc = new JLabel();
		panDesc.setLayout(new GridLayout(1, 1, 0, 0));
		JScrollPane scrollPane_1 = new JScrollPane(desc);
		panDesc.add(scrollPane_1);
	
		
		JPanel panVis = new JPanel();
		panelEst.add(panVis);
		panVis.setLayout(new GridLayout(2, 1, 0, 0));
		
		JButton btnoffre = new JButton("Visualiser Offre");
		btnoffre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(table.getSelectedRow() == -1)
				{
					JOptionPane.showMessageDialog(et.getEtView(), "Veuillez selectioner un offre");
				}
				else
					et.visualiser(ofSelect);
				
			}
		});
		panVis.add(btnoffre);
		
		JButton btnPostule = new JButton("Postuler");
		panVis.add(btnPostule);
		btnPostule.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() == -1)
				{
					JOptionPane.showMessageDialog(et.getEtView(), "Veuillez selectioner un offre");
				}
				else
		        et.postuler(ofSelect);
				
			}
		});
		JPanel panelSud = new JPanel();
		add(panelSud, BorderLayout.SOUTH);
		
		JButton btnDecon = new JButton("Deconnexion");
		panelSud.add(btnDecon);
		
		// Evt
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				ofSelect =ofModel.getListOf().get(table.getSelectedRow());
			desc.setText(ofSelect.getDescriptifOffre());
			}
		});
		btnRecherche.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
			}
		} );

	}

}
