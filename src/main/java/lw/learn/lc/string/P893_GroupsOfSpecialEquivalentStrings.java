package lw.learn.lc.string;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author lw
 * @Date 2019-02-22 12:50:25
 **/
public class P893_GroupsOfSpecialEquivalentStrings {

    /**
     * 求出 奇数位与偶数为相同的字符
     *
     * @param A
     * @return
     */
    public int numSpecialEquivGroups(String[] A) {
        HashSet<String> set = new HashSet<>();
        for (String s : A) {
            int[] count = new int[52];
            for (int i = 0; i < s.length(); i++) {
              /*  if (i % 2 == 0) {
                    count[26 + s.charAt(i) - 'a']++;
                } else {
                    count[s.charAt(i) - 'a']++;
                }*/
                count[s.charAt(i) - 'a' + 26 * (i & 1)]++;
            }
            set.add(Arrays.toString(count));
        }
        return set.size();
    }
}
