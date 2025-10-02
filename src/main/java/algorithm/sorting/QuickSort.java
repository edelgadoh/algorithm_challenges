package algorithm.sorting;

public class QuickSort {

    public void sort(int array[]){
        sort(array, 0, array.length-1);
    }

    private void sort(int array[], int begin, int end){
        if(begin < end){
            int index = partition(array, begin, end);
            sort(array, begin, index-1);
            sort(array,index+1, end);
        }
    }

    private int partition(int array[], int begin, int end){
        int pivot = array[end];
        int i = begin-1;

        for(int j=begin; j< end; j++){
            if(array[j] <= pivot){
                i++;
                swapValues(array, i, j);
            }
        }

        swapValues(array, i+1, end);

        return i+1;

    }

    private void swapValues(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
