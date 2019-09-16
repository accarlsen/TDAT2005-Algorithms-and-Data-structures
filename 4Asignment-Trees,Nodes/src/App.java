import java.util.Date;

public class App {
    public static void main(String[] args) throws Exception {
        
        Josephus j = new Josephus();
        int result;
        
        Date start = new Date();
        int rounds = 0;
        double time;
        Date end;
        do{
            result = j.kill(101,7);
            end = new Date();
            rounds++;
        } while(end.getTime()-start.getTime() < 1000);
        time = (double)(end.getTime()-start.getTime())/rounds;
        System.out.println(time);
        System.out.println(result);
    }
}