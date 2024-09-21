package src.Sep_20_2024;

/*
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
        Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
*/


import java.util.Arrays;

public class Exercise4 {

    static int[] nums= {1,2,3,4,5,6,7};

    public static void rotate_array(int n){

        //int i=0;
        int len=nums.length;
        int[] temp_array = new int[len] ;


       // copy the nums array into temp array
        for(int i=0;i<len;i++){
            temp_array[i] = nums[i];
        }

        int j=0;
        for(int i=len-n;i<len;i++){
            nums[j]=temp_array[i];
         //   System.out.println("numsarray: "+Arrays.toString(nums));
            j++;
        }

        j=0;
        // another loop to copy the initial set of values to the nums array
        for(int i=n;i<len;i++){
            nums[i]=temp_array[j];
            j++;
        }

        System.out.println("input array: "+Arrays.toString(temp_array));
        System.out.println("output array: "+Arrays.toString(nums));
    }

    public static void main(String[] args) {

        int rotation_key = 17;
        if(rotation_key>0 && rotation_key<nums.length) {
            rotate_array(rotation_key);
        }
        else if(rotation_key>nums.length) {
            rotate_array(rotation_key%nums.length);
        }
        else{
            System.out.println("Rotation key is negative ");
        }
    }
}
