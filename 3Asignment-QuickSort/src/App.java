import java.util.ArrayList;
import java.util.Date;

public class App {
    public static void main(String[] args) throws Exception {

        int checkSum = 0;
        ArrayList<Integer> n = new ArrayList<Integer>();
        for(int i = 0; i < 10000; i++){
            int a = (int) (Math.random() * 100 + 1);
            n.add(a);
            checkSum += a;
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
        } while(end.getTime()-start.getTime() < 1);
        time = (double)(end.getTime()-start.getTime())/rounds;
        System.out.println("Milliseconds per round: " + time);

        
        //Test A boiisis
        System.out.println("Test A: " + qs.testSortA(result));


        //Test B boisisisisiis
        int newCheckSum = 0;
        boolean testB = false;
        for(int i = 0; i < result.size(); i++){
            newCheckSum += result.get(i);
        }

        if(checkSum == newCheckSum){
            testB = true;
        }

        System.out.println("Test B: " + testB);
    }
}