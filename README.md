# Dice Games Simulations

This project implements two dice games:

1. **6-in-4**: Roll a die 4 times and win if you get 6 at least once
2. **double-6-in-24**: Roll two dice 24 times and win if you get double 6 at least once

In both games the bet is $1 and a win payout is $1. Both games are run 1M times and the mean, variance and standard deviation is calculated.

Tests are also included to validate the implementations of the die and both games.

## Build and Run

Maven and JDK 12 required

```mvn clean install exec:java```