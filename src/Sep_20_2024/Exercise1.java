package src.Sep_20_2024;


/*
Problem statement
Best Time to Buy and Sell Stock
You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0. Buying date has to precede the selling date

Input: prices = [7,1,5,3,6,4]
Output: 5
*/

public class Exercise1 {

    static int[] stock_price = {7,1,5,3,6,4};

    static int return_when_to_buy(){

        int original_profit = 0;
        int recommended_buy_day = 0;
        int recommended_sell_day = 0;

        int i,j;

        for (i=0;i<stock_price.length;i++){
            int buy_price = stock_price[i];
            //System.out.println("buy day"+i+" at price "+buy_price);

            for (j=i+1;j<stock_price.length;j++){
                int sell_price = stock_price[j];
                //System.out.println("sell day"+j+" at sell price "+sell_price);
                int temp_profit = sell_price - buy_price;
               // System.out.println("temp profit"+temp_profit);

                if(temp_profit > original_profit){
                    original_profit = temp_profit;
                    recommended_buy_day=i;
                    recommended_sell_day=j;
                  /*  System.out.println("original profit changed to "+original_profit);
                    System.out.println("recommended_buy_day "+recommended_buy_day);
                    System.out.println("recommended_sell_day  "+recommended_sell_day);
                    */
                }
            }


        }

        return original_profit;
    }

    public static void main(String[] args) {

        System.out.println(return_when_to_buy());
    }
}
