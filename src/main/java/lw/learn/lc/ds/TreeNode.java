package lw.learn.lc.ds;

/**
 * @Author lw
 * @Date 2018-11-14 11:57:13
 **/
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;

    public TreeNode() {
    }

    public TreeNode(int x) {
        this(x, null, null, null);
    }

    public TreeNode(int val, TreeNode left, TreeNode right, TreeNode parent) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    public static TreeNode aTree() {
        TreeNode root = new TreeNode(10);
        root.right = new TreeNode(19);
        root.right.right = new TreeNode(25);
        root.right.left = new TreeNode(15);
        root.left = new TreeNode(6);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.left.right.right = new TreeNode(8);
        return root;
    }

}
