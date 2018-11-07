package lw.learn.ds;

/**
 * @Author lw
 * @Date 2018-11-06 22:20:30
 **/
public class AVLTree<K extends Comparable<K>, V> {

    private class Node {
        K key;
        V value;
        int height;
        Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            height = 1;
        }
    }

    private Node root;
    private int size;

    public AVLTree() {
        root = null;
        size = 0;
    }

    public void add(K key, V value) {
        root = add(root, key, value);
    }

    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }
        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balanceFactor = balanceFactor(node);
        /*
            if (Math.abs(balanceFactor) > 1) {
                System.out.println("unbalanced... " + balanceFactor);
            }
        */
        /*
            // LL
            if (balanceFactor > 1 && balanceFactor(node.left) >= 0)
                return rightRotate(node);

            // LR
            if (balanceFactor > 1 && balanceFactor(node.left) < 0) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        */

        if (balanceFactor > 1) {

            // LR
            if (balanceFactor(node.left) < 0)
                node.left = leftRotate(node.left);

            return rightRotate(node);
        }

        /*
            // RR
            if (balanceFactor < -1 && balanceFactor(node.right) <= 0)
                return leftRotate(node);

            // RL
            if (balanceFactor < -1 && balanceFactor(node.right) > 0) {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        */

        if (balanceFactor < -1) {

            if (balanceFactor(node.right) > 0)
                node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public V remove(K key) {

        Node node = getNode(root, key);
        if (node != null) {

            root = remove(root, key);

            return node.value;
        }

        return null;
    }

    private Node remove(Node node, K key) {

        Node res = null;
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            res = node;

        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            res = node;

        } else {

            if (node.left == null) {
                Node right = node.right;
                node.right = null;
                size--;
                res = right;
            } else if (node.right == null) {
                Node left = node.left;
                node.left = null;
                size--;
                res = left;
            } else {
                Node min = min(node.right);
                node.right = remove(node.right, min.key);
                min.left = node.left;
                min.right = node.right;
                node.left = null;
                node.right = null;
                res = min;
            }
        }

        if (res == null)
            return null;

        res.height = Math.max(height(res.right), height(res.left)) + 1;

        int balanceFactor = balanceFactor(res);
        if (balanceFactor > 1) {

            if (balanceFactor(res.left) < 0)
                res.left = leftRotate(res.left);
            res = rightRotate(res);

        } else if (balanceFactor < -1) {
            if (balanceFactor(res.right) > 0)
                res.right = rightRotate(res.right);
            res = leftRotate(res);

        }

        return res;
    }

    public void set(K key, V value) {
        set(root, key, value);
    }

    private void set(Node node, K key, V value) {
        if (node == null)
            return;

        if (key.compareTo(node.key) < 0)
            set(node.left, key, value);
        else if (key.compareTo(node.key) > 0)
            set(node.right, key, value);
        else
            node.value = value;
    }


    public V get(K key) {
        Node node = getNode(root, key);
        if (node != null)
            return node.value;
        return null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
    public boolean contains(K key) {
        return contains(root, key);
    }

    private boolean contains(Node node, K key) {

        if (node == null)
            return false;

        if (key.compareTo(node.key) < 0)
            return contains(node.left, key);

        else if (key.compareTo(node.key) > 0)
            return contains(node.right, key);

        else
            return true;
    }

    private Node getNode(Node node, K key) {
        if (node == null)
            return null;
        if (key.compareTo(node.key) < 0)
            return getNode(node.left, key);

        else if (key.compareTo(node.key) > 0)
            return getNode(node.right, key);

        else
            return node;
    }

    private Node rightRotate(Node node) {
        Node nodeLeft = node.left;
        node.left = nodeLeft.right;
        nodeLeft.right = node;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        nodeLeft.height = Math.max(height(nodeLeft.left), height(nodeLeft.right)) + 1;
        return nodeLeft;
    }

    private Node leftRotate(Node node) {
        Node nodeRight = node.right;
        node.right = nodeRight.left;
        nodeRight.left = node;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        nodeRight.height = Math.max(height(nodeRight.left), height(nodeRight.right)) + 1;
        return nodeRight;
    }

    public boolean isBST() {
        Comparable<K> pre = min(root).key;
        return isBST(root, pre);
    }

    private boolean isBST(Node node, Comparable<K> pre) {
        if (node == null) {
            return true;
        }

        if (!isBST(node.left, pre)) {
            return false;
        }
        if (pre.compareTo(node.key) > 0) {
            return false;
        }
        pre = node.key;
        if (!isBST(node.right, pre)) {
            return false;
        }
        return true;
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }
        int factor = balanceFactor(node);
        if (Math.abs(factor) > 1) {
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);
    }

    private Node min(Node node) {
        if (node == null) {
            return null;
        }
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    private int balanceFactor(Node node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }
    private int height(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }


}
