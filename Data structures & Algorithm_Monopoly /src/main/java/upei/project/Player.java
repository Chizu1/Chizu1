package upei.project;
import java.util.Random;

// Player: Represents a participant in a Monopoly game
public class Player {
    private final String name;
    private int cash;
    private int position;
    private int Wealth;

    // Constructor: Initializes the player with a name and starting money
    public Player(String name, int cash) {
        this.name = name;
        this.cash = cash;
        this.position = 0; // Starting position
        this.Wealth = cash;
    }

    // Getter method: Retrieves the player's name
    public String getName() {
        return name;
    }

    // Getter method: Retrieves the player's current money
    public int getCash() {
        return cash;
    }

    // Getter method: Retrieves the player's total wealth (including properties)
    public int getTotalWealth() {
        return Wealth;
    }

    // Moves the player on the board by a specified number of steps
    public void move(int steps) {
        position = (position + steps) % 40; // Modulo 40 to simulate the circular board
    }

    // Adds money to the player's balance and updates total wealth
    public void addMoney(int amount) {
        cash += amount;
        Wealth += amount;
    }

    // Adds the value of a property to the player's total wealth
    public void addProperty(Property property) {
        Wealth += property.getValue();
    }

    // Placeholder for the play strategy, to be implemented in subclasses
    public void play() {
        // To be overridden by subclasses
    }

    // Getter method: Retrieves the player's current position on the board
    public int getPosition() {
        return position;
    }
}

// ArbitraryPlayer: Represents a player with a random strategy
class ArbitraryPlayer extends Player {
    private final Random random;

    // Constructor: Initializes an ArbitraryPlayer with a name and starting money
    public ArbitraryPlayer(String name, int money) {
        super(name, money);
        this.random = new Random();
    }

    // Override play method: Implements the random play strategy
    @Override
    public void play() {
        int steps = random.nextInt(6) + 1; // Roll a six-sided die
        move(steps);

        // 50% chance of buying a property when landing on a new space
        if (random.nextBoolean()) {
            Property property = new Property("Arbitrary's Property", random.nextInt(50));
            addProperty(property);
        }

        // Deducts $1500 if the total wealth reaches $1500
        if (getTotalWealth() == 1500) {
            addMoney(-1500);
        }
    }
}

// BoldPlayer: Represents a player with an aggressive strategy
class BoldPlayer extends Player {
    private final Random random;

    // Constructor: Initializes a BoldPlayer with a name and starting money
    public BoldPlayer(String name, int money) {
        super(name, money);
        this.random = new Random();
    }

    // Override play method: Implements the aggressive play strategy
    @Override
    public void play() {
        int steps = random.nextInt(6) + 1; // Determine the steps with a 90% chance
        move(steps);

        // 90% chance of buying a property when landing on a new space
        if (random.nextDouble() < 0.9) {
            Property property = new Property("Bold's Property", random.nextInt(20));
            addProperty(property);
        }

        // Deducts $1500 if the total wealth reaches $1500
        if (getTotalWealth() == 1500) {
            addMoney(-1500);
        }
    }
}

// PrudentPlayer: Represents a player with a cautious strategy
class PrudentPlayer extends Player {
    private final Random random;

    // Constructor: Initializes a PrudentPlayer with a name and starting money
    public PrudentPlayer(String name, int money) {
        super(name, money);
        this.random = new Random();
    }

    // Override play method: Implements the cautious play strategy
    @Override
    public void play() {
        move(2); // Always move 1 space

        // Buy a property with a 30% chance when landing on a new space
        if (random.nextFloat() < 0.6) {
            Property property = new Property("PrudentProperty", 10);
            addProperty(property);
        }

        // Deducts $1500 if the total wealth reaches $1500
        if (getTotalWealth() == 1500) {
            addMoney(-1500);
        }
    }
}