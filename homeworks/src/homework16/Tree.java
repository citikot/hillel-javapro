package homework16;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Tree {

    private Random random = new Random();
    private Node root = new Node(random.nextInt(100));
    private int level;

    public Tree(int level) {
        this.level = level;
        generate();
    }

    private void generate() {
        for (int i = 1; i <= level; i++) {
            for (int j = 1; j <= Math.pow( 2, i ); j++) {
                Node newNode = new Node(random.nextInt(100));
                add(root, newNode);
            }
        }
    }

    private void add(Node currentNode, Node newNode) {
        if ((newNode.getValue() > currentNode.getValue()) && currentNode.getRightNode() == null) {
            currentNode.setRightNode(newNode);
        } else if ((newNode.getValue() < currentNode.getValue()) && currentNode.getLeftNode() == null) {
            currentNode.setLeftNode(newNode);
        } else if ((newNode.getValue() > currentNode.getValue()) && currentNode.getRightNode() != null) {
            currentNode = currentNode.getRightNode();
            add(currentNode, newNode);
        } else if ((newNode.getValue() < currentNode.getValue()) && currentNode.getLeftNode() != null) {
            currentNode = currentNode.getLeftNode();
            add(currentNode, newNode);
        }
    }

    // Wide Traverse
    public void iterate() {
        Queue<Node> queue = new LinkedList<>();
        Node currentNode = root;
        do {
            System.out.println(currentNode.getValue());
            if (currentNode.getLeftNode() != null) {
                queue.offer(currentNode.getLeftNode());
            }
            if (currentNode.getRightNode() != null) {
                queue.offer(currentNode.getRightNode());
            }
            if (!queue.isEmpty()) {
                currentNode = queue.poll();
            } else {
                break;
            }
        } while (true);
    }

    @Override
    public String toString() {
        return "{" +
                "BinaryTree=" + root +
                '}';
    }
}
