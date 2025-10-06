package algorithm.exercises;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class SocksLaundering {
    public int solution(int K, int[] C, int[] D) {
        var mapClean = new HashMap<Integer, Integer>();
        var mapDirty = new HashMap<Integer, Integer>();

        Arrays.stream(C).forEach(i -> mapClean.merge(i, 1, Integer::sum));
        Arrays.stream(D).forEach(i -> mapDirty.merge(i, 1, Integer::sum));

        AtomicInteger alreadyCleanPairs = new AtomicInteger();

        // first count already clean pairs
        mapClean.entrySet().stream().forEach(x -> {
            if (x.getValue() > 1) {
                var pairs = x.getValue() / 2;
                var newValue = x.getValue() % 2;
                alreadyCleanPairs.addAndGet(pairs);
                x.setValue(newValue);
            }
        });

        // then try to make pairs from clean + dirty
        AtomicInteger atomicK = new AtomicInteger(K);
        for (Map.Entry<Integer, Integer> entry : mapClean.entrySet()) {
            if (atomicK.get() == 0) break;
            if (entry.getValue() == 1) {
                int key = entry.getKey();
                if (mapDirty.getOrDefault(key, 0) > 0) {
                    mapDirty.merge(key, -1, Integer::sum);
                    alreadyCleanPairs.incrementAndGet();
                    atomicK.decrementAndGet();
                }
            }
        }

        // finally use remaining K to make pairs from dirty socks
        for (Map.Entry<Integer, Integer> entry : mapDirty.entrySet()) {
            if (atomicK.get() < 2) break;
            var count = entry.getValue();// 4
            var possiblePairs = count / 2;// 4/2 = 2   -> because I need to wash 2 dirty socks to be 1 pair
            var canWash = atomicK.get() / 2;// k=2, 2/2=1   -> this is the minimum
            var use = Math.min(possiblePairs, canWash);// 1
            alreadyCleanPairs.addAndGet(use);// 1 pair
            atomicK.addAndGet(-use * 2);// k = k -1*2 = 0, because I washed 2 dirty socks
        }

        return alreadyCleanPairs.get();
    }

}
