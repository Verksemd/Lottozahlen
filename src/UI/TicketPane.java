package UI;

import Logic.LottoTicket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// done accept in constructor 6 winning numbers(name them winningNumbers)
// done allow only 6 numbers to be selected in lotto field (buttons)
// done once 6 numbers selected, go over grid and if selected number is among winning, color it green, otherwise red.
public class TicketPane extends Container implements ActionListener {
    private ArrayList<Integer> guesses = new ArrayList<>();
    private LottoTicket ticket;

    public TicketPane(LottoTicket ticket) {
        this.ticket = ticket;
        setLayout(new GridLayout(7, 7));
        int number = 1;
        for (int row = 1; row <= 7; row++) {
            for (int column = 1; column <= 7; column++) {
                JButton numberButton = new JButton("" + (number));
                numberButton.addActionListener(this);
                numberButton.setFont(new Font("Arial", Font.PLAIN, 14));
                numberButton.putClientProperty("number", number);
                buttonDesign(numberButton);
                add(numberButton);
                number++;
            }
        }
    }
    private void buttonDesign(JButton button) {
        button.setFocusable(false);
        button.setBackground(Color.WHITE);
        button.setForeground(Color.BLACK);
        button.setOpaque(true);
        button.setBorderPainted(true);
        button.setEnabled(true);
    }
    public void reset() {
        guesses.clear();
        for (Component component : this.getComponents()) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                buttonDesign(button);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton buttonNumber = (JButton) e.getSource();
        if (guesses.size() == 6) {
            return;
        }
        buttonNumber.setBorderPainted(false);
        buttonNumber.setOpaque(true);
        buttonNumber.setBackground(Color.YELLOW);
        buttonNumber.setForeground(Color.BLACK);
        buttonNumber.setOpaque(true);
        buttonNumber.setBorderPainted(true);
        int number = Integer.parseInt(buttonNumber.getText());
        guesses.add(number);
        buttonNumber.setEnabled(false);

        if (guesses.size() == 6) {
            highlightWinningNumbers();
        }

    }

    private void highlightWinningNumbers() {
        for (Component component : this.getComponents()) {
            if (component instanceof JButton button) {
                Integer value = (Integer) button.getClientProperty("number");
                if (ticket.winningNumbers.contains(value)) {
                    if (guesses.contains(value)) {
                        button.setBackground(Color.GREEN);
                    } else {
                        button.setBackground(Color.RED);
                    }
                    button.setForeground(Color.WHITE);
                    button.setOpaque(true);
                    button.setBorderPainted(false);
                }
            }
        }
    }

}
