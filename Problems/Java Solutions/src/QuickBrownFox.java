import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by will on 1/30/17.
 */
public class QuickBrownFox {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int testNum = sc.nextInt();
    sc.nextLine();
    String input;
    for (int i =0; i < testNum; i++){
      input = sc.nextLine();
      System.out.println(isPangram(input));
    }
  }

  public static StringBuilder isPangram(String input){
    //First need to create an alphabet
    ArrayList<String> alphabet = new ArrayList<>(Arrays.asList("a","b","d","e","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"));
    char[] array = input.toLowerCase().toCharArray();
    for (char c: array){
      if(alphabet.contains(String.valueOf(c))){
      alphabet.remove(String.valueOf(c));
      //System.out.println("New String: " + alphabet);
      }
    }
    StringBuilder stringBuilder = new StringBuilder();
    for(int i = 0; i < alphabet.size(); i++){
      stringBuilder.append(alphabet.get(i));
    }
    if (stringBuilder.toString().equals("")){
      stringBuilder = new StringBuilder("pangram");
    }else{
      stringBuilder.insert(0, "missing ");
    }
    return stringBuilder;
  }
}
