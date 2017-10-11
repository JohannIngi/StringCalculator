package is.ru.StringCalculator;

public class StringCalculator {
    public static int add(String numbers) {
        if(numbers.equals("")){
            return 0;
        }
        return toInt(numbers);
    }
    private static int toInt(String number){
        return Integer.parseInt(number);
    }
}
