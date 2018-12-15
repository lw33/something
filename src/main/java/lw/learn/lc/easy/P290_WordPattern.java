package lw.learn.lc.easy;


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lw
 * @Date 2018-12-14 11:57:55
 **/
public class P290_WordPattern {

    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        String[] s = str.split(" ");
        if (s.length != pattern.length()) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                if (!map.get(c).equals(s[i])) {
                    return false;
                }
            } else {
                if (map.containsValue(s[i]))
                    return false;
                map.put(c, s[i]);
            }
        }
        return true;
    }

    @Test
    public void test() {

    }
}
