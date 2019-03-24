package lw.learn.lc.map;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author lw
 * @Date 2019-01-29 22:00:24
 **/
public class P30_SubstringWithConcatenationOfAllWords {

    /**
     * map 计数
     *
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int len = words[0].length();
        int totalLen = len * words.length;
        if (totalLen > s.length()) {
            return res;
        }

        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int n = s.length() - totalLen;
        for (int i = 0; i <= n; i++) {
            HashMap<String, Integer> cloneMap = (HashMap<String, Integer>) map.clone();
            int index = i;
            for (int j = 0; j < words.length; j++) {
                String str = s.substring(index, index + len);
                if (cloneMap.containsKey(str)) {
                    if (cloneMap.get(str) == 1) {
                        cloneMap.remove(str);
                    } else {
                        cloneMap.put(str, cloneMap.get(str) - 1);
                    }
                } else {
                    break;
                }
                index += len;
            }
            if (cloneMap.isEmpty()) {
                res.add(i);
            }
        }
        return res;
    }

    @Test
    public void test() {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        System.out.println(this.findSubstring(s, words));
    }
}
