package LAB1.Application.Services;

import LAB1.Domain.Abstractions.IFractionCalculator;

public class FractionCalculator implements IFractionCalculator {
    @Override
    public double calculateFraction(int m, int n) {
        if (n == 0) {
            throw new ArithmeticException("n не может быть 0");
        }
        double result = (double) m / n;
        return result - Math.floor(result); // Более точное вычисление дробной части
    }
}
