package mt.carmeloebejer.gamesims.utils;

import java.util.Random;

public class Die {
    private static final Random RANDOM = new Random();

    /**
     * Roll a die and get a random number between 1 and 6.
     * @return random number between 1 and 6
     */
    public int roll() {
        return RANDOM.nextInt(6) + 1;
    }

    /**
     * Guess the outcome of a die roll.
     * @param outcome number between 1 and 6
     * @return <code>true</code> when number is guessed, otherwise <code>false</code>
     */
    public boolean guess(int outcome) {
        return roll() == outcome;
    }
}