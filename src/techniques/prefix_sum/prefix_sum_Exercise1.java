package src.techniques.prefix_sum;

/*Given an array nums, answer multiple queries about the sum of elements within a specific range [i, j]

Example:

Input: nums = [1, 2, 3, 4, 5, 6], i = 1, j = 3

Output: 9*/

import java.util.Arrays;

public class prefix_sum_Exercise1 {

    static int[] inputList = {1, 2, 3, 4, 5, 6};
    static int start = 1;
    static int end = 5;

   public static void main(String[] args) {

       int[] prefixSumArray = calculatePrefixSum(inputList);

       System.out.println("Input Array : "+Arrays.toString(inputList));

       System.out.println("PrefixSum Array : "+Arrays.toString(prefixSumArray));

       System.out.println("Output: Sum Of Elements from "+start+" to "+end+" is "+ calculateSumofElements(prefixSumArray,start, end));


   }

    private static int calculateSumofElements(int[] prefixSumArray,int start, int end) {
       if(prefixSumArray.length!=0) {
           int sumOfElements = prefixSumArray[end] - prefixSumArray[start - 1];
           return sumOfElements;
       }
       else return 0;

    }

    private static int[] calculatePrefixSum(int[] inputList) {

       int[] tempArray = new int[inputList.length];
       for(int i = 0; i < inputList.length; i++) {
           if(i == 0 )
               tempArray[i] = inputList[i];
           else
            tempArray[i] = tempArray[i-1] + inputList[i];
       }

       return tempArray;
    }


}
