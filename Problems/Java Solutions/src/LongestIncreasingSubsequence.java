import java.util.ArrayList;

/**
 * Created by will on 11/6/16.
 */
public class LongestIncreasingSubsequence {
  public static void main(String[] args){
    //Test by giving it an array
    int[] array1 = {1,2,3,4,5,6};
    int[] array2 = {9, 1, 3, 7, 5, 6, 20};
    ArrayList<Integer> finalList = longestSequenceCount(array2);
    for (int x = 0; x < finalList.size(); x++){
      System.out.print(finalList.get(x) + " ");
    }
  }
  static ArrayList<Integer> list = new ArrayList<>();
  public static ArrayList<Integer> longestSequenceCount(int[] nums){
    //TODO Count the increasing subsequence.
    if (nums == null || nums.length == 0)
      return  list;
    for (int num : nums){
      if (list.size() == 0 || num > list.get(list.size()-1)){
        list.add(num);
      }else{
        int i = 0;
        int j = list.size()-1;

        while(i < j){
          int mid = (i + j)/2;
          if (list.get(mid) < num) {
            i = mid + 1;
          }else{
            j = mid;
          }
        }
        list.set(j, num);
      }
    }
    return list;
  }
}
