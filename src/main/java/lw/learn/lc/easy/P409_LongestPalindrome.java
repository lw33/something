package lw.learn.lc.easy;


import java.util.HashMap;

/**
 * @Author lw
 * @Date 2018-11-23 17:17:45
 **/
public class P409_LongestPalindrome {

    public int longestPalindrome(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                Integer integer = map.get(c);
                if ((integer & 1) == 1) {
                    count++;
                }
                map.put(c, integer + 1);
            } else {
                map.put(c, 1);
            }
        }
        count = count * 2;
        return count < s.length() ? count + 1 : count;
    }
}
