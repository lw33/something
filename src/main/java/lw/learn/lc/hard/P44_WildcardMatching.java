package lw.learn.lc.hard;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-12-17 23:26:55
 **/
public class P44_WildcardMatching {

    public boolean isMatch(String s, String p) {
        return isMatch(s, p, 0, 0);
    }

    public boolean isMatch(String s, String p, int sIndex, int pIndex) {

        if (sIndex == s.length()) {
            String str = p.substring(pIndex);
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != '*') {
                    return false;
                }
            }
            return true;
        }

        if (pIndex == p.length()) {
            return false;
        }
        if ('*' == p.charAt(pIndex)) {
            return isMatch(s, p, sIndex + 1, pIndex) || isMatch(s, p, sIndex, pIndex + 1);
        } else if ('?' == p.charAt(pIndex) || p.charAt(pIndex) == s.charAt(sIndex)) {
            return isMatch(s, p, sIndex + 1, pIndex + 1);
        } else {
            return false;
        }
    }

    @Test
    public void test() {
        //"aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba"
        //"*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*"
        String s = "";
        String p = "";
        System.out.println(isMatch(s, p));
    }
}
