package algorithm.cracking;

public class Chapter08RecursiveMultiply {

    public static void main(String[] args) {
        Integer n = 20;
        Integer m = 7;
        Chapter08RecursiveMultiply chapter08RecursiveMultiply = new Chapter08RecursiveMultiply();
        Integer multiplied = chapter08RecursiveMultiply.multiply(n, m);
        System.out.println(multiplied);
    }

    private Integer multiply(Integer n, Integer m) {
        Integer smaller = n > m ? m : n;
        Integer bigger = n < m ? m : n;
        return multiplyHelper(smaller, bigger);
    }

    private Integer multiplyHelper(Integer smaller, Integer bigger) {

        if (smaller == 0) return 0;//0 * bigger
        if (smaller == 1) return bigger;// 1 * bigger

        Integer x = smaller >> 1; // smaller / 2

        Integer half = multiplyHelper(x, bigger);

        if (smaller % 2 == 0) { // on even number we just need to double the result
            return half + half;
        } else { // on odd numbers we double the result and sum the bigger value
            return half + half + bigger;
        }
    }

}
