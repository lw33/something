package lw.learn.lc.tree;

import lw.learn.lc.ds.TreeNode;

import java.util.*;

/**
 * @Author lw
 * @Date 2019-03-24 23:02:51
 **/
public class P863_AllNodesDistanceKInBinaryTree {

    /**
     * 将二叉树转换成为图
     * 进行广度优先遍历
     *
     * @param root
     * @param target
     * @param K
     * @return
     */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {

        List<Integer> res = new ArrayList<>();
        Map<Integer, Set<Integer>> g = new HashMap<>();
        buildG(g, root);

        HashSet<Integer> visited = new HashSet<>();
        bfs(g, visited, target.val, K, res);
        return res;
    }

    private void bfs(Map<Integer, Set<Integer>> g, HashSet<Integer> visited, int val, int k, List<Integer> res) {
        if (k == 0) {
            res.add(val);
            return;
        }
        visited.add(val);
        for (Integer i : g.get(val)) {
            if (!visited.contains(i)) {
                bfs(g, visited, i, k - 1, res);
            }
        }
    }

    private void buildG(Map<Integer, Set<Integer>> g, TreeNode node) {
        if (node == null)
            return;

        Set<Integer> set = g.getOrDefault(node.val, new HashSet<>());

        if (node.left != null) {
            set.add(node.left.val);
            Set<Integer> leftSet = g.getOrDefault(node.left.val, new HashSet<>());
            leftSet.add(node.val);
            g.put(node.left.val, leftSet);

            buildG(g, node.left);
        }

        if (node.right != null) {
            set.add(node.right.val);
            Set<Integer> rightSet = g.getOrDefault(node.right.val, new HashSet<>());
            rightSet.add(node.val);
            g.put(node.right.val, rightSet);

            buildG(g, node.right);
        }

        g.put(node.val, set);
    }
}
