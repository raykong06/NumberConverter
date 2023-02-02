import java.util.Scanner;
import java.util.Arrays;

class ConverterRunner {
    public static void main(String[] args) {
        // Instance Variables
        boolean binary = false;
        boolean octal = false;
        boolean decimal = false;
        boolean hex = false;
        boolean checkOption = true;
        boolean checkChoice = true;
        boolean invalidInput = false;
        boolean checkInput = true;

        final String binaryValidInput = "01";
        final String octalValidInput = "01234567";
        final String decimalValidInput = "0123456789";
        final String hexValidInput = "ABCDEF0123456789";

        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");

        Scanner s = new Scanner(System.in);
        System.out.print("Please pick an option (1/2):" +
                "\nOption 1 - Convert a binary, octal, decimal, or hex number to other bases" +
                "\nOption 2 - Convert a base 10 number to any base 1-64" +
                "\nOption: ");

        String option = s.nextLine();
        while (checkOption)
        {
            if (option.equals("1") || option.equals("2"))
            {
                checkOption = false;
            }
            else
            {
                System.out.print("That is an invalid option. Please select option 1 or 2: ");
                option = s.nextLine();
            }
        }

        System.out.println("--------------------------------");

        if (option.equals("1"))
        {
            System.out.print("Enter the base of your number (2, 8, 10, or 16): ");

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

            int n = 0;
            if (binary || octal || decimal)
            {
                n = Integer.parseInt(number);
            }

            s.close();


            NumberConverter nc;
            if (binary || octal || decimal)
            {
                nc = new NumberConverter(n, base);
                int[] digits = nc.getDigits();
                System.out.println("\n\nDigit array: " + Arrays.toString(digits));
            }
            else
            {
                nc = new NumberConverter(number, base);
                String[] strDigits = nc.getStrDigits();
                System.out.println("\n\nDigit array: " + Arrays.toString(strDigits));
            }

            if (hex)
            {
                System.out.println("Binary Number: " + nc.intArrtoNumber(nc.convertToBinary()));
                System.out.println("Octal Number: " + nc.intArrtoNumber(nc.convertToOctal()));
                System.out.println("Decimal Number: " + nc.intArrtoNumber(nc.convertToDecimal()));
            }
            else if (decimal)
            {
                System.out.println("Binary Number: " + nc.intArrtoNumber(nc.convertToBinary()));
                System.out.println("Octal Number: " + nc.intArrtoNumber(nc.convertToOctal()));
                System.out.println("Hexadecimal Number: " + nc.strArrtoString(nc.convertToHex()));
            }
            else if (octal)
            {
                System.out.println("Binary Number: " + nc.intArrtoNumber(nc.convertToBinary()));
                System.out.println("Decimal Number: " + nc.intArrtoNumber(nc.convertToDecimal()));
                System.out.println("Hexadecimal Number: " + nc.strArrtoString(nc.convertToHex()));
            }
            else if (binary)
            {
                System.out.println("Octal Number: " + nc.intArrtoNumber(nc.convertToOctal()));
                System.out.println("Decimal Number: " + nc.intArrtoNumber(nc.convertToDecimal()));
                System.out.println("Hexadecimal Number: " + nc.strArrtoString(nc.convertToHex()));
            }
        }
    }
}