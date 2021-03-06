package week5.binarytree;

public class Node {
    private int value;
    private Node left;
    private Node right;

    Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public Node addLeftNode(int value) {
        Node node = new Node(value);
        setLeft(node);
        return node;
    }

    public Node addRightNode(int value) {
        Node node = new Node(value);
        setRight(node);
        return node;
    }

    public int getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
