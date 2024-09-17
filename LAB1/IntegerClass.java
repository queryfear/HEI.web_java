package LAB1;

public class IntegerClass {
    private int value;

    // Constructor
    public IntegerClass(int value) {
        this.value = value;
    }

    // Getter for the value
    public int getValue() {
        return value;
    }

    // Check if the integer is positive
    public boolean isPositive() {
        return value > 0;
    }

}
