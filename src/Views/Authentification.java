package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controllers.AuthentificationController;

public class Authentification extends JFrame
{
	private JPanel container = new JPanel();
	private JTextField userName = new JTextField();
	private JPasswordField mdp = new JPasswordField();
	private JLabel label = new JLabel("Authentification");
	private JLabel labelNomU = new JLabel("Nom d'utilisateur");
	private JLabel labelMdp = new JLabel("Mot de passe");
	private JButton c = new JButton ("Connexion");
	
	//Instanciation de notre objet contrôleur
	private AuthentificationController controller;

	public Authentification(AuthentificationController authController)
	{
		this.controller = authController;
		
	    this.setTitle("Gestion Stage");
	    this.setSize(300, 200);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    
	    container.setBackground(Color.white);
	    container.setLayout(new BorderLayout());
	    
	    JPanel top = new JPanel();
	    top.add(label);
	    
	    JPanel center = new JPanel();
	    center.setLayout(new BorderLayout());
	    	JPanel ligneNomU = new JPanel();
	    	ligneNomU.add(labelNomU);
	    	ligneNomU.add(userName);
	    	JPanel ligneMdp = new JPanel();
	    	ligneMdp.add(labelMdp);
	    	ligneMdp.add(mdp);
	    center.add(ligneNomU, BorderLayout.NORTH);
	    center.add(ligneMdp, BorderLayout.SOUTH);
	    
	    JPanel south = new JPanel();
	    south.add(c);	    	
	    
	    Font police = new Font("Arial", Font.BOLD, 14);
	    label.setFont(police);
	    labelNomU.setFont(police);
	    userName.setPreferredSize(new Dimension(150, 30));
	    labelMdp.setFont(police);
	    mdp.setPreferredSize(new Dimension(150, 30));
	    //jtf.setForeground(Color.BLUE);
	    
	    c.addActionListener(new BoutonConnexionListener());
	    
	    container.add(top, BorderLayout.NORTH);
	    container.add(center, BorderLayout.CENTER);
	    container.add(south, BorderLayout.SOUTH);
	    
	    this.setContentPane(container);
	    this.setVisible(true);            
	}       

	class BoutonConnexionListener implements ActionListener
	{
	    public void actionPerformed(ActionEvent e)
	    {
	    	controller.setUserName(userName.getText());
	    	controller.setMdp(mdp.getText());
	    	
	    	controller.authentification();
	    }
	}
}
