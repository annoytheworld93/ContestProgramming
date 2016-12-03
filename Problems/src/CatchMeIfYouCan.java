import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

/**
 * Refer to project description for how program is used at execution.
 */

//FiXME Perhaps a hashmap of Hashmaps would be a helpful data structure???
//FIXME for input, rather than getting the line, get word by word and store that in an ArrayDeque.

public class CatchMeIfYouCan {
  //Useful variables
  static private int numOfRuns = 0;
  static private int numOfTests = 0;
  //hash tables used for store beginning location
  static private Hashtable<String, Hashtable> startingLocation = new Hashtable<>();
  static private Hashtable<String, String> endingLocation = new Hashtable<>();
  //function used for getting input.
  public static void getInput(){
    Scanner scanner = new Scanner(System.in);
    numOfRuns = scanner.nextInt();
    numOfTests = scanner.nextInt();
    String travelMethod = null;
    String startingCity = null;
    String endingCity = null;
    for (int i = 0; i < numOfRuns; i++){
      //get input for each line
      travelMethod = scanner.next();
      startingCity = scanner.next();
      endingCity = scanner.next();
      //base cases
      if (!startingLocation.containsKey(startingCity)){
        if (!endingLocation.containsKey(travelMethod)){

        }
      }
    }
  }


}
