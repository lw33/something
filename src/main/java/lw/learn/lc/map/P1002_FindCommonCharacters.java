package lw.learn.lc.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author lw
 * @Date 2019-03-09 20:28:19
 **/
public class P1002_FindCommonCharacters {

    public List<String> commonChars(String[] A) {

        List<String> res = new ArrayList<>();
        int[] map = new int[26];
        boolean init = true;
        int[] tmp = new int[26];
        for (String s : A) {
            Arrays.fill(tmp, 0);
            for (char c : s.toCharArray()) {
                tmp[c - 'a']++;
            }
            if (init) {
                System.arraycopy(tmp, 0, map, 0, tmp.length);
                init = false;
            } else {
                for (int i = 0; i < map.length; i++) {
                    if (map[i] != tmp[i]) {
                        map[i] = Math.min(tmp[i], map[i]);
                    }
                }
            }
        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i]; j++) {
                res.add(String.valueOf((char) (i + 'a')));
            }
        }

        return res;
    }
}
