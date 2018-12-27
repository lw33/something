package lw.learn.lc.easy;

/**
 * @Author lw
 * @Date 2018-12-26 23:58:08
 **/
public class P342_PowerOfFour {

    public boolean isPowerOfFour1(int num) {

        return (num & num - 1) == 0 && (num & 0b01010101010101010101010101010101) != 0;
    }


    public boolean isPowerOfFour(int num) {

        if (num < 1) {
            return false;
        }
        while (num != 1) {
            if (num % 4 != 0) {
                return false;
            }
            num /= 4;
        }
        return true;
    }
}
