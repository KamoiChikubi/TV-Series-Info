import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class HomeTab {

	private JLabel urlLabel;
	private JButton submitButton;
	private JTextField urlField;
	private JPanel homePanel;
	private GroupLayout gl_homePanel;
	private JTextArea results;
	private JScrollPane scroll;
	private ProcessResults process;
	
	public HomeTab() {
		
		urlField = new JTextField();
		homePanel = new JPanel();
		urlLabel = new JLabel("Enter IMDB url:");
		results = new JTextArea();
		scroll = new JScrollPane(results, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		submitButton = new JButton("Get Results");
		process = new ProcessResults(submitButton, urlField, results);
		gl_homePanel = new GroupLayout(homePanel);
		
	}
	
	public JPanel makeHomePageTab() {
		
		urlLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		
		results.setWrapStyleWord(true);
		results.setEditable(false);
		results.setVisible(true);
		
		submitButton.setContentAreaFilled(false);
		
		alignItemsHorizontal();
		alignItemsVertical();

		homePanel.setLayout(gl_homePanel);
		
		return homePanel;
		
	}
	
	public void alignItemsHorizontal() {
		
		gl_homePanel.setHorizontalGroup(
				gl_homePanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_homePanel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_homePanel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_homePanel.createSequentialGroup()
								.addComponent(urlLabel, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(urlField, GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
								.addGap(17)
								.addComponent(submitButton))
							.addComponent(scroll, GroupLayout.PREFERRED_SIZE, 535, GroupLayout.PREFERRED_SIZE))
						.addContainerGap())
			);
		
	}
	
	public void alignItemsVertical() {
		
		gl_homePanel.setVerticalGroup(
				gl_homePanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_homePanel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_homePanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(urlLabel)
							.addComponent(urlField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(submitButton))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scroll, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)
						.addGap(8))
			);
		
	}
}
