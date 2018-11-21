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
}
