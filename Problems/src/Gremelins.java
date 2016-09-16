import java.util.Scanner;

/**
 * Created by will on 9/16/16.
 */
public class Gremelins {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int numtestCases = scanner.nextInt();
        for (int testCaseIndex = 0; testCaseIndex < numtestCases; numtestCases++){

            //FIXME May potentially need this to be a BigInteger due to 10^18 switches.
            int numOfSwitches = scanner.nextInt();
            boolean[] switchNumbers = new boolean[numOfSwitches];
            //Populate the switchNumbers and increment by one.

            //FIXME This is just for debugging purposes
            for (int j = 0; j < switchNumbers.length; j++){
                System.out.println(switchNumbers[j]);
            }
            int numOfGremelins = scanner.nextInt();
            int[] primeNumbersList = new int[numOfGremelins];
            //Populate the primeNumbers to look at with scanner.
            for (int gremelinIndex = 0; gremelinIndex < numOfGremelins; gremelinIndex++){
                primeNumbersList[gremelinIndex] = scanner.nextInt();
            }


            //TODO: Need to add one to the index.


            //FIXME This is just for debugging purposes
            for (int j = 0; j < primeNumbersList.length; j++){
                System.out.println(primeNumbersList[j]);
            }


        }
    }
}
