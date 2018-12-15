package lw.learn.lc.medium;

import java.util.*;

/**
 * @Author lw
 * @Date 2018-12-14 12:29:12
 **/
public class P49_GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) return res;
        int index = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String string = new String(chars);
            if (map.containsKey(string)) {
                res.get(map.get(string)).add(strs[i]);
            } else {
                res.add(new ArrayList<>());
                map.put(string, index);
                res.get(index++).add(strs[i]);
            }
        }
        return res;
    }


}
