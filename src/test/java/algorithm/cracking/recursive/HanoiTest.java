package algorithm.cracking.recursive;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Stack;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class HanoiTest {

    @Test
    void hanoiTest() {
        Hanoi hanoi = new Hanoi(5);

        hanoi.solve();

        assertThat(hanoi.getTower(0), is(new Stack<>()));
        assertThat(hanoi.getTower(1), is(new Stack<>()));
        Stack<Integer> expectedLastTower = new Stack<>();
        expectedLastTower.addAll(List.of(5, 4, 3, 2, 1));
        assertThat(hanoi.getTower(2), is(expectedLastTower));
    }

    @Test
    void hanoiTestWithOneDisk() {
        Hanoi hanoi = new Hanoi(1);

        hanoi.solve();

        assertThat(hanoi.getTower(0), is(new Stack<>()));
        assertThat(hanoi.getTower(1), is(new Stack<>()));
        Stack<Integer> expectedLastTower = new Stack<>();
        expectedLastTower.addAll(List.of(1));
        assertThat(hanoi.getTower(2), is(expectedLastTower));
    }

    @Test
    void hanoiTestWithTwoDisks() {
        Hanoi hanoi = new Hanoi(2);

        hanoi.solve();

        assertThat(hanoi.getTower(0), is(new Stack<>()));
        assertThat(hanoi.getTower(1), is(new Stack<>()));
        Stack<Integer> expectedLastTower = new Stack<>();
        expectedLastTower.addAll(List.of(2, 1));
        assertThat(hanoi.getTower(2), is(expectedLastTower));
    }

    @Test
    void hanoiWithoutDisks() {
        Hanoi hanoi = new Hanoi(0);

        hanoi.solve();

        assertThat(hanoi.getTower(0), is(new Stack<>()));
        assertThat(hanoi.getTower(1), is(new Stack<>()));
        assertThat(hanoi.getTower(2), is(new Stack<>()));
    }

}