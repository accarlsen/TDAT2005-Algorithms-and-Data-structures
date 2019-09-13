import javax.xml.soap.Node;

public class Josephus{

    //fields

    //methods

    static class Node 
    { 
        public int data ; 
        public Node next; 
        public Node( int data ) 
        { 
            this.data = data;
        } 
    } 

    public int kill(int n, int m){
        
        Node head = new Node(1);
        Node prev = head;
        for(int i = 2; i <= n; i++){
            prev.next = new Node(i);    //connects the current node to the next
            prev = prev.next;
        }
        prev.next = head; //makes the list circular

        Node p1 = head, p2 = head; 

        while(p1.next != p1){
            int count = 1; 
            while(count != m) 
            { 
                p2 = p1;
                p1 = p1.next; 
                count++; 
            } 
              
            p2.next = p1.next; 
            p1 = p2.next; 
        }
        return p1.data;
    }
}