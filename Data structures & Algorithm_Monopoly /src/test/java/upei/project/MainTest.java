package upei.project;
import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    @Test
    public void testArbitraryPlayerMovement() {
        // Create a random player
        Player player = new ArbitraryPlayer("Arbitrary Player", 1500);

        // Save the initial position
        int initialPosition = player.getPosition();

        // player plays
        player.play();

        // checks the conditions are met
        int newPosition = player.getPosition();
        assertTrue(newPosition >= 0 && newPosition < 40, "Player position should be within [0, 40)");
        assertNotEquals(initialPosition, newPosition, "Player should move to a different position");
    }

    @Test
    public void testBoldPlayerMovement() {
        // Create an aggressive player
        Player player = new BoldPlayer("Bold Player", 1500);

        // Save the initial position
        int initialPosition = player.getPosition();

        // Act
        player.play();

        // Assert
        int newPosition = player.getPosition();
        assertTrue(newPosition >= 0 && newPosition < 40, "Player position should be within [0, 40)");
        assertNotEquals(initialPosition, newPosition, "Player should move to a different position");
    }

    @Test
    public void testPrudentPlayerMovement() {
        // Create a cautious player
        Player player = new PrudentPlayer("Prudent Player", 1500);

        // Save the initial position
        int initialPosition = player.getPosition();

        // Act
        player.play();

        // Assert
        int newPosition = player.getPosition();
        assertTrue(newPosition >= 0 && newPosition < 40, "Player position should be within [0, 40)");
        assertNotEquals(initialPosition, newPosition, "Player should move to a different position");
    }


    @Test
    public void testMonopolyGame() {
        // Test the overall game logic
        Player player1 = new ArbitraryPlayer("ArbitraryPlayer", 1500);
        Player player2 = new BoldPlayer("BoldPlayer", 1500);
        Player player3 = new PrudentPlayer("PrudentPlayer", 1500);

        Player[] players = {player1, player2, player3};

        MonopolyGame game = new MonopolyGame(players);

        // Test that the playGame() method returns a non-null winner
        Player winner = game.playGame();
        assertNotNull(winner);

        // Test that the winner has a total wealth greater than or equal to the starting money
        assertTrue(winner.getTotalWealth() >= 1500);
    }
}


