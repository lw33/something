package lw.learn.lc.medium;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-12-03 00:39:46
 **/
public class P43_Multiply {

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        String res = multiply(num1, num2.charAt(num2.length() - 1) - '0').toString();
        int zeroNum = 1;
        for (int i = num2.length() - 2; i >= 0; i--) {
            StringBuilder multiply = multiply(num1, num2.charAt(i) - '0');
            for (int j = 0; j < zeroNum; j++) {
                multiply.append(0);
            }
            zeroNum++;
            res = add(res, multiply.toString());
        }
        return res;
    }

    public String add(String num1, String num2) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        while (index1 >= 0 && index2 >= 0) {
            int i1 = num1.charAt(index1--) - '0';
            int i2 = num2.charAt(index2--) - '0';
            int res = i1 + i2 + carry;
            carry = res / 10;
            res = res % 10;
            //sb.insert(0, res);
            sb.append(res);
        }
        sb.reverse();

        while (index1 >= 0) {
            int i1 = num1.charAt(index1--) - '0';
            int res = i1  + carry;
            carry = res / 10;
            res = res % 10;
            sb.insert(0, res);
        }

        while (index2 >= 0) {
            int i2 = num2.charAt(index2--) - '0';
            int res =  i2 + carry;
            carry = res / 10;
            res = res % 10;
            sb.insert(0, res);
        }

        if (carry > 0) {
            sb.insert(0, carry);
        }

        return sb.toString();
    }
    public StringBuilder multiply(String num1, int num2){
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = num1.length() - 1; i >= 0; i--) {
            int i1 = num1.charAt(i) - '0';
            int res = i1 * num2 + carry;
            carry = res / 10;
            res = res % 10;
            //sb.insert(0, res);
            sb.append(res);
        }
        sb.reverse();
        if (carry > 0) {
            sb.insert(0, carry);
        }
        return sb;
    }

    @Test
    public void test() {
        System.out.println(multiply("123", "456"));
    }
}
