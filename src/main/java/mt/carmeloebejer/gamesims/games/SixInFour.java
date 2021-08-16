package mt.carmeloebejer.gamesims.games;

import mt.carmeloebejer.gamesims.utils.Die;

public class SixInFour implements BettingGame {
    private static final int ATTEMPTS = 4;
    private static final int WINNING_NUMBER = 6;
    private static final Die die = new Die();

    public boolean play() {
        boolean win = false;
        for (int i = 0; i < ATTEMPTS; i++) {
            if (die.roll() == WINNING_NUMBER) {
                win = true;
                break;
            }
        }
        return win;
    }
}