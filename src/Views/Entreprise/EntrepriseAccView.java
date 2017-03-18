package Views.Entreprise;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class EntrepriseAccView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EntrepriseAccView frame = new EntrepriseAccView();
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
	public EntrepriseAccView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		JButton btnPropOf = new JButton("Proposer un offre de stage");
		btnPropOf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EntreprisePropOffreView().setVisible(true);
				
			}
		});
		panel_1.add(btnPropOf);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		
		JButton btnRecSt = new JButton("Recruter un stagiaire");
		btnRecSt.setVerticalAlignment(SwingConstants.TOP);
		btnRecSt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new EntrepriseInscView();
				
			}
		});
		panel_2.add(btnRecSt);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		JButton btnArDif = new JButton("Arreter la diffusion");
		panel.add(btnArDif);
	}

}
