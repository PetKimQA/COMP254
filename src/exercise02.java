public class exercise02 {

    // Binary tree node class
    static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
        }
    }

    // Recursive postorder function to compute height and print node info
    // postorder traversal: left-right-current

    public static int computeAndPrintHeight(Node n) {
        // return -1 so that leaf node's height becomes 0
        if (n == null) {
            return -1;
        }

        int leftHeight = computeAndPrintHeight(n.left);
        int rightHeight = computeAndPrintHeight(n.right);

        int nodeHeight = 1 + Math.max(leftHeight, rightHeight);

        System.out.println("Node " + n.value + " → Height: " + nodeHeight);

        return nodeHeight;
    }

    // Sample test
    public static void main(String[] args) {
        /*
               4
              / \
             2   6
            / \   \
           1   3   7
                  /
                 8
        */

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);

        // Set up the tree
        n4.left = n2; n4.right = n6;
        n2.left = n1; n2.right = n3;
        n6.right = n7;
        n7.left = n8;

        computeAndPrintHeight(n4);
    }

}
