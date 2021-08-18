package mt.carmeloebejer.gamesims.utils;

import mt.carmeloebejer.gamesims.games.BettingGame;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;

public class SimulationUtility {

    private SimulationUtility() {
    }

    /**
     * Runs a game for a given number of times.
     * @param game The game to be simulated
     * @param simulations The number of times the game will be repeated
     * @param wager The amount wagered per game
     */
    public static SimulationResult simulate(BettingGame game, int simulations, BigDecimal wager) {
        System.out.printf("Starting simulation of game: %s%n", game.getClass().getSimpleName());

        BigDecimal[] winnings = new BigDecimal[simulations];
        BigDecimal startingBalance = BigDecimal.ZERO;
        BigDecimal balance = startingBalance;
        int wins = 0;

        // calculate mean
        for (int i = 0; i < simulations; i++) {
            BigDecimal winning = game.bet(wager);
            if (winning.compareTo(BigDecimal.ZERO) > 0) {
                wins++;
            }
            balance = balance.add(winning);
            winnings[i] = winning;
        }
        BigDecimal mean = balance.divide(BigDecimal.valueOf(simulations));

        // calculate variance
        BigDecimal variance = Arrays.stream(winnings).reduce(BigDecimal.ZERO, (subtotal, element) -> subtotal.add(element.subtract(mean).pow(2))).divide(BigDecimal.valueOf(simulations));

        BigDecimal std = variance.sqrt(MathContext.DECIMAL128);

        System.out.printf("simulations: %s%n", simulations);
        System.out.printf("wins: %s%n", wins);
        int losses = simulations - wins;
        System.out.printf("losses: %s%n", losses);
        System.out.printf("starting balance: %s%n", startingBalance);
        System.out.printf("final balance: %s%n", balance);
        System.out.printf("mean: %s%n", mean);
        System.out.printf("variance: %s%n", variance);
        System.out.printf("standard deviation: %s%n", std);
        System.out.println();

        return new SimulationResult(winnings, mean, variance);
    }

    public static class SimulationResult {
        private BigDecimal[] winnings;
        private BigDecimal mean;
        private BigDecimal variance;

        public SimulationResult(BigDecimal[] winnings, BigDecimal mean, BigDecimal variance) {
            this.winnings = winnings;
            this.mean = mean;
            this.variance = variance;
        }

        public BigDecimal[] getWinnings() {
            return winnings;
        }

        public BigDecimal getMean() {
            return mean;
        }

        public BigDecimal getVariance() {
            return variance;
        }

        public BigDecimal getStandardDeviation() {
            return variance.sqrt(MathContext.DECIMAL128);
        }
    }
}
