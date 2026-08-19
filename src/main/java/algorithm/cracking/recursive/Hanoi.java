package algorithm.cracking.recursive;

import java.util.Stack;

public class Hanoi {

    private static final int SOURCE = 0;
    private static final int DESTINATION = 2;
    private static final int BUFFER = 1;

    private Stack<Integer>[] towers = new Stack[3];

    public Hanoi(int size) {

        towers[SOURCE] = new Stack<>();
        for (int i = size; i > 0; i--) {
            towers[SOURCE].push(i);
        }
        towers[BUFFER] = new Stack<>();
        towers[DESTINATION] = new Stack<>();
    }

    public Stack getTower(int index) {
        return towers[index];
    }

    public void solve() {
        int n = towers[SOURCE].size();
        if (n == 0) return;
        solve(n, SOURCE, DESTINATION, BUFFER);
    }

    private void solve(int n, int indexFrom, int indexTo, int indexBuffer) {
        if (n == 1) {
            towers[indexTo].push(towers[indexFrom].pop());
        } else {
            solve(n - 1, indexFrom, indexBuffer, indexTo);
            towers[indexTo].push(towers[indexFrom].pop());
            solve(n - 1, indexBuffer, indexTo, indexFrom);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < towers.length; i++) {
            sb.append("Tower ").append(i).append(": ").append(towers[i]).append("\n");
        }
        return sb.toString();
    }

}
