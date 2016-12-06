import java.util.Scanner;
import java.util.logging.Logger;


/**
 * Created by annoytheworld on 12/3/16.
 * Used for the English
 */

public class EnglishNumbers {
  public static Logger logger = Logger.getLogger(EnglishNumbers.class.getName());


  public static String onesPlace[] ={"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
  public static String teensPlace[] = {"", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
  public static String tensPlace[] = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    /**
     * @param inputNum a long representing the number to be translated to English.
     * @return a String that represents inputNum in spoken English.
     */
    public static String convert(long inputNum){
        String retVal = "";

        String num = Long.toString(inputNum);

        //inputNum is in millions place
        if (num.length() > 6){
            boolean numsAfterMillion = !num.substring(3, 9).equals("000000");
            //TODO figure out what strings to concat to retVal
            if (numsAfterMillion){
              logger.info("There are numbers after the millions place");
              //need to add comma after million
              retVal = retVal.concat(",");
            }
        }
        //inputNum is in the thousands place
        else if (num.length() > 3 && num.length() < 7){
          boolean numsAfterThousand = !num.substring(3, 6).equals("000");
          //TODO figure out what strings to concat to retval
          if (numsAfterThousand) {
            logger.info("There are numbers after the thousands place");
            //need to add comma after thousand
            retVal = retVal.concat(", ");
          }
        }


        return retVal;
    }


  /**
   * main driver method that gets input and calls convert
   * @param args
   */
  public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        long inputNum = scanner.nextLong();
        System.out.println(convert(inputNum));
    }
}
