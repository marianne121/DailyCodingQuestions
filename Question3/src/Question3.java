public class Question3 {

    public static void main(String[] args) {
        int[] original = {1,2,3,4,5,6,7,8};
        Node root = new Node(original[0]);
        Tree binaryTree = new Tree(root);
        binaryTree.insertLevelOrder(original, root, 1);
        treeTraversals(root, binaryTree);
    }

    private static void treeTraversals(Node root, Tree binaryTree) {
        System.out.println("in order traversal");
        binaryTree.inOrder(root);
        System.out.println();
        System.out.println("pre order traversal");
        binaryTree.preOrder(root);
        System.out.println();
        System.out.println("post order traversal");
        binaryTree.postOrder(root);
    }


}
