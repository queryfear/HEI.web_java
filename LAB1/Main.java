package LAB1;

import java.io.IOException;

import LAB1.Application.Services.FractionCalculator;
import LAB1.Application.Services.NumberService;
import LAB1.Domain.Abstractions.IFractionCalculator;
import LAB1.Domain.Abstractions.INumberService;
import LAB1.UI.ConsoleUI;
import LAB1.UI.IUI;

public class Main {
    public static void main(String[] args) throws IOException {
        IUI ui = new ConsoleUI();
        try {
            // Приложение для нахождения первых двух положительных чисел
            INumberService numberService = new NumberService();
            int[] numbers = ui.getNumbers();
            int[] positiveNumbers = numberService.findFirstTwoPositiveNumbers(numbers);

            // Домен для расчета дробной части
            IFractionCalculator calculator = new FractionCalculator();
            double fractionalPart = calculator.calculateFraction(positiveNumbers[0], positiveNumbers[1]);

            ui.printNumbers(positiveNumbers[0], positiveNumbers[1], fractionalPart);

        } catch (IllegalArgumentException | ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            ui.close();
        }
    }

}