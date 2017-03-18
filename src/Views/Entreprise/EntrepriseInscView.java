package Views.Entreprise;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;

public class EntrepriseInscView extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	public EntrepriseInscView() {
		setVisible(true);
		getContentPane().setLayout(new GridLayout(9, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1);
		
		JLabel lblInscription = new JLabel("Inscription");
		panel_1.add(lblInscription);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		getContentPane().add(panel_2);
		
		JLabel lblNewLabel = new JLabel("Raison Sociale :");
		panel_2.add(lblNewLabel);
		
		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		getContentPane().add(panel_3);
		
		JLabel lblNewLabel_1 = new JLabel("Ville :");
		panel_3.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_4.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		getContentPane().add(panel_4);
		
		JLabel lblNewLabel_2 = new JLabel("Rue :");
		panel_4.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		panel_4.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_5.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		getContentPane().add(panel_5);
		
		JLabel lblNewLabel_3 = new JLabel("Code Postale :");
		panel_5.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		panel_5.add(textField_3);
		textField_3.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel_6.getLayout();
		flowLayout_5.setAlignment(FlowLayout.LEFT);
		getContentPane().add(panel_6);
		
		JLabel lblNewLabel_4 = new JLabel("");
		panel_6.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Mail :");
		panel_6.add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		panel_6.add(textField_4);
		textField_4.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_7.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		getContentPane().add(panel_7);
		
		JLabel lblNewLabel_6 = new JLabel("Telephone :");
		panel_7.add(lblNewLabel_6);
		
		textField_5 = new JTextField();
		panel_7.add(textField_5);
		textField_5.setColumns(10);
		
		JPanel panel_8 = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panel_8.getLayout();
		flowLayout_6.setAlignment(FlowLayout.LEFT);
		getContentPane().add(panel_8);
		
		JLabel lblNewLabel_7 = new JLabel("Secteur d'Activité");
		panel_8.add(lblNewLabel_7);
		
		textField_6 = new JTextField();
		panel_8.add(textField_6);
		textField_6.setColumns(10);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout_7 = (FlowLayout) panel.getLayout();
		getContentPane().add(panel);
		
		JButton btnValider = new JButton("VALIDER");
		panel.add(btnValider);
	}
	

}
