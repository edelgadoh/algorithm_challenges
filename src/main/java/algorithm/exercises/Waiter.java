package algorithm.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

public class Waiter {

    /*
     * Complete the 'waiter' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY number
     *  2. INTEGER q
     */
    private static boolean isPrime(int value) {
        return value > 1 && IntStream.range(2, value).noneMatch(n -> value % n == 0);
    }

    private static List<Integer> buildPrimeList(int limit) {
        var primeList = new ArrayList<Integer>();
        var i = 2;
        while (primeList.size() < limit) {
            if (isPrime(i)) primeList.add(i);
            i++;
        }
        return primeList;
    }

    public static List<Integer> waiter(List<Integer> number, int q) {

        var primeList = buildPrimeList(q);

        var answers = new ArrayList<Integer>();
        var stackA = new Stack<Integer>();
        stackA.addAll(number);
        var stackB = new Stack<Integer>();

        for (Integer prime : primeList) {
            var localStackA = new Stack<Integer>();
            while (!stackA.isEmpty()) {
                var e = stackA.pop();
                if (e % prime == 0) {
                    stackB.add(e);
                } else {
                    localStackA.add(e);
                }
            }
            while (!stackB.isEmpty()) {
                answers.add(stackB.pop());
            }
            stackA = localStackA;
        }
        while (!stackA.isEmpty()) {
            answers.add(stackA.pop());
        }
        return answers;
    }

}


