package mt.carmeloebejer.gamesims.games;

import mt.carmeloebejer.gamesims.utils.SimulationUtility;

import java.math.BigDecimal;
import java.math.MathContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimulationTestingUtility {

    /**
     * Runs a game for a given number of times.
     * @param game The game to be simulated
     * @param simulations The number of times the game will be repeated
     * @param wager The amount wagered per game
     * @param payOut The amount paid out when a game is won (excluding wager amount)
     * @param probabilityOfWinning Probability of a win (value between 0 and 1)
     */
    static void testSimulation(BettingGame game, int simulations, BigDecimal wager, BigDecimal payOut, BigDecimal probabilityOfWinning) {
        BigDecimal negativeWager = wager.negate();
        BigDecimal probabilityOfLosing = BigDecimal.ONE.subtract(probabilityOfWinning);
        BigDecimal expectedMean = probabilityOfWinning.multiply(payOut).add(probabilityOfLosing.multiply(negativeWager));
        BigDecimal expectedVariance = probabilityOfWinning.multiply(payOut.subtract(expectedMean).pow(2)).add(probabilityOfLosing.multiply(negativeWager.subtract(expectedMean).pow(2)));
        BigDecimal expectedStd = expectedVariance.sqrt(MathContext.DECIMAL128);

        SimulationUtility.SimulationResult simulationResult = SimulationUtility.simulate(game, simulations, wager);

        System.out.println("Checking simulation results");
        System.out.printf("expected mean %s\nexpected variance %s\nexpected standard deviation %s\n", expectedMean, expectedVariance, expectedStd);

        BigDecimal error = BigDecimal.valueOf(0.002);
        assertEquals(expectedMean.subtract(simulationResult.getMean()).abs().compareTo(error), -1, "Mean not within margin of error");
        assertEquals(expectedVariance.subtract(simulationResult.getVariance()).abs().compareTo(error), -1, "Variance not within margin of error");
        assertEquals(expectedStd.subtract(simulationResult.getStandardDeviation()).abs().compareTo(error), -1, "Standard deviation not within margin of error");

        System.out.println("Simulation OK: mean, variance and standard deviation within margin of error");
    }

    static void testSimulation(BettingGame game, int simulations, double wager, double payOut, double probabilityOfWinning) {
        testSimulation(game, simulations, BigDecimal.valueOf(wager), BigDecimal.valueOf(payOut), BigDecimal.valueOf(probabilityOfWinning));
    }
}
