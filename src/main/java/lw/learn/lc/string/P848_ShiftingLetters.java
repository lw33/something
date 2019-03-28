package lw.learn.lc.string;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-03-28 20:32:21
 **/
public class P848_ShiftingLetters {


    /**
     * @param S
     * @param shifts
     * @return
     */
    public String shiftingLetters(String S, int[] shifts) {
        char[] chars = S.toCharArray();
        for (int i = shifts.length - 2; i >= 0; i--) {
            shifts[i] = (shifts[i] + shifts[i + 1]) % 26;
        }
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (((chars[i] - 'a') + shifts[i]) % 26 + 'a');
        }
        return new String(chars);
    }

    @Test
    public void test() {
        String S = "bad";
        int[] shifts = {10, 20, 30};
        System.out.println(this.shiftingLetters(S, shifts));
    }
}
