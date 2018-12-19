package lw.learn.lc.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-12-19 21:38:00
 **/
public class P890_FindAndReplacePattern {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            return res;
        }
        char[] patternChars = pattern.toCharArray();
        HashMap<Character, Character> p2w = new HashMap<>(pattern.length() * 2);
        HashSet<Character> wSet = new HashSet<>(pattern.length() * 2);
        for (String word : words) {
            if (word.length() == pattern.length()) {
                int i = 0;
                for (; i < word.length(); i++) {
                    char p = pattern.charAt(i);
                    char w = word.charAt(i);
                    if (p2w.containsKey(p)) {
                        if (w == p2w.get(p)) {
                            continue;
                        }
                        break;
                    }
                    if (wSet.contains(w)) {
                        break;
                    }
                    p2w.put(p, w);
                    wSet.add(w);
                }
                if (i == word.length()) {
                    res.add(word);
                }
                p2w.clear();
                wSet.clear();
            }
        }
        return res;
    }


}
