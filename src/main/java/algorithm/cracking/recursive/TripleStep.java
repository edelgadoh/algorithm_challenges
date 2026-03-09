package algorithm.cracking.recursive;

import java.util.HashMap;
import java.util.Map;

/**
 * A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3
 * steps at a time. Implement a method to count how many possible ways the child can run up the
 * stairs.
 */
public class TripleStep {

    public int climbStairs(int n) {
        if (n == 0) return 0;
        Map<Integer, Integer> mapPaths = new HashMap<>();
        return findPaths(0, n, mapPaths);
    }

    /*
    findPaths(0, 3)
      findPaths(1, 3)                     + findPaths(2, 3)                      + findPaths(3, 3)
        findPaths(2, 3) + findPaths(3, 3)     findPaths(3, 3) + findPaths(4, 3)
    */
    private int findPaths(int i, int n, Map<Integer, Integer> mapPaths) {
        if (mapPaths.containsKey(i)) return mapPaths.get(i);

        if (i > n) return 0;
        if (i == n) {
            return 1;
        }
        int paths = findPaths(i + 1, n, mapPaths) + findPaths(i + 2, n, mapPaths) + findPaths(i + 3, n, mapPaths);
        mapPaths.put(i, paths);
        return paths;

    }

}
