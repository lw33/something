package lw.learn.lc.dp;

import org.junit.Test;

import java.util.HashMap;

/**
 * @Author lw
 * @Date 2019-02-05 09:19:56
 **/
public class P474_OnesAndZeroes {

    HashMap<String, Integer> memo;
    int[][][] arrMemo;

    public int findMaxForm(String[] strs, int m, int n) {

        memo = new HashMap<>();
        arrMemo = new int[m][n][strs.length];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < strs.length; k++) {
                    arrMemo[i][j][k] = -1;
                }
            }
        }

        int maxForm = findMaxForm(strs, m, n, 0);
        return maxForm;
    }

    public int findMaxForm(String[] strs, int m, int n, int index) {

        if (index == strs.length || (m == 0 && n == 0)) {
            return 0;
        }
        Integer integer = memo.get(m + "_" + n + "_" + index);
        if (integer != null) {
            return integer;
        }
        if (arrMemo[m][n][index] != -1) {
            return arrMemo[m][n][index];
        }

        char[] chars = strs[index].toCharArray();
        int zero = 0;
        int one = 0;
        for (char aChar : chars) {
            if (aChar == '0') {
                zero++;
            } else {
                one++;
            }
        }

        int max = findMaxForm(strs, m, n, index + 1);
        if (m - zero >= 0 && n - one >= 0) {
            max = Math.max(max, 1 + findMaxForm(strs, m - zero, n - one, index + 1));
        }

        memo.put(m + "_" + n + "_" + index, max);
        arrMemo[m][n][index] = max;
        return max;
    }


    /**
     * 成功的读错了题意
     *
     * @param strs
     * @param m
     * @param n
     * @param str
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n, String str) {

        if (m == 0 && n == 0) {
            System.out.println(str);
            int res = 0;
            for (String s : strs) {
                if (str.contains(s)) {
                    res++;
                }
            }
            return res;
        }
        if (m < 0 || n < 0) {
            return 0;
        }
        return Math.max(findMaxForm(strs, m - 1, n, str + 1),
                findMaxForm(strs, m, n - 1, str + 0));
    }


    @Test
    public void test() {
        String[] Array = {"10", "0001", "111001", "1", "0"};
        int m = 5, n = 3;
        //String[] Array = {"10", "0", "1"};
        //int m = 1, n = 1;

        System.out.println(this.findMaxForm(Array, m, n));
    }
}
