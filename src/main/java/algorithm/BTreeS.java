package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;


public class BTreeS<T extends Comparable> {

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


    public static BTreeS<Integer> tree = new BTreeS<Integer>();


    public Node root;


    public BTreeS() {
        root = null;

    }

<<<<<<< HEAD

    public BTreeS(Node root) {
        this.root = root;

=======
        root = new Node();
        root.isLeaf = true;
        root.numberOfNodes = 0;
        root.key[0] = -1;
>>>>>>> a58864e228e864bca17d3d81775ca99657715b42
    }


    public void insert(T info) {
        insert(info, root, null, false);

    }

<<<<<<< HEAD

    public boolean search(T info) {
        return search(info, root);

    }


    public void delete(T info) {
        delete(info, root);

    }


    public String print() {
        return print(root);
    }


    public boolean search(T info, Node node) {

        boolean member = false;
        if (node == null) {
            member = false;

        } else if (info.compareTo(node.information) == 0) {
            member = true;

        } else if (info.compareTo(node.information) > 0) {
            member = search(info, node.right);

=======
        if (r.numberOfNodes == 3) {
            Node s = new Node();
            root = s;
            s.numberOfNodes = 0;
            s.isLeaf = false;
            s.children[0] = r;
            splitChild(s, 1, r);
            insertNonfull(s, k);
>>>>>>> a58864e228e864bca17d3d81775ca99657715b42
        } else {
            member = search(info, node.left);

        }

        return member;

    }

<<<<<<< HEAD

    public void insert(T info, Node node, Node parent, boolean right) {
        if (node == null) {
            if (parent == null) {
                root = node = new Node(info, parent);

            } else if (right) {
                parent.right = node = new Node(info, parent);

            } else {
                parent.left = node = new Node(info, parent);

=======
    public void insertNonfull(Node node, int value) {
        int i = node.numberOfNodes;
        if (node.isLeaf) {
            while (i >= 1 && value < node.key[i - 1]) {
                node.key[i] = node.key[i - 1];
                i--;
>>>>>>> a58864e228e864bca17d3d81775ca99657715b42
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


    public void restructInsert(Node node, boolean wasRight) {

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
<<<<<<< HEAD

=======
            insertNonfull(node.children[i - 1], value);
>>>>>>> a58864e228e864bca17d3d81775ca99657715b42
        }

    }

    public void rotateLeft(Node a) {

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
<<<<<<< HEAD

        b.parent = a.parent;
        a.parent = b;
        b.left = a;

        if (b.balance == State.Balanced) {
            a.balance = State.DNotBalansed;
            b.balance = State.NotBalanced;

        } else {
            a.balance = State.Balanced;
            b.balance = State.Balanced;

=======
        newChild.numberOfNodes = 1;
        for (int j = parentNode.numberOfNodes + 1; j >= childIndex + 1; j--) {
            parentNode.children[j] = parentNode.children[j - 1];
            parentNode.key[j - 1] = parentNode.key[j - 2];
>>>>>>> a58864e228e864bca17d3d81775ca99657715b42
        }

    }

    public void rotateRight(Node a) {

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
<<<<<<< HEAD

        b.parent = a.parent;
        a.parent = b;
        b.right = a;

        if (b.balance == State.Balanced) {
            a.balance = State.NotBalanced;
            b.balance = State.DNotBalansed;

        } else {
            a.balance = State.Balanced;
            b.balance = State.Balanced;

=======
        if (!node.isLeaf) {
            return search(node.children[i - 1], value);
>>>>>>> a58864e228e864bca17d3d81775ca99657715b42
        }

    }

    public void doubleRotateLeft(Node a) {

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

    public void doubleRotateRight(Node a) {

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

<<<<<<< HEAD


    public void delete(T info, Node node) throws NoSuchElementException {
=======
    public boolean printBtree(Node node, String indent) {
>>>>>>> a58864e228e864bca17d3d81775ca99657715b42
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


    public void deleteNode(Node node) {
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


    public void restructDelete(Node z, boolean wasRight) {

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


    public String print(Node node) {
        String result = "";
        if (node != null) {
            result = result + print(node.left) + " ";
            result = result + node.information.toString();
            result = result + print(node.right);

        }
        return result;
    }

    public String preOrder() {
        return preOrder(root);
    }

    public String postOrder() {
        return postOrder(root);
    }

    private String preOrder(Node node) {

        String result = "";
        if (node != null) {
            result = result + node.information.toString() + " ";
            result = result + preOrder(node.left);
            result = result + preOrder(node.right);
        }
        return result;
    }

    private String postOrder(Node node) {

        String result = "";
        if (node != null) {
            result = result + postOrder(node.left);
            result = result + postOrder(node.right);
            result = result + node.information.toString() + " ";
        }
        return result;
    }
}
