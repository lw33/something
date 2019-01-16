package lw.learn.lc.string;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-01-16 21:26:56
 **/
// FIXME 2019/1/16  待优化。。。
public class P97_InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        char[] chars3 = s3.toCharArray();

        return isInterleave(chars1, chars2, chars3, 0, 0, 0);
    }

    public boolean isInterleave(char[] c1, char[] c2, char[] c3, int i1, int i2, int i3) {
        if (i1 == c1.length && i2 == c2.length && i3 == c3.length) {
            return true;
        }
        if (i1 == c1.length) {
            return onlyOne(c2, c3, i2, i3);
        } else if (i2 == c2.length) {
            return onlyOne(c1, c3, i1, i3);
        }
        if (c1[i1] == c3[i3] && c2[i2] == c3[i3]) {
            return isInterleave(c1, c2, c3, i1 + 1, i2, i3 + 1) || isInterleave(c1, c2, c3, i1, i2 + 1, i3 + 1);
        } else if (c1[i1] == c3[i3]) {
            return isInterleave(c1, c2, c3, i1 + 1, i2, i3 + 1);
        } else if (c2[i2] == c3[i3]) {
            return isInterleave(c1, c2, c3, i1, i2 + 1, i3 + 1);
        } else {
            return false;
        }
    }

    private boolean onlyOne(char[] c1, char[] c3, int i1, int i3) {
        for (; i1 < c1.length; i1++) {
            if (c1[i1] != c3[i3++]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        //String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        String s1 = "ab";
        String s2 = "bc";
        String s3 = "bcab";
        System.out.println(this.isInterleave(s1, s2, s3));
    }
}
