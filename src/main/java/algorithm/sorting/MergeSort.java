package algorithm.sorting;

public class MergeSort {

    public void sort(int[] array){
        sort(array, array.length);
    }

    private void sort(int[] array, int n){

        if(n < 2) return;

        int middle = n/2;
        int[] left = new int[middle];
        int[] right = new int[n-middle];
        for(int i=0; i< middle; i++){
            left[i] = array[i];
        }
        for(int j=middle; j< n; j++){
            right[j-middle] = array[j];
        }
        sort(left, middle);
        sort(right, n- middle);
        merge(array, left, right);

    }

    private void merge(int[] array, int[] left, int[] right) {
        int i=0;
        int j=0;
        int k=0;

        while(i < left.length && j < right.length){
            if(left[i] <= right[j]){
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }
        while(i < left.length){
            array[k++] = left[i++];
        }
        while(j < right.length){
            array[k++] = right[j++];
        }

    }

}
