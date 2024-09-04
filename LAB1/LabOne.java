package LAB1;

import java.util.Scanner;

public class LabOne 
{
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        double[] array = new double[tests];
        int m = 0, n = 1;

        for (int i = 0; i < array.length; ++i) {
            array[i] = in.nextDouble();
        }

        for (int i = 0; i < array.length; ++i) 
        {
            if (array[i] - (int)array[i] == 0.0) 
            {
                for (int j = i + 1; j < array.length - 1; ++j) 
                {
                    if (array[j] - (int)array[j] == 0.0) {
                        m = (int)array[i];
                        n = (int)array[j];
                        break;
                    }
                }

                if (n != 1) break;
            }
        }

        double p = (double)m / (double)n;

        System.out.print(p);

        in.close();
    }
}