package LAB1;

import java.util.Scanner;

public class LabOne 
{
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество чисел t: ");
        int t = in.nextInt();  
        IntegerClass[] numbers = new IntegerClass[t];  

        System.out.println("Введите " + t + " чисел:");
        for (int i = 0; i < t; i++) {
            int value = in.nextInt();
            numbers[i] = new IntegerClass(value); 
        }

        IntegerClass n = null, m = null;
        for (IntegerClass num : numbers) {
            if (num.isPositive()) {
                if (n == null) {
                    n = num;
                } else if (m == null) {
                    m = num; 
                    break;  
                }
            }
        }

        if (n != null && m != null) {
            double p = (double) m.getValue() / n.getValue();
            System.out.printf("Дробная часть десятичной дроби r = m / n: %.5f\n", p);
        } else {
            System.out.println("Не удалось найти два положительных числа.");
        }

        in.close();
    }
}