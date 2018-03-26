package algorithm;

public class Node {


    public int numberOfNodes;

    public int key[];

    public Node children[];

    public boolean isLeaf;


    Node() {
        key = new int[3];
        children = new Node[4];
        isLeaf = true;
    }
}
