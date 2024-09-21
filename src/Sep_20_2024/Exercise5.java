package src.Sep_20_2024;

/*
There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.
Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique.

Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
Output: 3
*/


import java.util.Arrays;

public class Exercise5 {

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
            sumofgas+=gas[i];
            sumofcost+=cost[i];
        }
        if(sumofgas<sumofcost) {
            System.out.println("No possible solutions for this input");
            return;
        }

        sumofgas = 0;
        sumofcost =0;
        for(int i=0;i<gas.length;i++){
           sumofgas+=gas[i];
           sumofcost+=cost[i];
           total_gas_in_car = total_gas_in_car + gas[i] - cost[i];
           if(total_gas_in_car<0){
               System.out.println("With Starting station :"+i+" you cannot do a circuit");
               total_gas_in_car=0;
               starting_station += 1;
           }

        }

        if(sumofgas<sumofcost)
            System.out.println("-1");
        else
            System.out.println("starting station: " +starting_station);

    }

}
