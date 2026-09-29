package algorithm.exercises;

public class NextPermutationNumber {

    public void nextPermutation(int[] nums) {
        //[1,5,1,3,2]
        //     i      find the pivot
        //         j  find the first bigger number, (i+1, j) is in descending order!
        //[1,5,2,3,1] swap(i, j)
        //[1,5,2,1,3] reverse(i+1, n-1) to get the lowest permutation (since it was in descending order)
        int breakPoint = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                breakPoint = i;
                break;
            }
        }

        if (breakPoint == -1) {
            reverse(nums, 0, nums.length - 1);
        } else {
            int biggerIndex = -1;
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] > nums[breakPoint]) {
                    biggerIndex = i;
                    break;
                }
            }
            swap(nums, breakPoint, biggerIndex);
            reverse(nums, breakPoint + 1, nums.length - 1);
        }

    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
