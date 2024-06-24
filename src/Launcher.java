import UI.GamePanel;

import javax.swing.*;
import java.awt.*;

public class Launcher extends JFrame  {

	public Launcher() {
		initComponents();
	}

	// Initializing the main frame
	private void initComponents() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Lottozahlen Spiel");
		this.setSize(new Dimension(800, 600));
		this.add(new GamePanel());

	}

	private void initFrame() {
		this.setLocationRelativeTo(null); // shows in the center of the screen
	}

	public void showFrame() {
		initFrame();
		this.setVisible(true);
	}





	public static void main(String[] args) {
		Launcher lottozahlenSpiel = new Launcher();
		lottozahlenSpiel.showFrame();
	}
}
