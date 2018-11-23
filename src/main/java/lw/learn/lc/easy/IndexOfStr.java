package lw.learn.lc.easy;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-11-23 23:07:21
 **/
public class IndexOfStr {
    
    public int strStr(String haystack, String needle) {

        if (haystack.length() < needle.length()) {
            return -1;
        }
        if (haystack.equals(needle) || needle.equals("")) {
            return 0;
        }
        int[] next = next(needle);

        int i1 = 0;
        int i2 = 0;

        while (i1 < haystack.length() && i2 < needle.length()) {
            if (haystack.charAt(i1) == needle.charAt(i2)) {
                i1++;
                i2++;
            } else {
                if (next[i2] == -1) {
                    i2 = 0;
                    i1++;
                } else {
                    i2 = next[i2];
                }
            }

        }

        return i2 == needle.length() ? i1 - i2 : -1;
    }

    public int[] next(String str) {
        if (str.length() == 1)
            return new int[]{-1};
        int[] next = new int[str.length()];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int prefix = 0;

        while (i < str.length()) {
            if (str.charAt(i - 1) == str.charAt(prefix)) {
                next[i++] = ++prefix;
            } else if (prefix > 0) {
                prefix = next[prefix];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }

    @Test
    public void test() {
        System.out.println(this.strStr("000java", "ja"));
    }
}
