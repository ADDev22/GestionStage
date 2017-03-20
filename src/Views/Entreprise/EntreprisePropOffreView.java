package Views.Entreprise;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class EntreprisePropOffreView extends JFrame {

	private JPanel contentPane;
	private JTextField libelele;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField dateDebut;
	private JTextField duree;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EntreprisePropOffreView frame = new EntreprisePropOffreView();
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
	public EntreprisePropOffreView() {
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
		
		textField_1 = new JTextField();
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel domaine = new JPanel();
		FlowLayout fl_domaine = (FlowLayout) domaine.getLayout();
		fl_domaine.setAlignment(FlowLayout.LEFT);
		contentPane.add(domaine);
		
		JLabel lblDescriptif = new JLabel("Descriptif :");
		domaine.add(lblDescriptif);
		
		textField_2 = new JTextField();
		domaine.add(textField_2);
		textField_2.setColumns(15);
		
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_5.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel_5);
		
		JLabel lblDateDeDebut = new JLabel("Date de debut :");
		panel_5.add(lblDateDeDebut);
		
		dateDebut = new JTextField();
		panel_5.add(dateDebut);
		dateDebut.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_6.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel_6);
		
		JLabel lblNewLabel_2 = new JLabel("Durée :");
		panel_6.add(lblNewLabel_2);
		
		duree = new JTextField();
		panel_6.add(duree);
		duree.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		contentPane.add(panel_7);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel.getLayout();
		contentPane.add(panel);
		
		JButton btnAnnuler = new JButton("Annuler");
		panel.add(btnAnnuler);
		
		JButton btnOk = new JButton("Valider");
		panel.add(btnOk);
	}

}
