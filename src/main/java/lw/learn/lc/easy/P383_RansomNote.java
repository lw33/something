package lw.learn.lc.easy;

/**
 * @Author lw
 * @Date 2018-12-22 22:42:01
 **/
public class P383_RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {

        char[] rChars = ransomNote.toCharArray();
        char[] mChars = magazine.toCharArray();
        int[] hash = new int[256];
        for (char rChar : rChars) {
            hash[rChar]++;
        }
        for (char mChar : mChars) {
            hash[mChar]--;
        }

        for (int i : hash) {
            if (i > 0) {
                return false;
            }
        }
        return true;
    }
}
