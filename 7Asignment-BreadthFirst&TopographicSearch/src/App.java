import java.io.File;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {

        
        File file = new File("D:/AlexanderSkole/NTNU 2019Høst/Algoritmer og Datastrukturer/TDAT2005-Algorithms-and-Data-structures/7Asignment-BreadthFirst&TopographicSearch/src/L7g1");
        UnweightedGraphs ug = new UnweightedGraphs(file);
        
        ug.breadthFirstSearch(5);
        ug.printUG();

        /*ArrayList<Integer> ai = ug.topologicalSort();
        for(int i = ai.size()-1; i >= 0; i--){
            System.out.println(ai.get(i));
        }*/
    }
}