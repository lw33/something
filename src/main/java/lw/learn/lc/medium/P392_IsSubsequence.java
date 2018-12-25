package lw.learn.lc.medium;

/**
 * @Author lw
 * @Date 2018-12-25 01:05:08
 **/
public class P392_IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int sIndex = 0;
        for (int i = 0; i < tChars.length; i++) {
            if (tChars[i] == sChars[sIndex]) {
                sIndex++;
                if (sIndex == sChars.length) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isSubsequence1(String s, String t) {
        int i = -1;
        for (char c : s.toCharArray()) {
            i = t.indexOf(c, ++i);
            if (i == -1) {
                return false;
            }
        }
        return true;
    }


}
