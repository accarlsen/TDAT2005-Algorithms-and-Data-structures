import java.util.ArrayList;

public class QuickSort{

    //fields
    public int partSize;
    public int numCall = 0;
    public int numBCall = 0;

    //constructor
    public QuickSort(int partSize){
        this.partSize = partSize;
    }

    //methods
    public ArrayList<Integer> sortQuick(ArrayList<Integer> array){  
        numCall++;
        if(array.size() > partSize){
            int lim = array.get(array.size()/2);
            int limRow = 1;
            int numLimCopies = 0;
            while(lim == 1 && limRow < array.size()-2){
                limRow++;
                lim = array.get(array.size()- limRow);
            }
            ArrayList<Integer> arrayP1= new ArrayList<Integer>();
            ArrayList<Integer> arrayP2= new ArrayList<Integer>();


            for(int i = 0; i < array.size(); i++){
                if(array.get(i) < lim){
                    arrayP1.add(array.get(i));
                }
                else if(array.get(i) > lim){
                    arrayP2.add(array.get(i));
                }
                else if(array.get(i) == lim){
                    numLimCopies++;
                }
            }
            
            arrayP1 = this.sortQuick(arrayP1);
            arrayP2 = this.sortQuick(arrayP2);
            ArrayList<Integer> retVal = new ArrayList<Integer>();

            for(int i = 0; i < arrayP1.size(); i++){
                retVal.add(arrayP1.get(i));
            }
            for(int i = 0; i < numLimCopies; i++){
                retVal.add(lim);
            }
            for(int i = 0; i < arrayP2.size(); i++){
                retVal.add(arrayP2.get(i));
            }

            return retVal;
        }
        else{
            return this.bubbleSort(array);
        }
    }

    public ArrayList<Integer> bubbleSort(ArrayList<Integer> array){
        numBCall++;
        int n = array.size();
        for(int i = 0; i < n-1; i++){
            for(int u = 0; u < n-i-1; u++){
                if(array.get(u) > array.get(u+1)){
                    int temp = array.get(u);
                    array.set(u, array.get(u+1));
                    array.set(u+1, temp);
                }
            }
        }
        return array;
    }

    public boolean testSortA(ArrayList<Integer> array){
        for(int i = 0; i < array.size()-1; i++){
            if(array.get(i) > array.get(i+1)){
                return false;
            }
        }
        return true;
    }
}