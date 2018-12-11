package lw.learn.lc.easy;

import lw.learn.lc.ds.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author lw
 * @Date 2018-11-25 23:34:53
 **/
public class P501_FindMode {

    public int[] findMode(TreeNode root) {

        TreeNode mostRight;
        TreeNode cur = root;
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }

                if (mostRight.right == null) {
                    Integer integer = map.get(cur.val);
                    max = getMax(cur, map, max, integer);
                    mostRight.right = cur;
                    cur = cur.left;
                } else {
                    mostRight.right = null;
                    cur = cur.right;
                }
            } else {
                Integer integer = map.get(cur.val);
                max = getMax(cur, map, max, integer);
                cur = cur.right;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                res.add(entry.getKey());
            }
        }
        int[] resInt = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resInt[i] = res.get(i);
        }
        return resInt;
    }

    private int getMax(TreeNode cur, HashMap<Integer, Integer> map, int max, Integer integer) {
        if (integer != null) {
            integer++;
            map.put(cur.val, integer);
            max = Math.max(max, integer);
        } else {
            integer = 1;
            map.put(cur.val, integer);
            max = Math.max(max, integer);
        }
        return max;
    }

}
