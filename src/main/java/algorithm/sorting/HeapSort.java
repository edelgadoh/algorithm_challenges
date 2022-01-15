package algorithm.sorting;

public class HeapSort {

    public void sort(int[] array){
        int n = array.length;
        for(int i=n/2; i>=0; i--){
            maxHeapify(array, i, n-1);
        }
        for(int i=n-1; i>0; i--){
            swap(array,0, i);
            maxHeapify(array, 0, i-1);
        }

    }

    private void maxHeapify(int[] array, int x, int n){
        int left = x*2+1;
        int right = x*2+2;
        int k = x;
        if(left <= n && array[k] < array[left]){
            k = left;
        }
        if(right <= n && array[k] < array[right]){
            k = right;
        }
        if(k != x){
            swap(array, x, k);
            maxHeapify(array, k, n);
        }

    }

    private void swap(int[] array, int x, int k) {
        int temp = array[x];
        array[x] = array[k];
        array[k] = temp;
    }

}
