package week5.binarytree;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class BinaryTreeTest {
    static BinaryTree tree;
    static Node root;

    @BeforeAll
    static void createBinaryTree() {
        tree = new BinaryTree();
        root = new Node(1);

        Node temp = root.addLeftNode(2);
        temp.addRightNode(6);
        temp = temp.addLeftNode(3);
        temp.addLeftNode(4);
        temp.addRightNode(5);

        temp = root.addRightNode(7);
        temp.addLeftNode(8);
        temp.addRightNode(9);
    }

    @Test
    void bfs() {
        tree.bfs(root);
        List<Integer> answer = Arrays.asList(1, 2, 7, 3, 6, 8, 9, 4, 5);
        assertArrayEquals(answer.toArray(), tree.bfsList.toArray());
    }

    @Test
    void dfs() {
        tree.dfs(root);
        List<Integer> answer = Arrays.asList(4, 3, 5, 2, 6, 1, 8, 7, 9);
        assertArrayEquals(answer.toArray(), tree.dfsList.toArray());
    }
}