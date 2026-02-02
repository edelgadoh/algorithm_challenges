package algorithm.cracking.stacks;

import java.util.Stack;

/**
 * How would you design a stack which, in addition to push and pop, has a function min which returns the minimum element?
 * Push, pop and min should all operate in 0(1) time.
 */
public class StackMin {

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
        var popped = stack.pop();
        if (popped == minStack.peek()) {
            minStack.pop();
        }
        return popped;
    }

    public Integer min() {
        return minStack.peek();
    }
}
