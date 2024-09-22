package LAB1.Domain.Abstractions;

public interface INumberService {
    int[] findFirstTwoPositiveNumbers(int[] numbers) throws IllegalArgumentException;
}