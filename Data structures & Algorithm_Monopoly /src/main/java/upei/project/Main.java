package upei.project;

import java.util.ArrayList;
import java.util.List;

// Main class for running a Monopoly game experiment
public class Main {

    public static void main(String[] args) {
        // Create a list of players with different strategies
        List<Player> players = new ArrayList<>();
        players.add(new ArbitraryPlayer("ArbitraryPlayer", 1500)); // Player with arbitrary/random strategy
        players.add(new BoldPlayer("BoldPlayer", 1500));          // Player with bold/aggressive strategy
        players.add(new PrudentPlayer("PrudentPlayer", 1500));    // Player with prudent/cautious strategy

        runExperiment(players);  // Run the experiment with the specified players and number of trials
    }

    private static void runExperiment(List<Player> players) {
        // Array to keep track of how many times each player wins
        int[] winCount = new int[players.size()];

        // Loop through the specified number of trials
        for (int trial = 1; trial <= 60; trial++) {
            System.out.println("Trial " + trial);

            // Create a new Monopoly game with the shuffled players
            MonopolyGame game = new MonopolyGame(players.toArray(new Player[0]));

            // Determine the winner
            Player winner = game.playGame();

            // Update the win count based on the winner
            for (int i = 0; i < players.size(); i++) {
                if (players.get(i) == winner) {
                    winCount[i]++;
                }
            }
        }

        // Print results of the experiment
        System.out.println("\nExperiment Results:");

        // Display the number of wins for each player
        for (int i = 0; i < players.size(); i++) {
            System.out.println(players.get(i).getName() + " - Wins: " + winCount[i]);
        }
    }
}
