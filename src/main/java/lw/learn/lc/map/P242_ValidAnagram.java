package lw.learn.lc.map;

/**
 * @Author lw
 * @Date 2019-01-24 10:37:35
 **/
public class P242_ValidAnagram {

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }
        int[] hash = new int[26];
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        for (int i = 0; i < sChars.length; i++) {
            hash[sChars[i] - 'a']++;
            hash[tChars[i] - 'a']--;
        }
        for (int i : hash) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}
