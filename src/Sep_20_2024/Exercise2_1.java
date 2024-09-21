package src.Sep_20_2024;

/*
Best Time to Buy and Sell Stock variation
Same problem above. But, you can do multiple buys & sells. Buy should always be followed by sell. Whats the max profit you can make?
Input: prices = [7,1,5,3,6,4]
Output: 7
*/


public class Exercise2_1 {
    static int[] stock_price = {7,1,5,3,6,4};

    public static int max_profits(){

        int i,j;

        int total_profit=0;
        int recommended_buy_day = 0;
        int recommended_sell_day = 0;


        for(i=0;i<stock_price.length;i++){
            int buy_price = stock_price[i];
            int original_profit = 0;
            for(j=i+1;j<stock_price.length;j++){
                int sell_price = stock_price[j];
                int temp_profit = sell_price - buy_price;
                if(temp_profit>original_profit){
                    //total_profit += profit;
                    original_profit = temp_profit;
                    recommended_buy_day = i;
                    recommended_sell_day = j;
                      System.out.println("original profit changed to "+original_profit);
                    System.out.println("recommended_buy_day "+recommended_buy_day);
                    System.out.println("recommended_sell_day  "+recommended_sell_day);

                }
               /* if(original_profit>0){
                    System.out.println("Buy on day"+recommended_buy_day+" at price "+buy_price+" and sell on day"+recommended_sell_day+" at price "+sell_price+" and get profit "+original_profit);
                }*/
            }
            total_profit += original_profit;
            System.out.println("Total profit is "+total_profit);
        }

        return total_profit;
    }

    public static void main(String[] args) {
        System.out.println(max_profits());
    }


}
