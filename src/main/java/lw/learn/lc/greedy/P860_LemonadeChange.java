package lw.learn.lc.greedy;

import lw.learn.utils.LCUtils;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-02-14 22:47:33
 **/
public class P860_LemonadeChange {
    /**
     * 简单的找零。。。
     *
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        if (bills[0] == 10 || bills[0] == 20)
            return false;
        int change5 = 0;
        int change10 = 0;
        int change = 0;
        for (int bill : bills) {
            int back = bill - 5;
            if (change < back) {
                return false;
            }
            switch (back) {
                case 0:
                    change5++;
                    break;
                case 5:
                    if (change5 == 0) {
                        return false;
                    }
                    change5--;
                    change10++;
                    break;
                case 15:
                    if (change10 > 0) {
                        back -= 10;
                        change10--;
                    }
                    while (back > 0) {
                        if (change5 == 0) {
                            return false;
                        }
                        back -= 5;
                        change5--;
                    }
            }
            change += 5;
        }
        return true;
    }

    @Test
    public void test() {
        int[] arr = LCUtils.stringToIntegerArray("[5,5,10,10,20]");
        System.out.println(this.lemonadeChange(arr));
    }
}
