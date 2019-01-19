package lw.learn.lc.easy;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2019-01-19 22:58:03
 **/
public class P821_ShortestDistanceToACharacter {


    public int[] shortestToChar(String S, char C) {
        char[] chars = S.toCharArray();
        int[] res = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == C) {
                continue;
            }
            int min = Integer.MAX_VALUE;
            int j = i;
            for (; j >= 0; j--) {
                if (chars[j] == C) {
                    break;
                }
            }
            if (j != -1) {
                min = i - j;
            }
            j = i;
            for (; j < chars.length; j++) {
                if (chars[j] == C) {
                    break;
                }
            }
            if (j != chars.length) {
                j = j - i;
                min = min > j ? j : min;
            }
            res[i] = min;
        }
        return res;
    }

    @Test
    public void test() {
        String S = "loveleetcode";
        char C = 'e';
        int[] ints = this.shortestToChar(S, C);
        System.out.println(Arrays.toString(ints));
    }
}
