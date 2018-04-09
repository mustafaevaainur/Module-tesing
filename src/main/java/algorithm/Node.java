package algorithm;

public class Node {


    public int numberOfNodes;

    public int key[];

    public Node children[];

    public boolean isLeaf;


    public Node() {
        key = new int[2];
        children = new Node[3];
        isLeaf = true;
    }

}
