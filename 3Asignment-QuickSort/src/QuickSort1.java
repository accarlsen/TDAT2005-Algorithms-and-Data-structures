import javax.swing.text.PlainView;

public class QuickSort1{

    //fields

    //constructor

    //methods



    public void sortQuick(int[] array, int low, int high){
        if(low < high){
            int pi = partition(array, low, high);

            sortQuick(array, low, pi-1); 
            sortQuick(array, pi+1, high); 
        }
    }


    public int partition(int[] array, int low, int high){
        int lim = array[high];
        int l = low-1;

        for(int i = low; i < high; i++){
            if(array[i] < lim){
                l++;

                int temp = array[i];
                array[i] = array[l];
                array[l] = temp;
            }
        }

        int temp = array[l+1];
        array[l+1] = array[high];
        array[high] = temp;

        return l+1;
    }






    public int[] bubbleSort(int[] array){
        //numBCall++;
        int n = array.length;
        for(int i = 0; i < n-1; i++){
            for(int u = 0; u < n-i-1; u++){
                if(array[u] > array[u+1]){
                    int temp = array[u];
                    array[u] = array[u+1];
                    array[u+1] = temp;
                }
            }
        }
        return array;
    }

    public boolean testSortA(int[] array){
        for(int i = 0; i < array.length-1; i++){
            if(array[i] > array[i+1]){
                return false;
            }
        }
        return true;
    }

}