package mt.carmeloebejer.gamesims.games;

import java.math.BigDecimal;

public interface BettingGame {

    /**
     * Play game once and bet money.
     * @param wager The bet amount
     * @return The amount that is won or lost (including the bet amount itself)
     */
    default BigDecimal bet(BigDecimal wager) {
        boolean win = play();
        if (win) {
            return wager;
        } else {
            return wager.negate();
        }
    }

    /**
     * Play the game once.
     * @return <code>true</code> if the game is won, <code>false</code> if the game is lost
     */
    boolean play();
}
