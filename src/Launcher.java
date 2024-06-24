import Logic.LottoTicket;
import UI.LottoPane;

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
		this.add(new LottoPane());

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
