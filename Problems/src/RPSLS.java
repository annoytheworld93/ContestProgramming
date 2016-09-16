import javax.sound.midi.SysexMessage;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.StringJoiner;

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
        //setting the hashtable
        hashtable.put("Scissors", scissorsList);
        hashtable.put("Paper", paperList);
        hashtable.put("Rock", rockList);
        hashtable.put("Lizard", lizardList);
        hashtable.put("Spock", spockList);
    }
    static public boolean beats(Move move1, Move move2){
        boolean retVal = true;
        if (hashtable.containsKey(move1.getAction())){
            if (hashtable.get(move1.getAction()).contains(move2.getAction())){
                //player 1 wins
                retVal = true;
            }
            //need to figure out case if player 2 did not choose a valid move
        }
        if (hashtable.containsKey(move2.getAction())){
            if (hashtable.get(move2.getAction()).contains(move1.getAction())){
                //player 2 wins
                retVal = false;
            }
            //need to figure out if player 1 did not choose a valid move
        }
        return retVal;
    }


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int numOfGames = scanner.nextInt();
        for (int i = 0; i < numOfGames; i++) {
            Move move1 = new Move(scanner.next(), scanner.next());
            Move move2 = new Move(scanner.next(), scanner.next());
            setHashTable();
            boolean winnner = beats(move1, move2);
            if (winnner){
                System.out.println(move1.getPlayer() + " wins!");
            }
            else{
                System.out.println(move2.getPlayer() + " wins!");
            }
        }
    }
}
