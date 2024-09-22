package LAB1.Application.Services;

import LAB1.Domain.Abstractions.INumberService;

public class NumberService implements INumberService {
    @Override
    public int[] findFirstTwoPositiveNumbers(int[] numbers) throws IllegalArgumentException {
        int[] positives = java.util.Arrays.stream(numbers)
                .filter(num -> num > 0)
                .limit(2)
                .toArray();
        if (positives.length < 2) {
            throw new IllegalArgumentException("Недостаточно положительных чисел.");
        }
        return positives;
    }
}