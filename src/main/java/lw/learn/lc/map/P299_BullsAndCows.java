package lw.learn.lc.map;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-03-08 11:10:33
 **/
public class P299_BullsAndCows {

    public String getHint(String secret, String guess) {
        int[] map = new int[10];
        char[] cs = secret.toCharArray();
        char[] cg = guess.toCharArray();
        int i = 0;
        int a = 0;
        int b = 0;
        //boolean[] cgs = new boolean[cg.length];
        while (i < cs.length && i < cg.length) {
            if (cs[i] == cg[i]) {
                a++;
                //cgs[i] = true;
            } else {
                map[cs[i] - '0']++;
            }
            i++;
        }
        while (i < cs.length) {
            map[cs[i] - '0']++;
            i++;
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < cg.length; j++) {
            if (j >= cs.length || cs[j] != cg[j]) {
                if (map[cg[j] - '0'] > 0) {
                    b++;
                    map[cg[j] - '0']--;
                }
            }
        }
        return sb.append(a).append("A").append(b).append("B").toString();
    }

    @Test
    public void test() {
        String s = "1123";
        String g = "0111";
        System.out.println(this.getHint(s, g));
    }
}
