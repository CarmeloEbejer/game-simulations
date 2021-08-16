package mt.carmeloebejer.gamesims.games;

import org.junit.jupiter.api.Test;

class DoubleSixInTwentyFourTest {

    int simulations = 1000000;
    double wager = 1.0;
    double payOut = 1.0;
    double probabilityOfLosing = Math.pow(1 - (1/6.0 * 1/6.0), 24);
    double probabilityOfWinning = 1 - probabilityOfLosing;

    @Test
    void testGame() {
        SimulationTestingUtility.testSimulation(new DoubleSixInTwentyFour(), simulations, wager, payOut, probabilityOfWinning);
    }
}