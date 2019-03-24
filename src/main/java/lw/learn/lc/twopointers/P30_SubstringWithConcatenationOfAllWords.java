package lw.learn.lc.twopointers;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lw
 * @Date 2019-03-20 19:01:02
 **/
public class P30_SubstringWithConcatenationOfAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int len = words[0].length();
        int totalLen = len * words.length;
        int sLen = s.length();

        if (s.length() < totalLen) {
            return res;
        }
        for (int i = 0; i < sLen; i++) {

        }
        return res;
    }
}
