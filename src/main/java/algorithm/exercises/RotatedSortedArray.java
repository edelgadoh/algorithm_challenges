package algorithm.exercises;

public class RotatedSortedArray {

    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        if (start > end) return -1;

        int middle = (start + end) / 2;
        if (nums[middle] == target) return middle;

        if (nums[end] < nums[middle]) {
            //left part is sorted
            if (nums[start] <= target && target < nums[middle]) { // it's in the left part
                return binarySearch(nums, start, middle - 1, target);
            } else {
                return binarySearch(nums, middle + 1, end, target);
            }
        } else {
            //right part is sorted
            if (nums[middle] < target && target <= nums[end]) { // it's in the right part
                return binarySearch(nums, middle + 1, end, target);
            } else {
                return binarySearch(nums, start, middle - 1, target);
            }
        }

    }
}
