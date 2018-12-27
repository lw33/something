package lw.learn.lc.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-12-27 00:44:26
 **/
public class P438_FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) {
            return res;
        }

        int[] hash = new int[26];
        char[] pChars = p.toCharArray();
        for (int i = 0; i < pChars.length; i++) {
            hash[pChars[i] - 'a']++;
        }
        int l = 0;
        int r = p.length();
        for (int i = 0; i < s.length(); i++) {

            if (r - l + 1 == p.length()) {

            }
        }
        return res;
    }
}
