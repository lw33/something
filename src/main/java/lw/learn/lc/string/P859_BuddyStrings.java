package lw.learn.lc.string;

import org.junit.Test;

import java.util.HashSet;

/**
 * @Author lw
 * @Date 2019-01-24 21:57:38
 **/
public class P859_BuddyStrings {

    public boolean buddyStrings(String A, String B) {

        if (A.length() != B.length()) {
            return false;
        }
        HashSet<Character> set = new HashSet<>();
        char[] aChars = A.toCharArray();
        char[] bChars = B.toCharArray();
        int exchangeCount = 2;
        char preA = ' ';
        char preB = ' ';
        if(A.equals(B)) {
            for (char aChar : aChars) {
                if (set.contains(aChar)) {
                    return true;
                }
                set.add(aChar);
            }
            return false;
        }
        for (int i = 0; i < aChars.length; i++) {
            if (aChars[i] != bChars[i]) {
                if (exchangeCount == 0) {
                    return false;
                } else {
                    if (exchangeCount == 2) {
                        preA = aChars[i];
                        preB = bChars[i];
                    } else {
                        if (preA != bChars[i] || preB != aChars[i]) {
                            return false;
                        }
                    }
                    exchangeCount--;
                }
            }
        }
        return true;
    }

    @Test
    public void test() {
        String s = "aa";
        String b = "ab";
        System.out.println(this.buddyStrings(s, b));
    }
}
