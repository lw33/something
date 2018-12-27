package lw.learn.lc.easy;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-12-26 23:23:37
 **/
public class P953_VerifyingAnAlienDictionary {

    public boolean isAlienSorted(String[] words, String order) {
        if (words.length < 2) {
            return true;
        }
        int[] map = new int[127];
        char[] chars = order.toCharArray();
        int i = 'a';
        for (int j = 0; j < chars.length; j++) {
            map[chars[j]] = i + j;
        }
        String pre = words[0];
        for (int j = 1; j < words.length; j++) {
            for (int k = 0; k < pre.length(); k++) {

                if (k == words[j].length()) {
                    return false;
                }
                int k1 = map[pre.charAt(k)];
                int k2 = map[words[j].charAt(k)];
                if (k2 > k1) {
                    break;
                } else if (k1 > k2) {
                    return false;
                }
            }
            pre = words[j];
        }
        return true;
    }

    @Test
    public void test() {
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        String[] words = {"hello", "leetcode"};
        System.out.println(this.isAlienSorted(words, order));
    }
}
