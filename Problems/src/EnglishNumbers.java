import java.util.Scanner;

/**
 * Created by annoytheworld on 12/3/16.
 */
public class EnglishNumbers {
    /**
     *
     * @param inputNum
     * @return a String that represents inputNum in spoken English.
     */
    public static String convert(long inputNum){
        String retVal = "";

        String num = Long.toString(inputNum);

        if (inputNum > 999999){
            boolean numsAfterMillion = num.substring(3, 6).equals("000000");
            if (numsAfterMillion){System.out.println("There are numbers after the millions.");}
        }


        return retVal;
    }




    //getting input number
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        long inputNum = scanner.nextLong();
        System.out.println(convert(inputNum));
    }
}
