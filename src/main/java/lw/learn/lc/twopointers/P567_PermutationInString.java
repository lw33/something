package lw.learn.lc.twopointers;

/**
 * @Author lw
 * @Date 2019-01-25 09:21:27
 **/
public class P567_PermutationInString {



    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        char[] s1Chars = s1.toCharArray();
        int l = 0;
        char[] s2Chars = s2.toCharArray();
        int r = 0;
        int[] map = new int[127];
        for (char s1Char : s1Chars) {
            map[s1Char]++;
        }

        int match = s1Chars.length;
        while (r != s2Chars.length) {
            map[s2Chars[r]]--;
            if (map[s2Chars[r]] < 0) {
                match--;
                while (map[s2Chars[r]] < 0) {
                    map[s2Chars[l++]]++;
                    match++;
                }
            } else {
                match--;
            }
            if (match == 0) {
                return true;
            }
            ++r;
        }
        return false;
    }
}
