package lw.learn.lc.map;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author lw
 * @Date 2019-01-25 09:42:01
 **/
public class P884_UncommonWordsFromTwoSentences {
    public String[] uncommonFromSentences666(String A, String B) {
        String[] sa = A.split(" ");
        String[] sb = B.split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : sa) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (String s : sb) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        List<String> tmp = new ArrayList<>();
        map.forEach((k, v) -> {
            if (v == 1) {
                tmp.add(k);
            }
        });
        return tmp.toArray(new String[tmp.size()]);
    }
    public String[] uncommonFromSentences(String A, String B) {
        String[] sa = A.split(" ");
        String[] sb = B.split(" ");
        HashMap<String, Integer> aMap = new HashMap<>();
        HashMap<String, Integer> bMap = new HashMap<>();

        for (String s : sa) {
            aMap.put(s, aMap.getOrDefault(s, 0) + 1);
        }
        for (String s : sb) {
            bMap.put(s, bMap.getOrDefault(s, 0) + 1);
        }
        List<String> res = new ArrayList<>();
        aMap.forEach((k, v) -> {
            if (!bMap.containsKey(k)) {
                if (v == 1) {
                    res.add(k);
                }
            }
        });

        bMap.forEach((k, v) -> {
            if (!aMap.containsKey(k)) {
                if (v == 1) {
                    res.add(k);
                }
            }
        });
        String[] result = new String[res.size()];

        return res.toArray(result);
    }
    
    @Test
    public void test() {
        String s1 = "this apple is sweet";
        String s2 = "this apple is sour";
        System.out.println(Arrays.toString(this.uncommonFromSentences(s1, s2)));
    }
}
