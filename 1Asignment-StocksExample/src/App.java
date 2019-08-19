import java.util.Date;

public class App {
    public static void main(String[] args) throws Exception {
        //int[] rate = {-1,2,-7,-5,-3,-4,-2,-3,-8};

        Stocks s = new Stocks();
        int[] rate = s.createRandomRateArray(100);
        
        Date start = new Date();
        int rounds = 0;
        double time;
        Date end;

        do{
            int[] r = s.optimizeStocks(rate);
            end = new Date();
            rounds++;
        } while(end.getTime()-start.getTime() < 1000);
        time = (double)(end.getTime()-start.getTime())/rounds;
        System.out.println("Milliseconds per round: " + time);
    }
}