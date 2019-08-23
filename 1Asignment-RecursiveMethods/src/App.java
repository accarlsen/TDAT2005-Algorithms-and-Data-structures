import java.util.Date;

public class App {
    public static void main(String[] args) throws Exception {
        Pow p = new Pow();
        Pow2 p2 = new Pow2();
        
        //Using Pow class' method, task 2.1-1

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

        //Using Pow2 class' method, task 2.2-3

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

        //Comparing to Java's Math.pow method

        Date start2 = new Date();
        int rounds2 = 0;
        double time2;
        Date end2;

        do{
            double r = Math.pow(2,4);
            end2 = new Date();
            rounds2++;
        } while(end2.getTime()-start2.getTime() < 1000);
        time2 = (double)(end2.getTime()-start2.getTime())/rounds2;
        System.out.println("Milliseconds per round p2: " + time2);
        
        
        System.out.println(Math.pow(2, 4));

    }
}