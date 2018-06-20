import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class p018 {
    private static String input =
            "75\n" +
            "95 64\n" +
            "17 47 82\n" +
            "18 35 87 10\n" +
            "20 04 82 47 65\n" +
            "19 01 23 75 03 34\n" +
            "88 02 77 73 07 63 67\n" +
            "99 65 04 28 06 16 70 92\n" +
            "41 41 26 56 83 40 80 70 33\n" +
            "41 48 72 33 47 32 37 16 94 29\n" +
            "53 71 44 65 25 43 91 52 97 51 14\n" +
            "70 11 33 28 77 73 17 78 39 68 17 57\n" +
            "91 71 52 38 17 14 91 43 58 50 27 29 48\n" +
            "63 66 04 68 89 53 67 30 73 16 69 87 40 31\n" +
            "04 62 98 27 23 09 70 98 73 93 38 53 60 04 23";

    private static List<List<Node>> nodes = new ArrayList<>();

    public static void main(String[] args) {
        initInput();
        System.out.println(nodes.get(0).get(0).distance());
    }

    private static void initInput() {
        String[] inputArray = input.split("\n");
        for(String s : inputArray) {
            String[] numbers = s.split(" ");
            nodes.add(new ArrayList<>());
            for(String number : numbers) {
                Node node = new Node();
                node.value = Integer.parseInt(number);
                nodes.get(nodes.size() - 1).add(node);
            }
        }

        for(int row = nodes.size() - 2; row >= 0; row--) {
            for(int col = 0; col < nodes.get(row).size(); col++) {
                setLargestPath(row, col);
            }
        }
    }

    private static void setLargestPath(int row, int column) {
        Node node = nodes.get(row).get(column);
        Node left = nodes.get(row + 1).get(column);
        Node right = nodes.get(row + 1).get(column + 1);

        if(left.distance() > right.distance()) {
            node.largestPath = left;
        } else {
            node.largestPath = right;
        }
    }

    static class Node {
        int value;
        Node largestPath;

        int distance() {
            Node node = largestPath;
            int sum = value;
            while(node != null) {
                sum += node.value;
                node = node.largestPath;
            }
            return sum;
        }
    }

    @Test
    public void testInitInput() {
        initInput();
        //test values
        assertEquals(75, nodes.get(0).get(0).value);
        assertEquals(65, nodes.get(4).get(4).value);

        //test distance
        assertEquals(125, nodes.get(13).get(0).distance());
        assertEquals(255, nodes.get(12).get(0).distance());

    }

    @Test
    public void testLargestPath() {
        Node node = new Node();
        node.value = 15;
        assertEquals(15, node.distance()); //leaf node

        Node child = new Node();
        child.value = 20;
        node.largestPath = child;
        assertEquals(35, node.distance()); //node with single child
    }
}
