package Views.Entreprise;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Models.Entreprise;
import Models.Etudiant;
import Models.DAO.EntrepriseDAO;

import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;

public class EntrepriseInscpView extends JFrame {

	private JPanel contentPane;
	private JTextField raisonSociale;
	private JTextField ville;
	private JTextField rue;
	private JTextField codePostale;
	private JTextField mail;
	private JTextField tel;
	private JTextField secteur;
	private  Entreprise ent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EntrepriseInscpView frame = new EntrepriseInscpView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EntrepriseInscpView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblInscription = new JLabel("Inscription");
		panel.add(lblInscription);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(7, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_1.add(panel_2);
		
		JLabel lblNewLabel = new JLabel("Raison Sociale :");
		panel_2.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		raisonSociale = new JTextField();
		panel_2.add(raisonSociale);
		raisonSociale.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_1.add(panel_3);
		
		JLabel lblNewLabel_1 = new JLabel("Ville :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		panel_3.add(lblNewLabel_1);
		
		ville = new JTextField();
		panel_3.add(ville);
		ville.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_4.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panel_1.add(panel_4);
		
		JLabel lblNewLabel_2 = new JLabel("Rue :");
		panel_4.add(lblNewLabel_2);
		
		rue = new JTextField();
		panel_4.add(rue);
		rue.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_5.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		panel_1.add(panel_5);
		
		JLabel lblNewLabel_3 = new JLabel("Code Postale");
		panel_5.add(lblNewLabel_3);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		
		codePostale = new JTextField();
		panel_5.add(codePostale);
		codePostale.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_6.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		panel_1.add(panel_6);
		
		JLabel lblNewLabel_4 = new JLabel("Mail :");
		panel_6.add(lblNewLabel_4);
		
		mail = new JTextField();
		panel_6.add(mail);
		mail.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panel_1.add(panel_7);
		FlowLayout flowLayout_5 = (FlowLayout) panel_7.getLayout();
		flowLayout_5.setAlignment(FlowLayout.LEFT);
		
		JLabel lblNewLabel_5 = new JLabel("Tel :");
		panel_7.add(lblNewLabel_5);
		
		tel = new JTextField();
		panel_7.add(tel);
		tel.setColumns(10);
		
		JPanel panel_8 = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panel_8.getLayout();
		flowLayout_6.setAlignment(FlowLayout.LEFT);
		panel_1.add(panel_8);
		
		JLabel lblNewLabel_6 = new JLabel("Secteur d'Activité :");
		panel_8.add(lblNewLabel_6);
		
		secteur = new JTextField();
		panel_8.add(secteur);
		secteur.setColumns(10);
		
		JPanel panel_9 = new JPanel();
		contentPane.add(panel_9, BorderLayout.SOUTH);
		
		JButton btnAnnuler = new JButton("Annuler");
		panel_9.add(btnAnnuler);
		
		JButton btnValider = new JButton("Valider");
		panel_9.add(btnValider);
		btnValider.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ent.setRaisonSociale(raisonSociale.getText());
				ent.setAdresseVilleEnt(ville.getText());
				ent.setAdresseRueEnt(rue.getText());
				//ent.setAdresseCodePostaleEnt(codePostale.getText());
				ent.setMail(mail.getText());
				ent.setTel(tel.getText());
				ent.setSecteurActivite(secteur.getText());
				
				new EntrepriseDAO().create(ent);
				
				// Retourner vers la fenetre de connex
			}
		});
	}

}
