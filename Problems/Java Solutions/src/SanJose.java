import java.util.HashSet;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Created by will on 12/6/16.
 * Contest Program: Do You Know The Way To San Jose?
 */
public class SanJose {
  final static Logger logger = Logger.getLogger(SanJose.class.getName());
  private static HashSet<String> startLocation = new HashSet<>();
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    String startCity;
    String endCity;
    int paths = scanner.nextInt();
    for (int i = 0; i < paths; i++){
      startCity = scanner.next();
      endCity = scanner.next();
      helper(startCity, endCity);
    }
  }

  private static void helper(String startCity, String endCity){
    if (!startLocation.contains(startCity)){
      startLocation.add(startCity);
    }

  }
}
