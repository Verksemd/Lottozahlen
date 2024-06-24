package Logic;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LottoTicket {
    // here we have game logic: drawing lotto ticket and performing the necessary actions
    public Set<Integer> winningNumbers = new HashSet<>();

    public LottoTicket() {

    }

    public void drawNumbers() {
        Random random = new Random();

        while (winningNumbers.size() < 6) {
            int number = random.nextInt(49) + 1;
            winningNumbers.add(number);
        }
    }

    public Set<Integer> getWinningNumbers() {
        return new HashSet<>(winningNumbers);
    }



}
