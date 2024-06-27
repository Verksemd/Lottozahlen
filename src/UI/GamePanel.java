package UI;

import Logic.LottoTicket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;;

// Uses ticket pane. Uses Result pane. Creates reset pane.
public class GamePanel extends Container implements ActionListener {
    private Font gameFont = new Font("Arial", Font.PLAIN, 18);
    private TicketPanel ticketPanel;
    private LottoTicket ticket;

    public GamePanel() {
        setLayout(new GridBagLayout());
        this.addTicketPane();
        this.addRestartButton();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ticketPanel.reset();
        ticket.drawNumbers();
    }

    private void addTicketPane() {
        ticket = new LottoTicket();
        ticket.drawNumbers();
        this.ticketPanel = new TicketPanel(ticket);
        this.add(this.ticketPanel);

    }

    private void addRestartButton() {
        // Adding "repeat" button
        JButton repeatButton = new JButton("Restart game");
        repeatButton.setFont(this.gameFont);
        repeatButton.addActionListener(this);
        this.add(repeatButton);
    }
}
