package lw.learn.lc.dfs;

import lw.learn.lc.ds.TreeNode;

/**
 * @Author lw
 * @Date 2019-03-27 15:47:19
 **/
public class P889_ConstructBinaryTreeFromPreorderAndPostorderTraversal {

    /**
     * 输入：pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
     * 输出：[1,2,3,4,5,6,7]
     *
     * @param pre
     * @param post
     * @return
     */
    public TreeNode constructFromPrePost(int[] pre, int[] post) {

        return dfs(pre, post, 0, pre.length - 1, 0, post.length - 1);
    }

    private TreeNode dfs(int[] pre, int[] post, int preStart, int preEnd, int postStart, int postEnd) {
        if (preStart == preEnd) {
            return new TreeNode(pre[preStart]);
        } else if (preStart > preEnd) {
            return null;
        }
        TreeNode node = new TreeNode(pre[preStart]);
        int index = indexOf(post, postStart, postEnd, pre[preStart + 1]);
        int len = index - postStart;
        node.left = dfs(pre, post, preStart + 1, preStart + len + 1, postStart, postStart + len);
        node.right = dfs(pre, post, preStart + len + 2, preEnd, postStart + len + 1, postEnd - 1);
        return node;
    }

    public int indexOf(int[] arr, int start, int end, int target) {
        for (int i = start; i <= end; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
