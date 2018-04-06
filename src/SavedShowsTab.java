import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class SavedShowsTab {

	private JTextArea results_savedShows;
	private JScrollPane scroll_savedShows;
	private JComboBox<Object> showsList;
	private GroupLayout gl_savedShowsTab;
	private JPanel panel;
	private ProcessResults process;
	
	public SavedShowsTab() {
		
		panel = new JPanel();
		gl_savedShowsTab = new GroupLayout(panel);
		showsList = new JComboBox<Object>();
		results_savedShows = new JTextArea();
		scroll_savedShows = new JScrollPane(results_savedShows, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		process = new ProcessResults(showsList, results_savedShows);
		
	}
	
	public JPanel makeSavedShowsTab() {
		
		results_savedShows.setWrapStyleWord(true);
		results_savedShows.setEditable(false);
		results_savedShows.setVisible(true);
		
		alignItemsHorizontal();
		alignItemsVertical();
		
		process.populateChoices();
		
		panel.setLayout(gl_savedShowsTab);
		
		return panel;
		
	}

	public void alignItemsHorizontal() {
		
		gl_savedShowsTab.setHorizontalGroup(
				gl_savedShowsTab.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_savedShowsTab.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_savedShowsTab.createParallelGroup(Alignment.LEADING)
							.addGroup(Alignment.TRAILING, gl_savedShowsTab.createSequentialGroup()
								.addComponent(showsList, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
								.addGap(141))
							.addGroup(gl_savedShowsTab.createSequentialGroup()
									.addComponent(scroll_savedShows, GroupLayout.PREFERRED_SIZE, 535, GroupLayout.PREFERRED_SIZE))
							))
			);
		
	}
	
	public void alignItemsVertical() {
		
		gl_savedShowsTab.setVerticalGroup(
				gl_savedShowsTab.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_savedShowsTab.createSequentialGroup()
						.addContainerGap()
						.addComponent(showsList, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scroll_savedShows, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
		
	}

}
