package lw.learn.lc.medium;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @Author lw
 * @Date 2018-12-15 01:06:53
 **/
public class P451_FrequencySort {

    public String frequencySort(String s) {
        int[] freq = new int[256];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++;
        }
        StringBuilder sb = new StringBuilder();
        TreeMap<Integer, List<Character>> map = new TreeMap<>((i1, i2) -> i2 - i1);
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                if (map.containsKey(freq[i])) {
                    map.get(freq[i]).add((char) i);
                } else {
                    List<Character> list = new ArrayList<>();
                    list.add((char) i);
                    map.put(freq[i], list);
                }
            }
        }
        map.forEach((k, v) -> {
            for (int i = 0; i < v.size(); i++) {
                for (Integer integer = 0; integer < k; integer++) {
                    sb.append(v.get(i));
                }
            }
        });
        return sb.toString();
    }

    @Test
    public void test() {
        String s = "tree";
        System.out.println(this.frequencySort(s));
    }
}
