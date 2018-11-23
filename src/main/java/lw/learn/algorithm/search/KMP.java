package lw.learn.algorithm.search;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-11-23 15:16:55
 **/
public class KMP {

    public static int indexOf(String source, String target) {

        if (source.length() < target.length()) {
            return -1;
        }
        char[] sourceChars = source.toCharArray();
        char[] targetChars = target.toCharArray();
        int i1 = 0;
        int i2 = 0;
        int[] next = next(targetChars);
        while (i1 < sourceChars.length && i2 < targetChars.length) {
            if (sourceChars[i1] == targetChars[i2]) {
                i1++;
                i2++;
            } else {
                if (next[i2] == -1) {
                    i1++;
                } else {
                    i2 = next[i2];
                }
            }
        }
        return i2 == target.length() ? i1 - i2 : -1;
    }

    public static int[] next(char[] str) {
        if (str.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[str.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int pre = 0;
        while (i < str.length) {
            if (str[i - 1] == str[pre]) {
                next[i++] = ++pre;
            } else if (pre > 0) {
                pre = next[pre];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }

    @Test
    public void test() {
        System.out.println(KMP.indexOf("lkjjava", "ja"));
    }
}
