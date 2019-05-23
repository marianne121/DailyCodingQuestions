public class Tree {
    private Node root;

    public Tree(Node root) {
        this.root = root;
    }

    // first call i = 1
    public void insertLevelOrder(int[] arr, Node root, int index) {

        if (index < arr.length) {
            root.setLeft(new Node(arr[index]));
            // end of array met
            int rightIndex = index + 1;
            if (rightIndex + 1 >= arr.length) {
                return;
            }
            root.setRight(new Node(arr[rightIndex]));
            insertLevelOrder(arr, root.getLeft(), index * 2 + 1);

            insertLevelOrder(arr, root.getRight(), rightIndex * 2 + 1);
        }
    }

    public void inOrder(Node currNode) {
        if (currNode != null) {
            inOrder(currNode.getLeft());
            System.out.print(currNode.getValue() + " ");
            inOrder(currNode.getRight());
        }
    }

    public void preOrder(Node currNode) {
        if (currNode != null) {
            System.out.print(currNode.getValue() + " ");
            preOrder(currNode.getLeft());
            preOrder(currNode.getRight());
        }
    }

    public void postOrder(Node currNode) {
        if (currNode != null) {
            postOrder(currNode.getLeft());
            postOrder(currNode.getRight());
            System.out.print(currNode.getValue() + " ");
        }
    }
}
