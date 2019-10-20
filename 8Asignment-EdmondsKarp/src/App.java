import java.io.File;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {

        
        File file = new File("D:/AlexanderSkole/NTNU 2019Høst/Algoritmer og Datastrukturer/TDAT2005-Algorithms-and-Data-structures/7Asignment-BreadthFirst&TopographicSearch/src/L7g1");
        //UnweightedGraphs ug = new UnweightedGraphs(file);

        int graph[][] =new int[][] { 
            {0, 16, 13, 0, 0, 0}, 
            {0, 0, 10, 12, 0, 0}, 
            {0, 4, 0, 0, 14, 0}, 
            {0, 0, 9, 0, 0, 20}, 
            {0, 0, 0, 7, 0, 4}, 
            {0, 0, 0, 0, 0, 0}}; 
  
        //System.out.println("The maximum possible flow is " + ug.edmondsKarp(graph, 0, 5)); 
        
        //ug.printUG();
    }
}