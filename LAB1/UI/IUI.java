package LAB1.UI;

import java.io.Closeable;

public interface IUI extends Closeable {
    int[] getNumbers() throws IllegalArgumentException;
    void printNumbers(int delimoe, int delitel, double chastnoe);
}
