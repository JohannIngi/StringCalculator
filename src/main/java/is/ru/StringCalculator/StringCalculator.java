package is.ru.StringCalculator;

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
}