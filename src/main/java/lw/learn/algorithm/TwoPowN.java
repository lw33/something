package lw.learn.algorithm;

import java.math.BigDecimal;

/**
 * @Author lw
 * @Date 2018-10-04 19:23:26
 **/
public class TwoPowN {

    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal(2);
        BigDecimal pow = bigDecimal.pow(512);
        System.out.println(pow);
    }
}
