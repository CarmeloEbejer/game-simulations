package mt.carmeloebejer.gamesims.games;

import java.math.BigDecimal;

public interface BettingGame {

    default BigDecimal bet(BigDecimal wager) {
        boolean win = play();
        if (win) {
            return wager;
        } else {
            return wager.negate();
        }
    }

    boolean play();
}
