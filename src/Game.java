import Logic.LottoTicket;
import UI.LottoPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;

public class Game extends JFrame  {
// here we have GUI elements
	private JLabel lottoResultsFieldLabel;
	private JTextArea lottoResultsArea;
	private JButton repeatButton;
	private ArrayList<Integer> guesses = new ArrayList<>();
	private Font gameFont;
	private Set<Integer> winningNumbers;
	private LottoTicket ticket = new LottoTicket();

	private JButton numberButton;

	public Game() {
		initComponents();
		ticket.drawNumbers();
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
		Game lottozahlenSpiel = new Game();
		lottozahlenSpiel.showFrame();
	}
}
