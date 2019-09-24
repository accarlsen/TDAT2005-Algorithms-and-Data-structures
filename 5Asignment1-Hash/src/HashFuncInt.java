public class HashFuncInt {

    //fields
    public int tableSize;
    public int collisions = 0;
    public Integer[] table;

    //constructor
    public HashFuncInt(int tableSize){
        this.tableSize = this.getNearestPrime( (int) (tableSize * 1.2));
        table = new Integer[this.tableSize];
    }

    //methods
    public boolean addToHashTable(int s){
        int index = this.intToHash1(s);
        boolean added = false;

        if(table[index] == null){
            table[index] = s;
            return true;
        }
        else{
            collisions++;
            while(!added){
                collisions++;
                index = this.intToHash2(index);
                if(table[index] == null){
                    table[index] = s;
                    added = true;
                }
            }
        }
        return added;

        /*
        do{
            if(table[index] == null){
                table[index] = s;   //Adds String to hashed index
                added = true;
            }
            else{
                collisions++;
                index = this.intToHash2(s);
            }
        }while(!added);*/

    }

    public int intToHash1(int s){
        return Math.abs(s%tableSize);
    }
    public int intToHash2(int s){
        return ((s%(tableSize-1)) +1) % tableSize;
    }

    public int searchHashTable(int s){
        int index = this.intToHash1(s);
        boolean found = false;
        int counter = 0;
        do{
            if(table[index] == s){
                return index;   //Adds String to hashed index
            }
            else if(counter <= tableSize && table[index] != s){
                index += this.intToHash2(s);
                counter++;
            }
        }while(!found);
        return -1;
    }

    public int getNearestPrime(int size) {
        boolean prime = true;
        int qed = (int)Math.sqrt(size);
        do{
            prime = true;
            for(int i = 2; i <= qed ; i++){
                if(size%i == 0){
                    prime = false;
                    size++;
                    break;
                }
            }
        }while(!prime);
        return size;
    }
}