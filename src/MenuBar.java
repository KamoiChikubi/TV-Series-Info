import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MenuBar implements ActionListener {
	private JMenuBar menuBar;
	private JMenu fileMenu, aboutMenu;
	private JButton exitButton, versionButton;
	
	public MenuBar() {
		
		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		aboutMenu = new JMenu("About");
		exitButton = new JButton("Exit");
		versionButton = new JButton("Version");
		
	}
	
	public JMenuBar makeMenu() {
		
		fileMenu.add(exitButton);
		aboutMenu.add(versionButton);
		
		menuBar.add(fileMenu);
		menuBar.add(aboutMenu);
		
		exitButton.addActionListener(this);
		versionButton.addActionListener(this);
		
		return menuBar;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == exitButton) {
			System.exit(0);
		}
		
		if(e.getSource() == versionButton) {
			JOptionPane.showMessageDialog(new JPanel(), "Pretty Boring Application v.0.2", "Version", JOptionPane.PLAIN_MESSAGE);
		}
		
	}
}
