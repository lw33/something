package lw.learn.lc.easy;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-12-23 21:41:15
 **/
public class P504_Base7 {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuffer sb = new StringBuffer();
        boolean flag = false;
        if (num < 0) {
            flag = true;
            num = Math.abs(num);
        }
        while (num > 0) {
            int i = num % 7;
            num /= 7;
            sb.append(i);
        }
        if (flag) {
            sb.append("-");
        }
        return sb.reverse().toString();
    }
    
    @Test
    public void test() {
        System.out.println(this.convertToBase7( -7));
    }
}
