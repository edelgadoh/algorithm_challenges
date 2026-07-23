package algorithm.cracking.recursive;

public class RecursiveMultiply {

    /**
     * Write a recursive function to multiply two positive integers without using
     * the * operator (or / operator). You can use addition, subtraction, and bit shifting, but you should
     * minimize the number of those operations.
     */
    public int multiply(int a, int b) {
        var smaller = Math.min(a, b);
        var bigger = Math.max(a, b);
        return internalMultiply(smaller, bigger);
    }

    private int internalMultiply(int smaller, int bigger) {
        if (smaller == 0) return 0;
        if (smaller == 1) return bigger;

        var half = smaller >> 1;
        var halfProduct = internalMultiply(half, bigger);
        if (smaller % 2 == 0) {
            return halfProduct + halfProduct;
        } else {
            return halfProduct + halfProduct + bigger;
        }
    }

}
