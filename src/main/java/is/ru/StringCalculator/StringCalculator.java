package is.ru.StringCalculator;

public class StringCalculator {
    public static int add(String numbers) {
        if(numbers.equals("")){
            return 0;
        }
        else if(numbers.contains(",")){
            return sumOfNumbers(splitNumbers(numbers));
        }
        else return toInt(numbers);
	}
    private static int toInt(String number){
        return Integer.parseInt(number);
    }
    private static int sumOfNumbers(String [] arr){
        int sum = 0;
        for(String numb : arr){
            sum += toInt(numb);
        }
        return sum;
    }
    private static String[] splitNumbers(String arr){
        return arr.split(",");
    }
}
