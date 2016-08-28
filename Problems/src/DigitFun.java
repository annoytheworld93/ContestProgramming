import java.util.Scanner;

/**
 * Created by will on 8/28/16.
 */
public class DigitFun {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String initialNumOfDigits = "null";
        int initialCount = 0;
        while (sc.hasNext()){
            String input = sc.next();
            if(input.equals("END")){
                return;
            }
            else{
                System.out.println(solve(input, initialNumOfDigits, initialCount));
            }
        }
    }

    private static int solve(String valueToCheck, String lastValue, int count){
        if (valueToCheck.equals(lastValue)) {
            return count;
        }
        else {
            lastValue = valueToCheck;
            valueToCheck = String.valueOf(valueToCheck.length());
            count++;
            return solve(valueToCheck, lastValue, count);
        }
    }
}
