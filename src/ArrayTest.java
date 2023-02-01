import java.util.Arrays;
public class ArrayTest {
    public static void main(String[] args) {
        NumberConverter nc = new NumberConverter(12, 64);
        int[] digits = nc.getDigits();
        System.out.println("\n\nDigit array: " + Arrays.toString(digits));
        System.out.println("Number: " + nc.displayOriginalNumber());
    }
}