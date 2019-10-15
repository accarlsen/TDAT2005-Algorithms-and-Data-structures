import java.io.File;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {

        
        File file = new File("D:/AlexanderSkole/NTNU 2019Høst/Algoritmer og Datastrukturer/TDAT2005-Algorithms-and-Data-structures/7Asignment-BreadthFirst&TopographicSearch/src/L7g5");
        UnweightedGraphs ug = new UnweightedGraphs(file);
        
        ug.breadthFirstSearch(5);
        ug.printUG();
    }
}