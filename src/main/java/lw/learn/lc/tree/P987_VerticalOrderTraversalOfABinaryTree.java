package lw.learn.lc.tree;

import lw.learn.lc.ds.TreeNode;

import java.util.*;

/**
 * @Author lw
 * @Date 2019-03-11 16:48:11
 **/
public class P987_VerticalOrderTraversalOfABinaryTree {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<int[]>> map = new TreeMap<>();
        dfs(root, map, 0, 0);
        map.forEach((k, v) -> {
            /*Collections.sort(v, new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    if (a[0] != b[0]) {
                        return a[0] - b[0];
                    } else {
                        return a[1] - b[1];
                    }
                }
            });*/
            Collections.sort(v, Comparator.comparing(a -> ((int[]) a)[0]).thenComparing(a -> ((int[]) a)[1]));
            List<Integer> list = new ArrayList<>(v.size());
            for (int[] ints : v) {
                list.add(ints[1]);
            }
            res.add(list);
        });
        return res;
    }

    private void dfs(TreeNode root, Map<Integer, List<int[]>> map, int x, int level) {
        if (root == null) {
            return;
        }
        List<int[]> list = map.getOrDefault(x, new ArrayList<>());
        list.add(new int[]{level, root.val});
        map.put(x, list);
        dfs(root.left, map, x - 1, level + 1);
        dfs(root.right, map, x + 1, level + 1);
    }
}
