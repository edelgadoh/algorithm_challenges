package algorithm.exercises;

import java.util.ArrayList;
import java.util.List;

public class AllSubSets {

    public List<List<Integer>> subsets(int[] elements) {

        List<List<Integer>> allSubSets = new ArrayList<>();
        int size = elements.length;
        int totalSets = (int) Math.pow(2, size);
        int i = 0;
        int[] binaryCounter = new int[size];
        while (i < totalSets) {
            List<Integer> localSubSet = new ArrayList<>();
            for (int j = 0; j < binaryCounter.length; j++) {
                if (binaryCounter[j] == 1) {
                    localSubSet.add(elements[j]);
                }
            }
            allSubSets.add(localSubSet);

            incrementBinary(binaryCounter);
            i++;
        }

        return allSubSets;

    }

    public void incrementBinary(int[] array) {
        int carrier = 1;
        for (int i = array.length - 1; i >= 0; i--) {
            int value = carrier + array[i];
            if (value > 1) {
                carrier = 1;
            } else {
                carrier = 0;
            }
            array[i] = value % 2;
        }
    }

}
