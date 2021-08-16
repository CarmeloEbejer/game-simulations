package mt.carmeloebejer.gamesims.games;

import mt.carmeloebejer.gamesims.utils.Die;

public class DoubleSixInTwentyFour implements BettingGame {
    private static final Die die = new Die();
    public static final int ATTEMPTS = 24;
    public static final int WINNING_NUMBER = 6;

    public boolean play() {
        var win = false;
        for (int i = 0; i < ATTEMPTS; i++) {
            if (die.roll() == WINNING_NUMBER && die.roll() == WINNING_NUMBER) {
                win = true;
                break;
            }
        }
        return win;
    }
}
