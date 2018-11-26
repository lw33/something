package lw.learn.p.z.tree;

import lw.learn.lc.ds.TreeNode;

/**
 * @Author lw
 * @Date 2018-11-26 11:40:41
 **/
public class MaxDistance {

    class ReturnData {
        int distance;
        int h;

        public ReturnData(int distance, int h) {
            this.distance = distance;
            this.h = h;
        }
    }

    public int maxDistance(TreeNode root) {

        return getMaxDistance(root).distance;
    }

    private ReturnData getMaxDistance(TreeNode head) {
        if (head == null) {
            return new ReturnData(0, 0);
        }

        ReturnData leftData = getMaxDistance(head.left);
        ReturnData rightData = getMaxDistance(head.right);
        int maxDistance = Math.max(Math.max(leftData.distance, rightData.distance), leftData.h + rightData.h + 1);
        return new ReturnData(maxDistance, Math.max(leftData.h, rightData.h) + 1);
    }

}
