import java.util.Date;

public class App {
    public static void main(String[] args) throws Exception {
        Pow p = new Pow();
        Pow2 p2 = new Pow2();
        
        Date start = new Date();
        int rounds = 0;
        double time;
        Date end;

        do{
            double r = p.solve(2,4);
            end = new Date();
            rounds++;
        } while(end.getTime()-start.getTime() < 1000);
        time = (double)(end.getTime()-start.getTime())/rounds;
        System.out.println("Milliseconds per round p: " + time);
        
        
        System.out.println(p.solve(2, 4));


        Date start1 = new Date();
        int rounds1 = 0;
        double time1;
        Date end1;

        do{
            double r = p2.solve(2,4);
            end1 = new Date();
            rounds1++;
        } while(end1.getTime()-start1.getTime() < 1000);
        time1 = (double)(end1.getTime()-start1.getTime())/rounds1;
        System.out.println("Milliseconds per round p2: " + time1);
        
        
        System.out.println(p2.solve(2, 4));
    }
}