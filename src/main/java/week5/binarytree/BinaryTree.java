package week5.binarytree;

import java.util.*;

public class BinaryTree {
    public List<Integer> bfsList = new ArrayList<>();
    public List<Integer> dfsList = new ArrayList<>();

    public void bfs(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            bfsList.add(n.getValue());
            if (n.getLeft() != null) {
                queue.offer(n.getLeft());
            }
            if (n.getRight() != null) {
                queue.offer(n.getRight());
            }
        }
    }

    public void dfs(Node node) {
        if (node == null) return;
        if (node.getLeft() != null) {
            dfs(node.getLeft());
        }
        dfsList.add(node.getValue());
        if (node.getRight() != null) {
            dfs(node.getRight());
        }
    }
}
