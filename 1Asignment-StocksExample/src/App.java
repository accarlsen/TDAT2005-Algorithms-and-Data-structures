public class App {
    public static void main(String[] args) throws Exception {
        int[] rate = {-1,2,-7,-5,-3,-4,-2,-3,-8}; // 1

        Stocks s = new Stocks();
        int[] ans = s.optimizeStocks(rate);
        System.out.println("Profit: " + ans[0] + ", buy date: " + ans[1] + ", sell date: " + ans[2]);
    }
}