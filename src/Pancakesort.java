import java.io.*;
import java.util.*;

public class Pancakesort {

  static int[] pancakeSort(int[] arr) {
    
    for(int i =arr.length-1; i>= 0; i--) {
      int pos = findNextLargestElement(arr, i); // 4 3
      flip(arr,pos); // [5,1,...] // 0,2 // 4,.. 
      flip(arr, i);
    }
    return arr;
  }z
  
  
  
  static int findNextLargestElement(int[] arr, int k) {
    
    int result = Integer.MIN_VALUE;
    for(int i =0; i<= k; i++) {
      result = Math.max(arr[i], result);
    }
    return result;
  }  
  
  static void flip(int[] arr, int k) {
    int left = 0; 
    int right = k-1;
    while(left<right) {
      int tmp = arr[right];
      arr[right] = arr[left];
      arr[left] = tmp;
      left++;
      right--;
    }
  }
  
  

  //[1,5,4,3,2] -> [5,1,4,3,2] -> [2,3,4,1,5]
  //[4,3,2,1,5] -> [1,2,3,4,5]
  
  public static void main(String[] args) {
      int[] arr = new int[]{1,2,3,4};
       flip(arr, 2);
       for(int elem: arr) {
           System.out.print(elem);
       };
  }

}