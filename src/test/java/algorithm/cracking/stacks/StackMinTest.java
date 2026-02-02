package algorithm.cracking.stacks;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StackMinTest {

    @Test
    void testMinStack() {
        int[] array = {4, 6, 7, 2, 1, 7, 9, 5};

        var minStack = buildMinStack(array);

        assertEquals(1, minStack.min());
        assertEquals(5, minStack.pop());
        assertEquals(9, minStack.pop());
        assertEquals(1, minStack.min());
        assertEquals(7, minStack.pop());
        assertEquals(1, minStack.pop());
        assertEquals(2, minStack.pop());
        assertEquals(4, minStack.min());
    }

    @Test
    void testMinStackWithDuplicates() {
        int[] array = {3, 3, 3, 2};

        var minStack = buildMinStack(array);

        assertEquals(2, minStack.min());
        assertEquals(2, minStack.pop());
        assertEquals(3, minStack.min());
        assertEquals(3, minStack.pop());
        assertEquals(3, minStack.min());
        assertEquals(3, minStack.pop());
        assertEquals(3, minStack.min());
        assertEquals(3, minStack.pop());
    }

    @Test
    void testMinStackEmpty() {
        var minStack = new StackMin();
        assertThrows(EmptyStackException.class, minStack::min);
        assertThrows(EmptyStackException.class, minStack::pop);

    }

    private StackMin buildMinStack(int[] array) {
        var minStack = new StackMin();
        Arrays.stream(array).forEach(x -> minStack.push(x));
        return minStack;
    }

}