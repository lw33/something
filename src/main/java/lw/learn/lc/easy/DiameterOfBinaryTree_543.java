package lw.learn.lc.easy;

import lw.learn.lc.ds.TreeNode;

/**
 * @Author lw
 * @Date 2018-12-03 22:04:28
 **/
public class DiameterOfBinaryTree_543 {

    class ReturnData {
        int distance;
        int h;

        public ReturnData(int distance, int h) {
            this.distance = distance;
            this.h = h;
        }
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return max(root).distance - 1;
    }

    public ReturnData max(TreeNode node) {

        if (node == null) {
            return new ReturnData(0, 0);
        }
        ReturnData leftData = max(node.left);
        ReturnData rightData = max(node.right);
        int maxDistance = Math.max(Math.max(leftData.distance, rightData.distance), leftData.h + rightData.h + 1);
        return new ReturnData(maxDistance, Math.max(leftData.h, rightData.h) + 1);
    }

}
