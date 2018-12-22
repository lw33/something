package lw.learn.lc.easy;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-12-22 22:32:17
 **/
public class P389_FindTheDifference {

    public char findTheDifference(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int[] hash = new int[256];
        for (char sChar : sChars) {
            hash[sChar]++;
        }
        for (char tChar : tChars) {
            hash[tChar]--;
        }
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] == -1) {
                return (char) i;
            }
        }
        return ' ';
    }
    public char findTheDifference2(String s, String t) {
        char c = 0;
        for (int i = 0; i < s.length(); i++)
            c ^= s.charAt(i);
        for (int i = 0; i < t.length(); i++)
            c ^= t.charAt(i);
        return c;
    }
    @Test
    public void test() {
        String s = "abcd";
        String t = "abcde";
        System.out.println(this.findTheDifference(s, t));
    }
    
}
