package lw.learn.lc.fastest.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-12-19 21:38:00
 **/
public class P890_FindAndReplacePattern {

    class Solution {
        public List<String> findAndReplacePattern(String[] words, String pattern) {
            List<String> result = new LinkedList<>();
            char[] patternChars = pattern.toCharArray();
            for (String word : words) {
                char[] chars = word.toCharArray();
                boolean test = true;
                for (int i = 0; i < chars.length && test; i++) {
                    for (int j = 0; j < i && test; j++) {
                        if (patternChars[i] == patternChars[j]) {
                            test = chars[i] == chars[j];
                        } else {
                            test = chars[i] != chars[j];
                        }
                    }
                }
                if (test) {
                    result.add(word);
                }
            }
            return result;
        }
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new LinkedList<>();
        char[] pChars = pattern.toCharArray();
        for (String word : words) {
            char[] wChars = word.toCharArray();
            boolean test = true;
            for (int i = 0; i < wChars.length && test; i++) {
                for (int j = 0; j < i && test; j++) {
                    if (pChars[i] == pChars[j]) {
                        test = wChars[i] == wChars[j];
                    } else {
                        test = wChars[i] != wChars[j];
                    }
                }
            }
            if (test) {
                res.add(word);
            }
        }
        return res;
    }
}
