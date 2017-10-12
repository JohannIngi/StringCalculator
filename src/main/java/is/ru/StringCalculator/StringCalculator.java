package is.ru.StringCalculator;

import java.util.ArrayList;

public class StringCalculator {
    /**
     * adds all the numbers toghether and return the sum, using helper functions
     * @param numbers are the numbers that are added into the function
     * @return
     */
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

    /**
     * return the string number as an int
     * @param number are the numbers that are added into the function
     * @return
     */
    private static int to_int(String number){return Integer.parseInt(number);}

    /**
     * does the actual math of the numbers and checking if the delimiters are legal and send them into according helper functions
     * @param arr are the numbers that are added into the function as an array
     * @return
     */
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

    /**
     * parsing function, that parses the delimiters
     * @param numbers are the numbers that are added into the function
     * @return
     */
    private static String[] split_numbers(String numbers){return numbers.split(",");}

    /**
     * helper function that checks the delimiter and converts them to the appropriate delimiter ","
     * @param numbers are the numbers that are added into the function
     * @return
     */
    private static String check_delimiter(String numbers){
        if(numbers.startsWith("//")){
            String delimiter = numbers.substring(2,3);
            String tmp_delimiter = numbers.substring(3);

            String number = tmp_delimiter.replaceAll(delimiter, ",");
            return number;
        }
        return numbers;
    }

    /**
     * helper function that runs the error message. It builds a string containing the actual message and the negative numbers and throws a run time exception
     * @param numbers are the numbers that are added into the function
     */
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