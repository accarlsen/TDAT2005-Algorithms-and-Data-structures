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


        /*
        Array of 100:    0.0018721087620306388
        Array of 1000:   0.15673981191222572
        Array of 10000: 15.363636363636363

        Corresponds to the fact that O( n^2 )

        */
    }
}