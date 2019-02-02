package lw.learn.lc.greedy;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-02-01 19:39:16
 **/
public class P984_StringWithoutAAAOrBBB {

    public String strWithout3a3b(int A, int B) {

        StringBuilder sb = new StringBuilder();
        int a = 0;
        int b = 0;
        while (A != 0 || B != 0) {

            if (A > B) {
                if (a == 2) {
                    sb.append('b');
                    a = 0;
                    B--;
                } else {
                    sb.append('a');
                    a++;
                    --A;
                }
            } else if (B > A) {
                if (b == 2) {
                    sb.append('a');
                    b = 0;
                    A--;
                } else {
                    sb.append('b');
                    b++;
                    --B;
                }
            } else {
                if (sb.length() >= 2 && sb.charAt(sb.length() - 1) == 'a') {
                    for (int i = 0; i < A; i++) {
                        sb.append("ba");
                        return sb.toString();
                    }
                } else {
                    for (int i = 0; i < A; i++) {
                        sb.append("ab");
                        return sb.toString();
                    }
                }
            }
        }
        return sb.toString();
    }
    
    @Test
    public void test() {

        int a = 1;
        int b = 2;
        System.out.println(this.strWithout3a3b(a, b));
    }
}
