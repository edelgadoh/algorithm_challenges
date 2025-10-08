package algorithm.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WaiterTest {
    private Waiter waiter;

    @Test
    void waiter01Test() {
        var input = java.util.Arrays.asList(3, 4, 7, 6, 5);
        var output = java.util.Arrays.asList(4, 6, 3, 7, 5);
        assertEquals(output, Waiter.waiter(input, 1));
    }

    @Test
    void waiter02Test() {
        var input = java.util.Arrays.asList(3, 3, 4, 4, 9);
        var output = java.util.Arrays.asList(4, 4, 9, 3, 3);
        assertEquals(output, Waiter.waiter(input, 2));
    }

    @Test
    void waiter03Test() {
        var input = java.util.Arrays.asList(3, 3, 4, 4, 9);
        var output = java.util.Arrays.asList(9, 4, 4, 3, 3);
        assertEquals(output, Waiter.waiter(input, 0));
    }


}