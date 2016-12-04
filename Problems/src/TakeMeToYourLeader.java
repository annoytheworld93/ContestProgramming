import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Created by will on 12/6/16.
 * Contest Program: Take Me To Your Leader
 */
public class TakeMeToYourLeader {
  final static Logger logger = Logger.getLogger(TakeMeToYourLeader.class.getName());

  private static HashSet<ArrayList> set = new HashSet<>();

  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    int numOfPeople = scanner.nextInt();
    logger.info("Num of people being interview = " + numOfPeople);
    String name;
    String leader;
    for (int i = 0; i < numOfPeople; i++){
      name = scanner.next();
      leader = scanner.next();
      helper(name, leader);
    }
  }
  public static void helper(String follower, String leader){
    if (!set.contains(follower)){
    }
  }
}
