package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;

public class BTreeS<T extends Comparable> {

    private static BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        System.out.println("---------------------------------------------------------------");
        System.out.println(" BTree algorithm not really good realization by me. I'm sorry.");
        System.out.println("---------------------------------------------------------------");


        String input;
        Integer value;

        do {
            input = stringInput("please select: [i]nsert, [d]elete, [e]xit");
            switch (input.charAt(0)) {
                case 'i':
                    value = Integer.parseInt(stringInput("insert: "), 10);
                    if (tree.isMember(value)) {
                        System.out.println("value " + value + " already in tree");
                    } else {
                        tree.insert(value);
                    }
                    System.out.println("Before: " + tree.print());
                    break;
                case 'd':
                    value = Integer.parseInt(stringInput("delete: "), 10);
                    if (tree.isMember(value)) {
                        tree.delete(value);
                    } else {
                        System.out.println(value + " not found in tree");
                    }
                    System.out.println("After DEL: " + tree.print());

                    break;
            }
        } while ((input.charAt(0) != 'e'));
    }

    @Override
    public String toString() {
        return print(root);
    }


    private static String stringInput(String inputRequest) throws IOException {
        System.out.println(inputRequest);
        return reader.readLine();
    }

    enum State {Balanced, NotBalanced, DNotBalansed}

    class Node {

        T information;

        Node parent;

        Node left;

        Node right;

        State balance;

        public Node(T information, Node parent) {
            this.information = information;
            this.parent = parent;
            this.left = null;
            this.right = null;
            this.balance = State.Balanced;
        }

        boolean isLeaf() {
            return ((left == null) && (right == null));
        }

        boolean isNode() {
            return !isLeaf();
        }

        boolean hasLeftNode() {
            return (null != left);
        }

        boolean hasRightNode() {
            return (right != null);
        }

        boolean isLeftNode() {
            return (parent.left == this);
        }

        boolean isRightNode() {
            return (parent.right == this);
        }
    }

    private static BTreeS<Integer> tree = new BTreeS<Integer>();

    private Node root;

    public BTreeS() {
        root = null;
    }

    public BTreeS(Node root) {
        this.root = root;
    }

    public void insert(T info) {
        insert(info, root, null, false);
    }

    public boolean isMember(T info) {
        return isMember(info, root);
    }

    public void delete(T info) {
        delete(info, root);
    }

    public String print() {
        return print(root);
    }


    private boolean isMember(T info, Node node) {

        boolean member = false;
        if (node == null) {
            member = false;
        } else if (info.compareTo(node.information) == 0) {
            member = true;
        } else if (info.compareTo(node.information) > 0) {
            member = isMember(info, node.right);
        } else {
            member = isMember(info, node.left);
        }

        return member;
    }

    private void insert(T info, Node node, Node parent, boolean right) {
        if (node == null) {
            if (parent == null) {
                root = node = new Node(info, parent);
            } else if (right) {
                parent.right = node = new Node(info, parent);
            } else {
                parent.left = node = new Node(info, parent);
            }
            restructInsert(node, false);
        } else if (info.compareTo(node.information) == 0) {
            node.information = info;
        } else if (info.compareTo(node.information) > 0) {
            insert(info, node.right, node, true);
        } else {
            insert(info, node.left, node, false);
        }
    }

    private void restructInsert(Node node, boolean wasRight) {

        if (node != root) {
            if (node.parent.balance == State.Balanced) {
                if (node.isLeftNode()) {
                    node.parent.balance = State.NotBalanced;
                    restructInsert(node.parent, false);
                } else {
                    node.parent.balance = State.DNotBalansed;
                    restructInsert(node.parent, true);
                }
            } else if (node.parent.balance == State.NotBalanced) {
                if (node.isRightNode()) {
                    node.parent.balance = State.Balanced;
                } else {
                    if (!wasRight) {
                        rotateRight(node.parent);
                    } else {
                        doubleRotateRight(node.parent);
                    }
                }
            } else if (node.parent.balance == State.DNotBalansed) {
                if (node.isLeftNode()) {
                    node.parent.balance = State.Balanced;
                } else {
                    if (wasRight) {
                        rotateLeft(node.parent);
                    } else {
                        doubleRotateLeft(node.parent);
                    }
                }
            }
        }
    }

    private void rotateLeft(Node a) {

        Node b = a.right;

        if (a.parent == null) {
            root = b;
        } else {
            if (a.isLeftNode()) {
                a.parent.left = b;
            } else {
                a.parent.right = b;
            }
        }

        a.right = b.left;
        if (a.right != null) {
            a.right.parent = a;
        }

        b.parent = a.parent;
        a.parent = b;
        b.left = a;

        if (b.balance == State.Balanced) {
            a.balance = State.DNotBalansed;
            b.balance = State.NotBalanced;
        } else {
            a.balance = State.Balanced;
            b.balance = State.Balanced;
        }
    }

    private void rotateRight(Node a) {

        Node b = a.left;

        if (a.parent == null) {
            root = b;
        } else {
            if (a.isLeftNode()) {
                a.parent.left = b;
            } else {
                a.parent.right = b;
            }
        }

        a.left = b.right;
        if (a.left != null) {
            a.left.parent = a;
        }

        b.parent = a.parent;
        a.parent = b;
        b.right = a;

        if (b.balance == State.Balanced) {
            a.balance = State.NotBalanced;
            b.balance = State.DNotBalansed;
        } else {
            a.balance = State.Balanced;
            b.balance = State.Balanced;
        }
    }

    private void doubleRotateLeft(Node a) {

        Node b = a.right;
        Node c = b.left;

        if (a.parent == null) {
            root = c;
        } else {
            if (a.isLeftNode()) {
                a.parent.left = c;
            } else {
                a.parent.right = c;
            }
        }

        c.parent = a.parent;

        a.right = c.left;
        if (a.right != null) {
            a.right.parent = a;
        }
        b.left = c.right;
        if (b.left != null) {
            b.left.parent = b;
        }

        c.left = a;
        c.right = b;

        a.parent = c;
        b.parent = c;

        if (c.balance == State.NotBalanced) {
            a.balance = State.Balanced;
            b.balance = State.DNotBalansed;
        } else if (c.balance == State.DNotBalansed) {
            a.balance = State.NotBalanced;
            b.balance = State.Balanced;
        } else {
            a.balance = State.Balanced;
            b.balance = State.Balanced;
        }

        c.balance = State.Balanced;
    }

    private void doubleRotateRight(Node a) {

        Node b = a.left;
        Node c = b.right;

        if (a.parent == null) {
            root = c;
        } else {
            if (a.isLeftNode()) {
                a.parent.left = c;
            } else {
                a.parent.right = c;
            }
        }

        c.parent = a.parent;

        a.left = c.right;
        if (a.left != null) {
            a.left.parent = a;
        }
        b.right = c.left;
        if (b.right != null) {
            b.right.parent = b;
        }

        c.right = a;
        c.left = b;

        a.parent = c;
        b.parent = c;

        if (c.balance == State.NotBalanced) {
            b.balance = State.Balanced;
            a.balance = State.DNotBalansed;
        } else if (c.balance == State.DNotBalansed) {
            b.balance = State.NotBalanced;
            a.balance = State.Balanced;
        } else {
            b.balance = State.Balanced;
            a.balance = State.Balanced;
        }
        c.balance = State.Balanced;
    }

    private void delete(T info, Node node) throws NoSuchElementException {
        if (node == null) {
            throw new NoSuchElementException();
        } else if (info.compareTo(node.information) == 0) {
            deleteNode(node);
        } else if (info.compareTo(node.information) > 0) {
            delete(info, node.right);
        } else {
            delete(info, node.left);
        }
    }

    private void deleteNode(Node node) {
        Node eNode, minMaxNode, delNode = null;
        boolean rightNode = false;

        if (node.isLeaf()) {
            if (node.parent == null) {
                root = null;
            } else if (node.isRightNode()) {
                node.parent.right = null;
                rightNode = true;
            } else if (node.isLeftNode()) {
                node.parent.left = null;
            }
            delNode = node;
        } else if (node.hasLeftNode()) {
            minMaxNode = node.left;
            for (eNode = node.left; eNode != null; eNode = eNode.right) {
                minMaxNode = eNode;
            }
            delNode = minMaxNode;
            node.information = minMaxNode.information;

            if (node.left.right != null) {
                minMaxNode.parent.right = minMaxNode.left;
                rightNode = true;
            } else {
                minMaxNode.parent.left = minMaxNode.left;
            }

            if (minMaxNode.left != null) {
                minMaxNode.left.parent = minMaxNode.parent;
            }
        } else if (node.hasRightNode()) {
            minMaxNode = node.right;
            delNode = minMaxNode;
            rightNode = true;

            node.information = minMaxNode.information;

            node.right = minMaxNode.right;
            if (node.right != null) {
                node.right.parent = node;
            }
            node.left = minMaxNode.left;
            if (node.left != null) {
                node.left.parent = node;
            }
        }
        restructDelete(delNode.parent, rightNode);
    }

    private void restructDelete(Node z, boolean wasRight) {

        Node parent;
        boolean isRight = false;
        boolean climb = false;
        boolean canClimb;

        if (z == null) {
            return;
        }

        parent = z.parent;
        canClimb = (parent != null);

        if (canClimb) {
            isRight = z.isRightNode();
        }

        if (z.balance == State.Balanced) {
            if (wasRight) {
                z.balance = State.NotBalanced;
            } else {
                z.balance = State.DNotBalansed;
            }
        } else if (z.balance == State.NotBalanced) {
            if (wasRight) {
                if (z.left.balance == State.DNotBalansed) {
                    doubleRotateRight(z);
                    climb = true;
                } else {
                    rotateRight(z);
                    if (z.balance == State.Balanced) {
                        climb = true;
                    }
                }
            } else {
                z.balance = State.Balanced;
                climb = true;
            }
        } else {
            if (wasRight) {
                z.balance = State.Balanced;
                climb = true;
            } else {
                if (z.right.balance == State.NotBalanced) {
                    doubleRotateLeft(z);
                    climb = true;
                } else {
                    rotateLeft(z);
                    if (z.balance == State.Balanced) {
                        climb = true;
                    }
                }
            }
        }

        if (canClimb && climb) {
            restructDelete(parent, isRight);
        }
    }

    private String print(Node node) {
        String result = "";
        if (node != null) {
            result = result + print(node.left) + " ";
            result = result + node.information.toString();
            result = result + print(node.right);
        }
        return result;
    }

}
