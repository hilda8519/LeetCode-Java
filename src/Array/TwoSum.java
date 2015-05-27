
//Question: Given an array of integers, find two numbers such that they add up to a specific
target number.//


package Array;
///Solution 1 Brute-force (time proportional N^2)//
public class TwoSum{
  //print the pairs number that satisify a[i] + a[j] = target;//
  public static void printTwoSum(int[] a){
      int N = a.length;
      for (int i = 0; i < N; i++) {
          for (int j = i+1; j < N; j++) {
              if (a[i] + a[j] == target) {
                  StdOut.println(a[i] + " " + a[j]);
              }
          }
      }
  }
  //find out the number pair that a[i] + a[j] = target;
  public static int count (int[ ] a) {
      int N = a.length;
      int cnt = 0;
      for (int i = 0; i < N; i++) {
          for (int j = i+1; j < N; j++) {
              if (a[i] + a[j] == target) {
                  cnt++;    
              } 
          }
      }
      return cnt;
  }
 
 public static void main(String[ ] args){
     In in = new In(args[target]);
     int[ ] a = in.readAllInts( );
     int cnt = count(a);
     StdOut.println(cnt);
 }
 
}

//Solution 2 binary search(time proportional N*logN)//
import java.until.Arrays;

public class TwoSum{
//print all the pairs (i, j) satisfy a[i] + a[j] = target; //    
  public static void printTwoSum(int[ ] a) {
      int N = a.length;
      Arrays.sort(a);
      for (int i = 0; i < N; i++) {
          int j = Arrays.binarySearch(a, target-a);
      }
  }  
//find out the pairs (i, j) satisfy a[i] + a[j] = target;//
  public static int count(int[ ] a) {
      int N = a.length;
      Arrays.sort(a);
      int cnt = 0;
      for (int i = 0; i< N; i++) {
          int j = Arrays.binarySearch(a, target-a[i]);
          if (j > i) {
          cnt++;
          }
       return cnt; 
      }
  }    
  public static void main(String[ ] args) {
      In in = new In(args[target]);
      int[ ] a = in.readAllInts( );
      int cnt = count(a);
      StdOut.println(cnt);
      
  }    
}



//solution 3 hashmap(time proportional to N)

public class TwoSum{
//find out the pair target(i,j)
  public int[ ] twosum(int[ ] numbers, int target){
      Map<Integer, Integer> map = new HashMap<>();
      for(int i = 0; i < numbers.length; i++){
      int a = numbers[i];
      if(map.containsKey(target - a)) {
        return new int[ ] {map.get(target -a)+1, i+1};//if find the pair, move to the next// 
      }
      map.put(a, i);//move out (a,i);
      }
  }
  public static void main(String[ ] args){
  In in = new In(args[target]);
  int[ ] array = in.readAllInts( );
  int pair[ ][ ] = twosum(a,target -a);
  StdOut.println(pair);     
  }
  
//SOLUTION 4. TWO POINERS(time o(n), space o(1))

public class TwoSum{
     public int[ ] TwoSum(int[ ] numbers, int target ) {
          int i = 0, j = numbers.length-1;//assume all inputs are loaded,    
          while(i < j) {
          int sum = numbers[i] + numbers[j];
          if(sum < target) {
            i++; 
          }
          else if(sum > target) {
            j--;
          }
          else {
            return new int[ ] { i + 1, j + 1 };
          }
          }
     throw new IllegalArgumentException("no such two sum pairs");
     }
     public static void main (String[ ] args) {
         In in = new In(args[target]);
         int[ ] array = in.readAllInts( );
         int pair[ ][ ] = TwoSum(i, j);
         StdOut.println(pair);  
    }
}

}