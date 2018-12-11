package lw.learn.lc.easy;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-11-20 17:00:19
 * @tag easy
 **/
public class P67_AddBinary {

    public String addBinary(String a, String b) {
        int carray = 0;
        String res = "";
        if (a.length() > b.length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }

        int j = b.length() - 1;
        for (int i = a.length() - 1; i >= 0; i--, j--) {
            int ac = a.charAt(i) - '0';
            int bc = b.charAt(j) - '0';
            int rst = ac + bc + carray;
            if (rst > 1) {
                carray = 1;
            } else {
                carray = 0;
            }
            res = (rst & 1) + res;
        }

        for (; j >= 0; j--) {
            int bc = b.charAt(j) - '0';
            int rst = bc + carray;
            if (rst > 1) {
                carray = 1;
            } else {
                carray = 0;
            }
            res = (rst & 1) + res;
        }
        if (carray == 1)
            res = 1 + res;
        return res;
    }
    
    @Test
    public void test() {
        String a = "1010", b = "1011";
        System.out.println(this.addBinary(a, b));
    }
}
