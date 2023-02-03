public class NumberConverter {
    private int[] digits;
    private String[] strDigits;
    private int base;
    private String[] baseReference;
    private final String digitMap = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz+/";

    public NumberConverter(int number, int base) {
        String numberAsString = Integer.toString(number);
        digits = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i,i+1);
            int d = Integer.parseInt(single);
            digits[i] = d;
        }
        this.base = base;

        baseReference = new String[64];
        for (int i = 0; i < 64; i++)
        {
            String single = digitMap.substring(i, i + 1);
            baseReference[i] = single;
        }
    }

    public NumberConverter(String number, int base) {
        strDigits = new String[number.length()];
        for (int i = 0; i < number.length(); i++) {
            String single = number.substring(i,i+1);
            strDigits[i] = single;
        }
        this.base = base;

        baseReference = new String[64];
        String digitMap = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz+/";
        for (int i = 0; i < 64; i++)
        {
            String single = digitMap.substring(i, i + 1);
            baseReference[i] = single;
        }
    }

    public String displayOriginalNumber() {
        String o = "";
        if (digits != null)
        {
            for (int i = 0; i < digits.length; i++) {
                o = o + digits[i];
            }
        }
        else
        {
            for (int i = 0; i < strDigits.length; i++) {
                o = o + strDigits[i];
            }
        }
        //o = o + "\n";
        return o;
    }

    public int[] getDigits() {
        return digits;
    }

    public String[] getStrDigits() {
        return strDigits;
    }

    public String[] getBaseReference(){
        return baseReference;
    }

    public int[] convertToDecimal() {
        String strNum = displayOriginalNumber();
        int decimal = 0;
        int power = strNum.length() - 1;
        for (int i = 0; i < strNum.length(); i++)
        {
            String place = strNum.substring(i, i + 1);
            int converted = digitMap.indexOf(place);
            decimal += converted * (int) Math.pow(base, power);
            power--;
        }
        String decimalStr = decimal + "";
        int[] decimalArray = new int[decimalStr.length()];
        for (int i = 0; i < decimalArray.length; i++)
        {
            decimalArray[i] = Integer.parseInt(decimalStr.substring(i, i + 1));
        }
        return decimalArray;
    }

    public int[] convertToBinary() {
        String converted = "";
        // convert to decimal then to binary
        int quotient = convertArrayToDecimal();
        int subtractNumber;

        while (quotient >= 2)
        {
            subtractNumber = quotient;
            quotient = quotient / 2;
            converted = (subtractNumber - (quotient * 2)) + converted;
        }
        converted = quotient + converted;
        int[] binary = new int[converted.length()];

        for (int i = 0; i < converted.length(); i++)
        {
            binary[i] = Integer.parseInt(converted.substring(i, i + 1));
        }

        return binary;
    }

    public int[] convertToOctal()
    {
        String converted = "";
        // convert to decimal then to octal
        int quotient = convertArrayToDecimal();
        int subtractNumber;

        while (quotient >= 8)
        {
            subtractNumber = quotient;
            quotient = quotient / 8;
            converted = (subtractNumber - (quotient * 8)) + converted;
        }
        converted = quotient + converted;
        int[] octal = new int[converted.length()];

        for (int i = 0; i < converted.length(); i++)
        {
            octal[i] = Integer.parseInt(converted.substring(i, i + 1));
        }

        return octal;
    }


    public String[] convertToHex()
    {
        int length = 0;
        int remainder = Integer.parseInt(displayOriginalNumber());
        while (remainder >= 1)
        {
            remainder /= 16;
            length++;
        }

        String[] converted = new String[length];
        int quotient = convertArrayToDecimal();
        int subtractNumber;

        int i = length - 1;
        while (quotient >= 16)
        {
            subtractNumber = quotient;
            quotient = quotient / 16;
            int substringIndex = subtractNumber - (quotient * 16);
            converted[i] = baseReference[substringIndex] + "";
            i--;
        }
        converted[i] = baseReference[quotient] + "";

        return converted;
    }

    public String[] convertToAnyBase(int baseToConvert)
    {
        int length = 0;
        int remainder = Integer.parseInt(displayOriginalNumber());
        while (remainder >= 1)
        {
            remainder /= baseToConvert;
            length++;
        }

        String[] converted = new String[length];
        int quotient = convertArrayToDecimal();
        int subtractNumber;

        int i = length - 1;
        while (quotient >= baseToConvert)
        {
            subtractNumber = quotient;
            quotient = quotient / baseToConvert;
            int substringIndex = subtractNumber - (quotient * baseToConvert);
            converted[i] = baseReference[substringIndex] + "";
            i--;
        }
        converted[i] = baseReference[quotient] + "";

        return converted;
    }

    public int intArrtoNumber(int[] arr)
    {
        String str = "";
        for (int i = 0; i < arr.length; i++)
        {
            str += arr[i];
        }

        return Integer.parseInt(str);
    }

    public String strArrtoString(String[] arr)
    {
        String str = "";
        for (int i = 0; i < arr.length; i++)
        {
            str += arr[i];
        }

        return str;
    }

    private int convertArrayToDecimal()
    {
        int[] decimalArr = convertToDecimal();
        String decimalStr = "";
        for (int i = 0; i < decimalArr.length; i++)
        {
            decimalStr += decimalArr[i];
        }

        return Integer.parseInt(decimalStr);
    }

}