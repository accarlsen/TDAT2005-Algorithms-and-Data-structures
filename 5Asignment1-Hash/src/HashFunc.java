import java.nio.charset.Charset;
import java.util.*;

public class HashFunc {

    //fields
    public int tableSize;
    public int collisions = 0;
    public ArrayList<Node> table = new ArrayList<Node>();

    //constructor
    public HashFunc(int tableSize){
        this.tableSize = this.getNearestPrime( (int) (tableSize * 1.2));

        for(int i = 1; i < this.tableSize; i++){
            table.add(new Node());
        }
    }

    //methods
    public boolean addToHashTable(String s){
        int index = this.stringToHash(s);

        if(table.get(index).data == null){
            table.get(index).data = s;   //Adds String to hashed index
        }
        else{
            collisions++;
            Node tempN = table.get(index);
            System.out.println("Collision: " + tempN.data);
            while(tempN.next != null){
                System.out.println("Collision: " + tempN.data + " & " + tempN.next.data);
                tempN = tempN.next;
                collisions++;
            }

            tempN.next = new Node();    //Adds String to hashed index
            tempN.next.data = s;
        }
        return true;
    }

    public int stringToHash(String s){
        byte[] bytes = s.getBytes(Charset.forName("UTF-16"));
        int[] uniArray = new int[bytes.length];
        int tempI = 0;
        
        for(int i = 0; i < bytes.length; i++){
            uniArray[i] = bytes[i];
            tempI += uniArray[i]*(i+1);
        }
        return (tempI%tableSize);
    }

    public int searchHashTable(String s){
        for(int i = 0; i < table.size(); i++){
            if(table.get(i).data != null && table.get(i).data.equals(s)){
                return i;
            }
        }
        return -1;
    }

    public int getNearestPrime(int size) {
        boolean prime = true;
        do{
            prime = true;
            for(int i = 2; i <= (int)Math.sqrt(size); i++){
                if(size%i == 0){
                    prime = false;
                    size++;
                    break;
                }
            }
        }while(!prime);
        return size;
    }
    
    static class Node 
    { 
        public String data;
        public Node next;
        public Node() {}
    }
}