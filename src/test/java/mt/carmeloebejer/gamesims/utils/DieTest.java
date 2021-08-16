package mt.carmeloebejer.gamesims.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DieTest {

    @Test
    void testDieRoll() {
        System.out.println("Testing die implementation");

        int simulations = 1000000;
        double error = 0.02;
        double avg = simulations / 6.0;
        double min = avg * (1 - error);
        double max = avg * (1 + error);

        Die die = new Die();
        int[] outcomes = new int[7];

        for (int i = 0; i < simulations; i++) {
            int outcome = die.roll();
            outcomes[outcome]++;
        }

        System.out.printf("simulations: %d\n", simulations);
        System.out.printf("expected minimum per number: %f\n", min);
        System.out.printf("expected maximum per number: %f\n", max);

        for (int i = 1; i < 7; i++) {
            System.out.printf("%d appeared %d times\n", i, outcomes[i]);
            assertTrue(outcomes[i] >= min && outcomes[i] <= max, "Outcome not within acceptable margin of error");
        }
    }
}