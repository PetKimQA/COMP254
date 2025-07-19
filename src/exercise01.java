public class exercise01 {

    // Binary tree node class
    static class Node {
        int value;
        Node left, right, parent;

        Node(int value) {
            this.value = value;
        }
    }

    // Find inorder successor of node p
    public static Node inorderNext(Node p) {
        if (p == null) return null;

        // Case 1: Right child exists → go to leftmost node in right subtree
        if (p.right != null) {
            Node curr = p.right;
            while (curr.left != null) {
                curr = curr.left;
            }
            return curr;
        }

        // Case 2: No right child → go up until node is a left child of its parent
        Node curr = p;
        while (curr.parent != null && curr == curr.parent.right) {
            curr = curr.parent;
        }
        return curr.parent;
    }

    // Test inorder
    public static void main(String[] args) {
        /*
               4
              / \
             2   6
            / \   \
           1   3   7
        */

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        // Set up connections
        n4.left = n2; n4.right = n6; n4.parent = null;
        n2.parent = n4; n2.left = n1; n2.right = n3;
        n6.parent = n4; n6.right = n7;
        n1.parent = n2; n3.parent = n2;
        n7.parent = n6;

        // Test
        System.out.println("Inorder successor of 3: " + inorderNext(n3).value);
        System.out.println("Inorder successor of 4: " + inorderNext(n4).value);
        System.out.println("Inorder successor of 6: " + inorderNext(n6).value);
        System.out.println("Inorder successor of 7: " + inorderNext(n7));
    }
}
