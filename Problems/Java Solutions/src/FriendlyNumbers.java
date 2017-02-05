import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by will on 2/3/17.
 */
public class FriendlyNumbers {


  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int numOfUnfriendlyNums = Integer.valueOf(sc.next());
    long friendlyNum = Long.valueOf(sc.next());

    TreeSet<Long> factors = getFactors(friendlyNum);

    for (int i = 0; i < numOfUnfriendlyNums; i++){
      long uf = Long.valueOf(sc.next());
      //TODO: Find gcd of unfriendly and friendly
      long gcd = gcd(Long.valueOf(sc.next()), friendlyNum);
      //TODO: Iterate through factors and remove factors that divide unfriendly evenly.
      for (int j = 0; j < factors.size(); j++){
        if (factors.)
      }
    }

  }

  public static TreeSet<Long> getFactors(long num){
    TreeSet<Long> retVal = new TreeSet<>();
    long upperBound = (long) Math.sqrt(num);
    for (long i = 2 ; i <= upperBound; i++){
      if(num % i ==0){
        retVal.add(i);
        retVal.add(num / i);
      }
    }
    return retVal;
  }

  public static long findFriendlyNums(long friend){
    long sqrtFriend = (long) Math.sqrt(friend);
    for (long i = 2; i <= sqrtFriend; i++){
      if (friend % i == 0){
        //Add i to collection of factors
        //add (friend/i) to collection
      }
    }
    for(long unf = 0; unf< unFriendlyNumbers){
      for(factor: collection){
        if(uf % factor == 0){
          //remove factor from collection
        }
      }
    }
  }

  for (int i = 0; i < n; i++){
    long uf = Long.valueOf(scanner.next());
    Iterator<Long> it = collection.iterator();
    while(it.hasNext()){
      long factor = it.next();
      //FIXME Notice how this is inefficient to calculate gcd in the if statement
      //FIXME
      if(factor < gcd(uf, f)){
        if(uf % factor == 0){
          it.remove();
        }
      }
    }
  }
//Used to
  public static long gcd(long a, long b){
    while(b != 0){
      long t = b;
      b = a % b;
      a = t;
    }
    return a;
  }
}
