package lw.learn.lc.easy;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2018-11-18 10:57:57
 **/
public class P455_FindContentChildren {

    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);
        int i = s.length - 1;
        int j = g.length - 1;
        int sum = 0;

        while (i >= 0 && j >= 0) {
            if (s[i] >= g[j]) {
                i--;
                sum++;
            }
            j--;
        }

        return sum;
    }


}
