import java.util.Date;

public class App {
    public static void main(String[] args) throws Exception {
        Pow p = new Pow();
        
        Date start = new Date();
        int rounds = 0;
        double time;
        Date end;

        do{
            double r = p.solve(10,10);
            end = new Date();
            rounds++;
        } while(end.getTime()-start.getTime() < 1000);
        time = (double)(end.getTime()-start.getTime())/rounds;
        System.out.println("Milliseconds per round: " + time);
        
        
        System.out.println(p.solve(10, 10));
    }
}