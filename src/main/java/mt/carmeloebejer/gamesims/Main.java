package mt.carmeloebejer.gamesims;

import mt.carmeloebejer.gamesims.games.DoubleSixInTwentyFour;
import mt.carmeloebejer.gamesims.games.SixInFour;
import mt.carmeloebejer.gamesims.utils.SimulationUtility;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        System.out.println("Dice Games Simulations\n");

        int simulations = 1000000;
        BigDecimal wager = BigDecimal.ONE;

        SimulationUtility.simulate(new SixInFour(), simulations, wager);
        SimulationUtility.simulate(new DoubleSixInTwentyFour(), simulations, wager);
    }
}
