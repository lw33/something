package lw.learn.algorithm.search;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-11-23 23:32:55
 **/
public class Manacher {

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

    public int longestPalindrome(String str) {

        if (str == null || str.length() == 0)
            return 0;

        char[] chars = manacherString(str);
        int[] rs = new int[chars.length]; // 每个位置回文串的长度
        int r = -1;     // 最右边界
        int index = -1; // 最右边界的中心点
        int max = 0;
        for (int i = 0; i < chars.length; i++) {

            rs[i] = i < r ? Math.min(rs[2 * index - i], r - i) : 1;

            while (i + rs[i] < chars.length && i - rs[i] > -1 && chars[i - rs[i]] == chars[i + rs[i]] ) {
                rs[i]++;
            }
            if (r < i + rs[i]) {
                r = i + rs[i];
                index = i;
            }
            max = Math.max(max, rs[i]);
        }

        return max - 1;
    }

    @Test
    public void test() {
        //System.out.println(Arrays.toString(manacherString("java")));
        System.out.println(longestPalindrome("java"));
    }
}
