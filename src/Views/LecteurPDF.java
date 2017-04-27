package Views;

import java.awt.BorderLayout;
import java.io.FileInputStream;
import javax.swing.JFrame;
import javax.swing.JPanel;
import com.adobe.acrobat.Viewer;

public class LecteurPDF extends JFrame {
	
	 private Viewer viewer;
	    JPanel p = new JPanel();
	    public LecteurPDF(String nomfichier) throws Exception{
	        p.setLayout(new BorderLayout());
	 
	        //créer le viewer qui va servir à afficher le contenu du pdf
	        viewer = new Viewer();
	        p.add(viewer, BorderLayout.CENTER);
	        FileInputStream fis = new FileInputStream(nomfichier);
	        viewer.setDocumentInputStream(fis);
	        viewer.activate();
	        setSize(1024,768);
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        setVisible(true);
	        getContentPane().add(p);
	    }

}