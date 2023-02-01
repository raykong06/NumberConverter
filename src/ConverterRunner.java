import java.util.Scanner;
import java.util.Arrays;

class ConverterRunner {
    public static void main(String[] args) {
        // Instance Variables
        boolean binary = false;
        boolean octal = false;
        boolean decimal = false;
        boolean hex = false;
        boolean checkChoice = true;
        boolean invalidInput = false;
        boolean checkInput = true;

        final String binaryValidInput = "01";
        final String octalValidInput = "01234567";
        final String decimalValidInput = "0123456789";
        final String hexValidInput = "ABCDEF0123456789";

        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.print("Enter the base of your number (2, 8, 10, or 16): ");

        Scanner s = new Scanner(System.in);
        String choice = s.nextLine();
        while (checkChoice)
        {
            if (choice.equals("2") || choice.equals("8") || choice.equals("10") || choice.equals("16"))
            {
                checkChoice = false;
            }
            else
            {
                System.out.print("That is an invalid input. Please enter the base of your number (2, 8, 10, or 16): ");
                choice = s.nextLine();
            }
        }
        int base = Integer.parseInt(choice);

        if (base == 2)
        {
            binary = true;
            octal = false;
            decimal = false;
            hex = false;
        }
        else if (base == 8)
        {
            binary = false;
            octal = true;
            decimal = false;
            hex = false;
        }
        else if (base == 10)
        {
            binary = false;
            octal = false;
            decimal = true;
            hex = false;
        }
        else if (base == 16)
        {
            binary = false;
            octal = false;
            decimal = false;
            hex = true;
        }

        System.out.print("Enter your number: ");
        String number = s.nextLine();

        while (checkInput)
        {
            invalidInput = false;
            String substring;
            if (binary)
            {
                for (int i = 0; i < number.length(); i++)
                {
                    substring = number.substring(i, i + 1);
                    if (binaryValidInput.indexOf(substring) == -1)
                    {
                        invalidInput = true;
                    }
                }
            }
            else if (octal)
            {
                for (int i = 0; i < number.length(); i++)
                {
                    substring = number.substring(i, i + 1);
                    if (octalValidInput.indexOf(substring) == -1)
                    {
                        invalidInput = true;
                    }
                }
            }
            else if (decimal)
            {
                for (int i = 0; i < number.length(); i++)
                {
                    substring = number.substring(i, i + 1);
                    if (decimalValidInput.indexOf(substring) == -1)
                    {
                        invalidInput = true;
                    }
                }
            }
            else if (hex)
            {
                for (int i = 0; i < number.length(); i++)
                {
                    substring = number.substring(i, i + 1);
                    if (hexValidInput.indexOf(substring) == -1)
                    {
                        invalidInput = true;
                    }
                }
            }

            if (!invalidInput)
            {
                checkInput = false;
            }
            else
            {
                System.out.print("The number you inputted is invalid. Please enter another number: ");
                number = s.nextLine();
            }
        }
        
        int n = Integer.parseInt(number);

        s.close();


        NumberConverter nc = new NumberConverter(n, base);
        int[] digits = nc.getDigits();
        System.out.println("\n\nDigit array: " + Arrays.toString(digits));

        if (base == 10)
        {
            System.out.println("Binary Number: " + nc.intArrtoNumber(nc.convertToBinary()));
            System.out.println("Octal Number: " + nc.intArrtoNumber(nc.convertToOctal()));
        }
        else if (base == 8)
        {
            System.out.println("Binary Number: " + nc.intArrtoNumber(nc.convertToBinary()));
            System.out.println("Decimal Number: " + nc.intArrtoNumber(nc.convertToDecimal()));
        }
        else if (base == 2)
        {
            System.out.println("Octal Number: " + nc.intArrtoNumber(nc.convertToOctal()));
            System.out.println("Decimal Number: " + nc.intArrtoNumber(nc.convertToDecimal()));
        }
    }
}