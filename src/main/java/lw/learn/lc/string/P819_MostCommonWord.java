package lw.learn.lc.string;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Author lw
 * @Date 2019-01-23 09:13:05
 **/
public class P819_MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for (String s : banned) {
            set.add(s);
        }
        char[] chars = paragraph.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                sb.append((char) (chars[i] + 32));
            } else if (chars[i] >= 'a' && chars[i] <= 'z') {
                sb.append(chars[i]);
            } else  {
                if (sb.length() > 0) {
                    String s = sb.toString();
                    if (!set.contains(s)) {
                        map.put(s, map.getOrDefault(s, 0) + 1);
                    }
                    sb.delete(0, sb.length());
                }
            }
        }
        if (sb.length() > 0) {
            String s = sb.toString();
            if (!set.contains(s)) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        String res = "";
        int max = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                res = entry.getKey();
                max = entry.getValue();
            }
        }
        return res;
    }

    @Test
    public void test() {
        //String s = "Bob hit a ball, the hit BALL flew far after it was hit.";
        //String[] b = {"hit"};
        String s = "Bob ";
        String[] b = {};
        System.out.println(this.mostCommonWord(s, b));
    }
}
