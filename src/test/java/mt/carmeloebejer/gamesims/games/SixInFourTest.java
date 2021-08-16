package mt.carmeloebejer.gamesims.games;

import org.junit.jupiter.api.Test;

class SixInFourTest {

    int simulations = 1000000;
    double wager = 1.0;
    double payOut = 1.0;
    double probabilityOfLosing = Math.pow(5/6.0, 4);
    double probabilityOfWinning = 1 - probabilityOfLosing;

    @Test
    void testGame() {
        SimulationTestingUtility.testSimulation(new SixInFour(), simulations, wager, payOut, probabilityOfWinning);
    }
}