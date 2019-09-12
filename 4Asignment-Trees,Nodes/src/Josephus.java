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

        Node ptr1 = head, ptr2 = head; 

        while(ptr1.next != ptr1){
            int count = 1; 
            while(count != m) 
            { 
                ptr2 = ptr1; 
                ptr1 = ptr1.next; 
                count++; 
            } 
              
            ptr2.next = ptr1.next; 
            ptr1 = ptr2.next; 
        }
        return ptr1.data;
    }
}