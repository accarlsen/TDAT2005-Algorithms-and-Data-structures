import java.util.ArrayList;
import java.util.Date;

public class App {
    public static void main(String[] args) throws Exception {
        
        ArrayList<Integer> n = new ArrayList<Integer>();
        for(int i = 0; i < 1000000; i++){
            n.add((int) (Math.random() * 40 + 1));
        }

        QuickSort qs = new QuickSort(50);
        ArrayList<Integer> result = new ArrayList<Integer>();

        Date start = new Date();
        int rounds = 0;
        double time;
        Date end;
        do{
            result = qs.sortQuick(n);
            end = new Date();
            rounds++;
        } while(end.getTime()-start.getTime() < 1000);
        time = (double)(end.getTime()-start.getTime())/rounds;
        System.out.println("Milliseconds per round: " + time);
        
        
        //System.out.println(qs.sortQuick(n));
    }
}