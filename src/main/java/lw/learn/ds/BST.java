package lw.learn.ds;

/**
 * @Author lw
 * @Date 2018-11-04 21:51:26
 **/
public class BST<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
        }
    }

    private Node root;
    private int size;

    public BST() {
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {

        root = add(root, e);

    }


    private Node add(Node node, E e) {

        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    public E remove(E e) {

        if (isEmpty()) {
            return null;
        }
        root = remove(root, e);
        return e;
    }

    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
        } else {
            if (node.left == null) {
                Node right = node.right;
                node.right = null;
                size--;
                return right;
            } else if (node.right == null) {
                Node left = node.left;
                node.left = null;
                size--;
                return left;
            } else {
                Node successor = min(node.right);
                successor.right = removeMin(node.right);
                successor.left = node.left;
                node.left = null;
                node.right = null;
                return successor;
            }
        }
        return node;
    }

    public E removeMin() {
        if (isEmpty()) {
            return null;
        }
        E e = min();
        root = removeMin(root);
        return e;
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node right = node.right;
            node.right = null;
            size--;
            return right;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax() {
        if (isEmpty()) {
            return null;
        }

        E e = max();
        root = removeMax(root);
        return e;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node left = node.left;
            node.left = null;
            size--;
            return left;
        }
        node.right = removeMax(node.right);
        return node;
    }



    public boolean contains(E e) {

        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }

        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) > 0) {
            return contains(node.right, e);
        } else {
            return contains(node.left, e);
        }

      /*  switch (e.compareTo(node.e)) {
            case 0:
                return true;

            case 1:
                return contains(node.right, e);
            case -1:
                return contains(node.left, e);
        }*/
    }


    public E min() {
        if (size == 0) {
            return null;
        }
        Node min = min(root);
        return min == null ? null : min.e;
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    public E max() {
        if (size == 0) {
            return null;
        }

        Node max = max(root);
        return max == null ? null : max.e;
    }

    private Node max(Node node) {
        if (node.right == null) {
            return node;
        }

        return max(node.right);
    }


}
