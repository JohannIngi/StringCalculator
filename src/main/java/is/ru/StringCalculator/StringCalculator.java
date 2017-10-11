package is.ru.StringCalculator;

public class StringCalculator {
    public static int add(String numbers) {
        if(numbers.equals("")){
            return 0;
        }
        else if(numbers.contains(",")){
        	String arr[] = numbers.split(",");
        	int sum = 0;
        	for(String numb : arr){
        		sum += toInt(numb);
        	}
        	return sum;
        }
        return toInt(numbers);
    }
    private static int toInt(String number){
        return Integer.parseInt(number);
    }
    private static int sumOfNumbers(String number){
    	    int sum = 0;
        	for(String numb : number){
        		sum += toInt(numb);
        	}
        	return sum;
    }
}
