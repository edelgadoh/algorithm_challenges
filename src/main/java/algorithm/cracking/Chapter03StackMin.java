package algorithm.cracking;

import java.util.Arrays;
import java.util.Stack;

public class Chapter03StackMin {
    public static void main(String[] args) {
        int[] array = {4, 6, 7, 2, 1, 7, 9, 5};
        Chapter03StackMin main = new Chapter03StackMin();
        MinStack minStack = main.buildMinStack(array);

        System.out.println("min ->" + minStack.min());
        System.out.println("pop ->" + minStack.pop());
        System.out.println("pop ->" + minStack.pop());
        System.out.println("pop ->" + minStack.pop());
        System.out.println("pop ->" + minStack.pop());
        System.out.println("pop ->" + minStack.pop());
        System.out.println("min ->" + minStack.min());

    }

    private MinStack buildMinStack(int[] array) {
        MinStack minStack = new MinStack();
        Arrays.stream(array).forEach(x -> minStack.push(x));
        return minStack;
    }

    private class MinStack {
        Stack<Integer> minStack = new Stack();
        Stack<Integer> stack = new Stack<>();

        public void push(Integer value) {
            if (minStack.isEmpty()) {
                minStack.push(value);
            } else if (value <= minStack.peek()) {
                minStack.push(value);
            }
            stack.push(value);
        }

        public Integer pop() {
            Integer popped = stack.pop();
            if (popped == minStack.peek()) {
                minStack.pop();
            }
            return popped;
        }

        public Integer min() {
            return minStack.peek();
        }
    }

}
