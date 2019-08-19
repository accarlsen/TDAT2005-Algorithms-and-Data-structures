import java.util.concurrent.ThreadLocalRandom;

public class Stocks{
    //fields

    //constructor
    public Stocks(){}

    //methods
    public int[] optimizeStocks(int[] rate){
        int largestProfit = 0; // 1
        int buyDate = 0; // 1
        int sellDate = 0; // 1 
        
        for(int i = 0; i < rate.length-1; i++) { //Buy // 1, 2n
            for(int u = i+1; u < rate.length; u++) { //Sell //3n
                int a = rate[u] - rate[i]; //4n
                if(a > largestProfit) {		//1n
                    largestProfit = a;		//1n
                    buyDate = i+1;		//1n
                    sellDate = u+1;		//1n
                }
            }
        }

        int[] returnArray = {largestProfit, buyDate, sellDate};
        return returnArray;
    }

    public int[] createRandomRateArray(int num){
        int[] rateArray = new int[num];
        for(int i = 0; i < num; i++){
            rateArray[i] = ThreadLocalRandom.current().nextInt(-10, 10 + 1);
        }
        return rateArray;
    }
}