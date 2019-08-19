package app;

public class App {
    public static void main(String[] args) throws Exception {
        int[] rate = {-1,2,-7,-5,-3,-4,-2,-3,-8}; // 1
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
        System.out.println("Profit: " + largestProfit + ", buy date: " + buyDate + ", sell date: " + sellDate);
    }
}