package lw.learn.lc.math;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2019-01-21 22:26:14
 **/
public class P942_DIStringMatch {

    /**
     * 将 I D 看做两个不同的序列
     * 然后将第一个 I 位置设为 0 然后逢 I 加一
     * 将第一个 D 位置设为 N 然后逢 D 减一
     * @param S
     * @return
     */
    public int[] diStringMatch(String S) {

        char[] chars = S.toCharArray();
        int[] res = new int[chars.length + 1];
        int min = 0;
        int max = chars.length;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'I') {
                    res[i] = min++;
            } else {
                res[i] = max--;
            }
        }
        res[chars.length] = min;
        return res;
    }
    
    @Test
    public void test() {
        String str = "DDD";
        int[] ints = this.diStringMatch(str);
        System.out.println(Arrays.toString(ints));
    }
}
