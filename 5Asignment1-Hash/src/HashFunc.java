import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.LinkedList;

import javax.xml.soap.Node;

public class HashFunc {

    //fields
    public int tableSize;
    public Node table = new Node(0);
    public Node tempN = table;

    //constructor
    public HashFunc(int tableSize){
        this.tableSize = this.getNearestPrime(tableSize);

        for(int i = 0; i < tableSize; i++){
            Node tempN2 = tempN;
            tempN.next = new Node(i);
            tempN = tempN.next;
            tempN.prev = tempN2;

        }
    }

    //methods
    public boolean addToHashTable(String s){
        int index = this.hashKey(this.stringToKey(s));

        this.goToNode(index);   //Navigates to correct Node
        table.object.add(s);    //Adds String to hashed index
        this.resetNode(index);  //Navigates back to origo

        return true;
    }

    public BigInteger stringToKey(String s){
        BigInteger retVal = new BigInteger("0");
        byte[] bytes = s.getBytes(Charset.forName("UTF-8"));
        int[] uniArray = new int[bytes.length];
        String tempS = "";
        
        for(int i = 0; i < bytes.length; i++){
            uniArray[i] = bytes[i];
            uniArray[i] = (int) Math.pow( uniArray[i] * 7, i+1);
            tempS += uniArray[i];
        }
        return retVal = retVal.add(new BigInteger(tempS));
    }
    
    public int hashKey(BigInteger bi){
        return (bi.mod(new BigInteger(Integer.toString(tableSize)))).intValue();
    }

    public boolean searchHashTable(String s){
        boolean found = false;
        int counter = 0;
        for(int i = 0; i < tableSize; i++){
            if(this.searchList(table.object, s)){
                this.resetNode(counter);
                return true;
            }
            else{
                table = table.next;
                counter++;
            }
        }
        return found;
    }

    //Support methods
    public static boolean checkPrime(int n) {
		int m = n/2;
		if(n == 0 || n == 1) {
			return false;
		} else {
			for(int i = 2; i <= m; i++) {
				if(n % i == 0) {
					return false;
				}
			}
		}
		return true;
    }

    public int getNearestPrime(int size) {
		boolean go = true;
		do {
			if(checkPrime(size)) {
				break;
			} else {
				size++;
			}
		} while (go);
		return size;
    }
    
    static class Node 
    { 
        public int index;
        public LinkedList<String> object = new LinkedList<String>(); 
        public Node next;
        public Node prev;
        public Node( int index ) { 
            this.index = index;
        }
    }

    public boolean goToNode(int target){
        for(int i = 0; i < target; i++){
            table = table.next;
        }
        return true;
    }

    public boolean resetNode(int target){
        for(int i = target; i > 0; i--){
            table = table.prev;
        }
        return true;
    }

    public boolean searchList(LinkedList<String> ls ,String searchword){
        boolean retVal = false;
        for(int i = 0; i < ls.size(); i++){
            if(searchword.equals(ls.get(i))){
                retVal = true;
            }
        }
        return retVal;
    }
    

}