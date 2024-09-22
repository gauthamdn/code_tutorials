package src.Sep_20_2024;

/*
There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.
Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique.

Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
Output: 3
*/


import java.util.Arrays;

public class Exercise5_1 {

   static int[] gas= {1,2,3,4,5};
   static int[] cost={3,4,5,1,2};

    /*
    test data for no possible solutions
    static int[] gas= {2,3,4};
    static int[] cost={4,5,1};
   */
    public static void main(String[] args) {

        int total_gas_in_car=0;
        int sumofgas=0;
        int sumofcost=0;
        int starting_station=0;

        for(int i=0;i<gas.length;i++){
            int[] temp_gas = rotate_array(i,gas);
            int[] temp_cost = rotate_array(i,cost);

            find_circuit(temp_gas,temp_cost);
        }

    }

    private static int[] rotate_array(int n, int[] nums) {

        int len=nums.length;
        int[] temp_array = new int[len] ;

        // copy the nums array into temp array
        for(int i=0;i<len;i++){
            temp_array[i] = nums[i];
        }

        int j=0;
        for(int i=len-n;i<len;i++){
            nums[j]=temp_array[i];
            j++;
        }

        j=0;
        // another loop to copy the initial set of values to the nums array
        for(int i=n;i<len;i++){
            nums[i]=temp_array[j];
            j++;
        }

        // System.out.println("input array: "+ Arrays.toString(temp_array));
        // System.out.println("output array: "+Arrays.toString(nums));
        return nums;
    }




    public static void find_circuit(int[] gas,int[] cost) {
        int total_gas_in_car = 0;
        int starting_station = 0;

        for (int i = 0; i < gas.length; i++) {
            total_gas_in_car = total_gas_in_car + gas[i] - cost[i];
            if (total_gas_in_car < 0) {
                //  System.out.println("With Starting station :"+i+" you cannot do a circuit");
                total_gas_in_car = 0;
                starting_station += 1;
                break;
            }
            System.out.println("starting_station " + starting_station + " gas position: " + gas[starting_station] + "cost postiion: " + cost[starting_station]);
        }
    }


}
