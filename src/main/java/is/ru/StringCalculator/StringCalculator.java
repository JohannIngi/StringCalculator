package is.ru.StringCalculator;

public class StringCalculator {
    public static int add(String numbers) {
        String tmp_numbers = numbers.replaceAll("\\r\\n|\\r|\\n", ",");
        if(tmp_numbers.equals("")){
            return 0;
        }
        else if(tmp_numbers.contains(",") || tmp_numbers.contains("\r\n")){
            return sum_of_numbers(split_numbers(tmp_numbers));
        } else
            return to_int(tmp_numbers);
    }
    private static int to_int(String number){
        return Integer.parseInt(number);
    }
    private static int sum_of_numbers(String [] arr){
        int sum = 0;
        for(String numb : arr){
        	if(to_int(numb) > 1000){
        		continue;
        	}else{
        		sum += to_int(numb);
        	}
        }
        return sum;
    }
    private static String[] split_numbers(String arr){
        return arr.split(",");
    }
}
