package lw.learn.lc.easy;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-12-20 13:48:13
 **/
public class P944_DeleteColumnsToMakeSorted {

    public int minDeletionSize(String[] A) {

        int res = 0;
        for (int i = 0; i < A[0].length(); i++) {
            char pre = 'A';
            for (String s : A) {
                if (s.charAt(i) < pre) {
                    res++;
                    break;
                }
                pre = s.charAt(i);
            }
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println((int) ('A'));
    }
}
