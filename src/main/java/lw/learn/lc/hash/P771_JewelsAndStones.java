package lw.learn.lc.hash;

import java.util.HashSet;

/**
 * @Author lw
 * @Date 2019-01-18 23:51:15
 **/
public class P771_JewelsAndStones {

    public int numJewelsInStones(String J, String S) {
        char[] charsJ = J.toCharArray();
        HashSet<Character> set = new HashSet<>();
        int res = 0;
        for (int i = 0; i < charsJ.length; i++) {
            set.add(charsJ[i]);
        }
        char[] charsS = S.toCharArray();
        for (char s : charsS) {
            if (set.contains(s)) {
                ++res;
            }
        }
        return res;
    }

}
