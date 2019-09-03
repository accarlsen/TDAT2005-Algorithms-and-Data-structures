import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        
        ArrayList<Integer> n = new ArrayList<Integer>();
        for(int i = 0; i < 40; i++){
            n.add((int) (Math.random() * 40 + 1));
            System.out.println(n.get(i));
        }

        QuickSort qs = new QuickSort();
        qs.sortQuick(n);
        
        System.out.println(qs.sortQuick(n));
    }
}