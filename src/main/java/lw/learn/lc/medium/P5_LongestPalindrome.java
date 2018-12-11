package lw.learn.lc.medium;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-11-23 18:13:59
 **/
public class P5_LongestPalindrome {

    public String longestPalindrome(String str) {
        if (str == null || str.length() == 0)
            return "";
        char[] chars = manacherString(str);
        int max = 0;
        int pi = 0;
        int[] rs = new int[chars.length];
        int index = 0;
        int r = 0;

        for (int i = 0; i < chars.length; i++) {
            rs[i] = i < r ? Math.min(r - i, rs[2 * index - i]) : 1;

            while (i + rs[i] < chars.length && i - rs[i] > -1 && chars[i + rs[i]] == chars[i - rs[i]]) {
                rs[i]++;
            }

            if (r < i + rs[i]) {
                r = i + rs[i];
                index = i;
            }
            if (max < rs[i]) {
                max = rs[i];
                pi = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1 - max; i < max; i++)
            if (chars[pi + i]!= '#')
                sb.append(chars[pi + i]);

        return sb.toString();
    }


    public char[] manacherString(String str) {
        char[] manacherStr = new char[str.length() * 2 + 1];
        int i = 0;
        for (int j = 0; j < manacherStr.length; j++) {
            if (j % 2 == 0) {
                manacherStr[j] = '#';
            } else {
                manacherStr[j] = str.charAt(i++);
            }
        }
        return manacherStr;
    }

    @Test
    public void test() {
        System.out.println(this.longestPalindrome("java"));
    }

}
