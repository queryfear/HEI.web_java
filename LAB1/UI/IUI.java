package LAB1.UI;

import java.io.Closeable;

public interface IUI extends Closeable {
    int[] getNumbers() throws IllegalArgumentException;
    void printNumbers(int divisible, int divider, double quotient);
}
