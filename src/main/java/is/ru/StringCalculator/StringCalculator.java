package is.ru.StringCalculator;

import java.util.ArrayList;

/**
 * Created by Johann on 10.10.2017.
 */

public class StringCalculator {

    public static int add(String numbers) {

        numbers = check_delimiter(numbers);

        if(numbers.equals("")){
            return 0;
        }

        String tmp_numbers = numbers.replaceAll("\\r\\n|\\r|\\n", ",");
        numbers = tmp_numbers;
        if(numbers.contains(",") || numbers.contains("\r\n")){
            return sum_of_numbers(split_numbers(numbers));
        } else
            return to_int(numbers);
    }
    private static int to_int(String number){
        return Integer.parseInt(number);
    }
    private static int sum_of_numbers(String [] arr){
        boolean contains_negative = false;
        ArrayList<String> negative_number = new ArrayList<String>();
        int sum = 0;
        for(String number : arr){
            if(to_int(number) < 0){
                negative_number.add(number);
                contains_negative = true;
            }

            if(to_int(number) > 1000){
                continue;
            }else{
                sum += to_int(number);
            }
        }
        if(contains_negative){run_error_msg(negative_number);}
        return sum;
    }
    private static String[] split_numbers(String numbers){
        return numbers.split(",");
    }
    private static String check_delimiter(String numbers){
        if(numbers.startsWith("//")){
            String delimiter = numbers.substring(2,3);
            String tmp_delimiter = numbers.substring(3);

            String number = tmp_delimiter.replaceAll(delimiter, ",");
            return number;
        }
        return numbers;
    }
    private static  void run_error_msg(ArrayList<String> numbers){
        StringBuilder sb = new StringBuilder("Error no negative numbers allowed: ");
        for(String number : numbers){
            sb.append(number);
            sb.append(",");
        }
        sb.setLength(sb.length() - 1);
        throw new RuntimeException(sb.toString());
    }
}