import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class mainUI extends JFrame {

	private JTabbedPane tabs;
	private SavedShowsTab savedShowsTab;
	private MenuBar menuBar;
	private HomeTab homeTab;

	public mainUI() {

		menuBar = new MenuBar();
		tabs = new JTabbedPane(JTabbedPane.TOP);
		homeTab = new HomeTab();
		savedShowsTab = new SavedShowsTab();

	}

	public void setupFrame() {

		setTitle("Pretty Useless Application");
		setSize(569, 419);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);

		add(menuBar.makeMenu(), BorderLayout.NORTH);
		add(tabs, BorderLayout.CENTER);

		tabs.addTab("Home", homeTab.makeHomePageTab());
		tabs.addTab("Saved Shows", savedShowsTab.makeSavedShowsTab());

	}

	public static void main(String[] args) {
		mainUI m = new mainUI();
		m.setupFrame();
	}

}
