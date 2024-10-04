package src.techniques.prefix_sum.leetcode;

/*525. Contiguous Array
Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

Example 1:

Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
Example 2:

Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.


Constraints:
1 <= nums.length <= 105
nums[i] is either 0 or 1.*/

import java.util.Arrays;

public class Solution {
    static int[] nums = {0,1,1,1,1,0,1,0,1,0,1,1,1,1,0,1,0};
   //  static int[] nums = {0,1,0,1};
    //static int[] nums = {0,1,1,1,1,0,0,0};

    public static int findMaxLength(int[] nums) {
       int[] prefix_sum_array = new int[nums.length];
        prefix_sum_array = calculatePrefixSum(nums);

        System.out.println("Input: "+Arrays.toString(nums));
        System.out.println("PrefixSum: "+Arrays.toString(prefix_sum_array));

        int maxLength = 0;
        for(int i=0;i<prefix_sum_array.length;i++){
            for(int j=i+1;j<prefix_sum_array.length;j++){
                if(prefix_sum_array[i]==prefix_sum_array[j]){
                    int temp_len = j-i;
                    if(temp_len>maxLength){
                        maxLength = temp_len;
                        System.out.println("i= "+i+" j= "+j);
                    }
                }
            }
        }
        return maxLength;
    }

    private static int[] calculatePrefixSum(int[] prefix_sum_array) {

        // create a temp array of inputlength + 1 ( because 1st value need to assign to 0, else logic wont consider the first value in the input array
        int[] temp = new int[prefix_sum_array.length+1];
        int sum = 0;
        temp[0] = sum;
        for(int i = 0; i < prefix_sum_array.length; i++) {
         //   System.out.println("input: "+prefix_sum_array[i]);

            if(prefix_sum_array[i] == 0)
                sum += -1;
            else
                sum += 1;
            temp[i+1] = sum;
        }

        return temp;
    }

    public static void main(String[] args) {
        if(nums.length<2)
            System.out.println("maxlength is 0");
        else if(nums.length==2 && nums[0]!=nums[1])
            System.out.println("maxlength is 2");
        else
        System.out.println("maxlength is "+findMaxLength(nums));
    }
}
