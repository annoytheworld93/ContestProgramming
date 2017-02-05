import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by will on 1/18/17.
 * FizzBuzzWhammy Contest Programming Problem
 */
public class FizzBuzzWhammy {
  public static void main(String[] args){
    //First, get the input...
    Scanner sc = new Scanner(System.in);
    String input = sc.nextLine();



    List<Long> list = Stream.of(input.split(","))
        .map(Long::parseLong)
        .collect(Collectors.toList());

    //System.out.println(list);

    long fizz;
    long buzz;
    long whammy;
    long fizzbuzz;
    long finalNum;

    fizz = list.get(0);
    while(fizz != -1){
      buzz = list.get(1);
      fizzbuzz = fizz * buzz;
      whammy = list.get(2);
      finalNum = list.get(3);
      solution(fizz, buzz, fizzbuzz, whammy, finalNum);
      input = sc.nextLine();
      list = Stream.of(input.split(","))
          .map(Long::parseLong)
          .collect(Collectors.toList());
      fizz = list.get(0);
    }
  }

  public static void solution(long fizz, long buzz, long fizzbuzz, long whammy, long finalNum){
    //Count to the finalNum+1
    for (int i = 1; i< finalNum+1; i++){

      if (i % whammy == 0) {
        System.out.println("Got a whammy");
        while(i % fizz != 0 && i != finalNum) {
          System.out.println("Whammy");
          i++;
        }
      }


      if (i % fizzbuzz == 0) {
        System.out.println("FizzBuzz");
      }
      else if (i % fizz == 0) {
        System.out.println("Fizz");
      }

      else if (i % buzz == 0) {
        System.out.println("Buzz");
      }

      else {
        System.out.println(i);
      }

    }
    System.out.println("Done");
  }
}
