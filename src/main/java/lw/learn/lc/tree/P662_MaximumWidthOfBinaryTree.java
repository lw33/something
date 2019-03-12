package lw.learn.lc.tree;

import lw.learn.lc.ds.TreeNode;
import org.junit.Test;

import java.util.LinkedList;

/**
 * @Author lw
 * @Date 2019-03-12 17:55:45
 **/
public class P662_MaximumWidthOfBinaryTree {

    // FIXME 2019/3/12  optimize
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode curLevelEnd = root;
        TreeNode nextLevelEnd = root;
        queue.add(root);
        int max = 0;
        int record = 0;
        while (!queue.isEmpty()) {
            root = queue.pop();
            record++;
            if (root == null) {
                queue.add(null);
                queue.add(null);
                continue;
            }
            queue.add(root.left);
            queue.add(root.right);
            if (root.right != null) {
                nextLevelEnd = root.right;
            } else if (root.left != null) {
                nextLevelEnd = root.left;
            }
            if (curLevelEnd == root) {
                max = max < record ? record : max;
                record = 0;
                curLevelEnd = nextLevelEnd;
                while (!queue.isEmpty() && queue.peekLast() != curLevelEnd) {
                    queue.pollLast();
                }
                while (!queue.isEmpty() && queue.peek() == null) {
                    queue.poll();
                }
            }
        }
        return max;
    }

    //[1,1,1,1,null,null,1,1,null,null,1]
    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        System.out.println(this.widthOfBinaryTree(root));
    }

}
