import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ProcessResults implements ActionListener {

	private WebsiteData webData;
	private LocalURLData localData;
	private JTextArea globalTextArea;
	private JButton globalButton;
	private JComboBox<Object> globalComboBox;
	private JTextField globalTextField;

	public ProcessResults() {
		
		webData = new WebsiteData();
		localData = new LocalURLData();
		
	}

	public ProcessResults(JButton button, JTextField textField, JTextArea textArea) {
		
		globalButton = button;
		globalTextField = textField;
		globalTextArea = textArea;
		globalButton.addActionListener(this);
		webData = new WebsiteData();
		localData = new LocalURLData();
		
	}

	public ProcessResults(JComboBox<Object> box, JTextArea textArea) {
		
		globalComboBox = box;
		globalTextArea = textArea;
		webData = new WebsiteData();
		localData = new LocalURLData();
		
	}

	public void populateChoices() {

		for (int i = 0; i < localData.getResult().size(); i++) {
			globalComboBox.addItem(localData.getTitle()[i]);
		}
		globalComboBox.addActionListener(this);
		
	}

	public void displayResults(String url, JTextArea area) {
		
		int num = 1;
		webData.getDates().clear();
		webData.getEpisodeTitle().clear();
		// This breaks if invalid URL is given. Needs fixing. Add URL checking.
		webData.setup(url);
		String result = "";

		for (int i = 0; i < webData.getDates().size(); i++) {
			result += "Episode " + num++ + ": " + webData.getEpisodeTitle().get(i) + "\n" + "Air date: "
					+ webData.getDates().get(i) + "\n\n";
		}
		area.setText(result);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == globalComboBox) {
			displayResults(localData.getLink(globalComboBox.getSelectedItem()), globalTextArea);
		}

		if (e.getSource() == globalButton && !globalTextField.getText().equals("")) {

			displayResults(globalTextField.getText(), globalTextArea);
			localData.writeToFile(webData.getShowTitle() + " _-_ " + globalTextField.getText());

		} else if (e.getSource() == globalButton && !globalTextField.getText().equals("")) {
			globalTextArea.setText("Please enter a valid URL!");
		}

	}

}
