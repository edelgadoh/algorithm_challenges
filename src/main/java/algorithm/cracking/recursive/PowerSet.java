package algorithm.cracking.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a method to return all subsets of a set.
 */
public class PowerSet {

    public List<List<Integer>> allSubsets(List<Integer> inputSet) {

        if (inputSet == null) {
            return List.of(List.of());
        }

        List<List<Integer>> result = new ArrayList<>();
        int totalSubSets = (int) Math.pow(2, inputSet.size());
        for (int i = 0; i < totalSubSets; i++) {
            var localSubSet = parseIntToBinary(i, inputSet);
            result.add(localSubSet);
        }
        return result;
    }

    private List<Integer> parseIntToBinary(int i, List<Integer> inputSet) {
        List<Integer> localSubSet = new ArrayList<>();
        var index = 0;
        for (var key = i; key > 0; key = key / 2) {
            if (key % 2 == 1) { // it's odd, then consider it!
                localSubSet.add(inputSet.get(index));
            }
            index++;
        }
        return localSubSet;
    }

}
