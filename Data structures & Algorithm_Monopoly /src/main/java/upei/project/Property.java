package upei.project;

// Property: Represents a property in a Monopoly game
public class Property {
    private int value;

    // Constructor: Initializes a Property with a name and value
    public Property(String name, int value) {
        this.value = value;
    }

    // Getter method: Retrieves the value of the property
    public int getValue() {
        return value;
    }
}
