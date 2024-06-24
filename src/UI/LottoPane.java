package UI;

import Logic.LottoTicket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;;

// Uses ticket pane. Uses Result pane. Creates reset pane.
public class LottoPane extends Container implements ActionListener {
    private Font gameFont = new Font("Arial", Font.PLAIN, 18);
    private JTextArea lottoResultsArea = new JTextArea();
    private TicketPane ticketPane;
    private LottoTicket ticket;


    public LottoPane() {
        setLayout(new GridBagLayout());
        this.addTicketPane();
        this.addRestartButton();

    }

    private void addTicketPane() {
        ticket = new LottoTicket();
        ticket.drawNumbers();
        this.ticketPane = new TicketPane(ticket);
        this.add(this.ticketPane);

    }

    private void addRestartButton() {
        // Adding "repeat" button
        JButton repeatButton = new JButton("Restart game");
        repeatButton.setFont(this.gameFont);
        repeatButton.addActionListener(this);
        this.add(repeatButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ticketPane.reset();
        ticket.drawNumbers();
    }
}
