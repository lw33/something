package lw.learn.lc.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2019-01-16 22:23:26
 **/
public class P91_DecodeWays {

    public int numDecodingsDP(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] chars = s.toCharArray();
        int cur = chars[chars.length - 1] == '0' ? 0 : 1;
        int next = 1;

        for (int i = chars.length - 2; i >= 0; i--) {
            if (chars[i] == '0') {
                next = cur;
                cur = 0;
            } else {
                int tmp = cur;
                if (i + 1 < chars.length && (chars[i] - '0') * 10 + chars[i + 1] - '0' < 27) {
                    cur += next;
                }
                next = tmp;
            }
        }

        return cur;
    }


    int[] memo;

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        memo = new int[s.length() + 1];
        Arrays.fill(memo, -1);
        return numDecodings(s.toCharArray(), 0);
    }

    private int numDecodings(char[] str, int i) {

        if (i == str.length) {
            return 1;
        }

        if (str[i] == '0') {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        int res = numDecodings(str, i + 1);
        if (i + 1 < str.length && (str[i] - '0') * 10 + str[i + 1] - '0' < 27) {
            res += numDecodings(str, i + 2);
        }
        memo[i] = res;
        return res;
    }

    @Test
    public void test() {
        System.out.println(this.numDecodings("10"));
    }
}
