package algorithm.linkedList;

public class ReturnKthToLast {

    static int getKthToLast(Node node, int k) {
        if (node == null) return -1;
        Node n1 = node;
        Node n2 = node;
        int i = 0;
        while (i < k) {
            if (n1 == null) return -1;
            n1 = n1.next;
            i++;
        }
        while (n1 != null) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n2.value;
    }

}
