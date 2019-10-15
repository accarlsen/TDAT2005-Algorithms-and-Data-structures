import java.io.*;
import java.util.ArrayList;

public class UnweightedGraphs{

    //fields
    public int numNodes;
    public int numEdges;
    public int[][] graph;
    public ArrayList<Node> nodeList = new ArrayList<Node>();
    public ArrayList<EdgeNode> egdeNodeList = new ArrayList<EdgeNode>();

    static class Node{
        public int index;
        public ArrayList<EdgeNode> edgesOut = new ArrayList<EdgeNode>(); //X
        public Node parent; 
        public boolean visited = false;
        public int distance = 0;

        public Node(int index){
            this.index = index;
        }
    }
    static class EdgeNode{
        public int index;
        public int capacity; //x
        public int capacityUsed = 0;
        public Node next; //x
        public Node last; //x

        public EdgeNode(int index){
            this.index = index;
        }
    }

    //constructor
    public UnweightedGraphs(File file) throws IOException{
        this.graph = readGraphFromFile(file);

        for(int i = 0; i < numNodes; i++){
            nodeList.add(new Node(i));
        }
        for(int i = 0; i < numEdges; i++){
            egdeNodeList.add(new EdgeNode(i));
        }
        for(int i = 0; i < graph.length; i++){
            egdeNodeList.get(graph[i][0]).capacity = graph[i][2];               //map capacity
            egdeNodeList.get(graph[i][0]).next = nodeList.get(graph[i][1]);     //map next
            egdeNodeList.get(graph[i][1]).last = nodeList.get(graph[i][0]);     //map last

            nodeList.get(graph[i][0]).edgesOut.add(egdeNodeList.get(graph[i][1]));  //map edges out
        }
    }
    

    //methods
    public void breadthFirstSearch(int index){
        Node start = nodeList.get(index);
        ArrayList<Node> queue = new ArrayList<Node>();
        queue.add(start);
        start.visited = true;

        while(queue.size()> 0){
            Node n = queue.get(queue.size()-1);
            queue.remove(queue.size()-1);
            
            for(int i = 0; i < n.edgesOut.size(); i++){
                if(n.edgesOut.get(i).next.visited == false){
                    Node nextN = n.edgesOut.get(i).next;
                    nextN.distance += n.distance +1;

                    nextN.parent = n;
                    nextN.visited = true;
                    queue.add(nextN);
                }
            }

        }
    }

    public int[][] readGraphFromFile(File file) throws IOException{
        BufferedReader bf = new BufferedReader(new FileReader(file));

        String line;
        line = bf.readLine().trim();
        for (int i = 0; i < line.length(); i++) {
            if(line.charAt(i) == ' ' && line.charAt(i-1) == ' ') line = line.substring(0, i-1) + line.substring(i, line.length());
        }

        String[] thisLine = line.split(" ");
        int numNodes = Integer.parseInt(thisLine[0]);
        int numEdges = Integer.parseInt(thisLine[1]);
        this.numNodes = numNodes;
        this.numEdges = numEdges;
        
        int[][] returnTable = new int[numEdges][3];
        for(int i = 0; i < numEdges; i++){
            line = bf.readLine().trim();
            for (int u = 0; u < line.length(); u++) {
                if(u != 0 && line.charAt(u) == ' ' && line.charAt(u-1) == ' '){
                    line = line.substring(0,u-1) + line.substring(u, line.length());
                    u--;
                }
            }
            thisLine = line.split(" ");

            returnTable[i][0] = Integer.parseInt(thisLine[0]);
            returnTable[i][1] = Integer.parseInt(thisLine[1]);
            returnTable[i][2] = Integer.parseInt(thisLine[2]);

        }
        bf.close();
        return returnTable;
    }

    public void printUG(){
        System.out.println("Node, parent, distance");
        for(int i = 0; i < numNodes; i++){
            if(nodeList.get(i).parent != null){
                System.out.println(i + ", " + nodeList.get(i).parent.index + ", " + nodeList.get(i).distance);
            }
            else{
                System.out.println(i + ",  , " + nodeList.get(i).distance);
            }
        }
    }
}