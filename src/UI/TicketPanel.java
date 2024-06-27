package UI;

import Logic.LottoTicket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TicketPanel extends Container implements ActionListener {
    private ArrayList<Integer> guesses = new ArrayList<>();
    private LottoTicket ticket;

    public TicketPanel(LottoTicket ticket) {
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
            onGameEnd();
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

    private void onGameEnd() {
        highlightWinningNumbers();
        int value;
        int matches = 0;
        for (Integer guess : guesses) {
            value = guess;
            if (ticket.winningNumbers.contains(value)) {
                matches++;
            }
        }

        String prize;
        switch (matches) {
            case 1:
                prize = "1 Dog \uD83D\uDC15";
                break;
            case 2:
                prize = "2 Dogs \uD83D\uDC15 \uD83D\uDC15";
                break;
            case 3:
                prize = "3 Dogs \uD83D\uDC15 \uD83D\uDC15 \uD83D\uDC15";
                break;
            case 4:
                prize = "4 Dogs \uD83D\uDC15 \uD83D\uDC15 \uD83D\uDC15 \uD83D\uDC15";
                break;
            case 5:
                prize = "5 Dogs \uD83D\uDC15 \uD83D\uDC15 \uD83D\uDC15 \uD83D\uDC15 \uD83D\uDC15";
                break;
            case 6:
                prize = "6 Dogs \uD83D\uDC15 \uD83D\uDC15 \uD83D\uDC15 \uD83D\uDC15 \uD83D\uDC15 \uD83D\uDC15";
                break;
            default:
                prize = "no dog for you \uD83D\uDC4E";
                break;
        }
        ImageIcon icon = new ImageIcon("resources/prizeDog.png");
        JOptionPane.showMessageDialog(this, "You've got " + prize, "YOUR PRIZE", JOptionPane.INFORMATION_MESSAGE, icon);
    }
}
