package homework16;

public class Node {
    private int value;
    private Node leftNode;
    private Node rightNode;

    public Node (int value){
        this.value = value;
        this.leftNode = null;
        this.rightNode = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public String toString() {
        return "{ \n" +
                "value=" + value +
                ",\n leftNode=" + leftNode +
                ",\n rightNode=" + rightNode +
                "} \n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node node)) return false;

        if (getValue() != node.getValue()) return false;
        if (getLeftNode() != null ? !getLeftNode().equals(node.getLeftNode()) : node.getLeftNode() != null)
            return false;
        return getRightNode() != null ? getRightNode().equals(node.getRightNode()) : node.getRightNode() == null;
    }

    @Override
    public int hashCode() {
        int result = getValue();
        result = 31 * result + (getLeftNode() != null ? getLeftNode().hashCode() : 0);
        result = 31 * result + (getRightNode() != null ? getRightNode().hashCode() : 0);
        return result;
    }
}
