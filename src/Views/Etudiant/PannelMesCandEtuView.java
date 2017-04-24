package Views.Etudiant;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Controllers.EtudiantController;
import Models.CandModel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PannelMesCandEtuView extends JPanel {
    EtudiantController et;

	public EtudiantController getEt() {
		return et;
	}


	public void setEt(EtudiantController et) {
		this.et = et;
	}
	/**
	 * Create the panel.
	 */
	public PannelMesCandEtuView(EtudiantController etCon) {
		et=etCon;
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		JLabel lblMesCandidatures = new JLabel("MES CANDIDATURES");
		panel.add(lblMesCandidatures);
		
		JPanel panLisCand = new JPanel();
		add(panLisCand, BorderLayout.CENTER);
		
	    JTable table = new JTable(et.getEtCand());
		JScrollPane scrollPane = new JScrollPane(table);
		panLisCand.add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(1, 2, 0, 0));
		
		JButton btnCV = new JButton("Mettre mon CV", new ImageIcon("cv.jpeg"));
		panel_1.add(btnCV);
		btnCV.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
		      et.mettreCV();
				
			}
		});
		
		JButton btnDeconnexion = new JButton("Deconnexion");
		btnDeconnexion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				etCon.deconnexion();
			}
		});
		panel_1.add(btnDeconnexion);

	}

}
