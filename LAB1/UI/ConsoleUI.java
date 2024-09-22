package LAB1.UI;

import java.util.Scanner;
import java.io.IOException;

public class ConsoleUI implements IUI {
    Scanner _scanner = new Scanner(System.in);

    @Override
    public int[] getNumbers() throws IllegalArgumentException {
        // Ввод количества чисел
        int t = getInput("Введите количество целых чисел (t): ");

        // Валидация: количество чисел должно быть больше 1
        if (t < 2) {
            throw new IllegalArgumentException("Введите не менее 2 целых чисел.");
        }

        // Ввод чисел
        int[] numbers = new int[t];
        System.out.println("Введите " + t + ":");
        for (int i = 0; i < t; i++) {
            numbers[i] = getInput("");
        }

        return numbers;
    }

    @Override
    public void printNumbers(int delimoe, int delitel, double chastnoe) {
        // Вывод результата
        System.out.printf("Fractional part of the division of %d/%d is: %.5f%n", 
        delimoe, delitel, chastnoe);
    }


    // Безопасное получение числового ввода
    private int getInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(_scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Введите число.");
            }
        }
    }

    @Override
    public void close() throws IOException {
        _scanner.close();
    }
}

    