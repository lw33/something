package lw.learn.lc.easy;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-11-22 11:48:49
 **/
public class P415_AddStrings {

    public String addStrings(String num1, String num2) {

        String res = "";
        int carry = 0;
        if (num1.length() < num2.length()) {
            String tmp = num1;
            num1 = num2;
            num2 = tmp;
        }

        int j = num2.length() - 1;
        int i = num1.length() - 1;
        for (; j >= 0; i--, j--) {
            int n1 = num1.charAt(i) - '0';
            int n2 = num2.charAt(j) - '0';
            int sum = n1 + n2 + carry;

            if (sum >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            res = sum % 10 + res;
        }
        while (i >= 0) {
            int sum = num1.charAt(i) - '0' + carry;
            if (sum >= 10) {
                carry = 1;
            } else {
                carry = 0;
                res = num1.substring(0, i) + sum + res;
                break;
            }
            res = sum % 10 + res;
            i--;
        }
        if (carry == 1)
            res = carry + res;
        return res;
    }

    @Test
    public void test() {
        System.out.println(this.addStrings("99", "5"));
    }
}
