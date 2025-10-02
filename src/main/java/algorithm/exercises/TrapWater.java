package algorithm.exercises;

public class TrapWater {
    public int trap(int[] height) {

        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];

        for (int i = 0; i < height.length; i++) {
            if (i == 0) {
                maxLeft[i] = height[i];
            } else {
                maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
            }
            int j = height.length - i - 1;
            if (j == height.length - 1) {
                maxRight[j] = height[j];
            } else {
                maxRight[j] = Math.max(maxRight[j + 1], height[j]);
            }

        }

        int trapWater = 0;
        for (int i = 0; i < height.length; i++) {
            int minValue = Math.min(maxLeft[i], maxRight[i]);
            trapWater += Math.abs(minValue - height[i]);
        }

        return trapWater;

    }

}
