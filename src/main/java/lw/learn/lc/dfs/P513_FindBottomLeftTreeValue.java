package lw.learn.lc.dfs;

import lw.learn.lc.ds.TreeNode;

/**
 * @Author lw
 * @Date 2019-02-09 08:43:19
 **/
public class P513_FindBottomLeftTreeValue {

    class ReturnData {
        int h;
        int value;

        ReturnData(int h, int value) {
            this.h = h;
            this.value = value;
        }
    }

    public int findBottomLeftValue(TreeNode root) {
        return dfs(root).value;
    }

    private ReturnData dfs(TreeNode node) {
        if (node == null) return new ReturnData(0, 0);
        ReturnData leftData = dfs(node.left);
        ReturnData rightData = dfs(node.right);
        int value = node.val;
        int h;
        if (leftData.h >= rightData.h) {
            value = leftData.h > 0 ? leftData.value : value;
            h = leftData.h + 1;
        } else {
            value = rightData.value;
            h = rightData.h + 1;
        }
        return new ReturnData(h, value);
    }
}
