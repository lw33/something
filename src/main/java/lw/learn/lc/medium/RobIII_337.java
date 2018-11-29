package lw.learn.lc.medium;

import lw.learn.lc.ds.TreeNode;

/**
 * @Author lw
 * @Date 2018-11-29 14:20:44
 **/
public class RobIII_337 {

    public int rob(TreeNode root) {

        ReturnData robbing = robbing(root);
        return Math.max(robbing.rob, robbing.nrot);
    }

    private ReturnData robbing(TreeNode node) {
        if (node == null) {
            return new ReturnData(0, 0);
        }
        ReturnData leftGet = robbing(node.left);
        // 不偷这一个 等于子节点 偷或不偷的最大值
        int nrob = Math.max(leftGet.rob, leftGet.nrot);
        ReturnData rightGet = robbing(node.right);
        nrob += Math.max(rightGet.rob, rightGet.nrot);
        // 偷这一个 等于子节点 不偷加自己的和
        int rob = leftGet.nrot + rightGet.nrot + node.val;
        return new ReturnData(rob, nrob);
    }

    class ReturnData {
        int rob;
        int nrot;

        public ReturnData(int rob, int nrot) {
            this.rob = rob;
            this.nrot = 0;
            this.nrot = nrot;
        }
    }
}
