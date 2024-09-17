package LAB2;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class LabTwo
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String regex = "^[0-255].[0-255].[0-255].[1-9]$";
        Pattern patt = Pattern.compile(regex);

        while(true)
        {
            String ip = in.nextLine();
            Matcher match = patt.matcher(ip);

            if (ip == "break") 
            {
                System.out.println("Breaking.");
                break;
            }

            if (match.matches())
            {
                System.out.println("Correct ip: " + match.group(0) + " — Success!");
            }
            else
            {
                System.out.println("Ip " + ip + " is not correct. Matched: " + match.group(0) + " — Fail.");
            }
        }

        in.close();
    }
}