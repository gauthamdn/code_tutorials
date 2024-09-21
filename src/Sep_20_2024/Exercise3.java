package src.Sep_20_2024;

/*
Remove Duplicates from Sorted Array
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
Return k.
Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
*/


import java.util.Arrays;

public class Exercise3 {

    public static int[] nums = {0,0,1,1,1,2,2,3,3,4};


    public static int remove_duplicates(int nums[]){

        int len=nums.length;
        int[] temp_array=new int[len];
        temp_array[0]=nums[0];

        int j=1;
        for (int i=1;i<len-1;i++){
            if(nums[i]!=nums[i+1]){
                temp_array[j]=nums[i+1];
                j++;
            }

        }
        for(int i=0;i<len;i++){
            nums[i]=temp_array[i];
        }
        //System.out.println("temp array: "+Arrays.toString(temp_array));
        return j;

       /*
       below Code if we want to create an array with just unique elements
       int[] temp_array2=new int[j];
        for(int i=0;i<temp_array2.length;i++){
            temp_array2[i]=temp_array[i];
        }
        System.out.println("temp array2: "+Arrays.toString(temp_array2));

        return j;
       */

    }

    public static void main(String[] args) {

        if(nums.length == 0 || nums.length == 1){
            System.out.println(nums.length+ " "+ Arrays.toString(nums));
            //System.out.println(Arrays.toString(nums));
        }
        else{
            System.out.println(remove_duplicates(nums)+" "+Arrays.toString(nums));
        }

    }
}
