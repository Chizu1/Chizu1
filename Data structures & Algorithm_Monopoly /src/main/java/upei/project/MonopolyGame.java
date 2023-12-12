package upei.project;

import java.util.ArrayList;
import java.util.List;

/// Class representing a Monopoly game simulation
public class MonopolyGame {
    private Player[] players;

    // Constructor to initialize the game with an array of players
    public MonopolyGame(Player[] players) {
        this.players = players;
    }

    // Simulate and play a Monopoly game for a fixed number of turns
    public Player playGame() {
        int gameRounds = 1;

        // Loop through each turn in the game
        for (int turn = 1; turn <= gameRounds; turn++) {
            // Each player takes a turn
            for (Player player : players) {
                player.play();
                System.out.println(player.getName() + " - Money: " + player.getTotalWealth());
            }

            System.out.println();  // Separate turns for clarity
        }

        // Determine the winner or if it's a tie
        return determineWinner();
    }

    // Determine the winner or if it's a tie
    private Player determineWinner() {
        List<Player> winners = new ArrayList<>();
        int maxWealth = 0;

        // Iterate through players to find the one with the highest wealth
        for (Player player : players) {
            if (player.getTotalWealth() > maxWealth) {
                maxWealth = player.getTotalWealth();
                winners.clear();
                winners.add(player);
            } else if (player.getTotalWealth() == maxWealth) {
                winners.add(player);
            }
        }

        // Return the winner or null if it's a tie
        return (winners.size() == 1) ? winners.get(0) : null;
    }

    // Main method for testing the Monopoly game
    public static void main(String[] args) {
        // Create three players with different strategies
        Player player1 = new ArbitraryPlayer("Arbitrary Player", 1500);
        Player player2 = new BoldPlayer("Bold Player", 1500);
        Player player3 = new PrudentPlayer("Prudent Player", 1500);
        Player[] players = {player1, player2, player3};

        // Create and run a Monopoly game with the specified players
        MonopolyGame game = new MonopolyGame(players);
        Player winner = game.playGame();

        // Display the winner or indicate a tie
        if (winner != null) {
            System.out.println("Winner: " + winner.getName() + " with total wealth " + winner.getTotalWealth());
        } else {
            System.out.println("It's a tie! No winner.");
        }
    }
}
