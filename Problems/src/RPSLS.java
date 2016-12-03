import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

/**
 * Created by Will on 12/1/2016.
 * Rock Paper Scissors Lizard Spock
 */
public class RPSLS {
  static class Move{
    String player;
    String action;
    public Move(String player, String action){
      this.player = player;
      this.action = action;
    }
    public Move(){}
    public void setPlayer(String player){this.player = player;}
    public void setAction(String action){this.action = action;}
    public String getPlayer(){return player;}
    public String getAction(){return action;}
  }
  static ArrayList<String> scissorsList = new ArrayList<>();
  static ArrayList<String> paperList = new ArrayList<>();
  static ArrayList<String> rockList = new ArrayList<>();
  static ArrayList<String> lizardList= new ArrayList<>();
  static ArrayList<String> spockList= new ArrayList<>();
  static ArrayList<String> acceptableList = new ArrayList<>();
  static Hashtable<String, ArrayList<String>> hashtable = new Hashtable<>();
  public static void setHashTable(){
    //what scissors beats
    scissorsList.add("Paper");
    scissorsList.add("Lizard");
    //what paper beats
    paperList.add("Rock");
    paperList.add("Spock");
    //what rock beats
    rockList.add("Lizard");
    rockList.add("Scissors");
    //what spock beats
    spockList.add("Scissors");
    spockList.add("Rock");
    //what lizard beats
    lizardList.add("Paper");
    lizardList.add("Spock");
    //acceptable moves
    acceptableList.add("Rock");
    acceptableList.add("Paper");
    acceptableList.add("Scissors");
    acceptableList.add("Lizard");
    acceptableList.add("Spock");
    //setting the hashtable
    hashtable.put("Scissors", scissorsList);
    hashtable.put("Paper", paperList);
    hashtable.put("Rock", rockList);
    hashtable.put("Lizard", lizardList);
    hashtable.put("Spock", spockList);
  }
  static public boolean beats(Move move1, Move move2){
    boolean retVal = false;
    int key = 0;
    if (hashtable.containsKey(move1.getAction())){
      if (hashtable.get(move1.getAction()).contains(move2.getAction())){
        //player 1 wins
        key = 1;
      }
    }
    if (hashtable.containsKey(move2.getAction())){
      if (hashtable.get(move2.getAction()).contains(move1.getAction())){
        //player 2 wins
        key = 2;
      }
    }
    switch (key){
      case 1: retVal = true; break;
      case 2: retVal = false; break;
      default:
        //System.out.println("Else case");
        retVal = invalidResponse(move1, move2);
    }
    return retVal;
  }
  static public boolean invalidResponse(Move move1, Move move2){
    boolean retVal = false;
    if (acceptableList.contains(move1.getAction()) && acceptableList.contains(move2.getAction())){
      //System.out.println("Both chose the same move.");
      int compare = move1.getPlayer().compareTo(move2.getPlayer());
      if (compare <= 0){
        retVal = true;
        return retVal;
      }
      else{
        retVal = false;
        return retVal;
      }
    }
    if (!acceptableList.contains(move1.getAction()) && acceptableList.contains(move2.getAction())){
      retVal = true;
    }
    if (!acceptableList.contains(move2.getAction()) && acceptableList.contains(move1.getAction())){
      retVal = false;
    }
    //both gave invalid answers
    else {
      int compare = move1.getPlayer().compareTo(move2.getPlayer());
      if (compare > 0){
        retVal = true;
      }
      else{
        retVal = false;
      }
    }
    return retVal;
  }

  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    Move move1 = new Move();
    Move move2 = new Move();
    while (scanner.hasNext()){
      move1.setPlayer(scanner.next());
      move1.setAction(scanner.next());
      move2.setPlayer(scanner.next());
      move2.setAction(scanner.next());
      setHashTable();
      boolean winner = beats(move1, move2);
      if (winner){
        System.out.println(move1.getPlayer() + " wins!");
      }
      else{
        System.out.println(move2.getPlayer() + " wins!");
      }
    }
  }
}
